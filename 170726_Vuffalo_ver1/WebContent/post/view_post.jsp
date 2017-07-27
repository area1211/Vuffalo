<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시글 상세보기</title>
<link rel="stylesheet" href="post/css/view_post.css"/>
<script src="js/jquery-3.2.1.min.js"></script>
<script src="post/js/view_post.js"></script>
</head>
<body>
	<jsp:include page="/login.jsp" /><!-- 로그인 -->
	<jsp:include page="/navi_bar.jsp" /><!-- 메인메뉴 -->
	<div class="view_post">
			<div class="view_post">
				<div class="board_title">
					<h2>자유게시판</h2>
					<h4>다양한 주제로 자유롭게 이야기해보세요</h4>
					<hr>
				</div>
				
				<div class="board_section">
				<br><br>
				<form id="edit_form" action="editRequest.do">
					<table>
						<tr>
							<td class="td_size">글번호</td>
							<td>${showVO.postNum}
							<input type="hidden" name="postNum" value="${showVO.postNum}"/>
							</td> 
						</tr>
						<tr>
							<td class="td_size">조회수</td>
							<td>${showVO.hit}
							<input type="hidden" name="hit" value="${showVO.hit}"/>
							</td> 
						</tr>
						<tr>
							<td class="td_size">작성일시</td>
							<td>${showVO.writeDate}
							<input type="hidden" name="writeDate" value="${showVO.writeDate}"/>
							</td> 
						</tr>
						<tr>
							<td class="td_size">제목</td>
							<td>${showVO.title}
							<input type="hidden" name="title" value="${showVO.title}"/>
							</td> 
						</tr>
						<tr>
							<td class="td_size">작성자</td>
							<td>${showVO.nickName}
							<input type="hidden" name="nickName" value="${showVO.nickName}"/>
							</td> 
						</tr>
						<tr>
							<td class="td_size">미디어</td>
							<td><video src="./video/YBM.mp4" preload="1" controls="1" autoplay loop="0" width="865" height="485"></video>
							${showVO.fileUrl}
							<input type="hidden" name="fileUrl" value="${showVO.fileUrl}"/>
							</td>
						</tr>
						
						<tr>
							<td class="td_size">내용</td>
							<td><textarea id="content" name="content" class="content" readonly>${showVO.text}</textarea>
							<input type="hidden" name="text" value="${showVO.text}"/>
							</td>
						</tr>
					</table>
					</form>
					<div class="btnBox_view">
					
						<input type="button" id="postList_btn" value="목록으로"/>
						<c:if test="${isMe == 1}">
						<form id="btn_form" action="deletePost.do">
						<input type="button" id="delete_btn" value="삭제"/>
						<input type="hidden" name="postNum" value="${showVO.postNum}"/>
						</form>
						<input type="button" id="edit_btn" value="수정"/>
						</c:if>
						<c:if test="${isMe == 2}">
						<form id="admin_form" action="adminDeletePost.do">
						<input type="button" id="adelete_btn" value="관리자삭제"/>
						<input type="hidden" name="postNum" value="${showVO.postNum}"/>
						</form>
						<input type="button" id="aedit_btn" value="수정"/>
						</c:if>
						<!-- <input type="button" id="comment_btn" value="댓글작성"/> -->
					</div>
					
					<br>
				</div>
			</div>
	</div>
	<%-- ${showVO.postNum}/ ${showVO.hit} / ${showVO.writeDate} / ${showVO.title} / ${showVO.nickName} / ${showVO.fileUrl} /
	${showVO.text} /  --%>
</body>
</html>