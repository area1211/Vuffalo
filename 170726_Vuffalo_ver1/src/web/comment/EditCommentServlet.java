package web.comment;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EditCommentServlet
 */
public class EditCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		request.setAttribute("description", request.getParameter("descriptionForEdit"));
		request.setAttribute("boardNum", request.getParameter("boardNumForEdit"));
		request.setAttribute("postNum",  request.getParameter("postNumForEdit"));
		request.setAttribute("commentNum",request.getParameter("commentNumForEdit"));
		
		System.out.println("´ñ±Û¼öÁ¤¼­ºí¸´");
		
		RequestDispatcher rd = request.getRequestDispatcher("comment/edit_comment.jsp");
		rd.forward(request, response);
	}

}
