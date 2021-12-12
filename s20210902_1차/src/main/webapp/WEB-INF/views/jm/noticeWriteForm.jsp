<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
  function chk() {
	if (!frm.n_num.value) {
		alert("번호를 입력한 후에 확인하세요");
		frm.n_num.focus();
		return false;
	} else location.href="noticeConfirm?n_num="+frm.n_num.value;
  }
</script>
</head>
<body>
 <h2>공지내용 입력</h2>
 <form action="noticeWrite" method="post" name="frm" >
   <table>
	<tr><th>제목</th><td><input type="text" name="n_title" required="required" value=[공지사항]></td></tr>
	<tr><th>내용</th><td><textarea rows="10" name="n_content" required="required" ></textarea></tr>
	<tr><th>등록일</th><td><input type="date" name="n_date" required="required"></td></tr>
	
  	<tr><td colspan="2"><input type="submit" value="확인"></td></tr> 
   </table>
  </form>
 
 </body>
</html>