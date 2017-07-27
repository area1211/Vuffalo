package web.profile;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manager.ViewProfileManager;
import vo.ProfileViewVO;

public class ViewProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		ViewProfileManager manager = new ViewProfileManager();
		ProfileViewVO profileViewVO
		= manager.viewProfile(Integer.parseInt(request.getParameter("num")));
		
		//response.getWriter().println(request.getParameter("name"));
		
		request.setAttribute("bean", profileViewVO);
		
//		request.setAttribute("favorOrNot", 1);
//		request.setAttribute("moveOrNot", 1);
//		request.setAttribute("name", "주동철");
//		request.setAttribute("age", 26);
//		request.setAttribute("motherTongue", "한국어");
//		request.setAttribute("hopeLanguage", "영어");
//		request.setAttribute("mail", "foreverjdch@naver.com");
//		request.setAttribute("gender", "남성");
//		request.setAttribute("country", "대한민국");
//		request.setAttribute("profileOpenType", "전체공개");
//		request.setAttribute("lastVisitDate", "2017/07/21");
//		request.setAttribute("profileUpdateDate", "2017/07/21");
//		request.setAttribute("image", "temp.png");
//		request.setAttribute("movie", "images/temp.mp4");
//		request.setAttribute("introduce","가나다라마바사가나다라마바사가나다라마바사가나다라마바사가나다라마바사가나다라마바사가나다라마바사가나다라마바사가나다라마바사가나다라마바사가나다라마바사가나다라마바사가나다라마바사가나다라마바사가나다라마바사가나다라마바사가나다라마바사가나다라마바사");
		
		RequestDispatcher rd = request.getRequestDispatcher("profile/view_profile.jsp");
		rd.forward(request, response);
	}

}
