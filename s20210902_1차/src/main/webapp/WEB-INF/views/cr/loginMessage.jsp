<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
	String context = request.getContextPath();
%>
<body>

	<script type="text/javascript">
		alert("로그인 후 이용 가능합니다.");
		location.href="<%=context%>/cm/loginForm";
	</script>

</body>
</html>