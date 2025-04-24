package test.com.bok.dao;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.bok.model.AskDAO;
import com.bok.model.AskVO;

public class AskDAOTest {

	static AskDAO adao;
	static AskVO avo;
	
	@Before
	public void start() {
		adao = new AskDAO();
		avo = new AskVO();
	}
	
	@Test
	public void getFaqNum() {
		System.out.println(adao.getFaq());
		assertNotNull(adao.getFaq());
	}
	
	@Test
	public void failGetFaqNum() {
		assertNull(adao.getFaq());
	}

}
