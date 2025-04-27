package test.com.bok.service;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import com.bok.model.SoloAskVO;
import com.bok.service.SoloAskService;

public class SoloAskServiceTest {

	static SoloAskService ss;

	@Before
	public void test_start() {
		ss = new SoloAskService();
	}

	@Test
	public void getSoloAsk() {
//		System.out.println(ss.getSoloAsk());
		assertNotNull(ss.getSoloAsk());
	}
	
	@Test
	public void failGetSoloAsk() {
		assertNull(ss.getSoloAsk());
	}
	
	@Test
	public void searchEmail() {
//		System.out.println(ss.searchEmail("kebin@gmail.com"));
		assertNotNull(ss.searchEmail("kebin@gmail.com"));
	}
	
	@Test
	public void getSearchEmail() {
//		System.out.println(ss.searchEmail("a@gmail.com"));
		assertNull(ss.searchEmail("kebin@gmail.com"));
	}
	
	@Test
	public void failGetSearchEmail() {
//		System.out.println(ss.searchEmail("a@gmail.com"));
		assertNull(ss.searchEmail("kebin@gmail.com"));
	}
	
//	@Test
	public void addSoloAsk() {
//		System.out.println(ss.addSoloAsk(new SoloAskVO("acc@gmail.com", "1234", "±Ëπ‰", 1, "±Ëπ‰¡¡¿Ω")));
		assertTrue(ss.addSoloAsk(new SoloAskVO("acc@gmail.com", "1234", "±Ëπ‰", 1, "±Ëπ‰¡¡¿Ω")));
	}

//	@Test
	public void failAddSoloAsk() {
		assertFalse(ss.addSoloAsk(new SoloAskVO("acc@gmail.com", "1234", "±Ëπ‰", 1, "±Ëπ‰¡¡¿Ω")));
	}
	
	@Test
	public void soloAskDetail() {
//		System.out.println(ss.soloAskDetail(new SoloAskVO("1", "1234")));
		assertNotNull(ss.soloAskDetail(new SoloAskVO("1", "1234")));
	}
	
	@Test
	public void failSoloAskDetail() {
		assertNull(ss.soloAskDetail(new SoloAskVO("1", "1234")));
	}
}

