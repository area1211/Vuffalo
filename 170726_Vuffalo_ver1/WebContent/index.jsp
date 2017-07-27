<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>프로필 목록</title>
<link rel="stylesheet" href="profile/css/profile_search_result.css" />
<script src="profile/js/profile_search_result.js"></script>
<script src="js/jquery-3.2.1.min.js"></script>

<script>

function goServ(num){
	//location.href="viewProfile.do?num="+num;
	window.open("viewProfile.do?num="+num, "profile", "width=540, height=630, top=50, left=200");
}

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
	 <h2 class = 'titleFont' align="center">새로운 펜팔 친구를 찾아보세요!</h2>
   <div align="center"></div>
   <hr>
   <form name = 'searchResultForm' id = 'searchResultForm' method='post' action='ShowServlet'>
   <table>
      <c:forEach var = "profile" items="${list}">
  <tr id="clicktr" onclick="goServ('${profile.num}');">
   
      <td class="imageVideo">
      	<img src="profile/images/human.JPG "/>
      </td>
      	
     
      <td class="textTd">
      닉네임:${profile.nickname}  
      <br>나이:${profile.age}  <br>성별:${profile.gender}  <br>국적:${profile.nationality}  <br>소개글:${profile.selfIntro}<br> 
      </td>
    </tr>
  </c:forEach>
    </table>
    </form>
    
    <div id="pageForm" class="paging">
        <c:if test="${startPage != 1}">
            <a class="a2" href="HomepageServlet?page=${startPage-1}&lNum=${lNum}">[이전]</a>
        </c:if>
        
        <c:forEach var="pageNum" begin="${startPage}" end="${endPage}">
            <c:if test="${pageNum == spage}">
                ${pageNum}&nbsp;
            </c:if>
            <c:if test="${pageNum != spage}">
                <a class="a2" href='HomepageServlet?page=${pageNum}&lNum=${lNum}'>${pageNum}&nbsp;</a>
            </c:if>
        </c:forEach>
        
        <c:if test="${endPage != maxPage }">
            <a class="a2" href='HomepageServlet?page=${endPage+1}&lNum=${lNum}'>[다음]</a>
        </c:if>
    </div>	
</body>
</html>