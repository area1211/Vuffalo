<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <link rel="stylesheet" href="./css/login.css"/>
 <style>

 </style>
<div class="login">
	<c:set var="state" value="${session}"/>
	<c:choose>
		<c:when test="${grade == 3}">
			<div class="mem-btn">
				<a class="link" href="logout.do">로그아웃</a><a class="link" href="memberListManage.do">관리설정</a>
			</div>
			<div class="login-user">
				<p id="welcome-text"><span class="login-name">${name}</span>님 반갑습니다!</p>
			</div>
			
		</c:when>
		<c:when test="${grade == 1}">
			<div class="mem-btn">
				<a class="link" href="logout.do">로그아웃</a>
				<a class="link" href="member/check_edit_pwd.jsp">개인정보</a>
			</div>
			<div class="login-user">
				<p><span class="login-name">${name}</span>님 반갑습니다!</p>
			</div>
			
		</c:when>
		<c:otherwise>
		
		<div class="login-box">
			<form method="post" action="login.do">
				<input type="text" class="input-size" name="id" placeholder="아이디"/>
				<input type="password" class="input-size" name="pwd" placeholder="비밀번호"/>
				<input type="submit" class="login-btn"value="로그인"/><br>
				<div class="link-box">
					<a class="link-login" href="linkFindId.do">아이디찾기 / </a>
					<a class="link-login" href="linkFindPwd.do">비밀번호찾기</a>
					<a class="link2-login" href="linkJoin.do">회원가입</a>
				</div>
			</form>
		</div>
		</c:otherwise>
	</c:choose>
</div>