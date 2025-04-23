package test.com.bok.dao;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.bok.model.CrewDAO;
import com.bok.model.CrewVO;

public class CrewDAOTest {

	static CrewDAO cdao;
	static CrewVO cvo;
	
	@Before
	public void test_start() {
		cdao = new CrewDAO();
	}
	
	@Test
	public void login() throws Exception{
		System.out.println(cdao.loginCrew(new CrewVO("mintfox23", "abc1234")));
	}
	
	@Test
	public void failLogin() {
//		assertEquals(cdao.loginCrew(new CrewVO("mintfox2", "abc1234")), "Á¤¼ºÂù");
		System.out.println(cdao.loginCrew(new CrewVO("mintfox2", "abc1234")));
	}

}
