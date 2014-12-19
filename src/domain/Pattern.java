package domain;

import java.io.Serializable;

public class Pattern implements Serializable {

	private static final long serialVersionUID = 1L;
	private String name;
	private String context;
	private String problem;
	private String solution;
	private String diagram;
	private String consequences;
	private Purpose purpose;
	private Scope scope;
	
	public Pattern() {
		
	}
	
	public Pattern(String n,Purpose p,Scope s) {
		name = n;
		purpose = p;
		scope = s;
	}
	
	public Pattern(String n,String cxt,String p,String s,String d,String con,Purpose pu,Scope sc) {
		name = n;
		context = cxt;
		problem = p;
		solution = s;
		diagram = d;
		consequences = con;
		purpose = pu;
		scope = sc;
	}
	
	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public String getProblem() {
		return problem;
	}

	public void setProblem(String problem) {
		this.problem = problem;
	}

	public String getSolution() {
		return solution;
	}

	public void setSolution(String solution) {
		this.solution = solution;
	}

	public String getDiagram() {
		return diagram;
	}

	public void setDiagram(String diagram) {
		this.diagram = diagram;
	}

	public String getConsequences() {
		return consequences;
	}

	public void setConsequences(String consequences) {
		this.consequences = consequences;
	}

	public void setPurpose(Purpose p) {
		purpose = p;
	}
	
	public Purpose getPurpose() {
		return purpose;
	}
	
	public void setScope(Scope s) {
		scope = s;
	}
	
	public Scope getScope() {
		return scope;
	}
	
	public String getName() {
		return name;
	}

}
