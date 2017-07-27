package web.reportedContent_manage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.DeleteHistoryVO;

public class ReportedContentManageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		List<DeleteHistoryVO> list = new ArrayList<DeleteHistoryVO>();
		
		list.add(new DeleteHistoryVO(832,"음란마귀","으하하우헤헤ㅔ으으ㅡㅇ흐흐","크하하하ㅏ","2017/07/16/11:11","음란물"));
		list.add(new DeleteHistoryVO(123,"음란마귀2","으하하우헤헤ㅔ으으ㅡㅇ흐흐","크하하하ㅏ","2017/07/16/11:11","음란물"));
		list.add(new DeleteHistoryVO(032,"음란마3","으하하으으ㅡㅇ흐흐","크하하하ㅏ","2017/07/16/11:11","음란물"));
		list.add(new DeleteHistoryVO(32,"폭력배","나의핵주먹을받아라","크후로ㅏ","2017/07/16/11:32","욕설"));
		list.add(new DeleteHistoryVO(342,"폭력배2","나의핵주먹을!!!!받아라","크후로ㅏ","2017/07/16/11:32","욕설"));
		
		for(int i = 0; i<48; i++){
			list.add(new DeleteHistoryVO(20+i,"도배맨","나는도배도배","야스ㅏ","2017/07/16/11:32","도배"));
		}
		
		int listNum = 8; // 기본 게시글 목록 개수
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
		RequestDispatcher rq = request.getRequestDispatcher("admin/reported_board_content.jsp");
		rq.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
