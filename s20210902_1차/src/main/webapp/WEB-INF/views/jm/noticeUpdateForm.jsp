<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title></head>
<body>
<h2>글정보</h2>
<form action="noticeUpdate" method="post">
  <input type="hidden" name="n_num" value="${notice.n_num }">
         
  <table>  
	<tr><th>제목</th><td>
	<input type="text" name="n_title" 	required="required" value="${notice.n_title }"></td></tr>
	<tr><th>내용</th><td>
	    <input type="text" name="n_content" required="required" value="${notice.n_content }" ></td></tr>
	<tr><th>등록일</th><td>
	    <input type="date" name="n_date" 	value="${notice.n_date }"></td></tr>
	
	<tr><td colspan="2">
	   <input type="submit" value="확인">
	   </td>
	</tr>
</table>
</form>
</body>
</html>