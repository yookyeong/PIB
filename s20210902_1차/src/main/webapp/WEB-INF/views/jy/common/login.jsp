<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="../js/jquery1.js"></script>
<%
	String context = request.getContextPath(); 
%>
<script type="text/javascript">

function onBtnButtonClick(){
	if($('#mem_id').val() == ""){
		alert("아이디를 입력해주세요");
		return;
	}
	if($('#mem_passwd').val() == ""){
		alert("비밀번호를 입력해주세요");
		return;
	}
	
	var param = { "mem_id"		: $('#mem_id').val()
				, "mem_passwd"	: $('#mem_passwd').val() };
	
	$.ajax({
		url:"<%=context%>/cm/Login"
		, type:"POST"
		, data: param
		, dataType: "json"
		, success : function(data){
			if(data == "0"){
				alert("로그인에 성공하였습니다. 메인페이지로 이동합니다.");
 				$("#loginForm").submit();
			}
			else{
				alert("로그인에 실패하였습니다.\n아이디와 비밀번호를 확인해주세요.");
			}
		}
		, error : function onError (error){
			alert("로그인에 실패하였습니다.\n관리자에게 문의하세요.");
		}
	});

};



</script>
</head>
<body>
	<h2>로그인</h2>
	<form id="loginForm" action="<%=context%>/home" method="post">
		<div>
		
		<input type="text" name="mem_id" id="mem_id" required="required" value="" placeholder="아이디를 입력하세요" maxlength="20">
		<input type="password" name="mem_passwd" id="mem_passwd" required="required" placeholder="비밀번호를 입력하세요" maxlength="20">
		<button id="btnLogin" onclick="javascript:onBtnButtonClick(); return false;">로그인</button><br>
		<input type="button" value="ID/PW찾기" onclick="location.href='<%=context%>/cm/find'"> 
		
		</div>
	</form>



</body>
</html>