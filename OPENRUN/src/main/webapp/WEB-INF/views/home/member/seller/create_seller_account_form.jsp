<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="../../include/create_seller_account_form_js.jsp"/>
<title>판매자 회원가입</title>
</head>
<body>
	<section>
			<div>
				<h3>판매자 회원가입 </h3>
			</div>
			<div class="create_seller_account_form">
				<form action="<c:url value='/home/member/seller/createSellerAccountConfirm' />" name="create_seller_account_form" method="post">
					
					<input type="text" name="s_id" placeholder="아이디."> <br>
					<input type="password" name="s_pw" placeholder="비밀번호."> <br>
					<input type="password" name="s_pw_again" placeholder="비밀번호 확인."> <br>
					<input type="text" name="s_name" placeholder="사업자명."> <br>
					<input type="text" name="s_birth" placeholder="사업자등록번호."> <br>
					<input type="text" name="s_address" placeholder="주소."> <br>
					<input type="text" name="s_phone" placeholder="휴대폰 번호."> <br>
					<input type="email" name="s_email" placeholder="이메일." ><br>
					<select name="s_bank_name">
						<option value="">은행명</option>
						<option value="카카오뱅크">카카오뱅크</option>
						<option value="신한은행">신한은행</option>
						<option value="농협은행">농협은행</option>
						<option value="기업은행">기업은행</option>
					</select> <br>
					<input type="text" name="s_account_no" placeholder="계좌번호" ><br>
		
					<input type="button" value="승인신청" onclick="createSellerAccountForm();">
				</form>
			</div>
	</section>
</body>
</html>