package com.DAL.Facade;

import java.util.Collection;
import java.util.List;

import com.DAL.DAO.Interface.IPatternDAO;
import com.DAL.DAO.Interface.IRootDAO;
import com.DAL.DAO.Interface.IWordDAO;
import com.DTO.PatternDTO;
import com.DTO.RootDTO;
import com.DTO.WordDTO;

public class DALFacade implements IDALFacade {
	
	public DALFacade(IRootDAO rootDAO, IPatternDAO patternDAO, IWordDAO wordDAO) {
		this.rootDAO = rootDAO;
		this.patternDAO = patternDAO;
		this.wordDAO = wordDAO;
	}

	private IRootDAO rootDAO;
	private IPatternDAO patternDAO;
	private IWordDAO wordDAO;

	@Override
	public List<RootDTO> getAllRoots() {
		return rootDAO.getAllRoots();
	}

	@Override
	public RootDTO getRootById(int rootId) {
		return rootDAO.getRootById(rootId);
	}

	@Override
	public boolean addRoot(RootDTO root) {
		return rootDAO.addRoot(root);
	}

	@Override
	public boolean deleteRoot(String rootLetters) {
		return rootDAO.deleteRoot(rootLetters);
	}

	@Override
	public boolean updateRoot(String oldRootLetters, String newRootLetters) {
		return rootDAO.updateRoot(oldRootLetters, newRootLetters);
	}

	@Override
	public int getRootIdByLetters(String rootLetters) {
		return rootDAO.getRootIdByLetters(rootLetters);
	}

	@Override
	public Collection<PatternDTO> getAllPatterns() {
		return patternDAO.getAllPatterns();
	}

	@Override
	public boolean deletPattern(PatternDTO dto) {
		return patternDAO.deletPattern(dto);
	}

	@Override
	public boolean updatePattern(PatternDTO dto) {
		return patternDAO.updatePattern(dto);
	}

	@Override
	public boolean addPattern(PatternDTO dto) {
		return patternDAO.addPattern(dto);
	}

	@Override
	public boolean addWord(WordDTO word) {
		return wordDAO.addWord(word);
	}

	@Override
	public List<WordDTO> getAllWords() {
		return wordDAO.getAllWords();
	}

	@Override
	public WordDTO getWordByArabicForm(String arabic_form) {
		return wordDAO.getWordByArabicForm(arabic_form);
	}

	@Override
	public boolean deleteWord(String arabic_form) {
		return wordDAO.deleteWord(arabic_form);
	}

	@Override
	public boolean upateWordMeaning(String arabic_form, String newUrduMeaning) {
		return wordDAO.upateWordMeaning(arabic_form, newUrduMeaning);
	}

	@Override
	public boolean updateWordPartOfSpeech(String arabic_form, String newPartOfSpeech) {
		return wordDAO.updateWordPartOfSpeech(arabic_form, newPartOfSpeech);
	}

	@Override
	public boolean updateWordRootId(String arabic_form, int newRootId) {
		return wordDAO.updateWordRootId(arabic_form, newRootId);
	}

}
