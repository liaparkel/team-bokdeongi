package test.com.bok.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
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

	// 카테고리 추가
	@Test
	public void addCkCategory() {
		String categoryName = "JUnit테스트카테고리V2"; // 테스트용 고유한 이름

		String result = cs.addCkCategory(categoryName);

		assertNotNull("카테고리 추가는 성공해야 한다.", result);
		assertEquals("리턴된 카테고리명이 입력한 값과 일치해야 한다.", categoryName, result);
	}

	// 카테고리 추가 실패(null 입력)
	@Test
	public void addCkCategory_fail_null() {
		String result = cs.addCkCategory(null);

		assertNull("null 입력 시 결과도 null이어야 한다.", result);
	}

	// 카테고리 추가 실패(빈 문자열 입력)
	@Test
	public void addCkCategory_fail_blank() {
		String result = cs.addCkCategory("");

		assertNull("빈 문자열 입력 시 결과도 null이어야 한다.", result);
	}
	
	// TIP+제목/본문 저장
	@Test
	public void saveCkContents() {
	    CkService service = new CkService();

	    int ckNum = 76; // 테스트용 임시 카테고리 번호 (미리 DB에 생성하기)
	    String tip = "JUnit 저장 테스트용 TIP";

	    List<CkContentVO> contentList = new ArrayList<>();
	    CkContentVO content1 = new CkContentVO();
	    content1.setTitle("JUnit 테스트 제목1");
	    content1.setContent("JUnit 테스트 본문1");

	    CkContentVO content2 = new CkContentVO();
	    content2.setTitle("JUnit 테스트 제목2");
	    content2.setContent("JUnit 테스트 본문2");

	    contentList.add(content1);
	    contentList.add(content2);

	    boolean result = service.saveCkContents(ckNum, tip, contentList);

	    assertTrue("TIP 수정 및 체크리스트 추가가 성공해야 한다.", result);
	}
	
	@Test
	public void saveCkContents_fail() {
	    CkService service = new CkService();

	    int invalidCkNum = -1; // 절대 존재할 수 없는 번호
	    String tip = "JUnit 실패 테스트용 TIP";

	    List<CkContentVO> contentList = new ArrayList<>();
	    CkContentVO content1 = new CkContentVO();
	    content1.setTitle("JUnit 실패 제목");
	    content1.setContent("JUnit 실패 본문");

	    contentList.add(content1);

	    boolean result = service.saveCkContents(invalidCkNum, tip, contentList);

	    assertFalse("존재하지 않는 ck_num이므로 저장은 실패해야 한다.", result);
	}
	
	// 카테고리 삭제(관련된 내용도 삭제)
	@Test
	public void cancelCkCategory() {
	    CkService service = new CkService();

	    int ckNum = 77; // 테스트용으로 미리 생성해둔 ck_num

	    boolean result = service.cancelCkCategory(ckNum);

	    assertTrue("카테고리 삭제가 성공해야 한다.", result);
	}
	
	@Test
	public void cancelCkCategory_fail() {
	    CkService service = new CkService();

	    int invalidCkNum = -1; // 절대 존재할 수 없는 번호

	    boolean result = service.cancelCkCategory(invalidCkNum);

	    assertFalse("존재하지 않는 ck_num이므로 삭제는 실패해야 한다.", result);
	}

}