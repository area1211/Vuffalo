<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>프로필 검색하기</title>
<link rel="stylesheet" href="profile/css/profile_search.css" />
<script src="jscript/jquery-3.2.1.min.js"></script>
<script src="profile/js/profile_search.js"></script>
<script>
/*
document.getElementById("confirmButton").onclick = submitAction;

function submitAction()
{
	alert("hi");
    document.getElementById("searchform").submit();
    return false;
}
*/

	function searchProfile(){
		alert("전송합니다.");
		//alert(document.getElementById("confirmButton"));	
		//console.log(document.getElementById("confirmButton"));
		//console.log($('#confirmButton'));
		document.getElementById('searchForm').submit();
		//$('#confirmButton').submit();
		//location.href="home.jsp";
		return;
	}
	
</script>
</head>
<body>
	<jsp:include page="/login.jsp" /><!-- 로그인 -->
	<jsp:include page="/navi_bar.jsp" /><!-- 메인메뉴 -->
	<div class='outerBound'>
	   <h2 class = 'titleFont'>프로필 검색</h2>
	   <div>당신을 기다리는 친구들을 마음껏 찾아보세요~</div>
	   <hr>
	   <form action='searchProfile.do' name = 'searchForm' id = 'searchForm' method='post' >
	   <table>
	   <tr>
	      <td>프로필 영상</td>
	      <td><label class="switch"><input type="checkbox" name="box"><span class="slider round"></span></label></td>
	   </tr>
	   <tr>
	      <td>나이</td>
	      <td>
	          <select class = "inputLine_age" name="age1" id = "age">
	            <c:forEach var = "age" items="${ageList}">
	               <option value = "${age}">${age}</option>
	            </c:forEach>
	         </select>
	      </td>
	      <td></td>
	      <td>
	      	<select class = "inputLine_age" name="age2" id = "age">
	            <c:forEach var = "age" items="${ageList}">
	               <option value = "${age}">${age}</option>
	            </c:forEach>
	         </select>
	      </td>
	   </tr>
	   <tr>
	      <td>성별</td>
	      <td>
	         <select class = "inputLine" name="motherTongue" id = "motherTongue" >
	            <c:forEach var = "sex" items="${sexList}" varStatus="loopCount">
	               <option value = "${loopCount.count}">${sex}</option>
	            </c:forEach>
	         </select>
	      </td>
	   </tr>
	   <tr>
	      <td> 국적</td>
	      <td>
	         <select class = "inputLine" name="hopeLanguage" id = "hopeLanguage">
	            <c:forEach var = "country" items="${countryList}" varStatus="loopCount">
	               <option value = "${country}">${country}</option>
	            </c:forEach>
	         </select>
	      </td>
	   </tr>
	   <tr>
	      <td>언어</td>
	      <td>
	      	<select class = "inputline" name="language" id="language">
	      		<c:forEach var="lang" items="${languageList }" varStatus="loopCount">
	      			<option value="${lang }">${lang }</option>
	      		</c:forEach>
	      	</select>
	      </td>
	   </tr>
	   <tr>
	     <!--  <td> 정렬기준</td> -->
	      <td>
	         <input type="hidden" class = "inputLine" id="gender" name="flag" value="1"/>
	      </td>
	   </tr>
	   <tr>
	      <td></td>
	      <td>
	         <input type="button" class = "confirmButton" id="confirmButton" value="검색"  onClick = "searchProfile()"/>
	         <input type="button" class = "cancelButton" id="searchButton" value="취소" onClick = "cancelModifyProfile()"/>
	      </td>
	   </tr>
	   </table>
	   </form>
   </div>
</body>
</html>