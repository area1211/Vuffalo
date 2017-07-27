package web.memberlist_manage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class MemberListManageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<String[]> list = new ArrayList<String[]>();
		list.add(new String[]{"namnani","2017.07.12","2017.07.12","4","3","2","관리자","일반"});
		list.add(new String[]{"inhowoo","2017.07.12","2017.07.12","7","5","2","회원","정지"});
		list.add(new String[]{"dongchul","2017.07.12","2017.07.12","3","3","2","회원","강퇴"});
		list.add(new String[]{"namnani","2017.07.12","2017.07.12","4","3","2","관리자","일반"});
		list.add(new String[]{"inhowoo","2017.07.12","2017.07.12","7","5","2","회원","정지"});
		list.add(new String[]{"dongchul","2017.07.12","2017.07.12","3","3","2","회원","강퇴"});
		list.add(new String[]{"namnani","2017.07.12","2017.07.12","4","3","2","관리자","일반"});
		list.add(new String[]{"inhowoo","2017.07.12","2017.07.12","7","5","2","회원","정지"});
		list.add(new String[]{"dongchul","2017.07.12","2017.07.12","3","3","2","회원","강퇴"});
		list.add(new String[]{"namnani","2017.07.12","2017.07.12","4","3","2","관리자","일반"});
		list.add(new String[]{"inhowoo","2017.07.12","2017.07.12","7","5","2","회원","정지"});
		list.add(new String[]{"dongchul","2017.07.12","2017.07.12","3","3","2","회원","강퇴"});
		list.add(new String[]{"namnani","2017.07.12","2017.07.12","4","3","2","관리자","일반"});
		list.add(new String[]{"inhowoo","2017.07.12","2017.07.12","7","5","2","회원","정지"});
		list.add(new String[]{"dongchul","2017.07.12","2017.07.12","3","3","2","회원","강퇴"});
		
		for(int i = 0; i< 60; i++){
			list.add(new String[]{"dongchul","2017.07.12","2017.07.12","3","3","2","회원","강퇴"});
		}
		
		int listNum = 10; // 기본 게시글 목록 개수
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
		RequestDispatcher view = request.getRequestDispatcher("admin_member/memberlist_for_manager.jsp");
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
