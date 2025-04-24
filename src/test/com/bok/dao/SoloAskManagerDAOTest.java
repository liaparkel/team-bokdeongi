package test.com.bok.dao;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.bok.model.SoloAskManagerDAO;
import com.bok.model.SoloAskManagerVO;

public class SoloAskManagerDAOTest {

	static SoloAskManagerDAO sdao;
	static SoloAskManagerVO svo;

	@Before
	public void test_start() {
		sdao = new SoloAskManagerDAO();
		svo = new SoloAskManagerVO();
	}
	
	@Test
	public void getSoloAsk() {
//		System.out.println(sdao.getSoloAsk());
		assertNotNull(sdao.getSoloAsk());
	}
	
	@Test
	public void failGetSoloAsk() {
		assertNull(sdao.getSoloAsk());
	}
	
	@Test
	public void soloAskDetail() {
//		System.out.println(sdao.soloAskDetail("1"));
		assertNotNull(sdao.soloAskDetail("1"));
	}
	
	@Test
	public void failSoloAskDetail() {
		assertNull(sdao.soloAskDetail("1"));
	}
	
	@Test
	public void soloAskSend() {
//		System.out.println(sdao.soloAskSend(new SoloAskManagerVO("21", "sdfdfdd", "mintfox23")));
		assertTrue(sdao.soloAskSend(new SoloAskManagerVO("21", "sdfdfdd", "mintfox23")));
	}
	
	@Test
	public void failSoloAskSend() {
		assertFalse(sdao.soloAskSend(new SoloAskManagerVO("21", "sdfdfdd", "mintfox23")));
	}
}
