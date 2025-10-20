package com.DTO;

public class RootDTO {
	private int id;
	private String rootLetters;
	
	public RootDTO(String rootLetters) {
		super();
		this.rootLetters = rootLetters;
	}

	public RootDTO(int id, String rootLetters) {
		super();
		this.id = id;
		this.rootLetters = rootLetters;
	}
	
	public int getId() {
		return id;
	}

	public String getRootLetters() {
		return rootLetters;
	}

	public void setRootLetters(String rootLetters) {
		this.rootLetters = rootLetters;
	}
	
}
