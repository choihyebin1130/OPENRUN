<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>구매자 로그인</title>
</head>
<body>
	<section>
		<div id="section_wrap">
			<div class="word">
				<h3>구매자로그인</h3>
			</div>
			<div class="login_form">
				<form action="<c:url value='/admin/member/loginConfirm' />" name="login_form" method="post">
						
					<input type="text" name="a_m_id" placeholder="아이디를 입력해주세요"> <br>
					<input type="password" name="a_m_pw" placeholder="비밀번호를 입력해주세요"> <br>
					<input type="button" value="login" onclick="loginForm();"> 
					<input type="reset" value="reset">
					
				</form>
			</div>
			<div class="find_password_create_account">
				<a href="<c:url value='/admin/member/findPasswordForm' />">비밀번호 찾기</a>
				<a href="<c:url value='/admin/member/createAccountForm' />">회원가입하기</a>
			</div>
		</div>
	</section>
</body>
</html>