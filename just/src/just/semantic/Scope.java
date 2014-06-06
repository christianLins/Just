package just.semantic;

import just.ParseException;


/**
 * the scope is a region which holds their symbols, an identifier 
 * and a reference to the outer scope
 *  * 
 * @author Christian
 *
 */
public class Scope {
	
	public Scope outer;
	public int level = 0; // initial level is 0
	public int nrOfParams = 0; // initially we have 0 params
	public int nrOfLocals = 0; // initially we have 0 locals
	public int nrOfFields = 0;
	public int nrOfConstants = 0;
	public int nrOfFunctions = 0;
	public Symbol locals; 
	public String identName;
	
	
	public Scope(Scope outer, int level, String identName) {
		this.outer = outer;
		this.level = level;
		this.identName = identName;
	}
	
	public void insert(Symbol sy) throws ParseException {
		if(containsLocal(sy)) {
			throw new  SemanticException(sy, "Symbol is already defined in scope " + identName);
		}
		switch(sy.kind) {
			case constKind:
				// is constant
				nrOfConstants++;
				break;
			case funcKind:
				// is function
				nrOfFunctions++;
				break;
			case parKind:
				// is parameter
				nrOfParams++;
				break;
			case varKind:
				// is local variable
				nrOfLocals++;
				break;
			case undefKind:
				// is undefined
				throw new SemanticException(sy, "Undefined symbol kind @ " + sy);
				//break;
			case fieldKind:
				// is class variable
				nrOfFields++;
				break;
		default:
			break;
		}
		if(locals == null) {
			locals = sy; // first local element in scope
		} else {
			locals.insert(sy, level); // add symbol to locals "chain"
		}
	}
	
	public boolean containsLocal(Symbol sy) {
		int spix = sy.spix;
		Symbol current = locals;
		while(current != null) {
			if(spix == current.spix) return true;
			current = current.next;
		}
		return false;
	}

	public Symbol lookup(int spix) throws SemanticException {
		Symbol current = locals;
		while(current != null) {
			if(current.spix == spix) return current;
			current = current.next;
		}
		throw new SemanticException(null, "Identifier not defined " 
				+ Namelist.getInstance().getNameOf(spix) 
				+ " at level " + level + " in scope "  + identName);
	}

	@Override
	public String toString() {
		return "Scope [outer=" + outer + ", level=" + level + ", nrOfParams="
				+ nrOfParams + ", nrOfLocals=" + nrOfLocals + ", nrOfFields="
				+ nrOfFields + ", nrOfConstants=" + nrOfConstants
				+ ", nrOfFunctions=" + nrOfFunctions + ", locals=" + locals
				+ ", identName=" + identName + "]";
	}

	
	
		
}
