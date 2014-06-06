package just.codegen.structure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import just.codegen.references.ClassReference;
import just.codegen.references.MethodReference;
import just.codegen.references.Reference;
import just.semantic.Symbol;

/**
 * this is a just class which contains
 * all elements of a class (methods, locals, globals,..)
 * 
 * @author Christian
 *
 */
public class JustClass {

	private HashMap<Integer, Reference> references;
	private ClassReference classRef;
	private List<Method> methods; 
	private List<Field> fields;
	
	public JustClass() {
		this.references = new HashMap<>();
		this.methods = new ArrayList<>();
		this.fields = new ArrayList<>();
	}
	
	public HashMap<Integer, Reference> getReferences() {
		return references;
	}
	
	public Reference addClassReference(Symbol sy) {
		return (ClassReference) addReference(new ClassReference(sy.getName()));
	}
	
	public Reference addReference(Reference ref){
		ref.setIndex(references.size() + 1);
		references.put(ref.getIndex(), ref);
		
		if(ref instanceof MethodReference) {
			this.methods.add(new Method((MethodReference) ref));
		} else if(ref instanceof ClassReference) {
			this.classRef = (ClassReference) ref;
		}
		return ref;
	}

	public Reference getClassReference() {
		return classRef;
	}
	
	public List<Field> getFields() {
		return fields;
	}
	
	public List<Method> getMethods() {
		return methods;
	}

		
}
