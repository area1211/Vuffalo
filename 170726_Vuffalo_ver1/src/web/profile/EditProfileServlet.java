package web.profile;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class EditProfileServlet
 */
public class EditProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		request.setAttribute("pname", "������");
		request.setAttribute("page", 26);
		
		request.setAttribute("pmail", "okokoknow@google.co.kr");
		List<String> languageList = new ArrayList<String>();
		languageList.add("�ѱ���");
		languageList.add("����");
		languageList.add("�Ϻ���");
		List<String> genderList = new ArrayList<String>();
		genderList.add("����");
		genderList.add("����");
		request.setAttribute("genderList", genderList);
		List<String> countryList = new ArrayList<String>();
		countryList.add("���ѹα�");
		countryList.add("�̱�");
		countryList.add("�߱�");
		request.setAttribute("countryList", countryList);
		request.setAttribute("introduce", "heelo");
		
		List<String> openLevelList = new ArrayList<String>();
		openLevelList.add("��ü����");
		openLevelList.add("�����̻�");
		openLevelList.add("������");
		
		List<String> memberLevelList = new ArrayList<String>();
		memberLevelList.add("�Ϲ�ȸ��");
		memberLevelList.add("������");
		memberLevelList.add("������");
		request.setAttribute("boardName", "�Խ���");
		request.setAttribute("boardDesc", "�Խ��� ����");
		request.setAttribute("writeRight",0);
		request.setAttribute("commentRight", 0);
		request.setAttribute("openLevel", 0);
		request.setAttribute("addOrEdit", "0");
		request.setAttribute("openLevelList",  openLevelList);
		request.setAttribute("memberLevelList", memberLevelList);
		request.setAttribute("languageList", languageList);
		
//		PrintWriter out = response.getWriter();
//		out.println("�����ʼ���!");
		HttpSession session = request.getSession(false);
		if(session == null){
			session = request.getSession();
		}
		int num = (Integer)(session.getAttribute("codeNum"));
		PrintWriter out = response.getWriter();
		out.println(num);
//		RequestDispatcher rq = request.getRequestDispatcher("profile/edit_profile.jsp");
//		rq.forward(request, response);
		
		//RequestDispatcher rd = request.getRequestDispatcher("delete_board.jsp");
		//rd.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
