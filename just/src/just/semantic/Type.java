package just.semantic;

public class Type {
	public enum Kind {
		undefType, voidType, boolType, intType, fieldType
	};
	
	public static Type intType = new Type("int", Kind.intType);
	public static Type voidType = new Type("void", Kind.voidType);
	public static Type boolType = new Type("bool", Kind.boolType);
	
	public Type(String name, Kind kind) {
		m_name = name;
		m_kind = kind;
	}
	
	public String m_name;
	public Kind m_kind;
	public int m_spix;
	
	
}
