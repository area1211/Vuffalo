package web.post;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class EditRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String postNum = request.getParameter("postNum");
		String hit = request.getParameter("hit");
		String writeDate = request.getParameter("writeDate");
		String title = request.getParameter("title");
		String nickName = request.getParameter("nickName");
		String fileUrl = request.getParameter("fileUrl");
		String text = request.getParameter("text");
		
		/*PrintWriter out = response.getWriter();
		out.println(postNum+"/"+ hit +"/"+ writeDate +"/"+ title +"/"+ nickName +"/"+ fileUrl +"/"+ text);*/
		
		request.setAttribute("postNum", postNum);
		request.setAttribute("hit", hit);
		request.setAttribute("writeDate", writeDate);
		request.setAttribute("title", title);
		request.setAttribute("nickName", nickName);
		request.setAttribute("fileUrl", fileUrl);
		request.setAttribute("text", text);
		
		RequestDispatcher rq = request.getRequestDispatcher("post/edit_post.jsp");
		rq.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
/*<%-- ${showVO.postNum}/ ${showVO.hit} / ${showVO.writeDate} / ${showVO.title} / ${showVO.nickName} / ${showVO.fileUrl} /
${showVO.text} /  --%>*/
