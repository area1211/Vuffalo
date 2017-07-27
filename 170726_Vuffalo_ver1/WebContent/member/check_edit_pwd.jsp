<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원정보수정</title>
<link rel="stylesheet" href="member/css/check_edit_pwd.css"/>
<!-- <script>
function moveClose(){
	var p=$('#pwd').val();
	var pc=$('#pwdCheck').val();
	var pn=$('#postNum').val();
	var url="DeletePost_do?pwd="+p+"&pwdCheck="+pc+"&postNum="+pn;
	
	if(p!=pc){
		alert('비밀번호가 일치하지 않습니다.');
		self.close();
	}
	else{
		//opener.location.href=url;
		deleteNow.submit();
		opener.location.href=url; //팝업창 호출한 윈도우 화면 바꾸기
		self.close();//팝업창 닫기
		
	}
}
</script>  -->
</head>
<body>
	<form method="post" action="checkPwd.do">
		<div id="editMemberInfo">
			<div id="main-header">
				<h1 id="main-title">회원정보수정</h1><br>
				<hr>
			</div>
			<div id="main-section" >
				<label for="pwdCheck">비밀번호를 입력해주세요.</label><br>
				<input type="password" id="pwdCheck" name="pwdCheck" placeholder="비밀번호를 입력하세요"/> 
				<input type="submit" id="edit" name="edit" value="확인"/>
			</div>
			
		</div>
	
	</form>
</body>
</html>