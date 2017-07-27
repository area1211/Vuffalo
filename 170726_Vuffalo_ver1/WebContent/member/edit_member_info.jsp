<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="member/css/edit_member_info.css" />
<script src="js/jquery-3.2.1.min.js"></script>
<script src="member/js/edit_member_info.js"></script>
</head>
<body>
	<h1 class="title">수정할 정보를 입력해주세요</h1>
	<hr>
	<br>
	<form id="editMember" name="editMember">
		<table class="table">
			<tr>
				<td><h2 class="text">비밀번호:</h2> </td>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input id="pw1" name="pw1" class="input" type="text" placeholder="영어,숫자특수문자, 6~12자 입력"/></td>
			</tr>
			<tr>
				<td><h2 class="text">비밀번호 확인:</h2> </td>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input id="pw2" name="pw2" class="input" type="text" placeholder="비밀번호 한번 더 입력" /></td>
			</tr>
			<tr>
				<td><h2 class="text">이메일:</h2> </td>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input id="email" name="email" class="input" type="text" placeholder="영문시작, @포함 이메일형식에 맞게 입력"/></td>
			</tr>
		</table>
	</form>
	<div align="center">
	<input  class="button"type="button" value="정보수정" />  <div align="right"><a href="http://www.naver.com">회원탈퇴</a></div>
	</div>
</body>
</html>