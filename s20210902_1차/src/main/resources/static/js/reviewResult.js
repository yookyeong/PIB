/**
 * 
 */
var resultInsert = ${reviewInsert};
var pcode = ${p_code};
if(resultInsert > 0){
	alert("리뷰가 작성되었습니다.");
	location.href="bhDetail?p_code="+p_code;
}else{
	alert("리뷰 작성에 실패하였습니다.");
	location.href="bhDetail?p_code="+p_code;
}

var resultDelete = ${reviewDelete};
if(resultDelete > 0){
	alert("리뷰가 삭제되었습니다.");
	location.href="bhDetail?p_code="+p_code;
}else{
	alert("리뷰 삭제에 실패하였습니다.");
	location.href="bhDetail?p_code="+p_code;
}

var resultUpdate = ${reviewUpdate};
if(resultUpdate > 0){
	alert("리뷰가 수정되었습니다.");
	location.href="bhDetail?p_code="+p_code;
}else{
	alert("리뷰 수정에 실패하였습니다.");
	location.href="bhDetail?p_code="+p_code;
}
