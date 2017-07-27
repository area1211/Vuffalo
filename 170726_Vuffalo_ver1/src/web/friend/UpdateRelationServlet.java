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
		Integer codeNum = (Integer)session.getAttribute("codeNum"); // 현재 사용자의 회원번호를 얻어온다.
		
		if(codeNum == null)
			codeNum = 0;
		
		String p_codeNum = request.getParameter("p_codeNum");
		String p_name = request.getParameter("p_name");
		String type = request.getParameter("type");
		
		System.out.println("현재회원번호는 "+codeNum+"입니다. 상대방 번호는 "+p_codeNum+". 유형코드는 "+type);
		
		switch(type){
		case "6"://친구차단
			break;
		case "5"://즐겨찾기
			break;
		case "4"://차단해제
		case "3"://친구 요청
			MyFriendManager.sendRequest(codeNum, Integer.parseInt(p_codeNum), p_name);
			//session.setAttribute("wasRequest", true);
			break;
		case "2"://보낸 친구요청 거절, 친구 요청 취소
			MyFriendManager.cancelRequest(codeNum, Integer.parseInt(p_codeNum), p_name);
			//session.setAttribute("wasRequest", false);
			break;
		case "1"://보낸 친구 요청 수락
			MyFriendManager.acceptRequest(codeNum, Integer.parseInt(p_codeNum), p_name);
			break;
		case "0"://친구 끊기
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
