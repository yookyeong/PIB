<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Order1List</title>
<style type="text/css">
A:link {text-decoration:none; color: #646464;}
A:visited {text-decoration:none; color: #646464;}
A:active {text-decoration:none; color: #646464;}
A:hover {text-decoration:none; color: #646464;}
</style>
</head>
<body>
<h2>내가 주문한 내역</h2>
<c:set var="num" value="${pg.total-pg.start+1}"></c:set>
	<form action="order1ListCategory?currentPage=${pg.currentPage}">
		주문상태 :	<select name='o_cancel' required="required">
					<option value='' selected>-선택-</option>
					<option value='0'>주문대기</option>
					<option value='1'>주문확정</option>
					<option value='2'>주문취소</option>
				</select>
				<input type="submit" value="확인">&nbsp;&nbsp;
					<button type="button" onclick="location.href='order1List?currentPage=1'">목록</button>
	</form>
	<table border="1">
	<thead>
		<tr>
			<th>상품정보</th><th><a href="order1Date?currentPage=${pg.currentPage}">주문일자</a></th>
			<th>주문번호</th><th>받으시는 분</th><th>받으시는 분 연락처</th><th>받으시는 분 주소</th><th>수량</th><th>금액</th><th>주문상태</th>
		</tr>
	</thead>
	<c:forEach var="order1" items="${order1List }">
	<tbody>
		<tr>
			<td>
				<div>
					<img src = "/${order1.p_img }" style="width: 200px; height: 100px">
					<ul>
						<li>상품명 : ${order1.p_name}</li>
						<li>사이즈 : ${order1.content}</li>
					</ul>
				</div>
			</td>
			<td>${order1.o_date }</td>
			<td>${order1.o_num }</td>
			<td>${order1.o_accept }</td>
			<td>${order1.o_tel }</td>
			<td>${order1.o_address }</td>
			<td>${order1.p_qty }</td>
			<td>${order1.sumValue }</td>
				<td>
				<c:set var ="o_cancel" value="${order1.o_cancel}"></c:set>
				<c:choose>
					<c:when test="${o_cancel eq '0'}">
						주문대기<br>
						<a href="order1Cancel?o_num=${order1.o_num}&p_size=${order1.p_size}&p_code=${order1.p_code}">[주문취소하기]</a>
					</c:when>
					<c:when test="${o_cancel eq '1'}">
						주문확정
					</c:when>
					<c:otherwise>
						주문취소
					</c:otherwise>
				</c:choose></td>
		</tr>
	</tbody>
	<c:set var="num" value="${num - 1 }"></c:set>
	</c:forEach>
</table>
<div>
<c:if test="${pg.startPage > pg.pageBlock }">
	<a href="order1List?currentPage=${pg.startPage-pg.pageBlock}">[이전]</a>
</c:if>
<c:forEach var="i" begin="${pg.startPage}" end="${pg.endPage}">
	<a href="order1List?currentPage=${i}">[${i}]</a>
</c:forEach>
<c:if test="${pg.endPage < pg.totalPage }">
	<a href="order1List?currentPage=${pg.startPage+pg.pageBlock}">[다음]</a>
</c:if>
</div>
</body>
</html>