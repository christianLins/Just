package just.codegen.structure;

import just.codegen.references.MethodReference;

public class Method {
	
	private MethodReference ref;
	
	public Method(MethodReference ref) {
		this.ref = ref;
	}
	
	public MethodReference getMethodReference() {
		return ref;
	}

}
