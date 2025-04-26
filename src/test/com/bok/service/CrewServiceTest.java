package test.com.bok.service;

import org.junit.Before;
import org.junit.Test;

import com.bok.model.CrewVO;
import com.bok.service.CrewService;
import static org.junit.Assert.*;

public class CrewServiceTest {

	static CrewService cs;

	@Before
	public void test_start() throws Exception {
		cs = new CrewService();
	}
	
	@Test
	public void loginCrew() {
		//System.out.println(cs.loginCrew(new CrewVO("mintfox23", "abc1234")));
		assertNotNull(cs.loginCrew(new CrewVO("mintfox23", "abc1234")));
	}
	
	@Test
	public void failLoginCrew() {
		assertNull(cs.loginCrew(new CrewVO("mintfox23", "abc1234")));
	}
}
