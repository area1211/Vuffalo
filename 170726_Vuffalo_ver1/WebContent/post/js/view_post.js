$(document).ready(function(e) {
	$('#postList_btn').click(function(){
		$(location).attr('href', "viewPostList.do");
	});
	$('#delete_btn').click(function(){
		alert("삭제합니다.");
		$('#btn_form').submit();
	});
	$('#edit_btn').click(function(){
		alert("수정합니다.");
		$('#edit_form').submit();
	});
	$('#comment_btn').click(function(){
		alert("댓글작성");
	});
	$('#adelete_btn').click(function(){
		alert("관리자삭제합니다.");
		$('#admin_form').submit();
	});
	
	$('#aedit_btn').click(function(){
		alert("수정합니다.");
		$('#edit_form').submit();
	});
});