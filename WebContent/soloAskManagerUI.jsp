<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<style>
.divimg {
	text-align: center;
}

#ask-list {
	width: 80% !important;
	margin: 0 auto;
}

.write-btn-container {
	width: 80%;
	margin: 1.5rem auto 0;
	display: flex;
	justify-content: space-between; /* 오른쪽 정렬 -> 양쪽 정렬로 변경 */
	align-items: center; /* 세로 가운데 정렬 추가 */
	transition: margin-top 0.3s ease;
}

.modal {
	display: none;
	position: fixed;
	z-index: 1;
	left: 0;
	top: 0;
	width: 100%;
	height: 100%;
	overflow: auto;
	background-color: rgba(0, 0, 0, 0.4);
	padding-top: 60px;
}

.modal-content {
	background-color: #fefefe;
	margin: 5% auto;
	padding: 20px;
	border: 1px solid #888;
	width: 80%;
	max-width: 400px;
}

.close {
	color: #aaa;
	float: right;
	font-size: 28px;
	font-weight: bold;
}

.close:hover, .close:focus {
	color: black;
	text-decoration: none;
	cursor: pointer;
}

.btn-info {
	background-color: #f4b400 !important;
	border: 0px !important;
}
</style>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>관리자 1:1 문의 관리</title>
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap"
	rel="stylesheet" />
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.5/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-SgOJa3DmI69IUzQ2PVdRZhwQ+dy64/BUtbMJw1MZ8t5HZApcHrRKUc4W0kG879m7"
	crossorigin="anonymous" />
<link rel="stylesheet" href="css/component.css" />
<link rel="stylesheet" href="css/askManagerUI.css" />
</head>
<body>
	<div class="page-layout">
		<!-- 관리자용 상단바 -->
		<nav class="navbar">
			<div class="container">
				<a class="navbar-brand" href="controller?cmd=ckHomeManagerUI"> <img
					src="image/logo.png" alt="로고" />
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
							<li><a class="dropdown-item"
								href="controller?cmd=askManagerUI">FAQ</a></li>
							<li><a class="dropdown-item"
								href="controller?cmd=soloAskManagerUI">1:1 문의관리</a></li>
						</ul>
					</div>
				</div>
			</div>
		</nav>

		<!-- 메인 -->
		<div class="main">
			<div class="container ask">
				<div class="divimg">
					<img src="image/solo.png">
				</div>

				<!-- 문의 항목 (DB에서 불러오기) -->
				<c:forEach var="item" items="${sessionScope.soloList}">
					<div id="ask-list" class="space-between">
						<div class="ask-item">${item.askNum}</div>
						<div class="ask-item">${item.email}</div>
						<div class="ask-item title-ellipsis">${item.askTitle}</div>
						<div class="ask-item">${item.soloDate}</div>
						<div class="ask-item">
							답변여부:
							<c:choose>
								<c:when test="${not empty item.soloAnswer}">답변 완료</c:when>
								<c:otherwise>답변 대기</c:otherwise>
							</c:choose>
						</div>
						<div class="ask-item">
							<button class="btn btn-info"
								onclick="openModal('controller?cmd=soloAskDetailUI&askNum=${item.askNum}')">답변하기</button>



						</div>
					</div>
				</c:forEach>

				<!-- 페이지네이션 -->
				<div class="pagination-container d-flex justify-content-center">
					<nav aria-label="Page navigation example">
						<ul class="pagination">
							<li class="page-item"><a class="page-link" href="#"
								aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
							</a></li>
							<li class="page-item"><a class="page-link" href="#">1</a></li>
							<li class="page-item"><a class="page-link" href="#">2</a></li>
							<li class="page-item"><a class="page-link" href="#">3</a></li>
							<li class="page-item"><a class="page-link" href="#"
								aria-label="Next"> <span aria-hidden="true">&raquo;</span>
							</a></li>
						</ul>
					</nav>
				</div>
			</div>
		</div>

		<!-- 푸터 -->
		<div class="footer">
			<div class="container">
				<div class="footer-left">
					<span>상호명: <span class="bok-name">복덩이 부동산</span> <img
						src="image/logo.png" id="img-bok1" /></span> <span>복덩이: 김정훈, 박종석,
						정현아, 박희수</span>
				</div>
				<div class="footer-middle">
					<span>주소: 서울 금천구 가산디지털1로 912호 호서대벤처타워 9층</span> <span>문의:
						kebin10804@gmail.com</span>
				</div>
				<div class="footer-bok">
					<img src="image/bok.png" class="img-bok2" />
				</div>
			</div>
		</div>
	</div>

	<!-- 모달 -->
	<div id="passwordModal" class="modal">
		<div class="modal-content">
			<span class="close" onclick="closeModal()">&times;</span>
			<h3>비밀번호를 입력하세요</h3>
			<input type="password" id="password" placeholder="비밀번호 입력"
				class="form-control" />
			<div class="d-flex justify-content-between">
				<button class="btn btn-secondary" onclick="closeModal()">취소</button>
				<button class="btn btn-primary" onclick="checkPassword()">확인</button>
			</div>
		</div>
	</div>

	<!-- Bootstrap JS -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.5/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-k6d4wzSIapyDyv1kpU366/PK5hCdSbCRGRCMv+eplOQJWyd1fbcAu9OCUj5zNLiq"
		crossorigin="anonymous"></script>

	<script>
    const correctPassword = "1234"; // 임시 비밀번호

    function openModal(targetUrl) {
        document.getElementById("passwordModal").style.display = "block";
        document.getElementById("passwordModal").setAttribute("data-url", targetUrl);
    }

    function closeModal() {
        document.getElementById("passwordModal").style.display = "none";
    }

    function checkPassword() {
        const enteredPassword = document.getElementById("password").value;
        const targetUrl = document.getElementById("passwordModal").getAttribute("data-url");
        if (enteredPassword === correctPassword) {
            closeModal();
            window.location.href = targetUrl;
        } else {
            alert("비밀번호가 틀렸습니다.");
        }
    }
</script>

	<!-- 상단바 동작 -->
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
