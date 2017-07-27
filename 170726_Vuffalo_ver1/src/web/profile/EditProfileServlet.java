package web.profile;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class EditProfileServlet
 */
public class EditProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		request.setAttribute("pname", "남나니");
		request.setAttribute("page", 26);
		
		request.setAttribute("pmail", "okokoknow@google.co.kr");
		List<String> languageList = new ArrayList<String>();
		languageList.add("한국어");
		languageList.add("영어");
		languageList.add("일본어");
		List<String> genderList = new ArrayList<String>();
		genderList.add("남성");
		genderList.add("여성");
		request.setAttribute("genderList", genderList);
		List<String> countryList = new ArrayList<String>();
		countryList.add("대한민국");
		countryList.add("미국");
		countryList.add("중국");
		request.setAttribute("countryList", countryList);
		request.setAttribute("introduce", "heelo");
		
		List<String> openLevelList = new ArrayList<String>();
		openLevelList.add("전체공개");
		openLevelList.add("스탭이상");
		openLevelList.add("관리자");
		
		List<String> memberLevelList = new ArrayList<String>();
		memberLevelList.add("일반회원");
		memberLevelList.add("스태프");
		memberLevelList.add("관리자");
		request.setAttribute("boardName", "게시판");
		request.setAttribute("boardDesc", "게시판 설명");
		request.setAttribute("writeRight",0);
		request.setAttribute("commentRight", 0);
		request.setAttribute("openLevel", 0);
		request.setAttribute("addOrEdit", "0");
		request.setAttribute("openLevelList",  openLevelList);
		request.setAttribute("memberLevelList", memberLevelList);
		request.setAttribute("languageList", languageList);
		
//		PrintWriter out = response.getWriter();
//		out.println("프로필수정!");
		HttpSession session = request.getSession(false);
		if(session == null){
			session = request.getSession();
		}
		int num = (Integer)(session.getAttribute("codeNum"));
		PrintWriter out = response.getWriter();
		out.println(num);
//		RequestDispatcher rq = request.getRequestDispatcher("profile/edit_profile.jsp");
//		rq.forward(request, response);
		
		//RequestDispatcher rd = request.getRequestDispatcher("delete_board.jsp");
		//rd.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
