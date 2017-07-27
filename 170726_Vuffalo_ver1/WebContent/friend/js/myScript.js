function modifyProfile(){
	alert("전송합니다");
	document.getElementById("myProfileForm").submit();
}
function deleteCommentReal(){
	alert("댓글을 정말로 삭제합니다.");
}
function addCommentReal(){
	alert("댓글을 답니다.");
}
function editCommentReal(){
	alert("댓글을 수정합니다.")
}
function replyComment(boardNum, postNum, commentNum, depth){
	alert("댓글에 댓글을 답니다.")
	document.getElementById('boardNumForReply').value = boardNum;
	document.getElementById('postNumForReply').value = postNum;
	document.getElementById('commentNumForReply').value = commentNum;
	document.getElementById('depthForReply').value = depth;
	document.getElementById('formForReply').submit();
}
function deleteComment(boardNum, postNum, commentNum, description){
	alert("댓글 삭제합니다.");
	document.getElementById('boardNumForDelete').value = boardNum;
	document.getElementById('postNumForDelete').value = postNum;
	document.getElementById('commentNumForDelete').value = commentNum;
	document.getElementById('descriptionForDelete').value = description;
	document.getElementById('formForDelete').submit();
}
function editComment(boardNum, postNum, commentNum, description){
	alert("댓글을 수정합니다.");
	document.getElementById('boardNumForEdit').value = boardNum;
	document.getElementById('postNumForEdit').value = postNum;
	document.getElementById('commentNumForEdit').value = commentNum;
	document.getElementById('descriptionForEdit').value = description;
	document.getElementById('formForEdit').submit();

}

function selectBoard(){
	alert("게시판 전송");
	document.getElementById("editProfileForm").submit();
}
function deleteBoard(){
	alert("게시판을 삭제합니다");
	document.getElementById("deleteProfileForm").submit();
}
function cancel(){
	alert("취소합니다.");
}
function blockMem(){
	document.getElementById('blockMember').submit();
}
function updateMem(){
	document.getElementById('levelChangeMember').submit();
}
function stopMem(){
	alert(document.getElementById("name").value);
	alert(document.getElementById("reason").value);
	alert(document.getElementById("reasonInText").value);
	alert(document.getElementById("stopPeriod").value);
	document.getElementById('stopMember').submit();
	
}
function addFavorite(){
	alert(document.getElementById('favorOrNot').value)
	document.getElementById('favorOrNot').value = 1;
	location.href="SendProfile";
}
function report(){
	alert("신고합니다");
}
function block(){
	alert("차단");
}
function editBoardDefaultSetting(temp, boardName, boardDesc, writeRight, commentRight, openLevel){
	if(temp != '0'){	
		document.getElementById("boardName").value = boardName;
		document.getElementById("boardDesc").value = boardDesc;
		var a = document.getElementById("writeRight");
		a.selectedIndex = writeRight;
		var b = document.getElementById("commentRight");
		b.selectedIndex = commentRight;
		var c = document.getElementById("openLevel");
		c.selectedIndex = openLevel;
	}
	
}
function sendMail(){
	alert("메일전송");
}
function addFriend(){
	alert("친구요청");
}
function removeFavorite(){
	alert(document.getElementById('favorOrNot').value);
	document.getElementById('favorOrNot').value = "0";
	location.href="SendProfile";
}
function recommend(){
	location.href="viewProfile.do";
}
function editProfile(){
	alert("수정합니다.");
	document.getElementById("myProfile").submit();
}
function cancelModifyProfile(){
	alert("수정 취소합니다");
}
function fileInfo(f){
	   var file = f.files; // files 를 사용하면 파일의 정보를 알 수 있음
	   // file 은 배열이므로 file[0] 으로 접근해야 함

	   if(file[0].size > 1024 * 1024){
	      // 큰 파일을 올리니까 브라우저가 다운되었음 -_-;;
	      alert('1MB 이상의 파일은 안돼!!!');
	      return;
	   }

	   /* var reader = new FileReader(); // FileReader 객체 사용
	   reader.onload = function(rst){ // 파일을 다 읽었을 때 실행되는 부분
	      $('[name=base64text]').val(rst.target.result); // 해당 파일의 base64 값을 가져옴
	   }
	   reader.readAsDataURL(file[0]); // 파일을 읽는다 */
}
