package test.com.bok.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bok.model.SprtDAO;
import com.bok.model.SprtPersonVO;

public class SprtDAOTest {
	static SprtDAO dao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		dao = new SprtDAO();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test	//사용자에게 오늘 기준으로 유효한 지원금 정보(제목, 링크, 요약, 지원 시작일, 지원 종료일)만 카테고리별로 제공
	public void testGetSprtPerson() {
		List<SprtPersonVO> result = dao.getSprtPerson(2);
		assertEquals(1, result.size());
	}


}
