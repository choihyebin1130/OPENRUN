<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
 <c:url value="/resources/footer.css" var="css"/> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="${css}" rel="stylesheet">
</head>
<body>
<div class="footer-container">
	<div class="footer-container-sub">
		<div id="footer-logo">
		</div>
	 	<div id="footer-company">
			주식회사 오픈런 <br>
			대표이사: 윤황집 ｜ 서울특별시 강남구 테헤란로14길 6  <br>
			사업자등록번호: 105-00-00000 <br>
			통신판매업신고: 2023-서울강남-2023  <br>
			<div id= "personal" onclick="goToPersonal()">개인정보처리방침</div><br>
		</div>
		<div id="footer-as">
			<div>
				<button class="footer-as-btn" id="freq">❓자주묻는질문</button>
				<button class="footer-as-btn" id="one-on-one">📒1:1문의하기</button>
				<button class="footer-as-btn" id="notice">🔈공지사항</button>
			</div>
			<div>🚨 고객센터 ></div>
			<div>1544-9970</div>
			<div>월-금 10:00-18:00 (주말·공휴일 휴무)</div>
		</div>
	</div>
</div>

</body>
</html>