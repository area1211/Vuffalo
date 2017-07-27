package web.comment;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddComment
 */
public class AddCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		request.setAttribute("depth", request.getParameter("depthForReply"));
		request.setAttribute("boardNum", request.getParameter("boardNumForReply"));
		request.setAttribute("postNum",  request.getParameter("postNumForReply"));
		request.setAttribute("commentNum",request.getParameter("commentNumForReply"));
		
		System.out.println("¥Ò±€√ﬂ∞°º≠∫Ì∏¥");
		
		RequestDispatcher rd = request.getRequestDispatcher("comment/add_comment.jsp");
		rd.forward(request, response);
	}

}
