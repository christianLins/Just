package just.semantic;

/**
 * flat implementation of a symbol with kinds (alternatively in oo-design)
 * a symbol stands for a construct in the source-code and is used by the compiler
 * 
 * @author Christian
 *
 */
public class Symbol {
	public enum Kind { undefKind, constKind, varKind, parKind, funcKind, fieldKind, progKind, methodKind };
	
	public int spix; //Spelling index for name list
	public Kind kind = Kind.undefKind;
	
	public Type type; //data type
	public boolean init; //is init? for vars only
	public int val; //for constants and initialized vars only
	public int addr; //for globals, params, consts and local vars
	
	//for functions only
	public boolean defined; //is func already defined
	public Symbol symbols; //params and loc vars
	
	public int level; //scope level
	public Symbol next; //linear list of symbols within a scope
	private String name;
	
	/**
	 * instantiates a new symbol
	 * 
	 * @param spix
	 * @param kind
	 */
	public Symbol(int spix, Kind kind, String name) {
		this.spix = spix;
		this.kind = kind;
		this.setName(name);
	}
	
	/**
	 * insert a symbol
	 * 
	 * @param sy
	 * @param level
	 */
	public void insert(Symbol sy, int level) {
		if(next != null) {
			next.insert(sy, level);
		} else {
			sy.level = level;
			next = sy;
		}
	}
	
	public String getName() {
		return Namelist.getInstance().getNameOf(spix);
	}

	@Override
	public String toString() {
		return "Symbol [ident=" + getName() + ", kind=" + kind + ", type=" + type
				+ ", init=" + init + ", val=" + val + ", addr=" + addr
				+ ", defined=" + defined + ", symbols=" + symbols + ", level="
				+ level + ", next=" + next + "]";
	}

	public Type getType() {
		return type;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public int getSpix(){
		return spix;
	}
	
	
}