<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<!DOCTYPE html >
<html><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title></head><body>
<h2>공지사항</h2>

<%--  <p>kkk Update 수정 결과  Message : ${kkk} <p>
 <p>kk3 수정시 전달  Message : ${kk3} <p> --%>
 

<table>
	<tr>
		<th>번호</th><th>작성자</th><th>제목</th><th>등록일</th><th>마감일</th>
	</tr>
	<c:forEach var="notice" items="${listNotice }">
		<tr>
			<td>${notice.n_num }</td>
			<td>관리자</td>
			<td><a href="noticeDetail?n_num=${notice.n_num}">${notice.n_title}</a></td>
			<td>${notice.n_reg_date}</td>
			<td>${notice.n_date}</td>
		</tr>
	</c:forEach>
</table>
<c:if test="${pg.startPage > pg.pageBlock }">
	<a href="noticeList?currentPage=${pg.startPage-pg.pageBlock}">[이전]</a>
</c:if>
<c:forEach var="i" begin="${pg.startPage}" end="${pg.endPage}">
	<a href="noticeList?currentPage=${i}">[${i}]</a>
</c:forEach>
<c:if test="${pg.endPage < pg.totalPage }">
	<a href="noticeList?currentPage=${pg.startPage+pg.pageBlock}">[다음]</a>
</c:if>
<br>
<br>
<a href="noticeWriteForm">입력</a>
</body>
</html>