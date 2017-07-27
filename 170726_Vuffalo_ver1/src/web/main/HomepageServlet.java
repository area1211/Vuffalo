package web.main;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lecto.dao.RelationViewListDAO;

import manager.ProfileListManager;
import vo.ProfileViewVO;

/**
 * Servlet implementation class HomepageServlet
 */
public class HomepageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProfileListManager manager = new ProfileListManager();
		RelationViewListDAO rvld = RelationViewListDAO.getInstance();
		System.out.println("추가된목록\n"+rvld.getAddedRelationVOList());
		System.out.println("삭제된목록\n"+rvld.getDeletedRelationVOList());
		System.out.println("수정된목록\n"+rvld.getDeletedRelationVOList());
		
		List<ProfileViewVO> list = manager.showProfileList();
		request.setAttribute("list", list);
		int listNum = 3; // 기본 게시글 목록 개수
		String lNum = request.getParameter("lNum");
		System.out.println(lNum+"개를 뿌리게씁니다아.");
		if(lNum != null){
			listNum = Integer.parseInt(lNum);
		}
		request.setAttribute("lNum", listNum);

		// 전체 글 수
		int listCount = list.size();
		
		// 현재 페이지 번호 만들기
		int spage = 1;
		String page = request.getParameter("page");
		if(page != null)
			spage = Integer.parseInt(page);
		
		int maxPage = (int)((double)listCount/listNum + 1 - (double)1/listNum);
		int startPage = (int)(spage/5.0 + 0.8)*5 - 4;
		int endPage = startPage + 4;
		if(endPage > maxPage) endPage = maxPage;
		
		
		System.out.println("spage:"+spage+", maxPage:"+maxPage+", startPage:"+startPage+", endPage:"+endPage);
		request.setAttribute("spage", spage);
		request.setAttribute("maxPage", maxPage);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		
		int toIndex = listCount - (spage-1)*listNum;
		int fromIndex = toIndex - listNum;
		if(fromIndex <= 0)
			fromIndex = 0;
		
		System.out.println("from:"+fromIndex+", to:"+toIndex);
		list=list.subList(fromIndex, toIndex);
		request.setAttribute("list", list);
		RequestDispatcher rq = request.getRequestDispatcher("index.jsp");
		rq.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
