<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	<section>
		<h3>회원가입에 실패했습니다</h3>		
		<div>
			<a href="<c:url value='/home/member/seller/createSellerAccountForm' />">다시하기</a>
		</div>
	</section>
</body>
</html>