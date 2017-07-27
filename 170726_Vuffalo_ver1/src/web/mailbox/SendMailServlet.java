package web.mailbox;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SendMailServlet
 */
public class SendMailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String receiver = request.getParameter("to");
		String title = request.getParameter("title");
		String textBody = request.getParameter("textBody");
		
		PrintWriter out = response.getWriter();
		out.println("receiver : " + receiver + "\ntitle : " + title + "\ntextBody : " +textBody);
		/*RequestDispatcher rq = request.getRequestDispatcher("");*/
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
