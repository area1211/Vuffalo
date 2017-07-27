package web.mailbox;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import manager.MailManager;

/**
 * Servlet implementation class LinkSendMailServlet
 */
public class LinkSendMailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		String receiver = request.getParameter("receiverNickName");
		if (receiver == null) {
			receiver = "µ¿Ã¶";
		}
		request.setAttribute("receiver", receiver);

		RequestDispatcher rq = request.getRequestDispatcher("mail/send_mail.jsp");
		rq.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		String path = "C:\\Workspaces\\Lecto15_ee_works\\1707_Vuffalo_ver1\\WebContent\\file";
		int max = 1024 * 1024 * 10;
		String enc = "utf-8";
		DefaultFileRenamePolicy dfr = new DefaultFileRenamePolicy();

		MultipartRequest multi = new MultipartRequest(request, path, max, enc, dfr);
		String file = "file\\" + multi.getOriginalFileName("file");
		System.out.println(file + "al;skdjf;alsdkjf;laskd");
		String to = multi.getParameter("to");
		String title = multi.getParameter("title");
		String textBody = multi.getParameter("textBody");

		byte fileFlag;
		if (file == null || file.length() == 0) {
			fileFlag = 0;
			file = null;
		} else if (file.contains(".avi") || file.contains(".mp4") || file.contains("wmv"))
			fileFlag = 2;
		else
			fileFlag = 1;

		MailManager manager = new MailManager();

		manager.makeMailVO(Integer.parseInt("" + request.getSession().getAttribute("codeNum")), to, title, textBody,
				file, fileFlag);
		response.sendRedirect("ViewMailList.do?flag=1");
	}

}