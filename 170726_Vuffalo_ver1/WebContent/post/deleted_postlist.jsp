<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="js/jquery-3.2.1.min.js"></script>
<script src="post/js/view_postlist.js"></script>
<script>
$(document).ready(function(e) {
	$('#search_btn').click(function(){
		$('#delete_btn').submit();
	});
});
</script>
<link rel="stylesheet" href="post/css/view_postlist.css"/>
<style>
	#deleteNum{
		width : 80px;
	}
</style>
<title>삭제내역관리</title>
</head>
<body>
	<jsp:include page="/login.jsp" /><!-- 로그인 -->
	<jsp:include page="/navi_bar.jsp" /><!-- 메인메뉴 -->
   <br/>
	<div id="div_body">
	<h2>삭제내역관리</h2><hr/>
	<form id="show_form" action="viewPost.do">
	<div id="div_list">
	<table class="list_table">
	<tr id="tr1">
		<th id="th1">번호</th>
		<th id="th2">작성자</th>
		<th id="th3">제목</th>
		<th id="th4">내용</th>
		<th id="th5">조회수</th>
		<th id="th6">작성일</th>
	</tr>
	<c:forEach var="postViewVO" items="${list}" varStatus="Listcount">
		<tr>
		<td>${postViewVO.postNum}</td>
		<td>${postViewVO.nickname}</td>
		<td><p id="ptitle">${postViewVO.title}</p></td>
		<td>${postViewVO.content}</td>
		<td>${postViewVO.hit}</td>
		<td>${postViewVO.postDate}</td>
		<td>
		<input type="hidden" id="${postViewVO.title}" value="${postViewVO.postNum}"/>
		<input type="hidden" id="postNum" name="postNum" value="0"/>
		</td>
		</tr>
	</c:forEach>
	</table>
		</div><!-- 리스트 -->
	</form><!-- 상세보기 선택받는폼 -->
	<div id="pageForm" class="paging">
        <c:if test="${startPage != 1}">
            <a href="viewPostList.do?page=${startPage-1}&lNum=${lNum}">[이전]</a>
        </c:if>
        
        <c:forEach var="pageNum" begin="${startPage}" end="${endPage}">
            <c:if test="${pageNum == spage}">
                ${pageNum}&nbsp;
            </c:if>
            <c:if test="${pageNum != spage}">
                <a href='viewPostList.do?page=${pageNum}&lNum=${lNum}'>${pageNum}&nbsp;</a>
            </c:if>
        </c:forEach>
        
        <c:if test="${endPage != maxPage }">
            <a href='viewPostList.do?page=${endPage+1}&lNum=${lNum}'>[다음]</a>
        </c:if>
    </div>	

	<form id="delete_from" action="deletePost.do">
	<table id="search_table">
		<tr>
			<td>삭제할게시글의 번호입력 : 
			<input type="text" value="" name="postNum" id="deleteNum"/>
			<input type="button" value="영구삭제" id="delete_btn"/>
			<input type="hidden" value="admin" name="isAdmin" />
			</td>
			
		</tr>
	</table>
	</form>
	</div><!-- 전체div -->
	<input type="hidden" id="logFlag" value="${logFlag}" name="logFlag"/>
</body>
</html>