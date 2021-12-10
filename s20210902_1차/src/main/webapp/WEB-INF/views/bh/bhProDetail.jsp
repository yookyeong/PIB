<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html >
<html>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>PIB 상품 상세</title>
</head>
<body>

	<div class="w3-sidebar w3-bar-block w3-light-grey w3-card" style="width:160px;">
 
  <button class="w3-button w3-block w3-left-align" onclick="myAccFunc()">
  PIB 상품 <i class="fa fa-caret-down"></i>
  </button>
  
 <div id="demoAcc" class="w3-hide w3-white w3-card">
  	<a href="#" onclick="location.href='bhPro'"  class="w3-bar-item w3-button">PIB 전체</a>
  	<a href="#" onclick="location.href='bhProT?p_c_mcode=210'" class="w3-bar-item w3-button">PIB 상의</a>
  	<a href="#" onclick="location.href='bhProB?p_c_mcode=220'" class="w3-bar-item w3-button">PIB 하의</a>
  	<a href="#" onclick="location.href='bhProS?p_c_mcode=240'" class="w3-bar-item w3-button">PIB 신발</a>
  	<a href="#" onclick="location.href='bhProA?p_c_mcode=230'" class="w3-bar-item w3-button">PIB 용품</a>
  </div>
  
  <div class="w3-dropdown-click">
    <button class="w3-button" onclick="myDropFunc()">상품 나열</button>
    <div id="demoDrop" class="w3-dropdown-content w3-bar-block w3-white w3-card-4">
    <a href="#" class="w3-bar-item w3-button">인기순</a> 
    <a href="#" class="w3-bar-item w3-button">최신순</a> 
    <a href="#" class="w3-bar-item w3-button">높은 가격순</a> 
    <a href="#" class="w3-bar-item w3-button">낮은 가격순</a>
    </div>
  </div>
</div>

<div class="w3-container" style="margin-left:160px">
<h2>상품 상세</h2>
<input type="image" src="${product.p_img }" style="width:300px;height:300px;"> 
<input type="hidden" name="p_code" value="${product.p_code }"> 
<table>	
	<tr><th>상품명 : </th><td>${product.p_name }</td></tr>
	<tr><th>상품가격 : </th><td>${product.p_price }</td></tr>
	<tr><th>상품 갯수 : </th><td><input type='number' min="0" name="c_qty"/></td>	
	<tr><th>상품 사이즈 : 
 		<input type="radio" name="p_size" value="110">
  		<label for="p_size">S</label>
 		<input type="radio" name="p_size" value="120">
  		<label for="p_size">M</label>
 		<input type="radio" name="p_size" value="130">
  		<label for="p_size">L</label>
	
	
	<tr><td colspan="2">
	    <button onClick="history.go(-1);">뒤로가기</button >
		<input type="button" value="위시리스트" 		onclick="location.href='bhPro'"><!-- 수정해야함 -->
		<input type="button" value="장바구니" 		onclick="location.href='bhPro'"><!-- 수정해야함 -->
	</tr>
</table>
<p></p>
<div class="w3-panel w3-border">
<h3>상품 설명</h3>
<p>This product is designed, made and published by PIB.</p>
</div>
<p></p>
<div class="w3-panel w3-border">
<form action="bhReviewWrite" method="post" enctype="multipart/form-data" target="myBatisFrame">
<h3>리뷰 작성</h3>
		<p>리뷰 내용 : <input type="text" name="r_content"></p>
		<p>이미지 : <input type="file" name="file1"> 
		<p>
			평점 : <label>1</label> 
					<input type="radio" name="rate" value="1">
				 <label>2</label> 
					<input type="radio" name="rate" value="2"> 
				 <label>3</label>
					<input type="radio" name="rate" value="3"> 
				 <label>4</label> 
					<input type="radio" name="rate" value="4"> 
				 <label>5</label> 
					<input type="radio" name="rate" value="5">
		</p>
		<input type="button" value="작성 완료">
		<p></p>
</form>		
</div>
<p></p>	
<div class="w3-panel w3-border">		
<h3>상품 리뷰</h3>
	<table>
  	<tr>
		<td>아이디</td><td>사진</td><td>리뷰내용</td><td>평점</td><td>수정/삭제</td>
  	</tr>
    <c:forEach items="${list }" var="review">
        <tr>
 				<td>${review.mem_Id}</td>
				<td>${review.p_img}</td>
				<td>${review.r_content}</td>
				<td>${review.bHit}</td>
        </tr>
    </c:forEach>
    <p></p>
  </table>
 </div> 
</div>

<script>
function myAccFunc() {
  var x = document.getElementById("demoAcc");
  if (x.className.indexOf("w3-show") == -1) {
    x.className += " w3-show";
    x.previousElementSibling.className += " w3-green";
  } else { 
    x.className = x.className.replace(" w3-show", "");
    x.previousElementSibling.className = 
    x.previousElementSibling.className.replace(" w3-green", "");
  }
}

function myDropFunc() {
  var x = document.getElementById("demoDrop");
  if (x.className.indexOf("w3-show") == -1) {
    x.className += " w3-show";
    x.previousElementSibling.className += " w3-green";
  } else { 
    x.className = x.className.replace(" w3-show", "");
    x.previousElementSibling.className = 
    x.previousElementSibling.className.replace(" w3-green", "");
  }
}
</script>

</body>
</html>