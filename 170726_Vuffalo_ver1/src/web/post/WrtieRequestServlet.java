package web.post;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WrtieRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String sessionName = (String)request.getSession().getAttribute("name");
		if(sessionName == null){
			RequestDispatcher rq = request.getRequestDispatcher("viewPostList.do");
			rq.forward(request, response);
		}
		String boardNum = "1";
		
		request.setAttribute("sessionName", sessionName );
		request.setAttribute("boardNum",boardNum);
		
		RequestDispatcher rq = request.getRequestDispatcher("post/write_post.jsp");
		rq.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
