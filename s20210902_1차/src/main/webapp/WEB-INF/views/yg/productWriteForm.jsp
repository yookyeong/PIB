<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<% String context = request.getContextPath(); %>
	<script type="text/javascript">
		
		var result=${result};
		if(result > 0)
			alert("상품등록 완료");
		if(result == -1 )
			alert("상품등록 실패");

			var result    = '${savedName}';
			var delResult = '${delResult}';
			parent.addFilePath(result);
			
		
			
			</script>
			
  		
</head>
<body>
	<h2>상품 등록</h2>
	<form action="productWrite" method="post" enctype="multipart/form-data" name="write">
		<table>

			<tr>
				<th>상품코드</th>
				<td><input type="text" name="p_code" required="required"
					value=${product.p_code }></td>
			</tr>
			<tr>
				<th>상품명</th>
				<td><input type="text" name="p_name" required="required"
					value=${product.p_name }></td>
			</tr>
			<tr>
				<th>상품분류</th>
				<td><select name="p_c_mcode" id="selectbox">
						<c:forEach var="cate" items="${cateProductList2}">
							<option value="${cate.mcode}">${cate.content}</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<th>사이즈</th>
				<td><select name="p_size" id="selectbox">
						<c:forEach var="cate" items="${cateProductList1}">
							<option value="${cate.mcode}">${cate.content}</option>
						</c:forEach>
					</select>
				</td>
						
			</tr>
			<tr>
				<th>수량</th>
				<td><input type="text" name="p_qty" required="required"
					value=${product.p_qty }></td>
			</tr>
			<tr>
				<th>가격</th>
				<td><input type="text" name="p_price" required="required"
					value=${product.p_price }></td>
			</tr>
			<tr>
			
				<th>이미지첨부</th>
				<td>
				<input type="file" name="file1">
				<!-- <input type="submit"> -->
				<!-- <iframe name="myBatisFrame"></iframe> -->
				</td>
				
			<tr>
				<td><input type="submit" value="확인"></td>
				<tr><td><input type="button" value="목록" onclick="location.href='productTable'"></td></tr>
			</tr>
		




		</table>
	</form>
</body>
</html>