package web.board_manage;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.BoardVO;

public class BoardConServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardConServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		List<BoardVO> tempList = new ArrayList<BoardVO>();
		//BoardVO bvo = new BoardVO(4,"자유게시판","자유롭다",(byte)1,(byte)1,(byte)1);
		//tempList.add(bvo);		
		//BoardConDAO.getInstance().addList(tempList);
		
	      //tempList.add(new BoardVO(4,"자유게시판2","자유롭다2",(byte)2,(byte)2,(byte)2));
	      
		//BoardConDAO.getInstance().editList(tempList);
		//BoardConDAO.getInstance().deleteList(tempList);  
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
