package just.codegen.structure;

import just.codegen.references.FieldReference;


public class Field {
	
	private FieldReference fieldRef;

	public Field(FieldReference ref) {
		this.fieldRef = ref;
	}

	public FieldReference getFieldReference() {
		return fieldRef;
	}


}
