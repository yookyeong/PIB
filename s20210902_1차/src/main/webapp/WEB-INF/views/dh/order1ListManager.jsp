<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<!DOCTYPE html>
<%
	String context = request.getContextPath();
%>
<html>
<head>
<meta charset="UTF-8">
<title>Order1ListManager</title>
<style type="text/css">
	A:link {text-decoration:none; color: #646464;}
	A:visited {text-decoration:none; color: #646464;}
	A:active {text-decoration:none; color: #646464;}
	A:hover {text-decoration:none; color: #646464;}
	.thborder {border-top:2px solid sliver; border-bottom:2px solid silver;}
	.centertable {border: 1px solid silver;  border-collapse: collapse;}
	td {border-left: none; border-bottom:1px solid silver; text-align: center;}
	ul {list-style:none;}

</style>

<script src="js/jquery1.js"></script>	<!-- ajax 사용하려면 필수  -->
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<script type="text/javascript">
	var str1 = "";
	var str2 = "";

	function getMemberInfo(Vmem_id) {
		alert("Vmem_id -> "+ Vmem_id);
		$.ajax({	
			url:"<%=context%>/getMemberInfo",	
			data:{mem_id : Vmem_id},
			dataType:'json',						
			success:function(data){		
				str1 = data.mem_tel
				str2 = data.mem_email
				$('#Jmem_tel').val(str1);
 				$('#Jmem_email').val(str2);
 		    }
	}); 
 }
</script>
</head>
<body>
<h2>관리자 - 실시간 주문 내역</h2>
<c:set var ="order1Manager" value="${listOrderManager}"></c:set>
			<button type="button" onclick="location.href='order1ListManager?currentPage=1'">목록</button>
			<table class="centertable">
				<thead class="thborder">
					<tr>
						<th>상품정보</th><th>주문일자</th><th>주문번호</th><th>구매자</th><th>받으시는 분</th><th>받으시는 분 연락처</th><th>받으시는 분 주소</th><th>수 량</th><th>금 액</th><th>주문상태</th>
					</tr>
				</thead>
				<tbody>
				<c:if test="${total > 0 }">
				<c:forEach var="order1Manager" items="${listOrderManager }" varStatus="">
					<tr>
						<td style="width: 200px;">
							<div align="left">
								<img src = "/${order1Manager.p_img }" style="width: 200px; height: 150px;">
								<ul>
									<li>상품명 : ${order1Manager.p_name}</li>
									<li>사이즈 : ${order1Manager.content}</li>
								</ul>
							</div>
						</td>
						<td style="width: 200px;">${order1Manager.o_date }</td>
						<td style="width: 100px;">${order1Manager.o_num }</td>
						<td>${order1Manager.mem_name }
						<a onclick="getMemberInfo('${order1Manager.mem_id }')">[정보]</a>
						<td style="width: 100px;">${order1Manager.o_accept }</td>
						<td style="width: 200px;">${order1Manager.o_tel }</td>
						<td>${order1Manager.o_address }</td>
						<td style="width: 100px;">${order1Manager.p_qty }</td>
						<td style="width: 100px;">${order1Manager.sumValue }</td>
						<td style="width: 200px;">
								<c:choose>
									<c:when test="${order1Manager.o_cancel eq '0'}">
										주문대기<br>
										<a href="order1CancelManager?o_num=${order1Manager.o_num}&p_qty=${order1Manager.p_qty}&p_code=${order1Manager.p_code}&p_size=${order1Manager.p_size}">[주문확정하기]</a>
									</c:when>
									<c:when test="${order1Manager.o_cancel eq '1'}">
										주문확정
									</c:when>
								</c:choose>
						</td>
					</tr>
					</c:forEach>
				</c:if>
				</tbody>
		<c:if test="${total == 0 }">
			<tr>
				<td>주문내역이 없습니다</td>
			</tr>
		</c:if>
		</table>
		<div>
		전화번호 : <input type="text" id="Jmem_tel"  readonly="readonly"><p>
		이메일 : <input type="text" id="Jmem_email"  readonly="readonly">
		</div><p>
<c:if test="${pg.startPage > pg.pageBlock }">
	<a href="order1ListManager?currentPage=${pg.startPage-pg.pageBlock}">[이전]</a>
</c:if>
<c:forEach var="i" begin="${pg.startPage}" end="${pg.endPage}">
	<a href="order1ListManager?currentPage=${i}">[${i}]</a>
</c:forEach>
<c:if test="${pg.endPage < pg.totalPage }">
	<a href="order1ListManager?currentPage=${pg.startPage+pg.pageBlock}">[다음]</a>
</c:if>
</body>
</html>