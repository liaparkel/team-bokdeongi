package com.bok.service;

import java.util.Collection;

import com.bok.model.FaqManagerDAO;
import com.bok.model.FaqManagerVO;

public class FaqManagerService {

	public Collection<FaqManagerVO> getFaq() {
		
		return new FaqManagerDAO().getFaq();
	}
	
	public boolean setFaq(FaqManagerVO vo) {
		
		return new FaqManagerDAO().setFaq(vo);
	}
	
	public boolean addFaq(FaqManagerVO vo) {
		
		return new FaqManagerDAO().addFaq(vo);
	}
	
	public boolean deleteFaq(int faqNum) {
		
		return new FaqManagerDAO().deleteFaq(faqNum);
	}
}
