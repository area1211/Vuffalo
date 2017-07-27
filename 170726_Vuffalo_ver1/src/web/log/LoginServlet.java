package web.log;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import manager.LoginManager;
import vo.MemberVO;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		LoginManager loginManager = new LoginManager();
		//int memberState = loginManager.checkLoginInfo(id, pwd);
		System.out.println(id+","+pwd);
		MemberVO tempVO=loginManager.login(id, pwd);
		//System.out.println("서블릿에서확인"+tempVO);
		
		HttpSession session = request.getSession(false);
		if(session == null){
			session = request.getSession();
		}
		
		if(tempVO!=null){ //일반회원 로그인성공 //if(memberState==1){//일반회원일경우
			
			Calendar calendar = Calendar.getInstance();
	        java.util.Date date = calendar.getTime();
	        String today = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date));
			
	        /*HttpSession session = request.getSession(false);
			if(session == null){
				session = request.getSession();
			}*/
			session.setAttribute("codeNum",tempVO.getMemberNum());
			session.setAttribute("name", tempVO.getNickName());
			session.setAttribute("id", tempVO.getMemberId());
			session.setAttribute("grade", tempVO.getGrade());
			session.setAttribute("logInTime", today);
			session.setAttribute("activePoint",tempVO.getActivePoint());
		
		}
		//request.setAttribute("flag", "7");
		response.sendRedirect(request.getHeader("referer"));
		return;
		
		/*else if(memberState==2){
			request.setAttribute("state",2); //정지
			System.out.println("request 정지회원");
		}
		else if(memberState==3){
			request.setAttribute("state",3); //강퇴
			System.out.println("request 강퇴회원");
		}
		else{ //0
			System.out.println("로그인정보 불일치 : 아이디와 비번을 확인하세요");
		}*/
		
		//RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
		//rd.forward(request, response);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
}
