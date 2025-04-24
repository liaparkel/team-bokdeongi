package com.bok.service;

import java.util.Collection;

import com.bok.model.SoloAskDAO;
import com.bok.model.SoloAskVO;

public class SoloAskService {

	public Collection<SoloAskVO> getSoloAsk() {
		
		return new SoloAskDAO().getSoloAsk();
	}
	
	public Collection<SoloAskVO> searchEmail(String email) {
		
		return new SoloAskDAO().searchEmail(email);
	}
	
	public boolean addSoloAsk(SoloAskVO vo) {
		
		return new SoloAskDAO().addSoloAsk(vo);
	}
	
	public SoloAskVO soloAskDetail(SoloAskVO vo) {
		
		return new SoloAskDAO().soloAskDetail(vo);
	}
}
