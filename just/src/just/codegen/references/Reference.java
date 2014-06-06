package just.codegen.references;

public abstract class Reference {
	
	private int index;

	public Reference(int index) {
		this.index = index;
	}
	
	
	
	public Reference() {
		
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}
	
}
