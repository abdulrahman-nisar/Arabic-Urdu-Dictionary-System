package com.DAL.Facade;

import com.DAL.DAO.Interface.IPatternDAO;
import com.DAL.DAO.Interface.IRootDAO;
import com.DAL.DAO.Interface.IWordDAO;

public interface IDALFacade extends IRootDAO,IPatternDAO,IWordDAO{ 

}
