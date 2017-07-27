package web.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manager.JoinManager;

public class JoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String name=request.getParameter("name");
		String id=request.getParameter("id");
		String pwd=request.getParameter("pwd");
		String pwdCheck=request.getParameter("pwdCheck");
		String email=request.getParameter("email");
		
		PrintWriter out=response.getWriter();
		
		//if(name!=""&&id!=""&&pwd!=""&&pwdCheck!=""&&email!=""){
			if(pwd.equals(pwdCheck)){
				JoinManager joinManager = new JoinManager();
				joinManager.join(name, id, pwd, email);
			}
			else{
				out.println("비밀번호와 확인이 불일치해요!");
			}
		//}
		//out.println(name+","+id+","+pwd+","+pwdCheck+","+email);
		response.sendRedirect("HomepageServlet");
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

}
