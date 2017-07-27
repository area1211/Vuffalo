<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>아이디찾기</title>
<script src="js/jquery-3.2.1.min.js"></script>
<script src="member/js/find_id.js"></script>
<link rel="stylesheet" href="member/css/find_id.css"/>
<!-- <script>
$(document).ready(function(e) {
	$('#ok_btn').click(function(){
		$('#submit_form').submit();
	});
	//$('#goListBtn').backPage();
});
</script> -->

<style>
	hr{
		 border: solid 1px #3498db; 
	}
	#div_body{
		height : 600px;
		width: 500px;
		text-align: center;
	}
	.info{font-size : 11pt;}
	.in{width:250px; height:40px;}
</style>
</head>
<body>
<div id="div_body">
	<h2>아이디찾기</h2><hr/>
	<br/>
	<form id="submit_form" action="findInfo.do">
			<h3>이메일을 입력해주세요.</h3>
			<input class="in" type="text" id="mail" name="mail" placeholder="이메일"/><br/><br/>
			<input type="button" id="ok_btn" value="확인"/>
	</form>
	</div><!-- 전체div -->
</body>
</html>