package web.comment;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteComment
 */
public class DeleteCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		request.setAttribute("description", request.getParameter("descriptionForDelete"));
		request.setAttribute("boardNum", request.getParameter("boardNumForDelete"));
		request.setAttribute("postNum",  request.getParameter("postNumForDelete"));
		request.setAttribute("commentNum",request.getParameter("commentNumForDelete"));
		
		System.out.println("¥Ò±€ªË¡¶º≠∫Ì∏¥");
		
		RequestDispatcher rd = request.getRequestDispatcher("comment/delete_comment.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

