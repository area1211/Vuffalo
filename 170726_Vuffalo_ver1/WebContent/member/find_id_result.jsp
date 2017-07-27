<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>아이디 찾기 결과</title>
<script src="js/jquery-3.2.1.min.js"></script>
<link rel="stylesheet" href="member/css/find_id_result.css"/>
</head>
<body>
<div id="div_body">
	<h2>아이디 찾기 결과</h2><hr/>
	<br/>
		<table>
			<tr><td><a class="text">아이디 : </a></td>
			<td><input class="in" type="text" id="id" name="id" value="${id}" readonly/><br/><br/></td>
			<tr>
		</table>
			<input type="button" id="ok_btn" value="확인"/>
	</div><!-- 전체div -->
</body>
</html>