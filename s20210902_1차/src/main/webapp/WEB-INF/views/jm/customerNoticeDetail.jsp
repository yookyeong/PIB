<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<!DOCTYPE html>
<html><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title></head><body>
<h2>공지사항 내용</h2> 
<table>
	<tr><th>번호</th><td>${notice.n_num }</td></tr>
	<tr><th>제목</th><td>${notice.n_title }</td></tr>
	<tr><th>내용</th><td>${notice.n_content }</td></tr>
	<tr><th>마감일</th><td>${notice.n_date }</td></tr>
	
	<tr><td colspan="2">
	    <input type="button" value="목록" 
			onclick="location.href='customerNoticeList'">
</table>
</body>
</html>