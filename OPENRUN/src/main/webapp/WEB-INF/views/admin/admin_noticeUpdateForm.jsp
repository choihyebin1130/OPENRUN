<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url value="/resources/cs/css/admin_cs.css" var="css" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${css}">

<script>
    // 공지사항 정보에서 카테고리 값을 가져옵니다.
    var categoryValue = "${notice.category}"; 

    // 카테고리 값에 따라 라디오 버튼 선택
    if (categoryValue === "일반") {
        document.getElementById("normalType").checked = true;
    } else if (categoryValue === "시스템") {
        document.getElementById("systemType").checked = true;
    }
    
    // 카테고리 넘버 설정
    function setCategoryNo() {
        var categoryRadioButtons = document.getElementsByName("category");
        var selectedCategoryNo = 0; // 기본값으로 0을 설정

        // 라디오 버튼에서 선택된 카테고리를 찾아서 categoryNo를 설정
        for (var i = 0; i < categoryRadioButtons.length; i++) {
            if (categoryRadioButtons[i].checked) {
                switch (categoryRadioButtons[i].value) {
                    case "일반":
                        selectedCategoryNo = 10;
                        break;
                    case "시스템":
                        selectedCategoryNo = 11;
                        break;
                    default:
                        selectedCategoryNo = 0; // 다른 경우에 대한 기본값
                        break;
                }
             // 디버그: 선택된 categoryNo를 콘솔에 출력
                console.log("Selected CategoryNo: " + selectedCategoryNo);
            }
        }
        // 설정된 categoryNo를 숨겨진 필드에 설정
        document.getElementById("categoryNo").value = selectedCategoryNo;
    }

    $(document).on('click', '#form-cancel-btn', function() {
        $('#notice_btn').trigger('click');
    });

    $(document).off('click', '#form-submit-btn').on('click', '#form-submit-btn', function(e) {
        e.preventDefault(); // 기본 제출 동작 방지
        
        $.ajax({
            url: '/ticket/notice/updateNotice',
            type: 'POST',
            data: $('form').serialize(),
            success: function(response) {
                if (response == "success") {
                    $('#notice_btn').trigger('click'); // Success 응답시 버튼 클릭 동작 수행
                    $('form')[0].reset(); // 폼 초기화
                } else {
                    alert('Failed to submit form'); // 다른 응답시 알림 표시
                }
            },
            error: function() {
                alert('Error occurred while submitting the form');
            }
        });
    });

</script>
</head>
<body>
<form action="/ticket/notice/updateNotice" method="post">
	<div id="cs-board-title">
		<span>공지사항 수정</span>
	</div>
	<div id="input-form-container">
    <table class="input-table" id="notice-input-table">
        <tr>
            <td class="input-title">
                유형
            </td>
            <td class="input-content" id="notice-category">
                <input type="radio" name="category" value="일반" id="normalType" checked onclick="setCategoryNo()">
                <label for="normalType">일반</label>
                
                <input type="radio" name="category" value="시스템" id="systemType" onclick="setCategoryNo()">
                <label for="systemType">시스템</label>
                
                <input type="hidden" id="categoryNo" name="categoryNo" value="10">
                <input type="hidden" name="noticeNo" value="${notice.noticeNo}">
            </td>
        </tr>
        <tr>
            <td class="input-title">
                제목
            </td>
            <td class="input-content">
                 <textarea id="textarea-title" name="title" cols="72" rows="1">${notice.title}</textarea>   
            </td>        
        </tr>
        <tr>
            <td class="input-title" id="notice-body">
                내용
            </td>
            <td class="input-content">
                <textarea id="textarea-body" name="body" cols="72" rows="18">${notice.body}</textarea>          
            </td>        
        </tr>

        <tr align="right" valign="middle">
            <td colspan="5">  
                <input class="form-btn" id="form-submit-btn" type="submit" value="수정" >
                <input class="form-btn" id="form-cancel-btn" type="button" value="취소" >           
            </td>
        </tr>
    </table>
    </div>    
</form>
</body>
</html>
