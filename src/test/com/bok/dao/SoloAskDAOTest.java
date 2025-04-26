//package test.com.bok.dao;
//
//import static org.junit.Assert.*;
//
//import org.junit.Before;
//import org.junit.Test;
//
//import com.bok.model.SoloAskDAO;
//import com.bok.model.SoloAskVO;
//
//public class SoloAskDAOTest {
//	
//	static SoloAskDAO sdao;
//	static SoloAskVO svo;
//	
//	@Before
//	public void start() {
//		sdao = new SoloAskDAO();
//		svo = new SoloAskVO();
//	}
//	
//	@Test
//	public void getSoloAsk() {
//		System.out.println(sdao.getSoloAsk());
//		assertNotNull(sdao.getSoloAsk());
//	}
//	
//	@Test
//	public void failGetSoloAsk() {
//		assertNull(sdao.getSoloAsk());
//	}
//	
//	@Test
//	public void searchEmail() {
////		System.out.println(sdao.searchEmail("kebin@gmail.com"));
//		assertTrue(sdao.searchEmail("kebin@gmail.com").isEmpty());
//	}
//	
//	@Test
//	public void failSearchEmail() {
//		assertTrue(sdao.searchEmail(" ").isEmpty());
//		
//	}
//	
////	@Test
//	public void addSoloAsk() {
//		//System.out.println(sdao.addSoloAsk(new SoloAskVO("kebin111@gmail.com", "1234", "질문이 뭐에요", 1, "질문이 뭐라유?")));
//		assertTrue(sdao.addSoloAsk(new SoloAskVO("kebin111@gmail.com", "1234", "질문이 뭐에요", 1, "질문이 뭐라유?")));
//	}
//	
////	@Test
//	public void failAddSoloAsk() {
//		assertFalse(sdao.addSoloAsk(new SoloAskVO("kebin111@gmail.com", "1234", "질문이 뭐에요", 1, "질문이 뭐라유?")));
//	}
//	
//	@Test
//	public void soloAskDetail() {
////		System.out.println(sdao.soloAskDetail(new SoloAskVO("1", "1234")));
//		assertNotNull(sdao.soloAskDetail(new SoloAskVO("1", "1234")));
//	}
//	
//	@Test
//	public void failSoloAskDetail() {
//		assertNull(sdao.soloAskDetail(new SoloAskVO("1", "1234")));
//	}
//
//	
//}
