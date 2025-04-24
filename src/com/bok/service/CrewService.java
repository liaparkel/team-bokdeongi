package com.bok.service;

import com.bok.model.CrewDAO;
import com.bok.model.CrewVO;

public class CrewService {

	public String loginCrew(CrewVO vo) {
		
		return new CrewDAO().loginCrew(vo);
	}
}
