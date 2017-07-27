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
<script src="jscript/jquery-3.2.1.min.js"></script>

<script>
function goServ(num){
	location.href="viewProfile.do?num="+num;
}
</script>
</head>
<body>
	<jsp:include page="/login.jsp" /><!-- 로그인 -->
	<jsp:include page="/navi_bar.jsp" /><!-- 메인메뉴 -->
	 <h2 class = 'titleFont'>프로필 회원 목록</h2>
   <div>프로필 회원 목록입니다.</div>
   <hr>
   <form name = 'searchResultForm' id = 'searchResultForm' method='post' action='ShowServlet'>
   <table>
      <c:forEach var = "profile" items="${list}">
      
   
   <tr id="clicktr" onclick="goServ('${profile.num}');">
      <td class="imageVideo">
      	<img src="profile/images/human.JPG "/>
      </td>
      	
     
      <td class="textTd">
      
      닉네임:${profile.nickname}<br>
   <c:choose>
   <c:when test="${profile.age==0 }">
   나이 : 입력안함
   </c:when>
   <c:otherwise>   
      나이 : ${profile.age}
	</c:otherwise>
   </c:choose><br>
   <c:choose>
   <c:when test="${profile.gender==0 }">
   성별 : 입력안함
   </c:when>
			<c:when test="${profile.gender == '1' }">
				성별 : 남성 
		 	 </c:when>
		  <c:otherwise>
		  성별 : 여성
		  </c:otherwise>
		 </c:choose><br>
		 
		 <c:choose>
		 <c:when test="${profile.nationality==null}">
  국적 : 입력안함
   </c:when>
   <c:otherwise>   
      국적 : ${profile.nationality}
	</c:otherwise>
   </c:choose><br>
   
  <c:choose>
		 <c:when test="${profile.selfIntro==null}">
  소개글 : 입력안함
   </c:when>
   <c:otherwise>   
      소개글 : ${profile.selfIntro}
	</c:otherwise>
   </c:choose>
    
      </td>
    </tr>
    
  </c:forEach>
    </table>
    </form>
    
    <div id="pageForm" class="paging">
        <c:if test="${startPage != 1}">
            <a class="a2" href="ProfileListServlet?page=${startPage-1}&lNum=${lNum}">[이전]</a>
        </c:if>
        
        <c:forEach var="pageNum" begin="${startPage}" end="${endPage}">
            <c:if test="${pageNum == spage}">
                ${pageNum}&nbsp;
            </c:if>
            <c:if test="${pageNum != spage}">
                <a class="a2" href='ProfileListServlet?page=${pageNum}&lNum=${lNum}'>${pageNum}&nbsp;</a>
            </c:if>
        </c:forEach>
        
        <c:if test="${endPage != maxPage }">
            <a class="a2" href='ProfileListServlet?page=${endPage+1}&lNum=${lNum}'>[다음]</a>
        </c:if>
    </div>	
</body>
</html>