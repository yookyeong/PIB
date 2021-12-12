<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery1.js"></script>	<!-- ajax 사용하려면 필수  -->
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>

<script>
$(document).ready(function() { 
	var totalPrice = 0;
	var totalPay = 0;
	
	$('.sumValue').each(function(){ //클래스가 sumValue인 항목의 갯수만큼 진행
		totalPrice += Number($(this).val()); 
	});
	 var totalPay = totalPrice.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
	$("#totalPrice").val(totalPay); 
	});
</script>

<script>
    function sample6_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var addr = ''; // 주소 변수
                var extraAddr = ''; // 참고항목 변수

                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    addr = data.roadAddress;
                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    addr = data.jibunAddress;
                }

                // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
                if(data.userSelectedType === 'R'){
                    // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                    // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                    if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                        extraAddr += data.bname;
                    }
                    // 건물명이 있고, 공동주택일 경우 추가한다.
                    if(data.buildingName !== '' && data.apartment === 'Y'){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                    if(extraAddr !== ''){
                        extraAddr = ' (' + extraAddr + ')';
                    }
                    // 조합된 참고항목을 해당 필드에 넣는다.
                    document.getElementById("sample6_extraAddress").value = extraAddr;

                } else {
                    document.getElementById("sample6_extraAddress").value = '';
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('sample6_postcode').value = data.zonecode;
                document.getElementById("sample6_address").value = addr;
                // 커서를 상세주소 필드로 이동한다.
                document.getElementById("sample6_detailAddress").focus();
            }
        }).open();
    }
</script>
</head>
<body>
<h2>주문서 작성 및 배송지 입력</h2>
<form action="order1Insert" method="post">
<table border="1">
	<thead>
		<tr>
			<th>이미지</th><th>제품명</th><th>수량</th><th>사이즈</th><th>가격</th><th>취소</th><th>히든</th>
		</tr>
	</thead>
		<tbody>
		<c:if test="${total > 0 }">
		<c:forEach var="cartList" items="${cartList }">
			<tr>
				<td>${cartList.p_img }</td>
				<td>${cartList.p_name }</td>
				<td>${cartList.c_qty }</td>
				<td>${cartList.content }</td>
				<td>&#8361;<input type="number" class="sumValue" value="${cartList.sumValue }" readonly="readonly" style="border:0 solid black; width: 70px;"></td>
				<td><a href="cartDelete?c_num=${cartList.c_num }">[취소하기]</a></td>
				<td><input type="hidden" name="p_code" value="${cartList.p_code }">
					<input type="hidden" name="p_size" value="${cartList.p_size }">
					<input type="hidden" name="c_qty" value="${cartList.c_qty }"></td>
			</tr>
	</c:forEach>
	</c:if>
		</tbody>
		<c:if test="${total == 0 }">
		<tr>
			<td>장바구니 내역이 없습니다</td>
		</tr>
	</c:if>
	</table>
	<br>
	<div>
		합계 금액 : &#8361;<input type="text" id="totalPrice" readonly="readonly" style="border:0 solid black; width: 70px;"><br>
	</div>
				<div>
					<input type="text" name="o_accept" placeholder="받으시는분" required="required"><br>
					<input type="tel" name="o_tel" placeholder="000-0000-0000" pattern="[0-9]{2,3}-[0-9]{3,4}-[0-9]{3,4}" maxlength="13" required="required"><br>
				</div>
				<div>
					<input type="text" name="text1" id="sample6_postcode" placeholder="우편번호">
					<input type="button" onclick="sample6_execDaumPostcode()" value="우편번호 찾기"><br>
					<input type="text"  name="text2" id="sample6_address" placeholder="받으시는분 주소"><br>
					<input type="text"  name="text3" id="sample6_detailAddress" placeholder="상세주소">
					<input type="text"  name="text4" id="sample6_extraAddress" placeholder="참고항목"><br>
				</div>
					<button onclick="test()">주문하기</button>

</form>
</body>
</html>