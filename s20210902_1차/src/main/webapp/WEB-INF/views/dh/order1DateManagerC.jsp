<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Order1ListManagerC</title>
<style type="text/css">
A:link {text-decoration:none; color: #646464;}
A:visited {text-decoration:none; color: #646464;}
A:active {text-decoration:none; color: #646464;}
A:hover {text-decoration:none; color: #646464;}
</style>
</head>
<body>
<c:set var="num" value="${pg.total-pg.start+1}"></c:set>
<form action="order1Search?currentPage=${pg.currentPage}">
		<input type="text" name="q" placeholder="주문번호로 검색" required="required" style = "width:300px;">
		<input type="submit" value="확인">
		<button type="button" onclick="location.href='order1ListManagerC?currentPage=1'">목록</button>
</form>
		<table border="1">
			<thead>
				<tr>
					<th>상품정보</th><th><a href="order1ListManagerC?currentPage=${pg.currentPage}">주문일자</a></th>
					<th>주문번호</th><th>구매자</th><th>받으시는 분</th><th>받으시는 분 연락처</th><th>받으시는 분 주소</th><th>수량</th><th>금액</th><th>주문상태</th>
				</tr>
			</thead>
			<c:forEach var="order1ManagerC" items="${order1DateManagerC }">
			<tbody>
				<tr>
					<td>
						<div>
							<img src = "/${order1ManagerC.p_img }" style="width: 200px; height: 100px">
							<ul>
								<li>상품명 : ${order1ManagerC.p_name}</li>
								<li>사이즈 : ${order1ManagerC.content}</li>
							</ul>
						</div>
					</td>
					<td>${order1ManagerC.o_date }</td>
					<td>${order1ManagerC.o_num }</td>
					<td>${order1ManagerC.mem_name }</td>
					<td>${order1ManagerC.o_accept }</td>
					<td>${order1ManagerC.o_tel }</td>
					<td>${order1ManagerC.o_address }</td>
					<td>${order1ManagerC.p_qty }</td>
					<td>${order1ManagerC.sumValue }</td>
					<td>
					<c:set var ="o_cancel" value="${order1ManagerC.o_cancel}"></c:set>
							<c:choose>
								<c:when test="${o_cancel eq '1'}">
									주문확정
								</c:when>
							</c:choose>
					</td>
				</tr>
			</tbody>
			<c:set var="num" value="${num - 1 }"></c:set>
		</c:forEach>
	</table>
<c:if test="${pg.startPage > pg.pageBlock }">
	<a href="order1DateManagerC?currentPage=${pg.startPage-pg.pageBlock}">[이전]</a>
</c:if>
<c:forEach var="i" begin="${pg.startPage}" end="${pg.endPage}">
	<a href="order1DateManagerC?currentPage=${i}">[${i}]</a>
</c:forEach>
<c:if test="${pg.endPage < pg.totalPage }">
	<a href="order1DateManagerC?currentPage=${pg.startPage+pg.pageBlock}">[다음]</a>
</c:if>
</body>
</html>