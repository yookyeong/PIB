<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2>회원 List</h2>
	<table>
		<tr>
			<th>번호</th>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이름</th>
			<th>전화번호</th>
			<th>이메일</th>
			<th>주소</th>
		</tr>
		<c:forEach var="member" items="${memberList }">
			<tr>
				<td>${member.mem_no }</td>
				<td>${member.mem_id }</td>
				<td>${member.mem_passwd }</td>
				<td><a href="detail?mem_no=${member.mem_no }"> ${member.mem_name }</a></td>
				<td>${member.mem_tel }</td>
				<td>${member.mem_email }</td>
				<td>${member.mem_address1 }</td>
				<td>${member.mem_address2 }</td>
				<td>${member.mem_address3 }</td>
			</tr>
		</c:forEach>
	</table>


</body>
</html>