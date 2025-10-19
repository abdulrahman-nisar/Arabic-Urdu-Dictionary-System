package com.BL.BO.Implementation;

import java.util.List;

import com.BL.BO.Interface.IWordBO;
import com.DAL.DAO.Interface.IPatternDAO;
import com.DAL.DAO.Interface.IRootDAO;
import com.DAL.DAO.Interface.IWordDAO;
import com.DAL.Facade.DALFacade;
import com.DAL.Facade.IDALFacade;
import com.DTO.WordDTO;

public class WordBO implements IWordBO {

	private IDALFacade facade;
	
	public WordBO(IRootDAO rootDAO, IPatternDAO patternDAO, IWordDAO wordDAO) {
		facade = new DALFacade(rootDAO, patternDAO, wordDAO);
	}

	@Override
	public boolean addWord(WordDTO word) {
		return facade.addWord(word);
	}

	@Override
	public List<WordDTO> getAllWords() {
		return facade.getAllWords();
	}

	@Override
	public WordDTO getWordByArabicForm(String arabic_form) {
		return facade.getWordByArabicForm(arabic_form);
	}

	@Override
	public boolean deleteWord(String arabic_form) {
		return facade.deleteWord(arabic_form);
	}

	@Override
	public boolean upateWordMeaning(String arabic_form, String newUrduMeaning) {
		return facade.upateWordMeaning(arabic_form, newUrduMeaning);
	}

	@Override
	public boolean updateWordPartOfSpeech(String arabic_form, String newPartOfSpeech) {
		return facade.updateWordPartOfSpeech(arabic_form, newPartOfSpeech);
	}

	@Override
	public boolean updateWordRootId(String arabic_form, int newRootId) {
		return facade.updateWordRootId(arabic_form, newRootId);
	}
	
}
