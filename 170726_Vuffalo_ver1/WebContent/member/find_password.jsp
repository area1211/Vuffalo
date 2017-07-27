<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>비밀번호찾기</title>
<script src="js/jquery-3.2.1.min.js"></script>
<script src="member/js/find_password.js"></script>
<link rel="stylesheet" href="member/css/find_password.css"/>
</head>
<body>
<div id="div_body">
	<h2>비밀번호찾기</h2><hr/>
	<br/>
	<form id="submit_form" action="findInfo.do">
			<h3>아이디와 이메일을 입력해주세요.</h3>
			<input class="in" type="text" id="id" name="id" placeholder="아이디"/><br/><br/>
			<input class="in" type="text" id="mail" name="mail" placeholder="이메일"/><br/><br/>
			<input type="button" id="ok_btn" value="확인"/>
	</form>
	</div><!-- 전체div -->
</body>
</html>