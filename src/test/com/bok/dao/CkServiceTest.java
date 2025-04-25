package test.com.bok.dao;

import static org.junit.Assert.*;

import java.sql.Date;
import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.bok.model.CkVO;
import com.bok.service.CkService;

public class CkServiceTest {

    private CkService service;
    private CkVO vo;

    @Before
    public void before() {
        service = new CkService();
        vo = new CkVO();
        System.out.println("Service 테스트 시작");
    }

    @Test
    public void testCkListInfo() {
        Collection<CkVO> list = service.getCkListInfo("집보기");
        assertTrue(list.size()==0);
        System.out.println(list);
    }

    @Test
    public void testCkListRecentInfo() {
        Collection<CkVO> list = service.getCkListRecentInfo("집보기");
        assertTrue(list.size()==0);
        System.out.println(list);
    }

    @Test
    public void testSetCkList() {
        vo.setCkContentNum(3);
        vo.setCkContent("서비스 수정");
        vo.setCkTitle("서비스 제목");
        int result = service.updateCkList(vo);
        assertEquals(1, result);
        System.out.println("서비스 수정 결과: " + result);
    }

    @Test
    public void testAddCkList() {
        vo.setCkTitle("서비스 추가 제목");
        vo.setCkContent("서비스 추가 내용");
        vo.setCkNum(1);
        int result = service.addCkList(vo);
        assertEquals(1, result);
        System.out.println("서비스 추가 성공!");
    }

    @Test
    public void testDeleteCkList() {
        int result = service.deleteCkList(1);
        assertTrue(result >= 0);
        System.out.println("서비스 삭제 성공: " + result);
    }

    @Test
    public void testAddCkCategory() {
        vo.setckCategory("서비스카테고리");
        vo.setCkDate(new Date(System.currentTimeMillis()));
        int result = service.addCkCategory(vo);
        assertEquals(1, result);
        System.out.println("카테고리 추가 성공");
    }

    @Test
    public void testSetTip() {
        vo.setCkNum(35);
        vo.setTip("수정된 팁");
        int result = service.updateTip(vo);
        assertEquals(1, result);
        System.out.println("팁 수정 성공");
    }

    @Test
    public void testAddTip() {
        vo.setckCategory("집보기");
        vo.setTip("추가된 팁");
        vo.setCkDate(new Date(System.currentTimeMillis()));
        int result = service.addTip(vo);
        assertEquals(1, result);
        System.out.println("팁 추가 성공");
    }

    @Test
    public void testDeleteTip() {
        int result = service.deleteTip(1);
        assertTrue(result >= 0);
        System.out.println("팁 삭제 성공: " + result);
    }

    @Test
    public void testDeleteAllTips() {
        int result = service.deleteAllTips(1);
        assertTrue(result >= 0);
        System.out.println("전체 팁 삭제 성공: " + result);
    }

    @Test
    public void testGetRecentTips() {
        Collection<CkVO> list = service.getRecentTips("집보기");
        assertTrue(list.size()==0);
        System.out.println(list);
    }

    @Test
    public void testTips() {
        Collection<CkVO> list = service.getTips("집보기");
        assertTrue(list.size()==0);
        System.out.println(list);
    }

    @Test
    public void testBackCkCategoryList() {
        Collection<String> list = service.getBackCkCategoryList();
        assertTrue(list.size()==0);
        System.out.println(list);
    }

    @Test
    public void testBackCkTitleList() {
        Collection<CkVO> list = service.getBackCkTitleList("집보기");
        assertTrue(list.size()==0);
        System.out.println(list);
    }

    @Test
    public void testBackCkListSearch() {
        Collection<CkVO> list = service.getBackCkListSearch();
        assertTrue(list.size()==0);
        System.out.println(list);
    }

    @Test
    public void testDeleteBackCkList() {
        int result = service.deleteBackCkList(38);
        assertTrue(result >= 0);
        System.out.println("이전 리스트 삭제 성공: " + result);
    }

    @After
    public void after() {
        System.out.println("Service 테스트 종료");
    }
}