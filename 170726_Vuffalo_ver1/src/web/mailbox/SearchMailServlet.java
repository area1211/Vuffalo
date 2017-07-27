package web.mailbox;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manager.MailManager;
import vo.MailViewVO;

/**
 * Servlet implementation class SearchMailServlet
 */
public class SearchMailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchMailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String option = request.getParameter("search_select");
		String keyword = request.getParameter("search_keyword");
		String url = "";
		if(request.getParameter("flagForSearch") == null){
			url = "home.jsp";
		}
		else if(request.getParameter("flagForSearch").equals("0")){//받은편지
			MailManager manager = new MailManager();
			List<MailViewVO> list = manager.searchList(0, option, keyword, (String)(""+request.getSession().getAttribute("codeNum")));
			request.setAttribute("list", list);
			request.setAttribute("flag", 0);
			url = "mail/receive_mailbox.jsp";
		}
		else if(request.getParameter("flagForSearch").equals("1")){//보낸편지
			MailManager manager = new MailManager();
			List<MailViewVO> list = manager.searchList(1,  option,  keyword,  (String)(""+request.getSession().getAttribute("codeNum")));
			request.setAttribute("list", list);
			request.setAttribute("flag", 1);
			url = "mail/send_mailbox.jsp";
		}
		RequestDispatcher rd = request.getRequestDispatcher(url);
		
		rd.forward(request, response);
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
