package web.member;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connection.DAOException;
import dao.MemberConDAO;
import vo.MemberVO;

public class MemberConDAOTestServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<MemberVO> tempList = new ArrayList<MemberVO>();
	      /*
	      tempList.add(new ProfileVO(6, 1, 13, "대한민국", "한국어", "한국어", "안녕하세요", (byte)2, (byte)2, "파일이름", 4));
	      tempList.add(new ProfileVO(5, 1, 13, "대한민국", "한국어", "한국어", "안녕하세요", (byte)2, (byte)2, "파일이름", 4));
	      try{
	      ProfileConDAO.getInstance().addList(tempList);
	      }*/
	      
		
	      tempList.add(new MemberVO(6, "123", "nani", "nani", "123@naver.com", (byte)2, 77, "2017-07-19 16:36:00",  (byte)1));
	    //  tempList.add(new MemberVO(7, "124", "!24", "123", "124@naver.com", (byte)2, 77, "2017-07-19 16:36:00",  (byte)1));
	      //tempList.add(new ProfileVO(5, 1, 13, "대한민국", "한국어", "한국어", "내용수정함", (byte)2, (byte)2, "수정파일명", 200));
	      //ProfileConDAO.getInstance().editList(tempList);
	      
	      MemberConDAO.getInstance().editList(tempList);
	      
	      
	      List<MemberVO> resList = null;
	      try{
	         
	      resList = MemberConDAO.getInstance().searchAll();
	      request.setAttribute("resList", resList);
	      }catch(DAOException e){
	         
	      }
	      
	      RequestDispatcher rd = request.getRequestDispatcher("res.jsp");
	      rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
