<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>친구 요청</title>
<link rel="stylesheet" href="friend/css/bookmark_list.css" />
<script src="friend/js/bookmark_list.js"></script>
<script src="js/jquery-3.2.1.min.js"></script>
<script>
	function goServlet2(codeNum, name, type){
		//alert(codeNum +", "+name);
		var flag;
		if(type==1)
			flag=confirm("친구 요청을 수락하시겠습니까?");
		else if(type==2)
			flag=confirm("친구 요청을 거부하시겠습니까?");
		
		if(flag==true)
			location.href="UpdateRelation.do?p_codeNum="+codeNum+"&p_name="+name+"&type="+type;
	};

	$(document).ready(function(e) {
		var videos = $('.videos');
		console.log($('.videos'));
		console.log(document.querySelectorAll(".videos"));
		console.log($('.videos')[0]);
		console.log(videos[0]);

		console.log(videos[1]);

		$('.videos').hover(function(e) {
			this.play();
		}, function(e) {
			this.pause();
		});
		$('.pointer').hover(function(e){
			this.style.cursor="pointer";
		});
// 		$('#accept').click(function(e){
// 			alert("수락!");
// 			console.log($(this));
			
// 			//this[0].parentElement.previousElementSibling
// 			//location.href="UpdateRelation.do";
// 		});
	});
</script>
</head>
<body>
	<jsp:include page="/login.jsp" /><!-- 로그인 -->
	<jsp:include page="/navi_bar.jsp" /><!-- 메인메뉴 -->
	<div class="div_body">
		<h2>친구 요청</h2>
		<div>친구요청관리를 해보세요!</div>
		<hr>
		<form name='searchResultForm' id='searchResultForm' method='post'
			action='ShowServlet'>
			<table class="table_css">
				<tr>
					<td class="title" colspan="3">받은 친구요청</td>
				</tr>
<%-- 				<c:forEach var="bookmark" items="${list}"> --%>
<!-- 					<tr> -->
<%-- 						<c:choose> --%>
<%-- 							<c:when test="${bookmark[6]=='0' }"> --%>
<%-- 								<td class="imageVideo"><img src="${bookmark[5] }" /></td> --%>
<%-- 							</c:when> --%>
<%-- 						</c:choose> --%>

<%-- 						<c:choose> --%>
<%-- 							<c:when test="${bookmark[6]=='1' }"> --%>
<!-- 								<td class="imageVideo"><video class="videos" -->
<%-- 										src="${bookmark[5]}" type="video/mp4" width="200px" --%>
<!-- 										height="110px" /></td> -->
<%-- 							</c:when> --%>
<%-- 						</c:choose> --%>
<%-- 						<td class="textTd">이름:${bookmark[0]} <br>나이:${bookmark[1]} --%>
<%-- 							<br>성별:${bookmark[2]} <br>국적:${bookmark[3]} <br> --%>

<%-- 							소개글:${bookmark[4]}<br> 요청받은일시:${bookmark[7]}<br> --%>
<!-- 						</td> -->
<!-- 						<td><img width="90px" height="30px" -->
<!-- 							src="friend/images/refusal.JPG" /> <img width="90px" -->
<!-- 							height="30px" src="friend/images/accept.JPG" /></td> -->
<!-- 					</tr> -->
<%-- 				</c:forEach> --%>
				<c:forEach var="bookmark" items="${list}">
					<tr>
						<c:choose>
							<c:when test="${bookmark[6]=='1' }">
								<td class="imageVideo"><img src="${bookmark[5] }" /></td>
							</c:when>
						</c:choose>

						<c:choose>
							<c:when test="${bookmark[6]=='2' }">
								<td class="imageVideo"><video class="videos"
										src="${bookmark[5]}" type="video/mp4" width="266px"
										height="191px" /></td>	
							</c:when>
						</c:choose>
						<td class="textTd">
<%-- 							이름:${bookmark[0]} <br>나이:${bookmark[1]} --%>
<%-- 							<br>성별:${bookmark[2]} <br>국적:${bookmark[3]} <br> --%>
<%-- 							언어:${bookmark[7]}<br> 요청 받은 날짜:${bookmark[8]}<br> --%>
<%-- 							연락회수:${bookmark[9]}<br> 소개글:${bookmark[4]}<br> --%>
							<table>
								<tr>
									<td class="p_name">이름:${bookmark[0]}</td>
									<td>요청 받은 날짜:${bookmark[8]}</td>
								</tr>
								<tr>
									<td>국적:${bookmark[3]}&nbsp;언어:${bookmark[7]}<br/>소개글:${bookmark[4]}</td>
									<td><img class="pointer" width="90px" height="30px" src="friend/images/refusal.JPG" 
									onclick="goServlet2('${bookmark[9]}', '${bookmark[0]}', 2);"/> 
									<img id="accept" class="pointer" width="90px" height="30px" src="friend/images/accept.JPG" 
									onclick="goServlet2('${bookmark[9]}', '${bookmark[0]}', 1);"/></td>
								</tr>
							</table>
							<input class="p_name" type="hidden" value="${bookmark[0]}"/>
							<input class="p_codeNum" type="hidden" value="${bookmark[9]}"/>
						</td>
<!-- 						<td><img width="90px" height="30px" -->
<!-- 							src="friend/images/refusal.JPG" /> <img id="accept" width="90px" -->
<!-- 							height="30px" src="friend/images/accept.JPG" /></td> -->
					</tr>
					
				</c:forEach>
				<tr><td><c:if test="${empty list}">받은 친구 요청이 없습니다!</c:if></td></tr>
			</table>
		</form>
	</div>
</body>
</html>