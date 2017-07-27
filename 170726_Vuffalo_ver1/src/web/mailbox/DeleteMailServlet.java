package web.mailbox;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manager.MailManager;

/**
 * Servlet implementation class DeleteMailServlet
 */
public class DeleteMailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteMailServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		if(request.getParameter("flag").equals("0")){
			String[] selected = request.getParameterValues("checkbox");
			
			MailManager temp = new MailManager();
			temp.removeMailList(selected);
		}
		else if(request.getParameter("flag").equals("1")){
			String[] selected = request.getParameterValues("checkbox");
			
			MailManager temp = new MailManager();
			temp.removeMailList(selected);
			
		}
		response.sendRedirect("ViewMailList.do?flag="+request.getParameter("flag"));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
