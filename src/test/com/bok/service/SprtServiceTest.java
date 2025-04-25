package test.com.bok.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.bok.model.PagingVO;
import com.bok.model.SprtPersonVO;
import com.bok.service.SprtService;

public class SprtServiceTest {
	static SprtService ss;

	@Before
	public void setUp() throws Exception {
		ss = new SprtService();
	}

	@Test	//카테고리 가져오기
	public void getSprtInfo() {
		assertEquals(3, ss.getSprtInfo().size());
	}
	
	@Test
	public void getSprtInfo_fail() {
		assertNotEquals(10, ss.getSprtInfo().size());
	}
	
	@Test	//사용자에게 오늘 기준으로 유효한 지원금 정보(제목, 링크, 요약, 지원 시작일, 지원 종료일)만 카테고리별로 제공
	public void getSprtPerson() {
		assertEquals(1, ss.getSprtPerson(2).size());
	}

	@Test
	public void getSprtPerson_fail() {
		assertNotEquals(5, ss.getSprtPerson(2).size());
	}

	@Test	//제목 아코디언 버튼을 누르면 그 안의 개별 내용 제공
	public void getSprtContent() {
		assertEquals(2, ss.getSprtContent(100).size());
	}

	@Test
	public void getSprtContent_fail() {
		assertNotEquals(10, ss.getSprtContent(100).size());
	}

	@Test	//사용자에게 이전 지원금 정보를 카테고리별로 제공(종료일 내림차순)
	public void getBfSprtPerson() {
		assertEquals(3, ss.getBfSprtPerson(2).size());
	}

	@Test
	public void getBfSprtPerson_fail() {
		assertNotEquals(1, ss.getBfSprtPerson(2).size());
	}

	@Test	//사용자에게 카테고리에 해당하는 이전 지원금 정보 제공(종료일 내림차순, Pagination
	public void getPagedBfSprtPerson() {
		int fkSprtNum = 2;
		int totalCount = ss.getBfSprtPersonCount(fkSprtNum);
		PagingVO paging = new PagingVO(1, 10);	//1페이지에 10개씩

		List<SprtPersonVO> result = ss.getPagedBfSprtPerson(fkSprtNum, paging);
		assertEquals(3, totalCount);
		assertTrue(result.size()<=10);
	}

	@Test
	public void getPagedBfSprtPerson_fail() {
		int fkSprtNum = 6;	//존재하지 않는 카테고리
		int totalCount = ss.getBfSprtPersonCount(fkSprtNum);
		PagingVO paging = new PagingVO(1, 10);	//1페이지에 10개씩

		List<SprtPersonVO> result = ss.getPagedBfSprtPerson(fkSprtNum, paging);
		assertNotEquals(3, totalCount);
		assertTrue(result.isEmpty());
	}

	@Test	//카테고리에 해당하는 전체 게시물 수 조회
	public void getBfSprtPersonCount() {
		int result = ss.getBfSprtPersonCount(2);
		assertEquals(3, result);
	}

	@Test
	public void getBfSprtPersonCount_fail() {
		int result = ss.getBfSprtPersonCount(2);
		assertNotEquals(1, result);
	}
	
}
