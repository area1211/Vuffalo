package web.post;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manager.PostManager;

public class DeletePostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String rPostNum = request.getParameter("postNum");
		System.out.println("postNum : " + rPostNum);
		if(rPostNum == null){
			RequestDispatcher rq = request.getRequestDispatcher("viewPostList.do");
			rq.forward(request, response);
		}
		
		int postNum = Integer.parseInt(rPostNum);
		PostManager manager = new PostManager();	
		manager.deletePost(postNum, 1);
		
		String isAdmin = request.getParameter("isAdmin");
		if(isAdmin == null){
			RequestDispatcher rq = request.getRequestDispatcher("viewPostList.do");
			rq.forward(request, response);
		}else{
			RequestDispatcher rq = request.getRequestDispatcher("deleteHistoryManageServlet.do");
			rq.forward(request, response);
		}
		
		//response.sendRedirect("viewPostList.do");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}