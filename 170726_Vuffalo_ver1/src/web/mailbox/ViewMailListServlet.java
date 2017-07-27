package web.mailbox;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MailViewListDAO;
import vo.MailViewVO;

/**
 * Servlet implementation class ViewMailListServlet
 */
public class ViewMailListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ViewMailListServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		List<MailViewVO> tempList;
		RequestDispatcher rq;
		if (request.getParameter("flag") == null) {
			rq = request.getRequestDispatcher("mail/receive_mailbox.jsp");
		} else if (request.getParameter("flag").equals("0")) {// 받은우편함
			tempList = MailViewListDAO.getInstance()
					.searchMailViewVO(Integer.parseInt("" + request.getSession().getAttribute("codeNum")), false);
			request.setAttribute("list", tempList);
			rq = request.getRequestDispatcher("mail/receive_mailbox.jsp");

		} else {// 보낸우편함
			tempList = MailViewListDAO.getInstance()
					.searchMailViewVO(Integer.parseInt("" + request.getSession().getAttribute("codeNum")), true);
			request.setAttribute("list", tempList);
			rq = request.getRequestDispatcher("mail/send_mailbox.jsp");
		}
		rq.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
