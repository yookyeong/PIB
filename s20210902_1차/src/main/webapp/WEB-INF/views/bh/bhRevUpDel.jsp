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
<title>PIB 리뷰 수정</title>
</head>
<body>
<div class="w3-panel w3-border">
<form action="bhRevU" method="post" enctype="multipart/form-data" target="myBatisFrame">
<input type="hidden" value="${review.p_code}" name="p_code" >
<input type="hidden" value="${review.p_size}" name="p_size" >
<h3>리뷰 수정</h3>
		<p>리뷰 내용 : <textarea rows="5" name="r_content" required="required" onclick="getProCheck(${product.p_code },'${mem_id }')">${review.r_content }</textarea></p>
		<p>이미지 : <input type="hidden" name="r_img" value="${review.r_img}">
				  <input type="file" name="file1">
				  <c:if test="${review.r_img != null}">
						<img alt="${review.r_img }" src="${review.r_img }" width="100px" height="100px">
				  </c:if>		
		<p>
			평점 : <label>1</label> 
					<input type="radio" name="r_score" value="1" required="required" <c:if test="${review.r_score == 1}"> checked</c:if>> 
				 <label>2</label> 
					<input type="radio" name="r_score" value="2" required="required" <c:if test="${review.r_score == 2}"> checked</c:if>> 
				 <label>3</label>
					<input type="radio" name="r_score" value="3" required="required" <c:if test="${review.r_score == 3}"> checked</c:if>> 
				 <label>4</label> 
					<input type="radio" name="r_score" value="4" required="required" <c:if test="${review.r_score == 4}"> checked</c:if>> 
				 <label>5</label> 
					<input type="radio" name="r_score" value="5" required="required" <c:if test="${review.r_score == 5}"> checked</c:if>>
		</p>
		<input type="submit" value="수정 완료">
		<button onClick="history.go(-1);">수정 취소</button >
		<p></p>
</form>		
</div>
</body>
</html>