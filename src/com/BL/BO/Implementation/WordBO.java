package com.BL.BO.Implementation;

import com.BL.BO.Interface.IWordBO;
import com.DAL.DAO.Interface.IPatternDAO;
import com.DAL.DAO.Interface.IRootDAO;
import com.DAL.DAO.Interface.IWordDAO;
import com.DAL.Facade.DALFacade;
import com.DAL.Facade.IDALFacade;

public class WordBO implements IWordBO {

	private IDALFacade facade;
	
	public WordBO(IRootDAO rootDAO, IPatternDAO patternDAO, IWordDAO wordDAO) {
		facade = new DALFacade(rootDAO, patternDAO, wordDAO);
	}
	
}
