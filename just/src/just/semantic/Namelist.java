package just.semantic;

import java.util.ArrayList;
import java.util.HashMap;

import just.semantic.Symbol.Kind;

/**
 * this list holds the identifier of the source code in a special datastructure
 * the identifiers are called name
 * the index of the identifiers are called spix
 *  
 * @author Christian
 *
 */
public class Namelist {
	
	//name -> spix
	private HashMap<String, Integer> m_nameIndices;
		
	//spix -> name
	private ArrayList<String> m_names;
	
	private static Namelist INSTANCE = new Namelist();
	
	public static Namelist getInstance() {
		return INSTANCE;
	}
	
	private Namelist() {
		m_nameIndices = new HashMap<>();
		m_names = new ArrayList<>();
	}
		
	/**
	 * request the spix name
	 * 
	 * @param spix
	 * @return name
	 */
	public String getNameOf(int spix) {
		return m_names.get(spix);
	}
	
	/**
	 * request the spix of a name
	 * @param name
	 * @return spix
	 */
	public int getSpixOf(String name) {
		return m_nameIndices.get(name);
	}
	
	/**
	 * add a name to the namelist
	 * 
	 * @param name
	 * @return Symbol of entered name
	 */
	public Symbol insert(String name, Kind kind) {
		if(m_nameIndices.containsKey(name)) {
			// identifier is already in the list
		} else {
			// insert new identifier
			m_names.add(name);
			m_nameIndices.put(name, m_nameIndices.size());
		}
		int spix = m_nameIndices.get(name);
		if(Kind.methodKind.equals(kind)) {
			return new MethodSymbol(spix, kind, name);
		}
		return new Symbol(spix, kind, name);
	}
	

	/**
	 * 
	 * @param name
	 * @return spix
	 */
	public int lookup(String name) {
		if(!m_nameIndices.containsKey(name)) {
			return this.insert(name, Kind.undefKind).getSpix();
		}
		return m_nameIndices.get(name);
	}
}