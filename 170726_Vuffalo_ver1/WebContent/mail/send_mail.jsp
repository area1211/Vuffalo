<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="js/jquery-3.2.1.min.js"></script>
<script src="mail/js/send_mail.js"></script>
<link rel="stylesheet" href="mail/css/send_mail.css"/>

<title>편지보내기</title>
<!-- 	<form action="formPro.jsp" method="post" enctype="multipart/form-data">
		writer : <input type="text" name="writer" /><br />
		file : <input type="file" name="upload" /><br />
		<input type="submit" value="전송" />
	</form> -->
</head>
<body>
	<jsp:include page="/login.jsp" /><!-- 로그인 -->
	<jsp:include page="/navi_bar.jsp" /><!-- 메인메뉴 -->
	<div id="div_body">
	<h2>편지보내기</h2><hr/>
	<form id="send_form" name="send_form" method="post" enctype="multipart/form-data" action="linkSendMail.do">
	<div id="div_btns">
		<table id="table_btns">
		<tr><td>
		<!-- <input type="button" id="insert_btn" value="영상 첨부"/> -->
		<input type="button" id="send_btn" value="보내기"/>
		<input type="button" id="rewrite_btn" value="다시 쓰기"/>
		<input type="file" name="file" id = "file"/>
		</table>
	</div><!-- 버튼 -->
	<div id="div_send">

		<div id="div_send_head">
			<table>
				<tr><td class="to_td">To.</td><td>
				<input type="text" id="to_text" name="to" value="${receiver}" readonly /></td></tr>
				<tr><td class="to_td">Title.</td><td>
				<input type="text" id="title_text" name="title"/></td></tr>
			</table>
		</div><!-- 보내기머리 -->
		<div id="div_send_body">
			<textarea id="body_text" name="textBody"></textarea>
		</div><!-- 보내기바디 -->
		</form>
		</div><!-- 보내기폼 -->
	</div><!-- 전체div -->

</body>
</html>