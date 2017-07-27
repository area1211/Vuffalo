package web.banWord_manage;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BanWordManageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String[] list = {"±ÝÁö´Ù!!!!","½´¹ß½´¹ß","¶Ù¹Ù!!!!!","¶Ù¶Ùºüºü","¾ö¸¶°¡¼¶±×´Ã¿¡±¼µû·¯",
				"¾ö¸¶°¡¼¶±×´Ã¿¡±¼µû·¯","¾ö¸¶°¡¼¶±×´Ã¿¡±¼µû·¯","¾ö¸¶°¡¼¶±×´Ã¿¡±¼µû·¯","¾ö¸¶°¡¼¶±×´Ã¿¡±¼µû·¯",
				"¾ö¸¶°¡¼¶±×´Ã¿¡±¼µû·¯","¾ö¸¶°¡¼¶±×´Ã¿¡±¼µû·¯","¾ö¸¶°¡¼¶±×´Ã¿¡±¼µû·¯","¾ö¸¶°¡¼¶±×´Ã¿¡±¼µû·¯"
		};
		request.setAttribute("list", list);
		RequestDispatcher rq = request.getRequestDispatcher("admin/ban_word_manage.jsp");
		rq.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
