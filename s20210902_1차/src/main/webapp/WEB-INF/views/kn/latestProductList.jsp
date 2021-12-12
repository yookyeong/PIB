<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>최근 본 상품</title>
<script type="text/javascript" src="js/jquery1.js"></script>   <!-- ajax 사용하려면 필수  -->
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script>
function button1_click(p_code) {
	location.href="deleteLatestProduct?p_code="+p_code;
}
</script>
</head>
<body>
<h2>최근 본 상품</h2>
<c:set var="num" value="${lp.total-lp.start+1}"></c:set>
	<table>
		<tr>
			<th>상품명</th>
			<th>상품이미지</th>
			<th>상품가격</th>
		</tr>
	<c:if test="${listLatestProduct.size() == 0}">
		<div>최근 본 상품이 없습니다.</div>
	</c:if>
	<c:if test="${listLatestProduct.size() > 0 }">	
		<c:forEach var="product" items="${listLatestProduct}">
			<tr>
				<td>${product.p_name}</td>
				<td><a href="bhDetail?p_code=${product.p_code}"><input type="image" src="${product.p_img }" style="width:150px;height:150px;"></a></td>
				<td>${product.p_price}</td>
				<td colspan="2">
					<button id="button1" onclick="button1_click(${product.p_code})">삭제</button>
					<button id="button1" onclick="location.href='bhPro'">목록</button>
				</td>
			</tr>
			<c:set var="num" value="${num - 1 }"></c:set>
		</c:forEach>
	</c:if>
	</table>
<c:if test="${lp.startPage > lp.pageBlock }">
	<a href="latestProductList?currentPage=${lp.startPage-lp.pageBlock}">[이전]</a>
</c:if>
<c:forEach var="i" begin="${lp.startPage}" end="${lp.endPage}">
	<a href="latestProductList?currentPage=${i}">[${i}]</a>
</c:forEach>
<c:if test="${lp.endPage < lp.totalPage }">
	<a href="latestProductList?currentPage=${lp.startPage+lp.pageBlock}">[다음]</a>
</c:if>

</body>
</html>