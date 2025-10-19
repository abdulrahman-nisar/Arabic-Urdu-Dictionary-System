package com.BL.BO.Implementation;

import com.BL.BO.Interface.IRootBO;
import com.DAL.DAO.Interface.IPatternDAO;
import com.DAL.DAO.Interface.IRootDAO;
import com.DAL.DAO.Interface.IWordDAO;
import com.DAL.Facade.DALFacade;
import com.DAL.Facade.IDALFacade;

public class RootBO implements IRootBO {

	private IDALFacade facade;
	
	public RootBO(IRootDAO rootDAO, IPatternDAO patternDAO, IWordDAO wordDAO) {
		facade = new DALFacade(rootDAO, patternDAO, wordDAO);
	}

	@Override
	public boolean isValidRoot(String rootLetters) {
		// TODO Auto-generated method stub
		return false;
	}
}
