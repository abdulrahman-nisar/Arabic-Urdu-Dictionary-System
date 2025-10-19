package com.BL.BO.Interface;

import java.util.List;

import com.DTO.RootDTO;

public interface IRootBO {
	public List<RootDTO> getAllRoots();
	public RootDTO getRootById(int rootId);
	public boolean addRoot(RootDTO root);
	public boolean deleteRoot(String rootLetters);
	public boolean updateRoot(String oldRootLetters, String newRootLetters);
	public int getRootIdByLetters(String rootLetters);
	
}
