//package test.com.bok.dao;
//
//import static org.junit.Assert.*;
//
//import java.util.List;
//
//import org.junit.Before;
//import org.junit.Test;
//
//import com.bok.model.PagingVO;
//import com.bok.model.SprtContentVO;
//import com.bok.model.SprtDAO;
//import com.bok.model.SprtInfoVO;
//import com.bok.model.SprtPersonVO;
//
//public class SprtDAOTest {
//	static SprtDAO dao;
//
//	@Before
//	public void setUp() throws Exception {
//		dao = new SprtDAO();
//	}
//
//	@Test	//카테고리 가져오기
//	public void getSprtInfo() {
//		List<SprtInfoVO> result = dao.getSprtInfo();
//		assertEquals(3, result.size());
//	}
//
//	@Test
//	public void getSprtInfo_fail() {
//		List<SprtInfoVO> result = dao.getSprtInfo();
//		assertNotEquals(10, result.size());
//	}
//
//	@Test	//사용자에게 오늘 기준으로 유효한 지원금 정보(제목, 링크, 요약, 지원 시작일, 지원 종료일)만 카테고리별로 제공
//	public void getSprtPerson() {
//		List<SprtPersonVO> result = dao.getSprtPerson(2);
//		assertEquals(1, result.size());
//	}
//
//	@Test
//	public void getSprtPerson_fail() {
//		List<SprtPersonVO> result = dao.getSprtPerson(2);
//		assertNotEquals(5, result.size());
//	}
//
//	@Test	//제목 아코디언 버튼을 누르면 그 안의 개별 내용 제공
//	public void getSprtContent() {
//		List<SprtContentVO> result = dao.getSprtContent(100);
//		assertEquals(2, result.size());
//	}
//
//	@Test
//	public void getSprtContent_fail() {
//		List<SprtContentVO> result = dao.getSprtContent(100);
//		assertNotEquals(10, result.size());
//	}
//
//	@Test	//사용자에게 이전 지원금 정보를 카테고리별로 제공(종료일 내림차순)
//	public void getBfSprtPerson() {
//		List<SprtPersonVO> result = dao.getBfSprtPerson(2);
//		assertEquals(3, result.size());
//	}
//
//	@Test
//	public void getBfSprtPerson_fail() {
//		List<SprtPersonVO> result = dao.getBfSprtPerson(2);
//		assertNotEquals(1, result.size());
//	}
//
//	@Test	//사용자에게 카테고리에 해당하는 이전 지원금 정보 제공(종료일 내림차순, Pagination
//	public void getPagedBfSprtPerson() {
//		int fkSprtNum = 2;
//		int totalCount = dao.getBfSprtPersonCount(fkSprtNum);
//		PagingVO paging = new PagingVO(1, 10);	//1페이지에 10개씩
//
//		List<SprtPersonVO> result = dao.getPagedBfSprtPerson(fkSprtNum, paging);
//		assertEquals(3, totalCount);
//		assertTrue(result.size()<=10);
//	}
//
//	@Test
//	public void getPagedBfSprtPerson_fail() {
//		int fkSprtNum = 6;	//존재하지 않는 카테고리
//		int totalCount = dao.getBfSprtPersonCount(fkSprtNum);
//		PagingVO paging = new PagingVO(1, 10);	//1페이지에 10개씩
//
//		List<SprtPersonVO> result = dao.getPagedBfSprtPerson(fkSprtNum, paging);
//		assertNotEquals(3, totalCount);
//		assertTrue(result.isEmpty());
//	}
//
//	@Test	//카테고리에 해당하는 전체 게시물 수 조회
//	public void getBfSprtPersonCount() {
//		int result = dao.getBfSprtPersonCount(2);
//		assertEquals(3, result);
//		System.out.println(result);
//	}
//
//	@Test
//	public void getBfSprtPersonCount_fail() {
//		int result = dao.getBfSprtPersonCount(2);
//		assertNotEquals(1, result);
//	}
//}