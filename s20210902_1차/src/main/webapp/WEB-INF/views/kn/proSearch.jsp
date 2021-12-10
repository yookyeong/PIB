<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<!DOCTYPE html>
<%
	String context = request.getContextPath();
	System.out.println("context->"+context);
%>
<html>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>PIB 검색</title>
</head>
<body>

	<div class="w3-sidebar w3-bar-block w3-light-grey w3-card" style="width:160px;">
 
  <button class="w3-button w3-block w3-left-align" onclick="myAccFunc()">
  PIB 상품 <i class="fa fa-caret-down"></i>
  </button>
  
  <div id="demoAcc" class="w3-hide w3-white w3-card">
  	<a href="bhPro"  class="w3-bar-item w3-button" >PIB 전체</a>
  	<a href="bhProT" class="w3-bar-item w3-button" >PIB 상의</a>
  	<a href="bhProB" class="w3-bar-item w3-button" >PIB 하의</a>
  	<a href="bhProS" class="w3-bar-item w3-button" >PIB 신발</a>
  	<a href="bhProA" class="w3-bar-item w3-button" >PIB 용품</a>
  </div>
  
  <div class="w3-dropdown-click">
    <button class="w3-button" onclick="myDropFunc()">상품 나열</button>
    <div id="demoDrop" class="w3-dropdown-content w3-bar-block w3-white w3-card-4">
    <a href="bhPro?sort=1" class="w3-bar-item w3-button" >인기순</a> 
    <a href="bhPro?sort=2" class="w3-bar-item w3-button" >최신순</a> 
    <a href="bhPro?sort=3" class="w3-bar-item w3-button" >높은 가격순</a> 
    <a href="bhPro?sort=4" class="w3-bar-item w3-button" >낮은 가격순</a>
    </div>
  </div>
  	
</div>

<div class="w3-container" style="margin-left:160px">
<h2>PIB 검색</h2>

<c:set var="num" value="${pg.total-pg.start+1}"></c:set>

<form action="proSearch" >
	<input type="search" name="keyword"  placeholder="검색어를 입력해 주세요" required="required" style = "width:500px;" align="middle">
	<input type="submit" value="검색" >
</form>

	<table>
		<tr>
			<th>상품명</th>
			<th>상품이미지</th>
			<th>상품가격</th>
			<th>Cart/WishList</th>
		</tr>
		<c:if test="${listProSearch.size() == 0 }">
    	    <h2>검색 결과가 없습니다.</h2>
        </c:if>
		<c:forEach var="product" items="${listProSearch}">
			<tr>
				<td>${product.p_name}</td>
				<td><a href="bhDetail?p_code=${product.p_code}"><input type="image" src="${product.p_img }" style="width:150px;height:150px;"></a></td>
				<td>${product.p_price}</td>
				<td colspan="2">
					<input type="button" value="장바구니 담기" > 
					<input type="button" value="위시리스트 담기">
				</td>
			</tr>
			<c:set var="num" value="${num - 1 }"></c:set>
		</c:forEach>
	</table>
<c:if test="${pg.startPage > pg.pageBlock }">
	<a href="proSearch?currentPage=${pg.startPage-pg.pageBlock}">[이전]</a>
</c:if>
<c:forEach var="i" begin="${pg.startPage}" end="${pg.endPage}">
	<a href="proSearch?currentPage=${i}">[${i}]</a>
</c:forEach>
<c:if test="${pg.endPage < pg.totalPage }">
	<a href="proSearch?currentPage=${pg.startPage+pg.pageBlock}">[다음]</a>
</c:if>

</body>
</html>