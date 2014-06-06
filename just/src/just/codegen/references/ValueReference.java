package just.codegen.references;


public class ValueReference extends Reference {

	private String bytes;
	private String type;

	public ValueReference(String bytes, String type) {
		this.bytes = bytes;
		this.type = type;
	}

	public String getBytes() {
		return bytes;
	}

	public String getType() {
		return type;
	}
	
}
