package web.main;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestServlet
 */
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//RequestDispatcher rq = request.getRequestDispatcher("mail/send_mail.jsp");
		RequestDispatcher rq = request.getRequestDispatcher("member/find_id.jsp");
		//RequestDispatcher rq = request.getRequestDispatcher("member/find_password.jsp");
		//RequestDispatcher rq = request.getRequestDispatcher("member/member_leave.jsp");
		//RequestDispatcher rq = request.getRequestDispatcher("member/join.jsp");
		//RequestDispatcher rq = request.getRequestDispatcher("member/check_edit_pwd.jsp");
		//RequestDispatcher rq = request.getRequestDispatcher("post/edit_post.jsp");
		//RequestDispatcher rq = request.getRequestDispatcher("post/view_post.jsp");
		//RequestDispatcher rq = request.getRequestDispatcher("post/write_post.jsp");
		//RequestDispatcher rq = request.getRequestDispatcher("comment/add_comment.jsp");
		//RequestDispatcher rq = request.getRequestDispatcher("comment/edit_comment.jsp");
		//RequestDispatcher rq = request.getRequestDispatcher("admin_member/block_member.jsp");
		//RequestDispatcher rq = request.getRequestDispatcher("admin_member/member_grade_control.jsp");
		//RequestDispatcher rq = request.getRequestDispatcher("admin_member/stop_member.jsp");
		//RequestDispatcher rq = request.getRequestDispatcher("friends/recommend_friend.jsp");
		rq.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
