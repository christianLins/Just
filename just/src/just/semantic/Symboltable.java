package just.semantic;

import just.ParseException;
import just.semantic.Symbol.Kind;

/**
 * the symboltable
 * 
 * @author Christian
 *
 */
public class Symboltable {
	
	private int curLevel;
	private Scope curScope;

	private static Symboltable INSTANCE = new Symboltable();
	
	public static Symboltable getInstance() {
		return INSTANCE;
	}
	
	private Symboltable() {
		curLevel = 0;
		curScope = new Scope(null, curLevel, "program");
	}
	
	
	
	
	
	public void enterScope(String identName) {
		curLevel++; // if a scope is entered, we go one level "up" in the logical hierarchy
		curScope = new Scope(curScope, curLevel, identName); // set current scope to actually entered scope
	}
	
	public void leaveScope() {
		System.out.println(toString());
		curLevel--;
		curScope = curScope.outer; // set current scope to upper level scope (if null, we are in the program scope)
	}
	
	public void insert(Symbol sy) throws ParseException {
		if(curLevel == 1 && Kind.varKind.equals(sy.kind)) {
			sy.kind = Kind.fieldKind; // on class-level a var is a field
		}
		curScope.insert(sy); // add the symbol to the current scope
	}
	
	
	public Symbol lookup(String name) throws SemanticException {
		Scope current = curScope;
		int spix = Namelist.getInstance().lookup(name);
		SemanticException e = null;
		while(current != null) {
			try {
				Symbol sy = current.lookup(spix);
				if(sy != null) return sy;
			} catch (SemanticException ex) {
				e = ex;
			}
			current = current.outer;
		}
		throw e;
	}

	@Override
	public String toString() {
		return "Symboltable [curLevel=" + curLevel + ", curScope=" + curScope
				+ "]";
	}

	
}
