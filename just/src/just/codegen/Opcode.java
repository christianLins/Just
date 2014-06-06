package just.codegen;

/**
 * the just vm opcodes
 * "Konzepte abstrakter und konkreter Maschinen"
 * version 1.1
 * 
 * analog to Java VM Specification
 * 
 * @author Christian
 *
 */
public enum Opcode {
	NOP,
	POP,
	DUP,
	LDC_W, // load constants
	ISTORE,
	ILOAD, // load local variables
	PUTSTATIC,
	GETSTATIC, // load global variables
	IADD,
	ISUB,
	IMUL,
	IDIV,
	IAND,
	IOR,
	INEG,
	IF_ICMPEQ,
	IF_ICMPNE,
	IF_ICMPLT,
	IF_ICMPGE,
	IF_ICMPGT,
	IF_ICMPLE,
	GOTO,
	INVOKESTATIC,
	RETURN,
	IRETURN,
	ALOAD,
	ASTORE,
	NEWARRAY,
	IALOAD, // load fiel-elements
	IASTORE
}
