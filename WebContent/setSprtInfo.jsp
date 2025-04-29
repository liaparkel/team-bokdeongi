<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.bok.model.SprtPersonVO"%>
<%@ page import="java.util.List"%>
<%@ page import="com.bok.model.SprtContentVO"%>
<%@ page import="com.bok.model.SprtInfoVO"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.text.ParseException"%>

<%
	SprtPersonVO person = (SprtPersonVO) request.getAttribute("person");
	List<SprtContentVO> contentList = (List<SprtContentVO>) request.getAttribute("contentList");
	String category = (String) request.getAttribute("category");

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	// 날짜가 String 타입인 경우, 먼저 Date로 변환
	String startDateFormatted = "";
	String endDateFormatted = "";

	if (person != null) {
		try {
			if (person.getStart() != null) {
				Date startDate = sdf.parse(person.getStart().toString());
				startDateFormatted = sdf.format(startDate);
			}
			if (person.getEnd() != null) {
				Date endDate = sdf.parse(person.getEnd().toString());
				endDateFormatted = sdf.format(endDate);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
%>
<%
	
%>
<%
	String msg = (String) request.getAttribute("message");
%>
<%
	if (msg != null) {
%>
<div class="alert alert-danger"><%=msg%></div>
<%
	}
%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>관리자 지원금 글 수정</title>
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap"
	rel="stylesheet" />
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.5/dist/css/bootstrap.min.css"
	rel="stylesheet" />
<link rel="stylesheet" href="css/component.css" />
<link rel="stylesheet" href="css/setSprtInfo.css" />
</head>
<body>
	<div class="page-layout">
		<!-- 관리자용 상단바 -->
		<nav class="navbar">
			<div class="container">
				<a class="navbar-brand" href="#"> <img src="image/logo.png"
					alt="로고" />
				</a>

				<!-- 로고 옆 관리자 텍스트 + 로그아웃 버튼 -->
				<div class="admin-info d-flex align-items-center ms-3">
					<span class="admin-greeting">관리자님 안녕하세요.</span>
					<button class="logout-btn ms-2">로그아웃</button>
				</div>

				<!-- 메뉴 항목 -->
				<div class="menu-wrapper ms-auto">
					<div class="dropdown">
						<a class="nav-link dropdown-toggle no-underline" href="#"
							role="button" data-bs-toggle="dropdown" aria-expanded="false">
							체크리스트 </a>
						<ul class="dropdown-menu dropdown-menu-end">
							<li><a class="dropdown-item" href="#">현재 체크리스트</a></li>
							<li><a class="dropdown-item" href="#">이전 체크리스트</a></li>
						</ul>
					</div>
					<div class="dropdown">
						<a class="nav-link dropdown-toggle no-underline" href="#"
							role="button" data-bs-toggle="dropdown" aria-expanded="false">
							지원금 정보 </a>
						<ul class="dropdown-menu dropdown-menu-end">
							<li><a class="dropdown-item" href="#">현재 지원금 정보</a></li>
							<li><a class="dropdown-item" href="#">이전 지원금 정보</a></li>
						</ul>
					</div>
					<div class="dropdown">
						<a class="nav-link dropdown-toggle no-underline" href="#"
							role="button" data-bs-toggle="dropdown" aria-expanded="false">
							문의관리 </a>
						<ul class="dropdown-menu dropdown-menu-end">
							<li><a class="dropdown-item" href="#">FAQ관리</a></li>
							<li><a class="dropdown-item" href="#">1:1 문의관리</a></li>
						</ul>
					</div>
				</div>
			</div>
		</nav>



		<!-- 메인 -->
		<div class="main">
			<form action="controller" method="post" accept-charset="UTF-8">
				<input type="hidden" id="cmd" name="cmd" value="setSprtAdd" /> <input
					type="hidden" id="fkSprtNum" name="fkSprtNum"
					value="<%=person != null ? person.getFkSprtNum() : ""%>"> <input
					type="hidden" id="sprtpNum" name="sprtpNum"
					value="<%=person != null ? person.getSprtpNum() : ""%>">

				<div class="main">
					<div class="container">
						<h1><%=category != null ? category : "기본값"%></h1>

						<div class="gray-line"></div>
						<h2>제목</h2>
						<input type="text" class="text-input tip-box" name="sprtTitle"
							value="<%=person != null ? person.getTitle() : ""%>">

						<h2>요약</h2>
						<input type="text" class="text-input tip-box" name="sprtSummary"
							value="<%=person != null ? person.getSummary() : ""%>">

						<h2>지원 기간</h2>
						<div class="row mb-3">
							<div class="col-md-6">
								<label for="startDate" class="form-label">지원 시작일</label> <input
									type="date" class="form-control" id="startDate"
									name="startDate" value="<%=startDateFormatted%>">
							</div>
							<div class="col-md-6">
								<label for="endDate" class="form-label">지원 종료일</label> <input
									type="date" class="form-control" id="endDate" name="endDate"
									value="<%=endDateFormatted%>">
							</div>
						</div>
						<div class="gray-line"></div>
						<h2>내용</h2>
						<div class="content-area">
							<%
								if (contentList != null) {
									for (SprtContentVO content : contentList) {
							%>
							<div class="content-block">
								<input type="hidden" name="sprtpcNumList"
									value="<%=content.getSprtpcNum()%>"> <input type="text"
									class="text-input tip-box" name="sprtSubTitleList"
									value="<%=content.getSubtitle()%>">
								<textarea class="text-input tip-box" name="sprtTextList"><%=content.getContent()%></textarea>
							</div>
							<%
								}
								} else {
							%>
							<div class="content-block">
								<input type="text" class="text-input tip-box"
									name="sprtSubTitleList" placeholder="본문의 소제목을 작성해주세요.">
								<textarea class="text-input tip-box" name="sprtTextList"
									placeholder="본문의 내용을 작성해주세요."></textarea>
							</div>
							<%
								}
							%>
						</div>

						<div class="tip-box add-content">
							<button type="button" class="btn btn-outline-danger"
								id="removeContentBtn">-</button>
							<button type="button" class="btn btn-outline-secondary"
								id="addContentBtn">+</button>
						</div>

						<h3 class="link">링크 수정하기</h3>
						<input type="url" class="text-input tip-box" name="sprtLink"
							value="<%=(person != null && person.getLink() != null) ? person.getLink() : ""%>">
						<div class="button-wrapper">
							<button type="button" id="cancel" class="small"
								name="addSprtMenuDelete">삭제</button>
							<button type="button" id="update" class="small"
								name="addSprtMenuUpdate">수정</button>
							<button type="button" id="add" class="small"
								name="addSprtMenuSave">추가</button>

						</div>

					</div>
				</div>
			</form>
		</div>
	</div>

	<!-- 본문 추가 or 삭제하는 동작 -->
	<script>
  const addContentBtn = document.getElementById("addContentBtn");
  const contentArea = document.querySelector(".content-area");

  addContentBtn.addEventListener("click", () => {
	  const newBlock = document.createElement("div");
	  newBlock.classList.add("content-block");
	  newBlock.innerHTML = `
	    <input type="text" class="text-input tip-box" name="sprtSubTitleList" placeholder="본문의 소제목을 작성해주세요.">
	    <textarea class="text-input tip-box" name="sprtTextList" placeholder="본문의 내용을 작성해주세요."></textarea>
	  `;
	  contentArea.appendChild(newBlock);
	});

  const removeContentBtn = document.getElementById("removeContentBtn");

  removeContentBtn.addEventListener("click", () => {
    const blocks = document.querySelectorAll(".content-block");
    if (blocks.length > 1) {
      blocks[blocks.length - 1].remove(); // 마지막 블록 삭제
    }
  });
</script>
	<!-- Bootstrap JS -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.5/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-k6d4wzSIapyDyv1kpU366/PK5hCdSbCRGRCMv+eplOQJWyd1fbcAu9OCUj5zNLiq"
		crossorigin="anonymous"></script>
	<script>

	document.addEventListener("DOMContentLoaded", function () {
	    const form = document.querySelector("form");

	    document.getElementById("update").addEventListener("click", function () {
	        document.getElementById("cmd").value = "setSprtUpdate";
	        form.submit();
	    });

	    document.getElementById("add").addEventListener("click", function () {
	        document.getElementById("cmd").value = "setSprtAdd";
	        form.submit();
	    });

	    document.getElementById("cancel").addEventListener("click", function () {
	        if (confirm("정말 삭제하시겠습니까?")) {
	            document.getElementById("cmd").value = "setSprtDelete";
	            form.submit();
	        }
	    });
	});
</script>

	<!-- 상단바 동작 스크립트 -->
	<script>
    document.addEventListener("DOMContentLoaded", function () {
      const navLinks = document.querySelectorAll('.nav-link');
      const dropdownItems = document.querySelectorAll('.dropdown-item');

      function clearActiveLinks() {
        navLinks.forEach(link => link.classList.remove('active'));
      }

      navLinks.forEach(link => {
        link.addEventListener('click', function () {
          clearActiveLinks();
          if (!this.classList.contains('dropdown-toggle')) {
            this.classList.add('active');
          }
        });
      });
      // 드롭다운 항목 클릭 시  active 부여
      dropdownItems.forEach(item => {
        item.addEventListener('click', function () {
          clearActiveLinks();
          const parentDropdown = this.closest('.dropdown');
          const toggle = parentDropdown?.querySelector('.dropdown-toggle');
          if (toggle) toggle.classList.add('active');
        });
      });
    });
  </script>
</body>
</html>
