package test.com.bok.service;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import com.bok.service.AskService;

public class AskServiceTest {

	static AskService as;
	
	@Before
	public void test_start() {
		as = new AskService();
	}
	
	@Test
	public void getFaq() {
		System.out.println(as.getFaq());
		assertNotNull(as.getFaq());
	}
	
	@Test
	public void failGetFaq() {
		assertNull(as.getFaq());
	}
}
