package just.codegen.fixup;

/**
 * Missing informations about Symbols that are not yet defined need a fixup during codegeneration
 * 
 * this fixups are added later, when the missing informations are present (after process of whole program)
 * 
 * @author Christian
 *
 */
public abstract class Fixup {
	
	public Fixup() {
		
	}
	
	/**
	 * do fixup
	 */
	public abstract void fix();

}
