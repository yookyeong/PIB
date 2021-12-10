<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
 			var result = "${result}";
			if(result > 0)
			alert("상품수정 완료.");
			else if(result == -1)
			alert("상품수정 실패.");
			
		</script>
</head>
<body>
	<h2>상품 수정</h2>
	<form action="productUpdate" method="post" enctype= "multipart/form-data">
<!-- 	<input type="hidden" name="p_c_mcode" value="p_c_mcode">-->
		<input type="hidden" name="p_size" value="${product.p_size }">
		<table>
		
			
			<tr>
				<th>상품코드</th>
				<td><input type="text" name="p_code" required="required"
					value=${product.p_code } readonly/></td>
			</tr>
			<tr>
				<th>상품명</th>
				<td>${product.p_name } </td>
			</tr>
			<tr>
				<tr>
				<th>상품분류</th>
				<td>${product.cate_name }
				<%-- <select name="p_c_mcode" >
						<c:forEach var="cate" items="${cateProductList2}">
							<option value="${cate.mcode}" >${cate.content}</option>
						</c:forEach>
				</select> --%></td>
			</tr>
			<tr>
				<th>사이즈</th>
				<td>${product.s_name }
				<%-- <select name="p_size" >
						<c:forEach var="cate" items="${cateProductList1}">
							<option value="${cate.mcode}">${cate.content}</option>
						</c:forEach>
					</select> --%>
				</td>
						
			</tr>
			<tr>
				<th>수량</th>
				<td><input type="text" name="p_qty" required="required" value=${product.p_qty }></td>
			</tr>
			<tr>
				<th>가격</th>
				<td><input type="text" name="p_price" required="required" value=${product.p_price }></td>
			</tr>
			<tr>
			<th>상품이미지</th>
			<td>
				<input type="hidden" value="${product.p_img }" name="p_img">
				<img alt="${product.p_img  }" src="${product.p_img  }" width="300px" height="300px">
				
			</td>
			<td><input type="file" name="file1"></td>
			</tr>
			
	
		<div>
			<tr>
				<td><input type="submit" value="확인"></td>
			</tr>
			<tr>
				<td><input type="button" value="목록"
					onclick="location.href='productTable'"></td>
			</tr>
		</div>



		</table>
	</form>
</body>
</html>