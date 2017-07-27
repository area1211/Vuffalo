package web.log;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import manager.LogoutManager;

public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		HttpSession session = request.getSession();
		
		int codeNum= (Integer)session.getAttribute("codeNum");
		int activePoint = (Integer)session.getAttribute("activePoint");
		String lastVisitDate = (String)session.getAttribute("logInTime");
		
		//System.out.println((5+codeNum)+","+activePoint+","+lastVisitDate);
		
		LogoutManager logoutManager = new LogoutManager();
		logoutManager.logout(codeNum, activePoint, lastVisitDate);
		//System.out.println(logoutManager);
		
		if(session.getAttribute("codeNum")!=null)
		{
	      session.removeAttribute("codeNum");
	      session.removeAttribute("name");
	      session.removeAttribute("id");
	      session.removeAttribute("grade");
	      session.removeAttribute("logInTime");
	      session.removeAttribute("activePoint");
	      
	      session.invalidate(); //기존의 세션 데이터 모두 삭제
	      //System.out.println("로그아웃!"+session.getAttribute("codeNum"));
		} 
	      /*RequestDispatcher view = request.getRequestDispatcher("Front.do?cmd=BoardList");
	      view.forward(request, response);*/
	      response.sendRedirect(request.getHeader("referer"));
		return;
	      
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
}	
