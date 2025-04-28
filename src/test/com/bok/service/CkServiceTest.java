package test.com.bok.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.bok.model.CkContentVO;
import com.bok.model.CkVO;
import com.bok.service.CkService;

public class CkServiceTest {

    private CkService cs;

    @Before
    public void setUp() {
        cs = new CkService();
    }
    
    // 체크리스트 카테고리 전체 가져오기
    @Test
    public void getCkCategory() {
        List<CkVO> categories = cs.getCkCategory();
        assertNotNull("카테고리 리스트가 null이면 안됨", categories);
        assertTrue("카테고리 리스트는 비어있을 수도 있지만, null이면 안됨", categories.size() >= 0);
    }

    @Test
    public void getCkCategory_fail() {
        List<CkVO> categories = cs.getCkCategory();
        assertNotNull("카테고리 리스트가 null이면 안됨", categories);
        assertFalse("카테고리 리스트가 비어있어야 함 (fail test)", categories.isEmpty());
    }

    // 특정 카테고리 이름으로 최신 카테고리 정보 가져오기
    @Test
    public void getLatestCk() {
        String category = "집보기"; // 실제 존재하는 카테고리
        CkVO ckInfo = cs.getLatestCk(category);
        assertNotNull("최신 카테고리 메타 정보가 null이면 안됨", ckInfo);
        assertEquals("카테고리 이름이 일치해야 함", "집보기", ckInfo.getCategory());
    }

    @Test
    public void getLatestCk_fail() {
        String category = "없는카테고리"; // 존재하지 않는 이름
        CkVO ckInfo = cs.getLatestCk(category);
        assertNull("존재하지 않는 카테고리 조회는 null이어야 함", ckInfo);
    }

    // 특정 ck_num에 해당하는 체크리스트 항목 가져오기
    @Test
    public void getCkContent() {
        int ckNum = 1; // 실제 존재하는 ck_num
        List<CkContentVO> contents = cs.getCkContent(ckNum);
        assertNotNull("체크리스트 항목 리스트가 null이면 안됨", contents);
        assertTrue("체크리스트 항목 리스트는 비어있을 수도 있지만, null이면 안됨", contents.size() >= 0);
    }

    @Test
    public void getCkContent_fail() {
        int ckNum = -1; // 절대 존재할 수 없는 번호
        List<CkContentVO> contents = cs.getCkContent(ckNum);
        assertNotNull("리스트 자체는 null이 아니어야 함", contents);
        assertEquals("존재하지 않는 ck_num 조회는 리스트 크기가 0이어야 함", 0, contents.size());
    }

//	@Test
//	public void testCkListInfo() {
//		Collection<CkVO> list = service.getCkListInfo("집보기");
//		assertTrue(list.size()==0);
//		System.out.println(list);
//	}
//
//	@Test
//	public void testCkListRecentInfo() {
//		Collection<CkVO> list = service.getCkListRecentInfo("집보기");
//		assertTrue(list.size()==0);
//		System.out.println(list);
//	}
//
//	@Test
//	public void testSetCkList() {
//		vo.setCkContentNum(3);
//		vo.setCkContent("서비스 수정");
//		vo.setCkTitle("서비스 제목");
//		int result = service.setCkList(vo);
//		assertEquals(1, result);
//		System.out.println("서비스 수정 결과: " + result);
//	}
//
//	@Test
//	public void testAddCkList() {
//		vo.setCkTitle("서비스 추가 제목");
//		vo.setCkContent("서비스 추가 내용");
//		vo.setCkNum(1);
//		int result = service.addCkList(vo);
//		assertEquals(1, result);
//		System.out.println("서비스 추가 성공!");
//	}
//
//	@Test
//	public void testDeleteCkList() {
//		int result = service.deleteCkList(1);
//		assertTrue(result >= 0);
//		System.out.println("서비스 삭제 성공: " + result);
//	}
//
//	@Test
//	public void testAddCkCategory() {
//		vo.setckCategory("서비스카테고리");
//		vo.setCkDate(new Date(System.currentTimeMillis()));
//		int result = service.addCkCategory(vo);
//		assertEquals(1, result);
//		System.out.println("카테고리 추가 성공");
//	}
//
//	@Test
//	public void testSetTip() {
//		vo.setCkNum(35);
//		vo.setTip("수정된 팁");
//		int result = service.setTip(vo);
//		assertEquals(1, result);
//		System.out.println("팁 수정 성공");
//	}
//
//	@Test
//	public void testAddTip() {
//		vo.setckCategory("집보기");
//		vo.setTip("추가된 팁");
//		vo.setCkDate(new Date(System.currentTimeMillis()));
//		int result = service.addTip(vo);
//		assertEquals(1, result);
//		System.out.println("팁 추가 성공");
//	}
//
//	@Test
//	public void testDeleteTip() {
//		int result = service.deleteTip(1);
//		assertTrue(result >= 0);
//		System.out.println("팁 삭제 성공: " + result);
//	}
//
//	@Test
//	public void testDeleteAllTips() {
//		int result = service.deleteAllTips(1);
//		assertTrue(result >= 0);
//		System.out.println("전체 팁 삭제 성공: " + result);
//	}
//
//	@Test
//	public void testGetRecentTips() {
//		Collection<CkVO> list = service.tipRecentSearch("집보기");
//		assertTrue(list.size()==0);
//		System.out.println(list);
//	}
//
//	@Test
//	public void testTips() {
//		Collection<CkVO> list = service.tipSearch("집보기");
//		assertTrue(list.size()==0);
//		System.out.println(list);
//	}
//
//	@Test
//	public void testBackCkCategoryList() {
//		Collection<String> list = service.backCkCategoryList();
//		assertTrue(list.size()==0);
//		System.out.println(list);
//	}
//
//	@Test
//	public void testBackCkTitleList() {
//		Collection<CkVO> list = service.backCkTitleList("집보기");
//		assertTrue(list.size()==0);
//		System.out.println(list);
//	}
//
//	@Test
//	public void testBackCkListSearch() {
//		Collection<CkVO> list = service.backCkListSearch();
//		assertTrue(list.size()==0);
//		System.out.println(list);
//	}
//
//	@Test
//	public void testDeleteBackCkList() {
//		int result = service.deleteBackCkList(38);
//		assertTrue(result >= 0);
//		System.out.println("이전 리스트 삭제 성공: " + result);
//	}
//
//	@After
//	public void after() {
//		System.out.println("Service 테스트 종료");
//	}
}