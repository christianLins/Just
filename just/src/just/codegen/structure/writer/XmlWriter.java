package just.codegen.structure.writer;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.StreamResult;

import just.codegen.references.ClassReference;
import just.codegen.references.MethodReference;
import just.codegen.references.Reference;
import just.codegen.references.ValueReference;
import just.codegen.structure.Field;
import just.codegen.structure.JustClass;
import just.codegen.structure.Method;

import org.w3c.dom.*;


public class XmlWriter implements ClassWriter {
	
	private static final String METHOD = "method";
	private static final String METHOD_INFO = "method_info";
	private static final String DESCRIPTOR_INDEX = "descriptor_index";
	private static final String ATTRIBUTE_INFO = "attribute_info";
	private static final String NAME_INDEX = "name_index";
	private static final String PATH = "./";
	private static final String CLASS_ELEMENT = "classfile";
	private static final String CONSTANT_POOL = "constant_pool";
	private static final String CLASS_REFERENCE = "constant_element";
	private static final String THIS = "this_class";
	private static final String FIELD_INFO = "field_info";
	private Document doc;

	@Override
	public void write(JustClass justClass) {
		
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder db;
		try {
			db = dbFactory.newDocumentBuilder();
			doc = db.newDocument();
			
			Element rootElement = doc.createElement(CLASS_ELEMENT);
			
			// constants
			Element constantPool = doc.createElement(CONSTANT_POOL);
			rootElement.appendChild(constantPool);
			
			for (Reference ref : justClass.getReferences().values()) {
				constantPool.appendChild(getElementOfReference(ref));
			}
			Element thisClass = doc.createElement(THIS);
			thisClass.appendChild(doc.createTextNode(justClass.getClassReference().getIndex() + ""));
			rootElement.appendChild(thisClass);
			
			
			// fields
			Element fieldInfo = doc.createElement(FIELD_INFO);
			rootElement.appendChild(fieldInfo);
			
			for(Field field : justClass.getFields()) {
				fieldInfo.appendChild(getElementOfField(field));
			}
			
			
			// methods
			Element methodInfo = doc.createElement(METHOD_INFO);
			rootElement.appendChild(methodInfo);

			for (Method method : justClass.getMethods()) {
				methodInfo.appendChild(getElementOfMethod(method));
			}
			
			// output DOM XML to console
			TransformerFactory transformerFactory = TransformerFactory
					.newInstance();
			transformerFactory.setAttribute("indent-number", 4);
			Transformer transformer = transformerFactory.newTransformer();

			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			// initialize StreamResult with File object to save to file
			StreamResult result = new StreamResult(new StringWriter());
			DOMSource source = new DOMSource(doc);
			transformer.transform(source, result);
			String xmlString = result.getWriter().toString();
			System.out.println(xmlString);

			PrintWriter out = new PrintWriter(PATH + "class.jcl");
			out.println(xmlString);
			out.flush();
			out.close();

			System.out.println("\nXML DOM Created Successfully..");
			
		} catch(DOMException e) {
			System.out.println("Error during class-generation " + e.getLocalizedMessage());  
		} catch (ParserConfigurationException e) {
			System.out.println("Error during class-generation " + e.getLocalizedMessage());  
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	private Element getElementOfReference(Reference ref) {
		if(ref instanceof ClassReference) {
			ClassReference classRef = (ClassReference) ref;
			Element element = doc.createElement(CLASS_REFERENCE);
			element.setAttribute("id", classRef.getIndex() + "");
			Element name = doc.createElement(NAME_INDEX);
			name.appendChild(doc.createTextNode(classRef.getName()));
			element.appendChild(name);
			return element;
		} else if(ref instanceof MethodReference) {
			MethodReference methRef = (MethodReference) ref;
			Element element = doc.createElement(METHOD);
			element.appendChild(doc.createComment(methRef.getName()));
					
			Element name = doc.createElement(NAME_INDEX);
//			name.appendChild(doc.createTextNode(""
//					+ this.methodRef.getNameAndType().getNameIndex().getIndex()));
//			Element desc = doc.createElement("descriptor_index");
//			desc.appendChild(doc.createTextNode(""
//					+ this.methodRef.getNameAndType().getDescriptorIndex()
//							.getIndex()));

			element.appendChild(name);
			//element.appendChild(desc);

//			Element attr = doc.createElement(ATTRIBUTE_INFO);
//			for (Attribute attribute : this.attributes) {
//				Element e = attribute.writeXml(doc);
//				attr.appendChild(e);
//			}
//
//			element.appendChild(attr);

			return element;
		} else if(ref instanceof ValueReference) {
			ValueReference valRef = (ValueReference) ref;
			Element element = doc.createElement("constant_" + valRef.getType());
			element.setAttribute("id", valRef.getIndex() + "");

			Element bytes = doc.createElement("bytes");
			bytes.appendChild(doc.createTextNode(valRef.getBytes()));
			element.appendChild(bytes);
			
			return element;
		} else return null;
	}
	
	private Element getElementOfField(Field f) {
		Element element = doc.createElement("field");
		element.appendChild(doc.createComment(f.getFieldReference().toString()));
		
		Element name = doc.createElement(NAME_INDEX);
		name.appendChild(doc.createTextNode("" + f.getFieldReference().getIndex()));
		//Element desc = doc.createElement(DESCRIPTOR_INDEX);
		//desc.appendChild(doc.createTextNode("" + f..getNameAndType().getDescriptorIndex().getIndex()));

		element.appendChild(name);
		//element.appendChild(desc);
		
		return element;
	}
	
	private Element getElementOfMethod(Method m) {
		Element element = doc.createElement(METHOD);
		element.appendChild(doc.createComment(m.getMethodReference().getName()));
		
		Element name = doc.createElement(NAME_INDEX);
		name.appendChild(doc.createTextNode("" + m.getMethodReference().getIndex()));
		
		element.appendChild(name);

//		Element attr = doc.createElement("attribute_info");
//		for (Attribute attribute : this.attributes) {
//			Element e = attribute.writeXml(doc);
//			attr.appendChild(e);
//		}
//
//		element.appendChild(attr);

		return element;
	}
}
