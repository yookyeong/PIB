<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${result > 0 }">
	<script type="text/javascript">
		alert("장바구니에 추가되었습니다");
		var result;
		result = confirm("장바구니로 이동하시겠습니까?");
		if(result == true){
			location.href="cartList";
		}else{
			location.href="bhDetail?p_code="+${p_code};
		}
		
	</script>
	</c:if >
	<c:if test="${result==0}">
		<script type="text/javascript">
			alert("장바구니 추가에 실패하였습니다");
			location.href="wishDummy";
			</script>
		</c:if>
</body>
</html>