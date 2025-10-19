package com.DAL.DAO.Interface;

import java.util.Collection;

import com.DTO.PatternDTO;

public interface IPatternDAO {
	Collection<PatternDTO> getAllPatterns();
	boolean deletePattern(PatternDTO dto);
	boolean updatePattern(PatternDTO dto);
	boolean addPattern(PatternDTO dto);
}
