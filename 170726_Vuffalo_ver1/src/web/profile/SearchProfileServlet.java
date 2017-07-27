package web.profile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manager.ProfileListManager;
import vo.ProfileViewVO;

/**
 * Servlet implementation class SearchProfileServlet
 */
public class SearchProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
	      response.setContentType("text/html;charset=UTF-8");
	      if(request.getParameter("flag") == null){
	      List<String> temp = new ArrayList<String>();
	      temp.add("남성");
	      temp.add("여성");
	      request.setAttribute("sexList", temp);
	      List<Integer> ageList = new ArrayList<Integer>();
	      for(int i = 1; i<=120; i++){
	         ageList.add(i);
	      }
	      request.setAttribute("ageList",  ageList);
	      List<String> countryList = new ArrayList<String>();
	      countryList.add("대한민국");
	      countryList.add("미국");
	      countryList.add("중국");
	      request.setAttribute("countryList",  countryList);
	      
	      List<String> languageList = new ArrayList<String>();
			languageList.add("한국어");
			languageList.add("영어");
			languageList.add("일본어");
		request.setAttribute("languageList", languageList);
	      
	      RequestDispatcher rd = request.getRequestDispatcher("profile/profile_search.jsp");
	      rd.forward(request, response);
	      }
	      else{  
	    	  System.out.println(request.getParameter("motherTongue"));
	    	  //System.out.println(request.getParameter("hopeLanguage"));
	    	String box = request.getParameter("box");
	    	 String upAge = request.getParameter("age1");
	    	  String downAge = request.getParameter("age2");
	    	  String gender = request.getParameter("motherTongue");
	    	  String country = request.getParameter("hopeLanguage");
	    	  String mTongue = request.getParameter("language");
	    	  ProfileListManager manager = new ProfileListManager();
	    	  List<ProfileViewVO> list =manager.showProfileList();
	    	  list = manager.selectBoxList(list, request.getParameter("box"));
	    	  if(list==null){
	    		  System.out.println("해당 정보없음1");
	    		  return;
	    	  }
	    	  list = manager.selectAgeListUp(list, upAge);
	    	  if(list==null){
	    		  System.out.println("해당 정보없음2");
	    		  return;
	    	  }
	    	  list = manager.selectAgeListDown(list, downAge);
	    	  if(list==null){
	    		  System.out.println("해당 정보없음3");
	    		  return;
	    	  }
	    	 // System.out.println(list);
	    	  list = manager.selectGenderList(list, gender);
	    	  if(list==null){
	    		  System.out.println("해당 정보없음4");
	    		  return;
	    	  }
	    	  //System.out.println(list);
	    	  list = manager.selectCountryList(list, country);
	    	  if(list==null){
	    		  System.out.println("해당 정보없음5");
	    		  return;
	    	  }
	    	System.out.println(list);
	    	System.out.println(mTongue);
	    	  list = manager.selectLanguageList(list, mTongue);
	    	  if(list==null){
	    		  System.out.println("해당 정보없음6");
	    		  return;
	    	  }
	    	  request.setAttribute("list", list);
	    	  
	    	  int listNum = 3; // 기본 게시글 목록 개수
	  		String lNum = request.getParameter("lNum");
	  		System.out.println(lNum+"개를 뿌리게씁니다아.");
	  		if(lNum != null){
	  			listNum = Integer.parseInt(lNum);
	  		}
	  		request.setAttribute("lNum", listNum);

	  		// 전체 글 수
	  		int listCount = list.size();
	  		
	  		// 현재 페이지 번호 만들기
	  		int spage = 1;
	  		String page = request.getParameter("page");
	  		if(page != null)
	  			spage = Integer.parseInt(page);
	  		
	  		int maxPage = (int)((double)listCount/listNum + 1 - (double)1/listNum);
	  		int startPage = (int)(spage/5.0 + 0.8)*5 - 4;
	  		int endPage = startPage + 4;
	  		if(endPage > maxPage) endPage = maxPage;
	  		
	  		
	  		System.out.println("spage:"+spage+", maxPage:"+maxPage+", startPage:"+startPage+", endPage:"+endPage);
	  		request.setAttribute("spage", spage);
	  		request.setAttribute("maxPage", maxPage);
	  		request.setAttribute("startPage", startPage);
	  		request.setAttribute("endPage", endPage);
	  		
	  		//게시글 목록 개수 만큼 게시글 가져오기
//	  		int fromIndex = (maxPage-spage+1)*listNum-listNum + 1;
//	  		int toIndex =(maxPage-spage+1)*listNum+listNum-10;
//	  		if(toIndex>=listCount)
//	  			toIndex=listCount;
//	  		System.out.println("전체글수 : "+listCount);
//	  		System.out.println("현제페이지번호 : "+spage);
	  		int toIndex = listCount - (spage-1)*listNum;
	  		int fromIndex = toIndex - listNum;
	  		if(fromIndex <= 0)
	  			fromIndex = 0;
	  		
	  		System.out.println("from:"+fromIndex+", to:"+toIndex);
	  		list=list.subList(fromIndex, toIndex);
	  		request.setAttribute("list", list);

		      RequestDispatcher rd = request.getRequestDispatcher("profile/profile_searchlist.jsp");
		      rd.forward(request, response);
		      
	      }
	    	  
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
