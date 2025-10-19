package com.DTO;

import java.util.ArrayList;
import java.util.Collection;

public class PatternDTO {
	private int id;
	private String form;
	private ArrayList<RootDTO> applicableRoots;
	
	public PatternDTO(String form, ArrayList<RootDTO> applicableRoots) {
		super();
		this.form = form;
		this.applicableRoots = applicableRoots;
	}
	
	public PatternDTO(int id, String form, ArrayList<RootDTO> applicableRoots) {
		super();
		this.id = id;
		this.form = form;
		this.applicableRoots = applicableRoots;
	}

	public int getId() {
		return id;
	}

	public String getForm() {
		return form;
	}
	
	public Collection<RootDTO> getApplicableRoots() {
		return applicableRoots;
	}
}
