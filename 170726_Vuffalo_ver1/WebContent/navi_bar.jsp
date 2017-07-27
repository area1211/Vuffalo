<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<link rel="stylesheet" href="./css/menu.css"/>
<style>
.m_menu{
	color:white;
}

</style>
<script src="./js/jquery-3.2.1.min.js"></script>
<script src="./js/navi_bar.js"></script>
<script>
function randomFriend(num){
	//location.href="viewProfile.do?num="+num;
	window.open("viewProfile.do?num="+num, "profile", "width=540, height=630, top=50, left=200");
}
function isMember(nowUser){
	if(nowUser==''){
		return false;
	}
	return true;
}
function goServlet(nowUser, type){
	//alert(nowUser+", "+type);
	if(!isMember(nowUser)){
		alert("회원 전용 서비스입니다. 로그인 후 이용해주세요.");
		return;
	}
	var flag=true;
	
	if(flag==true){	
		location.href="ViewMailList.do?flag="+type;
			
			
	}
};

</script>

<div id="menuBox">
	<div id="page-wrapper">
		<div id="main-header" style="background: rgb(47, 155, 228);">
			<div id="main-title">
<!-- 				<hgroup> -->
<!-- 	                <h1 class="master-title">Vuffalow</h1> -->
<!-- 	                <h2 class="master-description">with my penpal</h2> -->
<!-- 	            </hgroup> -->
	            <img src="img/logo5-1.png" />
			</div>
		</div>
		
		
		<div id="main-navigation" style="background: rgb(47, 155, 228);">
			<div class="pull-left">
				<ul class="outer-menu">
					<li class="outer-menu-item">
                  		<span id="profile" class="menu-title"><a class="m_menu" href="HomepageServlet">HOME</a></span>
               		</li>
					<li class="outer-menu-item">
						<span id="profile" class="menu-title"><a class="m_menu" href="viewMyProfile.do">프로필</a></span>
						<ul id="inner-profile" class="inner-menu" style="display: none;">
							<li class="inner-menu-item"><a href="viewMyProfile.do">내프로필</a>
							<li class="inner-menu-item"><a href="searchProfile.do">프로필검색</a>
							<li class="inner-menu-item"><a href="friendList.do?cmd=3">즐겨찾기</a>
						</ul>
						
						
						
					</li>
					<li class="outer-menu-item">
						<span class="menu-title"><a class="m_menu" href="#" onClick="goServlet('${grade}', 0)">우편함</a></span>
						<ul class="inner-menu" style="display: none;">
							<li class="inner-menu-item"><a href="#" onClick="goServlet('${grade}', 0)">받은우편함</a>
							<li class="inner-menu-item"><a href="#" onClick="goServlet('${grade}', 1)">보낸우편함</a>
<!-- 							<li class="inner-menu-item"><a href="linkSendMail.do">편지보내기</a> -->
						</ul>
					</li>
					<li class="outer-menu-item">
						<span class="menu-title"><a class="m_menu" href="friendList.do?cmd=2">친구관리</a></span>
						<ul class="inner-menu" style="display: none;">
							<li class="inner-menu-item"><a href="friendList.do?cmd=2">나의친구들</a>
							<li class="inner-menu-item"><a href="friendList.do?cmd=1">보낸친구요청</a>
							<li class="inner-menu-item"><a href="friendList.do?cmd=4">받은친구요청</a>
							<li class="inner-menu-item"><a href="friendList.do?cmd=0">차단친구목록</a>
						</ul>
					</li>
					<li class="outer-menu-item">
						<span class="menu-title"><a class="m_menu" href="viewPostList.do">게시판</a></span>
						<ul class="inner-menu" style="display: none;">
<!-- 							<li class="inner-menu-item"><a href="viewPostList.do">펜팔게시판</a> -->
							<li class="inner-menu-item"><a href="viewPostList.do">자유게시판</a>
						</ul>
					</li>
					<li class="outer-menu-item">
						<span class="menu-title"><a class="m_menu" href="#">언어</a></span>
						<ul class="inner-menu" style="display: none;">
							<li class="inner-menu-item"><a href="#">한국어</a>
							<li class="inner-menu-item"><a href="#">영어</a>
							<li class="inner-menu-item"><a href="#">중국어</a>
							<li class="inner-menu-item"><a href="#">일본어</a>
						</ul>
					<li class="outer-menu-item">
						<span class="menu-title"><a class="m_menu" onclick="randomFriend(3)">오늘의친구추천</a></span>
					</li>
				</ul>
			</div>
			<div class="pull-right" style="display: none;">
			</div>
		</div>
	</div>
</div>