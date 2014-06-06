package just.codegen.structure;

import java.util.LinkedList;

import just.semantic.Scope;


public class MethodCode {
	
	private LinkedList<Codeline> lines = new LinkedList<>();

	private Scope scope;

	public MethodCode(Scope scope) {
		this.scope = scope;
	}

	public Scope getScope() {
		return scope;
	}

	public void addLine(Codeline line) {
		this.lines.add(line);
	}

}
