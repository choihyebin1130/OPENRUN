<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<c:url value='/resources/reservation/payment.css'  var="css"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="${css}" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<!-- 아임포트 -->
<script src ="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js" type="text/javascript"></script>
<title>결제하기</title>
</head>
<body>
<script>
$(document).ready(function() {
    $('#count').on('input', function(e) {
        var inputVal = $('#count').val();
        if ($.isNumeric(inputVal)) {
        	var p_price = $('.p_price').data('p-price');
            var amountValue = p_price * parseInt(inputVal, 10);
            $('#amount').val(amountValue);
            $('#amount').text(amountValue);
        } else {
            $('#count').val("");
        }
    });

});
$(document).ready(function() {
    $(document).on("click", "#button", function() {
        IMP.init('imp81761073');
        var p_no = $('.p_no').data('p-no');
        var p_name = $('.p_name').data('p-name');
        // 결제 창을 열기 위한 코드
        IMP.request_pay({
            pg: 'kakaopay',
            pay_method: 'kakaopay',
            merchant_uid: 'openrun_' + new Date().getTime(),
            name: p_name,
            amount: $('#amount').val(),
            buyer_email: '${userLoginResult.u_email}',
            buyer_name: '${userLoginResult.u_name}',
            buyer_tel: '${userLoginResult.u_phone}',
            buyer_addr: '${userLoginResult.u_address}'
        }, function(rsp) {
            console.log(rsp);
            console.log("결제 검증");
            // 결제 검증
            $.ajax({
                type: "POST",
                url: "/ticket/verifyIamport/" + rsp.imp_uid
            }).done(function(data) {
                // rsp.paid_amount와 data.response.amount를 비교한 후 로직 실행 (Iamport 서버 검증)
                if (rsp.paid_amount == data.response.amount) {
                    console.log("여기임");
                    //var r_no = rsp.imp_uid;
                    var u_no = ${userLoginResult.user_no};
                    var r_count = $('#count').val();
                    var r_amount = $('#amount').val();
                    var pay_no = 'openrun_' + new Date().getTime();

                    console.log(u_no);
                    console.log(r_count);
                    console.log(r_amount);
                    console.log(p_no);
                    $.ajax({
                        type: "POST",
                        url: "insertReservation",
                        data: JSON.stringify({
                        	p_no: p_no,
                            r_count: r_count,
                            r_amount: r_amount,
                            u_no: u_no,
                            pay_no: pay_no
                        }),
                        contentType: "application/json",
                        dataType: "text"
                    }).done(function(result) {
                    	console.log(result);
                    	if (result === '1') {
                    	    alert('결제가 완료 되었습니다');
                    	    window.location.href = "/ticket";
                    	} else {
                    	    alert('결제 실패');
                    	    console.log('결제 실패');
                    	}
                    });
                }
            });
        });
    });
});
</script>
<jsp:include page="../common/header.jsp" />
<form name="insertReservation" action="<c:url value='/insertReservation' />" method="POST" >
	<div id="main_container">
		<div id="main_container_sub">
			<div id="main_content_container">결제하기</div>
		</div>
		<div id="main_content">
			<div id="left_content">
			<c:forEach items="${exProductDetail}" var="exProductDetail">
				<div class="content">상품명 :<span class="p_name" data-p-name="${exProductDetail.p_name}">${exProductDetail.p_name}</span> </div>
				<div class="content">장소 : <span class="p_no" data-p-no="${exProductDetail.p_no}">${exProductDetail.p_location}</span> </div>
				<div class="content">관람일 : <span>${exProductDetail.p_perfo_start_date}</span> </div>
				<div  class="content">가격 : <span class="p_price" data-p-price="${exProductDetail.p_price}">${exProductDetail.p_price}</span> </div>
			</c:forEach>
				<div class="content" id="count_content">
					<div>갯수 : </div>
					<input class="input_text" type="text" id="count" autocomplete="off"  placeholder="숫자를 입력해 주세요" />
				</div>
				<div class="content" id="amount_content">
					<div >총 결제 가격 : </div> 
					<label id="amount"></label>
				</div>
			</div>
			<div id="right_content">
                <div class="content">이름 : <span> ${userLoginResult.u_name} </span></div>
                <div class="content">생년월일 : <span> ${userLoginResult.u_birth} </span></div>
                <div class="content">휴대폰 번호 : <span> ${userLoginResult.u_phone} </span></div>
                <div class="content">이메일 : <span> ${userLoginResult.u_email}</span></div>
            </div>
		</div>
		<button class="next_button" id="button"onclick="return false;"> 결제하기 </button>
	</div>
</form>
<jsp:include page="../common/footer.jsp" />
</body>
</html>