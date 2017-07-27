<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>나의 친구</title>
<link rel="stylesheet" href="friend/css/friend_list.css" />
<script src="friend/js/friend_list.js"></script>
<script src="js/jquery-3.2.1.min.js"></script>
<script>
	function goServlet0(codeNum, name, type){
		//alert(codeNum +", "+name);
		var flag=false;
		if(type==0)
			flag=confirm("정말로 친구사이를 끊으시겠습니까?");
		else if(type==11)
			flag=confirm(name+"님에게 편지를 보내시겠습니까?");
			
		if(flag==true){
			if(type==0)
				location.href="UpdateRelation.do?p_codeNum="+codeNum+"&p_name="+name+"&type="+type;
			else if(type==11)
				location.href="linkSendMail.do?receiverNickName="+name;//편지쓰기
		}
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
	});
</script>
</head>
<body>
	<jsp:include page="/login.jsp" /><!-- 로그인 -->
	<jsp:include page="/navi_bar.jsp" /><!-- 메인메뉴 -->
	<div class="div_body">
		<h2>나의 친구</h2>
		<div><c:out value='${nickname}' default="xxxx"/>님의 친구들을 관리해보세요.</div>
		<hr>
		<form name='searchResultForm' id='searchResultForm' method='post'
			action='ShowServlet'>
			<table class="table_css">
				<tr>
					<td class="title" colspan="3">나의 친구목록</td>
				</tr>
				<c:forEach var="bookmark" items="${list}">
					<tr>
						<c:choose>
							<c:when test="${bookmark[6]=='0' }">
								<td class="imageVideo"><img src="friend/images/human.JPG" /></td>
							</c:when>
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
<%-- 							이름:${bookmark[0]}  --%>
<%-- 							<br>나이:${bookmark[1]} --%>
<%-- 							<br>성별:${bookmark[2]} <br>국적:${bookmark[3]} <br> --%>
<%-- 							언어:${bookmark[7]}<br> 친구추가일:${bookmark[8]}<br> --%>
<%-- 							연락회수:${bookmark[9]}<br> 소개글:${bookmark[4]}<br> --%>
							<table>
								<tr>
									<td class="p_name">이름:${bookmark[0]}</td>
									<td>요청 받은 날짜:${bookmark[8]}</td>
								</tr>
								<tr>
									<td>국적:${bookmark[3]}&nbsp;언어:${bookmark[7]}<br/>소개글:${bookmark[4]}</td>
									<td>
									<li style="list-style-type: none"><img class="pointer" width="90px"
									height="30px" src="friend/images/mailSend.JPG" 
									onclick="goServlet0('${bookmark[9]}', '${bookmark[0]}', 11);"/></li>
									<li style="list-style-type: none"><img class="pointer" width="90px"
									height="30px" src="friend/images/friendDis.JPG" 
									onclick="goServlet0('${bookmark[9]}', '${bookmark[0]}', 0);"/></li>
								</tr>
							</table>
						</td>
						<td>
<!-- 							<li style="list-style-type: none"><img width="90px" -->
<!-- 								height="30px" src="friend/images/mailSend.JPG" /></li> -->
<!-- 							<li style="list-style-type: none"><img width="90px" -->
<!-- 								height="30px" src="friend/images/friendDis.JPG" /></li> -->
						</td>
					</tr>
				</c:forEach>
				<tr><td><c:if test="${empty list}">아직 친구가 없어요! 친구를 사귀어 보세요!</c:if></td></tr>
			</table>
		</form>
	</div>
</body>
</html>