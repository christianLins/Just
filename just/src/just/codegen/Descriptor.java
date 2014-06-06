package just.codegen;

import just.semantic.Symbol;

/**
 * descriptors are describing the operands
 * 
 * descriptors are a result of the parsing-process an they include a "translation"
 * 
 * @author Christian
 *
 */
public class Descriptor {

	public Symbol.Kind m_kind;
	public Symbol m_symbol;
	public Opcode m_adr;
	
	public Descriptor(Symbol sy) {
		this.m_symbol = sy;
		m_kind = sy.kind;
	}
	

}
