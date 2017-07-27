<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>받은 편지함</title>
<script src="js/jquery-3.2.1.min.js"></script>
<script src="mail/js/receive_mailbox.js"></script>
<link rel="stylesheet" href="mail/css/receive_mailbox.css"/>
</head>

<body>
	<jsp:include page="/login.jsp" /><!-- 로그인 -->
	<jsp:include page="/navi_bar.jsp" /><!-- 메인메뉴 -->
	<div id="div_body">
	<h2>받은편지함</h2><hr/>
	<form id="search_from" method = "GET" action="SearchMail.do">
	<table id="search_table">
		<tr>
			<td><select name="search_select">
				<option>보낸사람</option>
				<option>제목</option>
				<option>내용</option>
				<option>수신일</option>
			</select>
			<input type="text" value="검색어입력" name="search_keyword" id="search_keyword"/>
			<input type="button" value="검색" id="search_btn" onClick = "searchList()"/>
			<input type="button" value="삭제" id="delete_btn" onClick = "remove()"/>
			</td>
		</tr>
	</table>
	<input type="hidden" id="flagForSearch" name="flagForSearch" value = "0"/>
	</form>
	<form id="selectmail_form" action="DeleteMail.do">
	<input type="hidden" id="flag" name="flag" />
	<div id="div_list">
	<table class="list_table">
	<tr id="tr1">
		<th id="th0"></th>
		<th id="th1">번호</th>
		<th id="th2">보낸사람</th>
		<th id="th3">제목</th>
		<th id="th4">내용</th>
		<th id="th5">수신일</th>
	</tr>
	<c:forEach var="receiveMail" items="${list}" varStatus="Listcount">
		<tr>
		<td><input type="checkbox" id="checkbox" name="checkbox" value="${receiveMail.mailNum}"/></td>
		<td>${Listcount.count}</td>
		<td>${receiveMail.senderNickName}</td>
		<td>${receiveMail.title}</td>
		<c:choose>
			<c:when test = "${receiveMail.readDate == null}">
				<td onClick = "temp(${receiveMail.mailNum})"><div class="colorblue"><strong>${receiveMail.content}</strong></div></td>
			</c:when>
			<c:otherwise>
				<td onClick = "temp(${receiveMail.mailNum})">${receiveMail.content}</td>
			</c:otherwise>
		</c:choose>
		<td>${receiveMail.sendDate}</td>
		</tr>
	</c:forEach>
	</table>
		</div><!-- 리스트 -->
		</form><!-- 삭제할 편지를 선택받는 폼 -->
		<!-- 추가한부분 -->
		<div id="pageForm" class="paging">
        <c:if test="${startPage != 1}">
            <a href="receiveMailBox.do?page=${startPage-1}&lNum=${lNum}">[이전]</a>
        </c:if>
        
        <c:forEach var="pageNum" begin="${startPage}" end="${endPage}">
            <c:if test="${pageNum == spage}">
                ${pageNum}&nbsp;
            </c:if>
            <c:if test="${pageNum != spage}">
                <a href='receiveMailBox.do?page=${pageNum}&lNum=${lNum}'>${pageNum}&nbsp;</a>
            </c:if>
        </c:forEach>
        <form id="viewMail" id="GET" action="viewMail.do">
        	<input type="hidden" id="num" name="num" />
        </form>
        
        <c:if test="${endPage != maxPage }">
            <a href='receiveMailBox.do?page=${endPage+1}&lNum=${lNum}'>[다음]</a>
        </c:if>
    </div>
		<!-- 추가한부분 -->
		
		

	</div><!-- 전체div -->
</body>
</html>