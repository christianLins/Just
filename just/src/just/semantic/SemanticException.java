package just.semantic;

import just.ParseException;

public class SemanticException extends ParseException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String JUST_SEMANTIC_EXCEPTION = "Just Semantic Exception";
	
	
	public SemanticException(Symbol atSymbol, String message) {
		super(JUST_SEMANTIC_EXCEPTION + ": " + message);
		
	}

}
