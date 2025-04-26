<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>FAQ</title>
  <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap" rel="stylesheet">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.5/dist/css/bootstrap.min.css" rel="stylesheet" crossorigin="anonymous">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">
  <link rel="stylesheet" href="css/component.css">
</head>
<body>
  <div class="page-layout">
    <!-- 상단바 -->
    <nav class="navbar">
      <div class="container">
        <a class="navbar-brand" href="controller?cmd=ckHomeUI">
          <img src="image/logo.png" alt="로고" />
        </a>
        <div class="menu-wrapper">
          <a class="nav-link" href="#">체크리스트</a>

          <div class="dropdown">
            <a class="nav-link dropdown-toggle no-underline" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">지원금 정보</a>
            <ul class="dropdown-menu dropdown-menu-end">
              <li><a class="dropdown-item" href="#">현재 지원금 정보</a></li>
              <li><a class="dropdown-item" href="#">이전 지원금 정보</a></li>
            </ul>
          </div>

          <a class="nav-link" href="#">치안 정보</a>

          <div class="dropdown">
            <a class="nav-link dropdown-toggle no-underline" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">문의하기</a>
            <ul class="dropdown-menu dropdown-menu-end">
              <li><a class="dropdown-item" href="controller?cmd=askUI">FAQ</a></li>
              <li><a class="dropdown-item" href="controller?cmd=soloAskUI">1:1 문의하기</a></li>
            </ul>
          </div>
        </div>
      </div>
    </nav>

    <!-- 메인 -->
    <div class="main">
      <div class="container">
        <h1>FAQ</h1>
        <hr class="my-4">
        <div class="faq-list">
          <c:forEach var="faq" items="${faqList}">
            <div class="faq-item">
              <div class="faq-question">
                ${faq.faqTitle}
                <span class="faq-icon"><i class="bi bi-chevron-down"></i></span>
              </div>
              <div class="faq-answer">
                ${faq.faqContent}
              </div>
            </div>
          </c:forEach>
        </div>

        <div class="text-center mt-5">
          <button class="middle" onclick="location.href='controller?cmd=soloAskUI'">1:1 문의하기</button>
        </div>
      </div>
    </div>

    <!-- 푸터 -->
    <div class="footer">
      <div class="container">
        <div class="footer-left">
          <span>상호명: <span class="bok-name">복덩이 부동산</span> <img src="image/logo.png" id="img-bok1" /></span>
          <span>복덩이: 김정훈, 박종석, 정현아, 박희수</span>
        </div>
        <div class="footer-middle">
          <span>주소: 서울 금천구 가산디지털1로 912호 호서대벤처타워 9층</span>
          <span>문의: kebin10804@gmail.com</span>
        </div>
        <div class="footer-bok">
          <img src="image/bok.png" class="img-bok2" />
        </div>
      </div>
    </div>

    <!-- Bootstrap 및 동작 스크립트 -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.5/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>

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

    <!-- FAQ 아코디언 -->
    <script>
      const faqItems = document.querySelectorAll('.faq-item');

      faqItems.forEach(item => {
        const question = item.querySelector('.faq-question');
        const answer = item.querySelector('.faq-answer');
        const icon = item.querySelector('.faq-icon i');

        question.addEventListener('click', () => {
          const isActive = item.classList.contains('active');

          faqItems.forEach(otherItem => {
            if (otherItem !== item) {
              otherItem.classList.remove('active');
              const otherAnswer = otherItem.querySelector('.faq-answer');
              const otherIcon = otherItem.querySelector('.faq-icon i');
              otherAnswer.style.maxHeight = null;
              otherIcon.classList.remove('bi-chevron-up');
              otherIcon.classList.add('bi-chevron-down');
            }
          });

          if (!isActive) {
            item.classList.add('active');
            answer.style.maxHeight = answer.scrollHeight + "px";
            icon.classList.remove('bi-chevron-down');
            icon.classList.add('bi-chevron-up');
          } else {
            item.classList.remove('active');
            answer.style.maxHeight = null;
            icon.classList.remove('bi-chevron-up');
            icon.classList.add('bi-chevron-down');
          }
        });
      });
    </script>
  </div>
</body>
</html>
