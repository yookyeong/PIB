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
<h2>위시리스트</h2>
<table border="1">
	<thead>
		<tr>
			<th>상품이미지</th><th>상품명</th><th>상품가격</th>
		</tr>
	</thead>
	<c:if test="${total > 0 }">
		<c:forEach var="wishList" items="${wishList }">
		<tbody>
			<tr>
				<td>${wishList.p_img }</td>
				<td>${wishList.p_name }</td>
				<td>${wishList.p_price }원</td>
				<td><a href="bhDetail?p_code=${wishList.p_code}">장바구니</a></td><!-- 보훈님상세로 이동 -->
				<td><a href="wishListDelete?p_code=${wishList.p_code}&w_num=${wishList.w_num}">취소하기</a></td>
			</tr>
		</tbody>
		</c:forEach>
	</c:if>
	<c:if test="${total == 0 }">
	위시리스트에 담긴 상품이 없습니다
	</c:if>
	</table>
<div>
<c:if test="${pg.startPage > pg.pageBlock }">
	<a href="wishList?currentPage=${pg.startPage-pg.pageBlock}">[이전]</a>
</c:if>
<c:forEach var="i" begin="${pg.startPage}" end="${pg.endPage}">
	<a href="wishList?currentPage=${i}">[${i}]</a>
</c:forEach>
<c:if test="${pg.endPage < pg.totalPage }">
	<a href="wishList?currentPage=${pg.startPage+pg.pageBlock}">[다음]</a>
</c:if>
</div>
</body>
</html>