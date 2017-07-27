package web.friend;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import manager.MyFriendManager;

/**
 * Servlet implementation class UpdateRelationServlet
 */
public class UpdateRelationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateRelationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		HttpSession session=request.getSession();
		Integer codeNum = (Integer)session.getAttribute("codeNum"); // ���� ������� ȸ����ȣ�� ���´�.
		
		if(codeNum == null)
			codeNum = 0;
		
		String p_codeNum = request.getParameter("p_codeNum");
		String p_name = request.getParameter("p_name");
		String type = request.getParameter("type");
		
		System.out.println("����ȸ����ȣ�� "+codeNum+"�Դϴ�. ���� ��ȣ�� "+p_codeNum+". �����ڵ�� "+type);
		
		switch(type){
		case "6"://ģ������
			break;
		case "5"://���ã��
			break;
		case "4"://��������
		case "3"://ģ�� ��û
			MyFriendManager.sendRequest(codeNum, Integer.parseInt(p_codeNum), p_name);
			//session.setAttribute("wasRequest", true);
			break;
		case "2"://���� ģ����û ����, ģ�� ��û ���
			MyFriendManager.cancelRequest(codeNum, Integer.parseInt(p_codeNum), p_name);
			//session.setAttribute("wasRequest", false);
			break;
		case "1"://���� ģ�� ��û ����
			MyFriendManager.acceptRequest(codeNum, Integer.parseInt(p_codeNum), p_name);
			break;
		case "0"://ģ�� ����
			MyFriendManager.cutFriend((byte)2, Integer.parseInt(p_codeNum), codeNum, p_name);
			break;
		}
		
		
		response.setCharacterEncoding("UTF-8");
		response.sendRedirect(request.getHeader("referer"));
		
		
//		RequestDispatcher view=request.getRequestDispatcher("friendList.do?cmd=4");
//		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
