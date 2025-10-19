package com.BL.BO.Implementation;

import java.util.Collection;

import com.BL.BO.Interface.IPatternBO;
import com.DAL.DAO.Interface.IPatternDAO;
import com.DAL.DAO.Interface.IRootDAO;
import com.DAL.DAO.Interface.IWordDAO;
import com.DAL.Facade.DALFacade;
import com.DAL.Facade.IDALFacade;
import com.DTO.PatternDTO;

public class PatternBO implements IPatternBO {
	

	private IDALFacade facade;
	
	public PatternBO(IRootDAO rootDAO, IPatternDAO patternDAO, IWordDAO wordDAO) {
		facade = new DALFacade(rootDAO, patternDAO, wordDAO);
	}

	@Override
	public Collection<PatternDTO> getAllPatterns() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deletPattern(PatternDTO dto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updatePattern(PatternDTO dto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addPattern(PatternDTO dto) {
		// TODO Auto-generated method stub
		return false;
	}

}
