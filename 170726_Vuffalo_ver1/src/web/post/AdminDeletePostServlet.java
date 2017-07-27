package web.post;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manager.PostManager;

public class AdminDeletePostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String rPostNum = request.getParameter("postNum");
		int postNum = Integer.parseInt(rPostNum);
		PostManager manager = new PostManager();	
		manager.editPostDeleteFlag(postNum, 1, (byte)1);
		//manager.deletePost(postNum, 1);
		
	/*	PrintWriter out = response.getWriter();
		out.println(rPostNum);*/
		RequestDispatcher rq = request.getRequestDispatcher("viewPostList.do");
		rq.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
/*
 * <%-- ${showVO.postNum}/ ${showVO.hit} / ${showVO.writeDate} / ${showVO.title}
 * / ${showVO.nickName} / ${showVO.fileUrl} / ${showVO.text} / --%>
 */
