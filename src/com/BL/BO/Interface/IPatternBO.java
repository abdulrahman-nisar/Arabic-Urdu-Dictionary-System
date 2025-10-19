package com.BL.BO.Interface;

import java.util.Collection;

import com.DTO.PatternDTO;

public interface IPatternBO {
	Collection<PatternDTO> getAllPatterns();
	boolean deletePattern(PatternDTO dto);
	boolean updatePattern(PatternDTO dto);
	boolean addPattern(PatternDTO dto);
	
}
