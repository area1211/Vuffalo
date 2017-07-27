package web.post;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manager.PostManager;
import vo.PostVO;


public class ViewPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String rPostNum = request.getParameter("postNum");
		//String rPostBoardNum = request.getParameter("boardNum");
		System.out.println(rPostNum);
		int postNum = Integer.parseInt(rPostNum);
		//int boardNum = Integer.parseInt(rPostBoardNum);
		int boardNum = 1;
		//boardNum 1로 고정
		
		PostManager manager = new PostManager();
		PostVO showVO =manager.searchPost(postNum, boardNum);
		if(showVO == null){
			RequestDispatcher rq = request.getRequestDispatcher("viewPostList.do");
			rq.forward(request, response);
		}
		request.setAttribute("showVO", showVO);
		String logName = (String)request.getSession().getAttribute("name");
		int isMe = 0;
		//나의 게시글이 맞으면 1 관리자면2
		if(logName != null){
			if( logName.equals(showVO.getNickName())){
				isMe = 1;
			}
			if(logName.equals("관리자")){
				isMe = 2;
			}
		}
		request.setAttribute("isMe", isMe);
		//System.out.println(showVO);
		RequestDispatcher rq = request.getRequestDispatcher("post/view_post.jsp");
		rq.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
