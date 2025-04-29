//package test.com.bok.dao;
//
//import static org.junit.Assert.*;
//
//import java.sql.Date;
//import java.util.Collection;
//
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//
//import com.bok.model.CkDAO;
//import com.bok.model.CkVO;
//
//public class CkDAOTest {
//
//    private CkDAO dao;
//    private CkVO vo;
//
//    @Before
//    public void before() {
//        dao = new CkDAO();
//        vo = new CkVO();
//        System.out.println("테스트 시작");
//    }
//
//    // 체크리스트 제목, 내용 조회 성공
//    @Test
//    public void testCkListInfo() {
//        Collection<CkVO> list = dao.ckListInfo("집보기");
//        assertTrue(list.size()==0);
//        System.out.println(list);
//    }
//
//    // 체크리스트 최신순 조회
//    @Test
//    public void testCkListRecentInfo() {
//        Collection<CkVO> list = dao.ckListRecentInfo("집보기");
//        assertFalse("집보기 결과가 없습니다.", list.isEmpty());
//        System.out.println(list);
//    }
//
//    // 체크리스트 수정
//    @Test
//    public void testSetCkList() {
//        vo.setCkContentNum(3);
//        vo.setCkContent("수정 성공");
//        vo.setCkTitle("수정");
//        int result = dao.setCkList(vo);
//        assertEquals(1, result);
//        System.out.println("수정 결과: " + result);
//    }
//
//    // 체크리스트 글 추가
//    @Test
//    public void testAddCkList() {
//        vo.setCkTitle("추가");
//        vo.setCkContent("추가");
//        vo.setCkNum(5);
//        int result = dao.addCkList(vo);
//        assertEquals(1, result);
//        System.out.println("추가 성공!");
//    }
//
//    // 체크리스트 삭제
//    @Test
//    public void testDeleteCkList() {
//        vo.setCkContentNum(1);
//        int result = dao.deleteCkList(vo.getCkContentNum());
//        assertEquals(1, result);
//        System.out.println("삭제 성공: " + result);
//    }
//
//    // 카테고리 추가
//    @Test
//    public void testAddCategory() {
//        vo.setckCategory("감자");
//        vo.setCkDate(new Date(System.currentTimeMillis()));
//        int result = dao.addckCategory(vo);
//        assertEquals(1, result);
//        System.out.println("카테고리 추가 성공: " + result);
//    }
//
//    // 팁 최신 조회
//    @Test
//    public void testTipRecentSearch() {
//        Collection<CkVO> list = dao.TipRecentSearch("집보기");
//        assertTrue(list.size() == 0);
//        System.out.println(list);
//    }
//
//    // 팁 조회
//    @Test
//    public void testTipSearch() {
//        Collection<CkVO> list = dao.TipSearch("집보기");
//        assertTrue(list.size() == 0);
//        System.out.println(list);
//    }
//
//    // 팁 수정
//    @Test
//    public void testSetTip() {
//        vo.setCkNum(35);
//        vo.setTip("수정");
//        int result = dao.setTip(vo);
//        assertEquals(1, result);
//        System.out.println("팁 수정 결과: " + result);
//    }
//
//    // 팁 삭제
//    @Test
//    public void testDeleteTip() {
//        vo.setCkNum(1);
//        int result = dao.deleteTip(vo.getCkNum());
//        assertEquals(1, result);
//        System.out.println("팁 삭제 성공: " + result);
//    }
//
//    // 이전 카테고리 목록
//    @Test
//    public void testBackCategoryList() {
//        Collection<String> list = dao.BackCkCategoryList();
//        assertTrue(list.size()==0);
//       System.out.println(list);
//    }
//
//    // 이전 제목/날짜 조회
//    @Test
//    public void testBackCkTitleList() {
//        Collection<CkVO> list = dao.BackCkTitleList("집보기");
//        assertTrue(list.size() == 0);
//        System.out.println(list);
//    }
//
//    // 이전 제목/내용 삭제
//    @Test
//    public void testBackCkListDelete() {
//        int result = dao.backCkListDelete(38);
//        assertEquals(1, result);
//        System.out.println("삭제 결과: " + result);
//    }
//
//    // 이전 제목 클릭 시 속제목, 내용 조회
//    @Test
//    public void testBackCkListSearch() {
//        Collection<CkVO> list = dao.BackCkListSearch();
//        assertTrue(list.size() == 0);
//        System.out.println(list);
//    }
//
//    @After
//    public void after() {
//        System.out.println("테스트 종료");
//    }
//}
