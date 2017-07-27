package web.find;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FindInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String id = request.getParameter("id");
		String mail = request.getParameter("mail");
		
		RequestDispatcher rq;
		if(id!=null){
			//아이디가 입력된 경우 - 비밀번호 찾기인경우
			
			String pwd = "12345"; // 비밀번호찾아서
			request.setAttribute("id", id);
			request.setAttribute("pwd",pwd);
			rq = request.getRequestDispatcher("member/find_password_result.jsp");
		}else{
			//이메일만 입력된 경우- 아이디찾기인경우
			id="bbowkqo7777"; //아이디찾아서
			request.setAttribute("id", id);
			rq = request.getRequestDispatcher("member/find_id_result.jsp");
		}
		rq.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
