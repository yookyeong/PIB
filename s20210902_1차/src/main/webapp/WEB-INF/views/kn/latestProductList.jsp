<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>최근 본 상품</title>
<style type="text/css">
A:link {text-decoration:none; color: #646464;}
A:visited {text-decoration:none; color: #646464;}
A:active {text-decoration:none; color: #646464;}
A:hover {text-decoration:none; color: #646464;}
</style>
</head>
<body>
<h2>최근 본 상품</h2>
<c:set var="num" value="${lp.total-pg.start+1}"></c:set>
	<table>
		<tr>
			<th></th>
			<th></th>
			<th></th>
		</tr>
		<c:forEach var="product" items="${latestProductList}">
			<tr>
				<td>${latestProduct.p_name}</td>
				<td><a href="bhDetail?p_code=${latestProduct.p_code}"><input type="image" src="${latestProduct.p_img }" style="width:150px;height:150px;"></a></td>
				<td>${latestProduct.p_price}</td>
				<td colspan="2">
					<input type="submit" value="삭제" > 
				</td>
			</tr>
			<c:set var="num" value="${num - 1 }"></c:set>
		</c:forEach>
	</table>
<div>
<c:if test="${lp.startPage > lp.pageBlock }">
	<a href="latestProductList?currentPage=${lp.startPage-lp.pageBlock}">[이전]</a>
</c:if>
<c:forEach var="i" begin="${lp.startPage}" end="${lp.endPage}">
	<a href="latestProductList?currentPage=${i}">[${i}]</a>
</c:forEach>
<c:if test="${lp.endPage < lp.totalPage }">
	<a href="latestProductList?currentPage=${lp.startPage+lp.pageBlock}">[다음]</a>
</c:if>
</div>
</body>
</html>