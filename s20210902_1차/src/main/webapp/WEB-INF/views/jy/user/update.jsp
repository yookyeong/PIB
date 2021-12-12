<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript" src="../js/jquery1.js"></script>
<%
	String context = request.getContextPath(); 
%>
<script>
	function sample6_execDaumPostcode() {
		new daum.Postcode({
			oncomplete : function(data) {
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
				if (data.userSelectedType === 'R') {
					// 법정동명이 있을 경우 추가한다. (법정리는 제외)
					// 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
					if (data.bname !== '' && /[동|로|가]$/g.test(data.bname)) {
						extraAddr += data.bname;
					}
					// 건물명이 있고, 공동주택일 경우 추가한다.
					if (data.buildingName !== '' && data.apartment === 'Y') {
						extraAddr += (extraAddr !== '' ? ', '
								+ data.buildingName : data.buildingName);
					}
					// 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
					if (extraAddr !== '') {
						extraAddr = ' (' + extraAddr + ')';
					}
					// 조합된 참고항목을 해당 필드에 넣는다.
					// document.getElementById("sample6_extraAddress").value = extraAddr;

				} else {
					// document.getElementById("sample6_extraAddress").value = '';
					extraAddr = '';
				}

				// 우편번호와 주소 정보를 해당 필드에 넣는다.
				$("#mem_address1").val(data.zonecode);
				$("#mem_address2").val(addr + extraAddr);

				$("#divAddress1").text(data.zonecode);
				$("#divAddress2").text(addr + extraAddr);
				$("#mem_address3").focus();

			}
		}).open();
	}

	function validationCheck(){
		var pw = $('#pw').val();
		var pw2 = $('#pw2').val();
		
		if (pw == '') {
			alert("비밀번호를 입력해주세요.");
			$('#pw').focus();
			return false;
		}
		
		if (!/^[a-zA-Z0-9]{8,16}$/.test(pw)) {
			alert('숫자와 영문자 조합으로 8~16자리를 사용해야 합니다.');
			$('#pw').focus();
			return false;
		}

		var checkNum = pw.search(/[0-9]/g); // 숫자사용
		var checkEng = pw.search(/[a-z]/ig); // 영문사용

		if (checkNum < 0 || checkEng < 0) {
			alert("숫자와 영문자를 조합하여야 합니다.");
			$('#pw').focus();
			return false;
		}
		
		if (pw != pw2) {
			alert("비밀번호가 일치하지 않습니다");
			$('#pw2').val('');
			$('#pw2').focus();
			return false;
		}
		
		if($('#mem_tel').val() == ''){
			alert("전화번호는 필수값입니다.\n숫자만 입력해주세요.");
			$('#mem_tel').val('');
			$('#mem_tel').focus();
			return;
		}
		
		$("#formUpdate").submit();
	}

	/* function mem_tel(value) {
		value = value.replace(/[^0-9]/g, "");
		return value.replace(/(^02.{0}|^01.{1}|[0-9]{3})([0-9]+)([0-9]{4})/,
				"$1-$2-$3");
	} */

	/*
	//전화번호 - 자동 추가
	function phoneNumber(value) {
		  if (!value) {
		    return "";
		  }

		  value = value.replace(/[^0-9]/g, "");

		  let result = [];
		  let restNumber = "";

		  // 지역번호와 나머지 번호로 나누기
		  if (value.startsWith("02")) {
		    // 서울 02 지역번호
		    result.push(value.substr(0, 2));
		    restNumber = value.substring(2);
		  } else if (value.startsWith("1")) {
		    // 지역 번호가 없는 경우
		    // 1xxx-yyyy
		    restNumber = value;
		  } else {
		    // 나머지 3자리 지역번호
		    // 0xx-yyyy-zzzz
		    result.push(value.substr(0, 3));
		    restNumber = value.substring(3);
		  }

		  if (restNumber.length === 7) {
		    // 7자리만 남았을 때는 xxx-yyyy
		    result.push(restNumber.substring(0, 3));
		    result.push(restNumber.substring(3));
		  } else {
		    result.push(restNumber.substring(0, 4));
		    result.push(restNumber.substring(4));
		  }

		  return result.filter((val) => val).join("-");
		}
	 */
</script>

<body>
	<h2>직원정보</h2>
	<form id="formUpdate" action="<%=context%>/user/detail" method="post">
		<input type="hidden" name="mem_no" value="${member.mem_no }">

		<table>
			<!-- <tr><th>번호</th><td>${member.mem_no }</td></tr> -->
			<tr>
				<th>이름</th>
				<td>${member.mem_name }</td>
			</tr>
			<tr>
				<th>아이디</th>
				<td>${member.mem_id }</td>
			</tr>

			<tr>
				<th>비밀번호</th>
				<td><input type="password" id="pw" name="mem_passwd" required="required" value="${member.mem_passwd }"></td>
			</tr>
			<tr>
				<th>비밀번호확인</th>
				<td><input type="password" id="pw2" required="required"></td>
			</tr>

			<tr>
				<th>이메일</th>
				<td>${member.mem_email }</td>
			</tr>
			<tr>
				<th>전화번호</th>
				<td><input type="number" name="mem_tel" id="mem_tel" required="required" value="${member.mem_tel }"></td>
			</tr>

			<tr>
				<th>주소</th>
				<td>
				<input type="hidden" name="mem_address1" id="mem_address1" value="${member.mem_address1}"> 
				<pp id="divAddress1">${member.mem_address1}</pp>
				<input type="button" onclick="sample6_execDaumPostcode()" value="우편번호 찾기"><br> 
				<input type="hidden" name="mem_address2" id="mem_address2" value="${member.mem_address2}">
				<div id="divAddress2">${member.mem_address2}</div> 
				<input type="text" id="mem_address3" name="mem_address3" placeholder="상세주소" value="${member.mem_address3}">
				</td>
			</tr>
			<tr>
				<td colspan="2"><button onclick="javascript:validationCheck();">확인</button></td>
			</tr>
		</table>
	</form>
</body>
</html>