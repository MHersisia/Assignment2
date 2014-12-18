package domain;

import java.io.Serializable;

public class Scope implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String name;

	public Scope() {
		
	}
	
	public Scope(String n) {
		name = n;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String n) {
		name = n;
	}

}
