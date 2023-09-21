<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 회원가입 페이지 </title>
</head>
<body>
	<ul>
		<li><a href="<c:url value='/home/member/user/createUserAccountAgreementForm'/>">구매자 회원가입</a></li>
		<li><a href="<c:url value='/home/member/seller/createSellerAccountAgreementForm'/>">판매자 회원가입</a></li>
	</ul>
</body>
</html>