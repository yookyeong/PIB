<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html >
<%
   String context = request.getContextPath();
%>
<html>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>PIB 상품 상세</title>
<script type="text/javascript" src="js/jquery1.js"></script>
<script src="js/wishiListAjax.js"></script>

<script type="text/javascript">
    var contextPath='${pageContext.request.contextPath}';
   var src='${pageContext.request.contextPath}/images/';
   var contextPath='${pageContext.request.contextPath}';
   var i=2;
   var str="";
   var str2="";
   
   function getProCheck(vProd_code, vMem_id){
	   if(vMem_id != ""){
		   $.ajax({
		         url:"<%=context%>/getProCheck",  
		         data:{p_code : vProd_code, mem_id : vMem_id}, 
		         dataType:'json',
		         success:function(data){
		            if(data == 0) {
		                 alert("상품을 구매 하지 않았어요~");
		            }else {
		                 $(data).each(function() {
		                    location.href="bhReviewForm?p_code="+this.p_code+"&p_size="+this.p_size;
		                 });
		            }
		         }
		      });
	   }else{
		   alert("로그인 후 이용 가능합니다.");
		   location.href="cm/loginForm";
	  }
    }
 </script>
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
<form action="cartInsert" method="post">
<input type="image" src="${product.p_img }" style="width:300px;height:300px;"> 
<input type="hidden" name="p_code" value="${product.p_code }"> 
<table>   
   <tr><th>상품명 : </th><td>${product.p_name }</td></tr>
   <tr><th>상품가격 : </th><td>${product.p_price }</td></tr>
   <tr><th>상품 갯수 : </th><td><input type='number' min="0" name="c_qty" required="required"/></td>   
   <tr><th>상품 사이즈 : 
       <input type="radio" name="p_size" value="110" required="required">
        <label for="p_size">S</label>
       <input type="radio" name="p_size" value="120" required="required">
        <label for="p_size">M</label>
       <input type="radio" name="p_size" value="130" required="required">
        <label for="p_size">L</label>
   
   
   <tr><td colspan="2">
       <button onClick="history.go(-1);">이전 페이지</button >
      <input type="button" value="위시리스트" onclick="wishiInsert(${product.p_code})"><!-- 수정해야함 -->
      <input type="submit" value="장바구니" >
   </tr>
</table>
</form>
<p></p>
<div class="w3-panel w3-border">
<h3>상품 설명</h3>
<p>This product is designed, made and published by PIB.</p>
</div>
<p></p>
<div class="w3-panel w3-border">
<form action="bhReviewForm">
<input type="hidden" value="${product.p_code }" name="p_code" >
   <input type="button" onclick="getProCheck(${product.p_code },'${mem_id }')" value="리뷰 작성하기" >
</form>      
</div>
<p></p>   
<div class="w3-panel w3-border">      
<h3>상품 리뷰</h3>

<c:set var="num" value="${pg.total-pg.start+1}"></c:set>
   <table>
     <tr>
      <th>아이디</th>
      <th>사진</th>
      <th>리뷰내용</th>
      <th>평점</th>
      <th>수정/삭제</th>
     </tr>
     <c:if test="${total == 0 }">
     	<tr>
     		<td colspan="5">상품에 대한 리뷰가 없습니다.</td>
     	</tr>
     </c:if>
     <c:if test="${total > 0 }">
    <c:forEach var="review" items="${listRev}">
        <tr>
             <td>${review.mem_id}</td>
             <td>
                <c:if test="${review.r_img != null}">
                  <input type="image" src="${review.r_img }" style="width:100px;height:100px;">
               </c:if>
            </td>
            <td>${review.r_content}</td>
            <td>${review.r_score}</td>
            <td colspan="2">
               <c:choose>
               <c:when test="${review.mem_id.equals(mem_id) && mem_admin == 0}">
                  <input type="button" value="수정" onclick="location.href='bhUpdateForm?p_code=${review.p_code}&p_size=${review.p_size}'"> 
                  <input type="button" value="삭제" onclick="location.href='bhRevD?p_code=${review.p_code}&p_size=${review.p_size}'">
               </c:when>   
               <c:when test="${mem_admin == 1}">
                  <input type="button" value="관리자댓글" onclick="location.href='dhReviewForm?p_code=${review.p_code}&p_size=${review.p_size}&r_num=${review.r_num }'">
                  <input type="button" value="삭제" onclick="location.href='dhReviewDelete?p_code=${review.p_code}&p_size=${review.p_size}&r_num=${review.r_num }'">
               </c:when>
               </c:choose>   
            </td>
        </tr>
        <c:set var="num" value="${num - 1 }"></c:set>
    </c:forEach>
    </c:if>
  </table>
  <c:if test="${pg.startPage > pg.pageBlock }">
      <a href="bhDetail?p_code=${product.p_code }&currentPage=${pg.startPage-pg.pageBlock}">[이전]</a>
   </c:if>
   <c:forEach var="i" begin="${pg.startPage}" end="${pg.endPage}">
      <a href="bhDetail?p_code=${product.p_code }&currentPage=${i}">[${i}]</a>
   </c:forEach>
   <c:if test="${pg.endPage < pg.totalPage }">
      <a href="bhDetail?p_code=${product.p_code }&currentPage=${pg.startPage+pg.pageBlock}">[다음]</a>
   </c:if>
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