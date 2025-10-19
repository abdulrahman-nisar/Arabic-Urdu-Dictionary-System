package com.DAL.DAO.Interface;

import java.util.List;

import com.DTO.WordDTO;

public interface IWordDAO {
	
	boolean addWord(WordDTO word);
	List<WordDTO> getAllWords();
	WordDTO getWordByArabicForm(String arabic_form);
	boolean updateWord(WordDTO word);
	boolean deleteWord(String arabic_form);

}
