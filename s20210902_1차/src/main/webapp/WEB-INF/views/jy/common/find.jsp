<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript" src="../js/jquery1.js"></script>
<%
	String context = request.getContextPath(); 
%>
<script type="text/javascript">
function fn_btnFindIdClick(){
	var formData = $('#findId').serialize();
	
	$.ajax({
		url:'<%=context%>/cm/findId',
        type:'post', //POST 방식으로 전달
        data:formData,
        success:function(rtn){
            if(rtn.code == "0"){
            	alert("아이디는 [" + rtn.id + "]입니다.\n홈으로 이동하여, 다시 로그인 해주세요.");
            }else if(rtn.code == "-1"){
            	alert("잘못된 정보입니다 \n다시 입력해주세요.");
            	return;
            }
        },
        error:function(){
            alert("에러가 발생하였습니다. 관리자에게 문의하세요.");
        }
    });
}

function fn_btnFindPwClick(){
	var formData = $('#findPw').serialize();
	$.ajax({
		url:'<%=context%>/cm/findPw',
        type:'post', //POST 방식으로 전달
        data:formData,
        success:function(result){
            if(result == "0"){
            	alert("비밀번호는 [" + rtn.pw + "]입니다.\n홈으로 이동하여, 다시 로그인 해주세요.");
            }else if(result == "-1"){
            	alert("잘못된 정보입니다 \n다시 입력해주세요.");
            	return;
            }
        },
        error:function(){
            alert("에러가 발생하였습니다. 관리자에게 문의하세요.");
        }
    });
}
	

</script>


</head>
<body>
	<form id="findId">
		<table>
			<tr>
				<th>이름</th>
				<td><input type="text" name="mem_name" id="mem_name" required="required" /></td>
			</tr>
			<tr>
				<th>이메일</th>
				<td><input type="text" name="mem_email" id="mem_email" required="required" /></td>
			</tr>
			<tr>
				<th>전화번호</th>
				<td><input type="text" name="mem_tel" id="mem_tel" required="required" /></td>
			</tr>
			<tr>
				<td>
				<input type="button" value="아이디찾기" onclick="javascript:fn_btnFindIdClick(); return false;">
				</td>
			</tr>
		</table>
	</form>	
	<form id="findPw">
		<table>
			<tr>
				<th>아이디</th>
				<td><input type="text" name="mem_id" id="mem_id" required="required" /></td>
			</tr>
			<tr>
				<th>이름</th>
				<td><input type="text" name="mem_name" id="mem_name" required="required" /></td>
			</tr>
			<tr>
				<th>이메일</th>
				<td><input type="text" name="mem_email" id="mem_email" required="required" /></td>
			</tr>
			<tr>
				<th>전화번호</th>
				<td><input type="text" name="mem_tel" id="mem_tel" required="required" /></td>
			</tr>
			<tr>
				<td>
				<input type="button" value="비밀번호찾기" onclick="javascript:fn_btnFindPwClick(); return false;">
				</td>
			</tr>
		</table>	
	</form>
	<form id="goHome" action="<%=context%>/home" method="post">
	</form>
	



</body>
</html>