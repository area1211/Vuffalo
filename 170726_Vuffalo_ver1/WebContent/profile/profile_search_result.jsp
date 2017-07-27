<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>프로필 검색 목록</title>
<link rel="stylesheet" href="profile/css/profile_search_result.css" />
<script src="profile/js/profile_search_result.js"></script>
<script src="jscript/jquery-3.2.1.min.js"></script>

<script>
	$(document).ready(function (e){
		console.log($('#iv1'));
		$('#iv1').hover(function(){
			$('#iv1').get(0).play();
		}, function(){
			$("#iv1").get(0).pause();})
		});
</script>
</head>
<body>
	<jsp:include page="/login.jsp" /><!-- 로그인 -->
	<jsp:include page="/navi_bar.jsp" /><!-- 메인메뉴 -->
	 <h2 class = 'titleFont'>프로필 검색 목록</h2>
   <div>검색된 회원 목록입니다.</div>
   <hr>
   <form name = 'searchResultForm' id = 'searchResultForm' method='post' action='ShowServlet'>
   <table>
   <tr>
      <td class="imageVideo">
      	<img src="profile/images/human.JPG"/>
      </td>
      <td class="textTd">
       
      이름:${stringArray[0]}  
      <br>나이:${stringArray[1]}  <br>성별:${stringArray[2]}  <br>국적:${stringArray[3]}  <br>소개글:${stringArray[4]}<br> 
      </td>
    </tr>
    <tr>
      <td class="imageVideo">
      	<video id="iv1" name="iv1" width="200px" height="110px" src="profile/videos/악녀.mp4" type="video/mp4" onClick="hi()" />
      </td>
      <td class="textTd">
       
      이름:${stringArray[0]}  
      <br>나이:${stringArray[1]}  <br>성별:${stringArray[2]}  <br>국적:${stringArray[3]}  <br>소개글:${stringArray[4]}<br>
      </td>
    </tr>
    <tr>
      <td class="imageVideo">
      	<img src="profile/images/human.JPG"/>
      </td>
      <td class="textTd">
       
      이름:${stringArray[0]}  
      <br>나이:${stringArray[1]}  <br>성별:${stringArray[2]}  <br>국적:${stringArray[3]}  <br>소개글:${stringArray[4]}<br>
    </tr>
    <tr>
      <td class="imageVideo">
      	<img src="profile/images/human.JPG"/>
      </td>
      <td class="textTd">
       
      이름:${stringArray[0]}  
      <br>나이:${stringArray[1]}  <br>성별:${stringArray[2]}  <br>국적:${stringArray[3]}  <br>소개글:${stringArray[4]}<br>
      </td>
    </tr>
    <tr>
      <td class="imageVideo">
      	<img src="profile/images/human.JPG"/>
      </td>
      <td class="textTd">
       
      이름:${stringArray[0]}  
      <br>나이:${stringArray[1]}  <br>성별:${stringArray[2]}  <br>국적:${stringArray[3]}  <br>소개글:${stringArray[4]}<br> 
      </td>
    </tr>
    </table>
    </form>
</body>
</html>