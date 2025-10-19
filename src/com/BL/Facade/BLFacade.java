package com.BL.Facade;

import java.util.Collection;
import java.util.List;

import com.BL.BO.Interface.IPatternBO;
import com.BL.BO.Interface.IRootBO;
import com.BL.BO.Interface.IWordBO;
import com.DTO.PatternDTO;
import com.DTO.RootDTO;
import com.DTO.WordDTO;

public class BLFacade implements IBLFacade {
	
	private IPatternBO patternBO;
	private IWordBO wordBO;
	private IRootBO rootBO;
	
	public BLFacade(IRootBO rootBO, IPatternBO patternBO, IWordBO wordBO) {
		this.rootBO = rootBO;
		this.patternBO = patternBO;
		this.wordBO = wordBO;
	}
 
	@Override
	public Collection<PatternDTO> getAllPatterns() {
		return patternBO.getAllPatterns();
	}

	@Override
	public boolean updatePattern(PatternDTO dto) {
		return patternBO.updatePattern(dto);
	}

	@Override
	public boolean addPattern(PatternDTO dto) {
		return patternBO.addPattern(dto);
	}


	@Override
	public boolean addWord(WordDTO word) {
		return wordBO.addWord(word);
	}

	@Override
	public List<WordDTO> getAllWords() {
		return wordBO.getAllWords();
	}

	@Override
	public WordDTO getWordByArabicForm(String arabic_form) {
		return wordBO.getWordByArabicForm(arabic_form);
	}

	@Override
	public boolean deleteWord(String arabic_form) {
		return wordBO.deleteWord(arabic_form);
	}

	@Override
	public boolean upateWordMeaning(String arabic_form, String newUrduMeaning) {
		return wordBO.upateWordMeaning(arabic_form, newUrduMeaning);
	}

	@Override
	public boolean updateWordPartOfSpeech(String arabic_form, String newPartOfSpeech) {
		return wordBO.updateWordPartOfSpeech(arabic_form, newPartOfSpeech);
	}

	@Override
	public boolean updateWordRootId(String arabic_form, int newRootId) {
		return wordBO.updateWordRootId(arabic_form, newRootId);
	}

	@Override
	public boolean deletePattern(PatternDTO dto) {
		return patternBO.deletePattern(dto);
	}

	@Override
	public List<RootDTO> getAllRoots() {
		return rootBO.getAllRoots();
	}

	@Override
	public RootDTO getRootById(int rootId) {
		return rootBO.getRootById(rootId);
	}

	@Override
	public boolean addRoot(RootDTO root) {
		return rootBO.addRoot(root);
	}

	@Override
	public boolean deleteRoot(String rootLetters) {
		return rootBO.deleteRoot(rootLetters);
	}

	@Override
	public boolean updateRoot(String oldRootLetters, String newRootLetters) {
		return rootBO.updateRoot(oldRootLetters, newRootLetters);
	}

	@Override
	public int getRootIdByLetters(String rootLetters) {
		return rootBO.getRootIdByLetters(rootLetters);
	}

}
