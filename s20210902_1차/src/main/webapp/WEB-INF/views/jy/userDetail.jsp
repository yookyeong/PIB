<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
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
			<td><button onclick="#">탈퇴</button> </td>
		</tr>
		<tr>
			<td colspan="2"><input type="button" value="목록" 	onclick="location.href='memberList'"> 
			<input type="button" value="수정" onclick="location.href='updateForm?mem_no=${member.mem_no}'">
			<input type="button" value="삭제" onclick="location.href='delete?mem_no=${member.mem_no}'" ></td>
		</tr>
	</table>

</body>
</html>