package com.BL.BO.Interface;

import java.util.Collection;

import com.DTO.PatternDTO;

public interface IPatternBO {
	Collection<PatternDTO> getAllPatterns();
	boolean deletPattern(PatternDTO dto);
	boolean updatePattern(PatternDTO dto);
	boolean addPattern(PatternDTO dto);
	
}
