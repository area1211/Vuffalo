<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="js/jquery-3.2.1.min.js"></script>
<script src="admin/js/reported_board_content.js"></script>
<link rel="stylesheet" href="admin/css/reported_board_content.css"/>

<title>신고하기</title>
</head>
<body>
		<jsp:include page="/login.jsp" /><!-- 로그인 -->
	<jsp:include page="/navi_bar.jsp" /><!-- 메인메뉴 -->
	<jsp:include page="/admin_menu.jsp" /><!-- 관리자메뉴 -->
 
	<div id="div_body">
	<h3>신고내역목록</h3>
	<div id="div_list">
	<table class="list_table">
	<tr id="tr1">
		<th id="th0"></th>
		<th id="th1">번호</th>
		<th id="th2">작성자</th>
		<th id="th3">제목</th>
		<th id="th4">내용</th>
		<th id="th5">신고일</th>
		<th id="th6">신고사유</th>
	</tr>
	<c:forEach var="deleteHistory" items="${list}" varStatus="Listcount">
		<tr>
		<td><input type="checkbox" name="checkbox" value="${deleteHistory.postNum}"/></td>
		<td>${deleteHistory.postNum}</td>
		<td>${deleteHistory.writer}</td>
		<td>${deleteHistory.title}</td>
		<td>${deleteHistory.postText}</td>
		<td>${deleteHistory.deleteDate}</td>
		<td>${deleteHistory.deleteReason}</td>
		</tr>
	</c:forEach>
	</table>
		</div><!-- 리스트 -->
		
	<div id="pageForm" class="paging">
        <c:if test="${startPage != 1}">
            <a href="reportedContentManageServlet.do?page=${startPage-1}&lNum=${lNum}">[이전]</a>
        </c:if>
        
        <c:forEach var="pageNum" begin="${startPage}" end="${endPage}">
            <c:if test="${pageNum == spage}">
                ${pageNum}&nbsp;
            </c:if>
            <c:if test="${pageNum != spage}">
                <a href='reportedContentManageServlet.do?page=${pageNum}&lNum=${lNum}'>${pageNum}&nbsp;</a>
            </c:if>
        </c:forEach>
        
        <c:if test="${endPage != maxPage }">
            <a href='reportedContentManageServlet.do?page=${endPage+1}&lNum=${lNum}'>[다음]</a>
        </c:if>
        <div class="btns_div">
        <input type="button" id="delete_btn" value="게시글삭제"/>
        <input type="button" id="restore_btn" value="신고취소"/>
        </div>	
    </div><!-- 페이징 -->
	</div><!-- 전체div -->
</body>
</html>