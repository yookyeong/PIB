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
	<c:if test="${result>0 }">
	<script type="text/javascript">
			location.href="bhDetail?p_code="+${p_code};
	</script>
	</c:if >
	<c:if test="${result==0}">
		<script type="text/javascript">
			alert("댓글 삭제에 실패하였습니다");
			location.href="bhDetail?p_code="+${p_code};
			</script>
		</c:if>
</body>
</html>