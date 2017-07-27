package web.comment;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.CommentVO;

public class ViewCommentListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		CommentVO com1 = new CommentVO(1, 1, 1, 0, 0, "ù��° �ڸ�Ʈ", "�ۼ���1", "2017/11/11", 338);
		CommentVO com2 = new CommentVO(1, 1, 2, 1, 1, "�ι�° �ڸ�Ʈ", "�ۼ���2", "2017/11/11", 329);
		CommentVO com3 = new CommentVO(1, 1, 3, 2, 1, "����° �ڸ�Ʈ", "�ۼ���3", "2017/11/11", 11);
		CommentVO com4 = new CommentVO(1, 1, 4, 2, 2, "�׹�° �ڸ�Ʈ", "�ۼ���4", "2017/11/11", 338);
		CommentVO com5 = new CommentVO(1, 1, 5, 1, 1, "�ټ���° �ڸ�Ʈ", "�ۼ���1", "2017/11/11", 339);
		CommentVO com6 = new CommentVO(1, 1, 6, 2, 5, "������° �ڸ�Ʈ", "�ۼ���6", "2017/11/11", 2);
		CommentVO com7 = new CommentVO(1, 1, 7, 2, 0, "�ϰ���° �ڸ�Ʈ", "�ۼ���7", "2017/11/11", 2);
		CommentVO com8 = new CommentVO(1, 1, 8, 3, 1, "������° �ڸ�Ʈ", "�ۼ���8", "2017/11/11", 339);
		List<CommentVO> commentList = new ArrayList<CommentVO>();
		commentList.add(com1);
		commentList.add(com2);
		commentList.add(com3);
		commentList.add(com4);
		commentList.add(com5);
		commentList.add(com6);
		commentList.add(com7);
		commentList.add(com8);
		
		request.setAttribute("commentList", commentList);
		request.setAttribute("myMemberNum", 338);
		RequestDispatcher rd = request.getRequestDispatcher("comment/view_comment_list.jsp");
		rd.forward(request,response);
	}

}
