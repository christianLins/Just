package just.codegen;

import just.codegen.references.Reference;

/**
 * a statement is a line of java byte-code
 * 
 * @author Christian
 *
 */
public class Statement {
	
	private Opcode op;
	private Reference ref;

	public Statement(Opcode op) {
		this.op = op;
	}
	
	public Statement(Opcode op, Reference ref) {
		this.op = op;
		this.ref = ref;
	}

}
