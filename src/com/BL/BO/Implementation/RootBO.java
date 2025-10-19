package com.BL.BO.Implementation;

import java.util.List;

import com.BL.BO.Interface.IRootBO;
import com.DAL.DAO.Interface.IPatternDAO;
import com.DAL.DAO.Interface.IRootDAO;
import com.DAL.DAO.Interface.IWordDAO;
import com.DAL.Facade.DALFacade;
import com.DAL.Facade.IDALFacade;
import com.DTO.RootDTO;

public class RootBO implements IRootBO {

	private IDALFacade facade;
	
	public RootBO(IRootDAO rootDAO, IPatternDAO patternDAO, IWordDAO wordDAO) {
		facade = new DALFacade(rootDAO, patternDAO, wordDAO);
	}

	@Override
	public List<RootDTO> getAllRoots() {
		return facade.getAllRoots();
	}

	@Override
	public RootDTO getRootById(int rootId) {
		return facade.getRootById(rootId);
	}

	@Override
	public boolean addRoot(RootDTO root) {
		return facade.addRoot(root);
	}

	@Override
	public boolean deleteRoot(String rootLetters) {
		return facade.deleteRoot(rootLetters);
	}

	@Override
	public boolean updateRoot(String oldRootLetters, String newRootLetters) {
		return facade.updateRoot(oldRootLetters, newRootLetters);
	}

	@Override
	public int getRootIdByLetters(String rootLetters) {
		return facade.getRootIdByLetters(rootLetters);
	}


}
