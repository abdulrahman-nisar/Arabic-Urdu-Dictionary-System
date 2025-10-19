package com.PL.View;

import com.BL.BO.Interface.IPatternBO;
import com.BL.BO.Interface.IRootBO;
import com.BL.BO.Interface.IWordBO;
import com.BL.Facade.BLFacade;
import com.BL.Facade.IBLFacade;

public class PatternView {
	
	private IBLFacade blFacade;
	
	public PatternView(IPatternBO patternBO, IRootBO rootBO, IWordBO wordBO) {
		this.blFacade = new BLFacade(rootBO, patternBO, wordBO);		
	}

}
