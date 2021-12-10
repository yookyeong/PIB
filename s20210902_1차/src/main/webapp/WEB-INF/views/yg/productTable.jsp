<%@  page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
 var admin=${admin}
 if (admin == 1){
	 alert("관리자로 로그인 되었습니다");
 }else{
	 alert("관리자가 아닙니다.");
	 location.href="login";
 }
</script>
</head>
<body>

	<c:set var="num" value="${pg.total-pg.start+1}"></c:set>

	<table>
		<tr>
			<th>상품코드</th>
			<th>상품명</th>
			<th>상품사이즈</th>
			<th>상품수량</th>
			<th>상품분류</th>
		</tr>
		
		<c:forEach var="product" items="${tableProduct}"> 
			<tr>
				
				<td><a href="productContent?p_code=${product.p_code} &p_size=${product.p_size}" >
					${product.p_code}</a></td>
				<td>${product.p_name}</td>	
				<td>${product.s_name}</td>
				<td>${product.p_qty}</td>
				<td>${product.cate_name}</td>
			    
				
			  	
			</tr>
			<c:set var="num" value="${num - 1 }"></c:set> 
			</c:forEach>
	</table>
	<div>
	<c:if test="${pg.startPage > pg.pageBlock }">
				<a href="productTable?currentPage=${pg.startPage - pg.pageBlock}">[이전]</a>
			</c:if>
			<c:forEach var="i" begin="${pg.startPage }" end="${pg.endPage }">
				<a href="productTable?currentPage=${i }">[${i }]</a>
			</c:forEach>
			<c:if test="${pg.endPage < pg.totalPage }">
				<a href="productTable?currentPage=${pg.startPage + pg.pageBlock}">[다음]</a>
			</c:if>
	</div>

	
	
	
	
	<input type="button" value="등록" onclick="location.href='productWriteForm'">
	<input type="button" value="삭제" onclick="location.href='productdelete'">
</body>
</html>