package com.bok.service;

import java.util.Collection;

import com.bok.model.SoloAskManagerDAO;
import com.bok.model.SoloAskManagerVO;

public class SoloAskManagerService {

	public Collection<SoloAskManagerVO> getSoloAsk() {
		
		return new SoloAskManagerDAO().getSoloAsk();
	}
	
	public SoloAskManagerVO soloAskDetail(String askNum) {
		
		return new SoloAskManagerDAO().soloAskDetail(askNum);
	}
	
	public boolean soloAskSend(SoloAskManagerVO vo) {
		
		return new SoloAskManagerDAO().soloAskSend(vo);
	}
}
