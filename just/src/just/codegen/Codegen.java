package just.codegen;

import java.util.HashMap;

import just.codegen.fixup.FieldFixup;
import just.codegen.fixup.Fixup;
import just.semantic.Symbol;

/**
 * 
 * @author Christian
 *
 */
public class Codegen {
	
	// name -> Fixup
	private HashMap<String, Fixup> m_nameFixup = new HashMap<>();
	
	public Descriptor newDescriptor(Symbol sy) {
		return new Descriptor(sy);
	}

	public void load(Descriptor desc) {
		switch(desc.m_kind) {
			case constKind:
				// is constant
				emit2(Opcode.LDC_W, desc.m_adr);
				break;
			case funcKind:
				// is function
				break;
			case parKind:
				// is parameter
				emit2(Opcode.ILOAD, desc.m_adr);
				break;
			case varKind:
				// is local variable
				emit2(Opcode.ILOAD, desc.m_adr);
				break;
			case undefKind:
				// is undefined
				//throw new SemanticException(null, "Undefined symbol kind on codegen/load");
				break;
			case fieldKind:
				// is class variable
				emit2(Opcode.GETSTATIC, desc.m_adr);
				m_nameFixup.put(desc.m_symbol.getName(), new FieldFixup(desc));				
				break;
		default:
			break;
		}
		
	}
	
	private void markFieldFixup(String name) {
		// TODO Auto-generated method stub
		
	}

	public void generateClassfile() {
		
	}
	
	public void emit1(Opcode opc) {
		
	}
	
	public void emit2(Opcode opc1, Opcode opc2) {
		
	}
	
}
