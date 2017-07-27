package web.post;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manager.PostManager;


public class WritePostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String rImgFlag = request.getParameter("imgFlag");
		String fileUrl = request.getParameter("fileUrl");
		
		Byte imgFlag = Byte.parseByte(rImgFlag);
		/*if(title==null){
			RequestDispatcher rq = request.getRequestDispatcher("post/write_post.jsp");
			rq.forward(request, response);
		}//쓰기요청
*/		
		//int rCodeNum = (int) request.getSession().getAttribute("codeNum");
		/*if(rCodeNum == null){
			RequestDispatcher rq = request.getRequestDispatcher("viewPostList.do");
			rq.forward(request, response);
			return;
		}*/
		/*int codeNum = Integer.parseInt(rCodeNum);*/
		int codeNum = (int) request.getSession().getAttribute("codeNum");
		String nickName = (String) request.getSession().getAttribute("name");
		
		/*System.out.println("title:"+title+" content:"+content);
		PostVO vo = new PostVO(ran,1,title,content,(byte)0,"2017-07-19 10:02:58.0",(byte)0,1,"글쓰기맨","wrURL",0);
		PostListDAO.getInstance().addPostVO(vo);*/
		PostManager manager = new PostManager();
		manager.writePost(1, title, content, imgFlag, (byte)0, codeNum, nickName, fileUrl);
		//boardNum은 현재 1만
		response.sendRedirect("viewPostList.do");
		/*RequestDispatcher rq = request.getRequestDispatcher("viewPostList.do");
		rq.forward(request, response);*/
		
	}

}
