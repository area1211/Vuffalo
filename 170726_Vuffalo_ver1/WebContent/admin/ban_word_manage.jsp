<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>금지어관리</title>
<script src="js/jquery-3.2.1.min.js"></script>
<script src="admin/js/ban_word_manage.js"></script>
<link rel="stylesheet" href="admin/css/ban_word_manage.css"/>
</head>

<body>
<form method="post">
	<jsp:include page="/login.jsp" /><!-- 로그인 -->
	<jsp:include page="/navi_bar.jsp" /><!-- 메인메뉴 -->
	<jsp:include page="/admin_menu.jsp" /><!-- 관리자메뉴 -->
   </form>
	<div id="div_body">
	<h3>금칙어목록</h3>
	<div id="div_list">
	<form id="delete_form" action="deleteBanWordServlet.do">
	<c:forEach var="banWord" items="${list}" varStatus="Listcount">
		<input type="checkbox" name="checkbox" value="${banWord}"/>
		<input type="text" value="${banWord}" readonly/>
		<c:if test="${Listcount.count%5==0}"><br></c:if>
	</c:forEach>
	<br>
	</form>
        <div class="btns_div">
        <input type="button" id="add_btn" value="추가"/>
        <input type="text" id="add_text" value="금칙어입력"/>
        <input type="button" id="delete_btn" value="삭제"/>
        삭제할 금칙어 체크
        </div>	
		</div><!-- 리스트 -->
	</div><!-- 전체div -->
</body>
</html>