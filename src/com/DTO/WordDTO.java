package com.DTO;

public class WordDTO {
	private String arabic_form;
	private String base_form;
	private String urdu_meaning;
	private String part_of_speech;
	private int root_id;
	
	public WordDTO(
			String arabic_form, 
			String base_form, 
			String urdu_meaning, 
			String part_of_speech, 
			int root_id) {
		this.arabic_form = arabic_form;
		this.base_form = base_form;
		this.urdu_meaning = urdu_meaning;
		this.part_of_speech = part_of_speech;
		this.root_id = root_id;	
	}
	
	public String getArabic_form() {
		return arabic_form;
	}
	public String getBase_form() {
		return base_form;
	}
	public String getUrdu_meaning() {
		return urdu_meaning;
	}
	public String getPart_of_speech() {
		return part_of_speech;
	}
	public int getRoot_id() {
		return root_id;
	}

}
