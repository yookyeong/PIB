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
</head>

<body>
<form id="detailDelite">
	<h1>상세정보</h1>
	<table>
		<tr>
			<th>번호</th>
			<td>${member.mem_no }</td>
		</tr>
		<tr>
			<th>아이디</th>
			<td>${member.mem_id }</td>
		</tr>
		<tr>
			<th>비밀번호</th>
				<td>${member.mem_passwd }</td>
		</tr>
		<tr>
			<th>이름</th>
				<td>${member.mem_name }</td>
		</tr>
		<tr>
			<th>전화번호</th>
				<td>${member.mem_tel }</td>
		</tr>
		<tr>
			<th>이메일</th>
				<td>${member.mem_email }</td>
		</tr>
		<tr>
			<th>주소</th>
				<td>${member.mem_address1 }<br>
					${member.mem_address2 }<br>
					${member.mem_address3 }</td>
		</tr>
		<tr>
			<th>탈퇴</th>
			<td><pp>${member.mem_delete }</pp>
		</tr>
		<tr>
			<td colspan="2">
			<input type="button" value="홈" onclick="location.href='<%=context%>/home'">
			<input type="button" value="수정" onclick="location.href='<%=context%>/user/update?mem_no=${member.mem_no}'">
			<input type="button" value="삭제" onclick="location.href='<%=context%>/mng/detailUserDelete?mem_no=${member.mem_no}'" ></td>
		</tr>
	</table>
</form>
</body>
</html>