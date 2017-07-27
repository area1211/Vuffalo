<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<link rel="stylesheet" href="./css/navi_bar.css"/>
<script src="./js/jquery-3.2.1.min.js"></script>
<script src="./js/navi_bar.js"></script>

<div id="menuBox">
	<div id="page-wrapper">
		<div id="main-header" style="background: rgb(52, 152, 219);">
			<div id="main-title">
				<hgroup>
	                <h1 class="master-title">Penpal</h1>
	                <h2 class="master-description">JDC컴패니</h2>
	            </hgroup>
			</div>
		</div>
		
		
		<div id="main-navigation" style="background: rgb(224, 224, 224);">
			<div class="pull-left">
				<ul class="outer-menu">
					<li class="outer-menu-item">
						<span id="profile" class="menu-title">프로필</span>
						<ul id="inner-profile" class="inner-menu" style="display: none;">
							<li class="inner-menu-item"><a href="#">나의 프로필</a>
							<li class="inner-menu-item"><a href="#">즐겨찾기 </a>
						</ul>
						
						
						
					</li>
					<li class="outer-menu-item">
						<span class="menu-title">우편함</span>
						<ul class="inner-menu" style="display: none;">
							<li class="inner-menu-item"><a href="#">받은 우편함</a>
							<li class="inner-menu-item"><a href="#">보낸 우편함</a>
							<li class="inner-menu-item"><a href="write_post.jsp">편지쓰기</a>
						</ul>
					</li>
					<li class="outer-menu-item">
						<span class="menu-title">친구관리</span>
						<ul class="inner-menu" style="display: none;">
							<li class="inner-menu-item"><a href="#">나의 친구들</a>
							<li class="inner-menu-item"><a href="#">보낸친구요청</a>
							<li class="inner-menu-item"><a href="#">받은친구요청</a>
							<li class="inner-menu-item"><a href="#">차단회원</a>
						</ul>
					</li>
					<li class="outer-menu-item">
						<span class="menu-title">게시판</span>
						<ul class="inner-menu" style="display: none;">
							<li class="inner-menu-item"><a href="#">펜팔게시판</a>
							<li class="inner-menu-item"><a href="#">자유게시판</a>
						</ul>
					</li>
					<li class="outer-menu-item">
						<span class="menu-title">언어선택</span>
						<ul class="inner-menu" style="display: none;">
							<li class="inner-menu-item"><a href="#">한국어</a>
							<li class="inner-menu-item"><a href="#">영어</a>
							<li class="inner-menu-item"><a href="#">중국어</a>
							<li class="inner-menu-item"><a href="#">일본어</a>
							<li class="inner-menu-item"><a href="#">스페인어</a>
							<li class="inner-menu-item"><a href="#">프랑스어</a>
						</ul>
					<li class="outer-menu-item">
						<span class="menu-title">친구추천</span>
					</li>
				</ul>
			</div>
			<div class="pull-right">
			</div>
		</div>
	</div>
</div>