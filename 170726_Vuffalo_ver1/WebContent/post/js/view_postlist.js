$(document).ready(function(e) {
	$('#write_btn').click(function(){
		log = $('#logFlag').val();
		if(log == "out"){
			alert("로그인하세요.");
			return;
		}else{$(location).attr('href', "wrtieRequest.do");}
	});
	$('p').click(function(){
		title = $(this).text();
		postnum = document.getElementById(title).value;
		$('#postNum').attr("value",postnum);
		$('#show_form').submit();
	});
	$('#goListBtn').click(function(){
		$(location).attr('href', "viewPostList.do");
	});
	
	$('#delete_btn').click(function(){
		alert("영구삭제합니다.");
		$('#delete_from').submit();
	});
});
/*function goPost() {
	alert("Button Click");
}*/