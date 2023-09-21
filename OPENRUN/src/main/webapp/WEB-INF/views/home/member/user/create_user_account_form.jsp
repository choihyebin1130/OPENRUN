<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="../../include/create_user_account_form_js.jsp"/>
<title>구매자 회원가입</title>
</head>
<body>
	<section>
			<div>
				<h3>구매자 회원가입 </h3>
			</div>
			<div class="create_user_account_form">
				<form action="<c:url value='/home/member/createAccountConfirm' />" name="create_user_account_form" method="post">
					
					<input type="text" name="u_id" placeholder="아이디."> <br>
					<input type="password" name="u_pw" placeholder="비밀번호."> <br>
					<input type="password" name="u_pw_again" placeholder="비밀번호 확인."> <br>
					<input type="text" name="u_name" placeholder="이름."> <br>
					<input type="text" name="u_birth" placeholder="생년월일."> <br>
					<input type="text" name="u_address" placeholder="주소."> <br>
					<input type="text" name="u_phone" placeholder="휴대폰 번호."> <br>
					<input type="email" name="u_email" placeholder="이메일." ><br>
					<select name="u_bank_name">
						<option value="">은행명</option>
						<option value="카카오뱅크">카카오뱅크</option>
						<option value="신한은행">신한은행</option>
						<option value="농협은행">농협은행</option>
						<option value="기업은행">기업은행</option>
					</select> <br>
					<input type="text" name="u_account_no" placeholder="계좌번호" ><br>
		
					<input type="button" value="가입완료" onclick="createUserAccountForm();">
				</form>
			</div>
	</section>
</body>
</html>