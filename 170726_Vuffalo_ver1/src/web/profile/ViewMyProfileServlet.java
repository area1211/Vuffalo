package web.profile;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import manager.ViewProfileManager;
import vo.ProfileViewVO;

/**
 * Servlet implementation class ViewMyProfileServlet
 */
public class ViewMyProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		if(session.getAttribute("codeNum")==null){
			RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
			rd.forward(request, response);
			return;
		}
//		request.setCharacterEncoding("UTF-8");
//		response.setContentType("text/html;charset=UTF-8");
//		request.setAttribute("pfavorOrNot", 1);
//		request.setAttribute("pmoveOrNot", 1);
//		request.setAttribute("pname", "주동철");
//		request.setAttribute("page", 26);
//		request.setAttribute("pmotherTongue", "한국어");
//		request.setAttribute("phopeLanguage", "영어");
//		request.setAttribute("pmail", "foreverjdch@naver.com");
//		request.setAttribute("pgender", "1");
//		request.setAttribute("pnationality", "중국");
//		request.setAttribute("pprofileOpenType", "1");
//		request.setAttribute("plastVisitDate", "2017/07/21");
//		request.setAttribute("pprofileUpdateDate", "2017/07/21");
//		request.setAttribute("pimage", "temp.png");
//		request.setAttribute("pmovie", "images/temp.mp4");
//		request.setAttribute("pintroduce","가나다라마바사가나다라마바사가나다라마바사가나다라마바사가나다라마바사가나다라마바사가나다라마바사가나다라마바사가나다라마바사가나다라마바사가나다라마바사가나다라마바사가나다라마바사가나다라마바사가나다라마바사가나다라마바사가나다라마바사가나다라마바사");
		else{
			int num = (Integer)(session.getAttribute("codeNum"));
			ViewProfileManager manager = new ViewProfileManager();
			ProfileViewVO bean = manager.viewProfile(num);
			request.setAttribute("bean", bean);
		
		RequestDispatcher rd = request.getRequestDispatcher("profile/view_my_profile.jsp");
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
