<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="../js/jquery1.js"></script>
<%
	String context = request.getContextPath(); 
%>
</head>
<script type="text/javascript">


function fn_memRestore(mem_no){
	if(!confirm("복구하시겠습니까?")){
		return;
	}
	
	$.ajax({
		url:'<%=context%>/mng/restore',
        type:'post', //POST 방식으로 전달
        data:{"mem_no" : mem_no},
		dataType: "json",
        success:function(result){
        	console.log(result);
            if(result.code == "0"){
            	alert("복구되었습니다");
            	fn_redrawMemberList(result.memberList);
            	// 여기도 이해
            	return;
            }else if (result.code == "-1"){
	            alert("에러가 발생하였습니다. 관리자에게 문의하세요.1");
            	return;
            }
        },
        error:function(){
            alert("에러가 발생하였습니다. 관리자에게 문의하세요.2");
        }
    });
}

function fn_memDelete(mem_no){
	if(!confirm("삭제하시겠습니까?")){
		return;
	}
	
	$.ajax({
		url:'<%=context%>/mng/delete',
        type:'post', //POST 방식으로 전달
        data:{"mem_no" : mem_no},	// 이 형식이 json 타입이니까 아랫줄의 dataType:"json"을 입력
		dataType: "json",
		// json 타입이 뜻하는 건뭐지? 자동으로 key : value 타입으로 데이터를 받는다는거 같은데 
        success:function(result){
        	console.log(result);
            if(result.code == "0"){
            	alert("탈퇴되었습니다");
            	fn_redrawMemberList(result.memberList);
            	// 여기도 이해
            	return;
            }else if (result.code == "-1"){
	            alert("에러가 발생하였습니다. 관리자에게 문의하세요.1");
            	return;
            }
        },
        error:function(){
            alert("에러가 발생하였습니다. 관리자에게 문의하세요.2");
        }
    });
}

function fn_redrawMemberList(list){
	var table = $("#newTable");
	// 이건 #newTable에서 실행한다는 뜻?
	
	table.empty();
	table.append("<tr>");
	table.append("    <th>번호</th>");
	table.append("    <th>아이디</th>");
	table.append("    <th>이름</th>");
	table.append("    <th>전화번호</th>");
	table.append("    <th>이메일</th>");
	table.append("    <th>우편번호</th>");
	table.append("    <th>주소</th>");
	table.append("    <th>상세주소</th>");
	table.append("    <th>탈퇴여부</th>");
	table.append("</tr>");
	
	for(var i = 0; i < list.length; ++i){
		//<tr id="tr01">
		table.append("<tr id='tr"+list[i].mem_no+"'>");
		
		//	<td>01</td>
		var td = $("#tr" + list[i].mem_no);
		td.append("    <td>"+ list[i].mem_no +"</td>");
		td.append("    <td>"+ list[i].mem_id +"</td>");
		td.append('    <td><a href="/mng/detail?mem_no=' + list[i].mem_no + '">' + list[i].mem_name +"</a></td>");
		td.append("    <td>"+ list[i].mem_tel +"</td>");
		td.append("    <td>"+ list[i].mem_email +"</td>");
		td.append("    <td>"+ list[i].mem_address1 +"</td>");
		td.append("    <td>"+ list[i].mem_address2 +"</td>");
		td.append("    <td>"+ list[i].mem_address3 +"</td>");
		td.append("    <td>"+ list[i].mem_delete +"</td>");
		td.append('    <td><button onclick="javascript:fn_memDelete('+ list[i].mem_no +'); return false;">삭제</button></td>');
		td.append('    <td><button onclick="javascript:fn_memRestore('+ list[i].mem_no +'); return false;">복구</button></td>');

		//<tr id="tr01">
		table.append("</tr>");
		
		
	}
}


</script>

<body>

<h2>회원 List</h2>
	
	<table id="newTable">
		<tr>
			<th>번호</th>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이름</th>
			<th>전화번호</th>
			<th>이메일</th>
			<th>우편번호</th>
			<th>주소</th>
			<th>상세주소</th>
			<th>탈퇴여부</th>
			<th>탈퇴</th>
		</tr>
		<c:forEach var="member" items="${memberList }">
			<tr>
				<td>${member.mem_no }</td>
				<td>${member.mem_id }</td>
				<td>${member.mem_passwd }</td>
				<td><a href="/mng/detail?mem_no=${member.mem_no }"> ${member.mem_name }</a></td>
				<td>${member.mem_tel }</td>
				<td>${member.mem_email }</td>
				<td>${member.mem_address1 }</td>
				<td>${member.mem_address2 }</td>
				<td>${member.mem_address3 }</td>
				<td>${member.mem_delete }</td>
				<td><button id="mem_delete" onclick="javascript:fn_memDelete(${member.mem_no }); return false;">삭제</button></td>
				<td><button id="mem_restore" onclick="javascript:fn_memRestore(${member.mem_no }); return false;">복구</button></td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>