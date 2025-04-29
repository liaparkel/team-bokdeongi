package test.com.bok.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import com.bok.service.SprtManagerService;
import com.bok.service.SprtService;

public class SprtManagerServiceTest {
	static SprtManagerService sm;
	

	@Before
	public void setUp() throws Exception {
		sm = new SprtManagerService();
	}

	//@Test
	public void getSprtPerson_True(){
		assertNotNull(sm.getSprtPerson(100));
	}
	//@Test
	public void getSprtPerson_False(){
		assertNotNull(sm.getSprtPerson(1000));
	}
	
	
	
	
}
