package com.BL.BO.Interface;

import java.util.List;

import com.DTO.WordDTO;

public interface IWordBO {
	public boolean addWord(WordDTO word);
	public List<WordDTO> getAllWords();
	public WordDTO getWordByArabicForm(String arabic_form);
	public boolean deleteWord(String arabic_form);
	public boolean upateWordMeaning(String arabic_form, String newUrduMeaning);
	public boolean updateWordPartOfSpeech(String arabic_form, String newPartOfSpeech);
	public boolean updateWordRootId(String arabic_form, int newRootId);
}
