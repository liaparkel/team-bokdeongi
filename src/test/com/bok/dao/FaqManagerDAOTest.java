package test.com.bok.dao;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.bok.model.FaqManagerDAO;
import com.bok.model.FaqManagerVO;

public class FaqManagerDAOTest {

	static FaqManagerDAO fdao;
	static FaqManagerVO fvo;
	
	@Before
	public void test_start() {
		fdao = new FaqManagerDAO();
		fvo = new FaqManagerVO();
	}
	
	@Test
	public void getFaq() {
		System.out.println(fdao.getFaq());
	}
	
	@Test
	public void updateFaq() {
//		System.out.println(fdao.updateFaq(new FaqManagerVO(1, "±èÄ¡Âò")));
		assertTrue(fdao.setFaq(new FaqManagerVO(1, "±èÄ¡Âò")));
	}
	
	@Test
	public void failUpdateFaq() {
		assertFalse(fdao.setFaq(new FaqManagerVO(1, "±èÄ¡Âò")));
	}
	
//	@Test
	public void addFaq() {
//		System.out.println(fdao.addFaq(new FaqManagerVO("asd", "±èÄ¡Âò")));
		assertTrue(fdao.addFaq(new FaqManagerVO("asd", "±èÄ¡Âò")));
	}

//	@Test
	public void failAddFaq() {
		assertFalse(fdao.addFaq(new FaqManagerVO("asd", "±èÄ¡Âò")));
	}
	
	@Test
	public void deleteFaq() {
//		System.out.println(fdao.deleteFaq(10));
		assertTrue(fdao.deleteFaq(11));
	}
	
	@Test
	public void failDeleteFaq() {
		assertFalse(fdao.deleteFaq(12));
	}

}
