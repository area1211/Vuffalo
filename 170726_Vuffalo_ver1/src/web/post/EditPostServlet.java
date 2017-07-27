package web.post;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manager.PostManager;

public class EditPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String rPostNum = request.getParameter("postNum");
		if(rPostNum == null){
			RequestDispatcher rq = request.getRequestDispatcher("viewPostList.do");
			rq.forward(request, response);
		}
		int postNum = Integer.parseInt(rPostNum);
		String title = request.getParameter("title");
		String fileUrl = request.getParameter("fileUrl");
		String text = request.getParameter("text");
		
		/*PostVO vo = new PostVO(3, 1, "타131이틀~", "내용131~~", (byte) 1, "2017-07-19 10:02:58", (byte) 0, 1, "뉙1넴", "UeRL",
				0);

		List<PostVO> resList = new ArrayList<PostVO>();
		resList.add(vo);
		PostConDAO.getInstacne().editList(resList);*/
		PostManager manager = new PostManager();
		manager.editPost(postNum, 1, title, text, fileUrl); // boardnum1로 고정
		
		RequestDispatcher rq = request.getRequestDispatcher("viewPostList.do");
		rq.forward(request, response);
		
		/*manager.editPost(20, 1, "후,!!~~~!!!..", "아...", "url"); // boardnum1로 고정
		PrintWriter out = response.getWriter();
		out.println("dd");*/
	}

}
/*<%-- ${showVO.postNum}/ ${showVO.hit} / ${showVO.writeDate} / ${showVO.title} / ${showVO.nickName} / ${showVO.fileUrl} /
${showVO.text} /  --%>*/
