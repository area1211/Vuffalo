$(document).ready(function(e) {
	$('#admin_member').click(function(){
		//alert("회원관리");
		$(location).attr('href', "memberListManage.do");
		jQuery('#board_manage_div').hide();  
	});
	$('#admin_banword').click(function(){
		//alert("금칙어관리");
		$(location).attr('href', "banWordManageServlet.do");
		jQuery('#board_manage_div').hide();  
	});
	$('#admin_delete').click(function(){
		//alert("삭제내역관리");
		$(location).attr('href', "deleteHistoryManageServlet.do");
		jQuery('#board_manage_div').hide();  
	});
	$('#admin_report').click(function(){
		//alert("삭제내역관리");
		$(location).attr('href', "reportedContentManageServlet.do");
		jQuery('#board_manage_div').hide();  
	});
	$('#admin_board').click(function(){
		//alert("게시판관리");
		if($("#board_manage_div").css("display") == "none"){   
	        jQuery('#board_manage_div').show();  
	    } else {  
	        jQuery('#board_manage_div').hide();  
	    }  
	});
	$('#add_board_btn').click(function(){
		//alert("게시판 추가하기");
		$(location).attr('href', "addBoardManageServlet.do");
	});
	$('#modify_board_btn').click(function(){
		//alert("게시판 수정하기");
		$(location).attr('href', "editBoardManageServlet.do");
	});
	$('#delete_board_btn').click(function(){
		//alert("게시판 삭제하기");
		$(location).attr('href', "deleteBoardManageServlet.do");
	});
});