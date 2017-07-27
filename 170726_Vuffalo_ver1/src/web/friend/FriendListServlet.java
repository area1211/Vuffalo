package web.friend;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lecto.manager.FriendManager;

import manager.MyFriendManager;

/**
 * Servlet implementation class FriendListServlet
 */
public class FriendListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		Integer codeNum = (Integer)session.getAttribute("codeNum");
		
		if(codeNum == null)
			codeNum = 0;
		System.out.println("목록가져오기,,,현재회원번호는 "+codeNum+"입니다.");	
		String cmd = request.getParameter("cmd");
		if(cmd == null)
			cmd = "2";
		
		
		List<String[]> list = MyFriendManager.getFriends(Byte.parseByte(cmd), codeNum);	
		request.setAttribute("list", list);
//		FriendManager fm = new FriendManager();
//		List<String[]> list = fm.getFriends(userNum, Integer.parseInt(cmd)); // 회원번호가 2인 친구의 cmd번관계(친구) 목록 가져오기
		
//		RelationViewConnDAO rvcd = RelationViewConnDAO.getInstance();
//		System.out.println(rvcd.readFromDB());
		
		RequestDispatcher view = null;
		switch(cmd){
		case "0":
			view = request.getRequestDispatcher("friend/cutoutfriend_list.jsp");
			break;
		case "1":
			view = request.getRequestDispatcher("friend/sendfriend_list.jsp");
			break;
		case "2":
			view = request.getRequestDispatcher("friend/friend_list.jsp");
			break;
		case "3":
			view = request.getRequestDispatcher("friend/bookmark_list.jsp");
			break;
		case "4":
			view = request.getRequestDispatcher("friend/receivefriend_list.jsp");
			break;	
		}
		
		
		
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
