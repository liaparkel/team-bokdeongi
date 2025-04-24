package com.bok.service;

import java.util.Collection;

import com.bok.model.AskDAO;
import com.bok.model.AskVO;

public class AskService {

	public Collection<AskVO> getFaqNum() {
		
		return new AskDAO().getFaq();
	}
}
