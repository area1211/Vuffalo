<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원가입(Join Us!)</title>
<link rel="stylesheet" href="member/css/join.css"/>
<script src="js/jquery-3.2.1.min.js"></script>
</head>
<body>
	<form method="post" action="join.do">
		<div id="join">
			<div id="main-header">
				<h1 class="main-title"> 환영합니다 </h1>
				<h3 class="main-subtitle"> 전세계의 친구들이 당신을 기다리고 있습니다!</h3>
				<hr>
			</div>
			<div id="main-section" style="background:white;">
				<fieldset>
					<legend>회원가입</legend>
						<table>
							<tr>
								<td class="field"><label for="name">이름</label></td>
								<td><input type="text" class="inputSize" id="name" name="name" placeholder="이름을 입력해주세요"/></td>
							</tr>
							<tr>
								<td class="field"><label for="id">아이디</label></td>
								<td><input type="text" class="inputSize" id="id" name="id" placeholder="아이디를 입력해주세요"/></td>
							</tr>
							<tr>
								<td class="field"><label for="pwd">비밀번호</label></td>
								<td><input type="password" class="inputSize" id="pwd" name="pwd" placeholder="비밀번호를 입력해주세요"/></td>
							</tr>
							<tr>
								<td class="field"><label for="pwdCheck">비밀번호확인</label></td>
								<td><input type="password" class="inputSize" id="pwdCheck" name="pwdCheck" placeholder="비밀번호를 다시 한 번 입력해주세요"/></td>
							</tr>
							<tr>
								<td class="field"><label for="email">이메일</label></td>
								<td><input type="text" class="inputSize" id="email" name="email" placeholder="비밀번호를 다시 한 번 입력해주세요"/></td>
							</tr>
						</table>
						<br>
				</fieldset>
			</div>
			<br>
			<br>
			<div style="text-align:center;">
			<input type="submit" id="joinBtn" value="가입하기"/><br>
			</div>
		</div>
	</form>
</body>
</html>