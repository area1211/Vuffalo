<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="js/jquery-3.2.1.min.js"></script>
<script src="post/js/view_postlist.js"></script>
<link rel="stylesheet" href="post/css/view_postlist.css"/>
<style>
a.pageNumber{
color:black;
}
</style>
<title>게시글 목록보기+검색</title>
</head>
<body>
	<jsp:include page="/login.jsp" /><!-- 로그인 -->
	<jsp:include page="/navi_bar.jsp" /><!-- 메인메뉴 -->
   <br/>
	<div id="div_body">
	<h2>게시판목록보기</h2><hr/>
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
		<td>${Listcount.count}</td>
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
                <a class="pageNumber" href='viewPostList.do?page=${pageNum}&lNum=${lNum}'>${pageNum}&nbsp;</a>
            </c:if>
        </c:forEach>
        
        <c:if test="${endPage != maxPage }">
            <a href='viewPostList.do?page=${endPage+1}&lNum=${lNum}'>[다음]</a>
        </c:if>
    </div>	
		
	<form id="search_from" action="searchPost.do">
	<table id="search_table">
		<tr>
			<td><select name="search_select">
				<option>전체</option>
				<option>작성자</option>
				<option>제목</option>
				<option>내용</option>
			</select>
			<input type="text" placeholder="검색어입력" name="search_keyword"/>
			<input type="button" value="검색" id="search_btn"/>
			<input type="button" value="글쓰기" id="write_btn"/>
			<c:if test="${search =='yes'}">
		<input type="button" value="목록으로" id="goListBtn"/>
	</c:if>
			</td>
		</tr>
	</table>
	</form>
	</div><!-- 전체div -->
	<input type="hidden" id="logFlag" value="${logFlag}" name="logFlag"/>
</body>
</html>