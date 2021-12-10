<%@  page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type=delete......????>
 			var result = "${result}";
			if(result > 0)
			alert("상품수정 완료.");
			else if(result == -1)
			alert("상품수정 실패.");
			
		</script>

</head>
<body>
<table>

	<tr><th>상품코드</th><td>${product1.p_code }</td></tr>
	<tr><th>상품명</th><td>${product1.p_name }</td></tr>
	<tr><th>상품사이즈</th><td>${product1.p_size }</td></tr>
	<tr><th>상품수량</th><td>${product1.p_qty }</td></tr>
	<tr><th>상품가격</th><td>${product1.p_price }</td></tr>
	<tr><th>상품이미지</th>
	<td><input type="hidden" value="${product1.p_img }" name="p_img">
	<img alt="${product1.p_img }" src="${product1.p_img }" width="300px" height="300px"></td></tr>
	
	<tr><td><input type="button" value="목록" onclick="location.href='productTable'"></td></tr>
	<tr><td><input type="button" value="수정" onclick="location.href='productUpdateForm?p_code=${product1.p_code}&p_size=${product1.p_size }'"></td></tr>
	<tr><td><input type="button" value="삭제" onclick="location.href='productDelete?p_code=${product1.p_code}&p_size=${product1.p_size }&p_img=${product1.p_img }'"></td></tr>


</table>

</body>
</html>