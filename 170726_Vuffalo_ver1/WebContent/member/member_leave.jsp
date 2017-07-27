<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원탈퇴</title>
<script src="js/jquery-3.2.1.min.js"></script>
<script src="member/js/member_leave.js"></script>
<link rel="stylesheet" href="member/css/member_leave.css"/>
</head>
<body>
<div id="div_body">
	<h1>탈퇴안내</h1><hr/>
	<p class="info">1. 사용하고 계신 아이디는 탈퇴할경우 재사용 및 복구가 불가능합니다.</p>
	<p class="info">2. 탈퇴 후에도 게시판형 서비스에 등록한 게시물이 남아있을 수 있습니다.</p>
	<br/><br/>
	<form id="submit_form">
		<input type="checkbox" id="checkbox" name="checkbox"/>&nbsp;안내 사항을 모두 확인하였으며, 이에 동의합니다.
		<div id="div_footer">
			<h3>탈퇴하러면 비밀번호를 입력해 주세요.</h3>
			<input type="text" id="pwd" name="pwd" placeholder="비밀번호"/>
			<input type="button" id="ok_btn" value="확인"/>
		</div>
	</form>
	</div><!-- 전체div -->
</body>
</html>