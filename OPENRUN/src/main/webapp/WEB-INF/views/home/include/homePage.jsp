<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<body>
	<!-- 로그인 전 -->
		<div class="menu">
			<ul>
				<li><a href="<c:url value='/home/user/loginForm' />">구매자 로그인</a></li>
				<li><a href="<c:url value='/home/user/loginFormm' />">판매자 로그인</a></li>
				<li><a href="<c:url value='/home/user/createAccountForm'/>">회원가입</a></li>
			</ul>
		</div>
</body>