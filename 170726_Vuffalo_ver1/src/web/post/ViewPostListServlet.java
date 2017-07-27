package web.post;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manager.PostManager;
import vo.PostViewVO;

public class ViewPostListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String name = (String)request.getSession().getAttribute("name");
		String logFlag = "in";
		if(name == null){
			logFlag = "out";
		}request.setAttribute("logFlag", logFlag);
		
		PostManager manager = new PostManager();
		List<PostViewVO> list = null;
		list = manager.getPostViewVOList();

		int listNum = 8; // 기본 게시글 목록 개수
		String lNum = request.getParameter("lNum");
		if(lNum != null){
			listNum = Integer.parseInt(lNum);
		}
		request.setAttribute("lNum", listNum);

		int listCount = 0;
		// 전체 글 수
		if(list != null){
			listCount = list.size();
		}
		
		// 현재 페이지 번호 만들기
		int spage = 1;
		String page = request.getParameter("page");
		if(page != null)
			spage = Integer.parseInt(page);
		
		int maxPage = (int)((double)listCount/listNum + 1 - (double)1/listNum);
		int startPage = (int)(spage/5.0 + 0.8)*5 - 4;
		int endPage = startPage + 4;
		if(endPage > maxPage) endPage = maxPage;
		
		
		
		request.setAttribute("spage", spage);
		request.setAttribute("maxPage", maxPage);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("search", "no");
		
		int toIndex = listCount - (spage-1)*listNum;
		int fromIndex = toIndex - listNum;
		if(fromIndex <= 0)
			fromIndex = 0;
		
		
		if(list!=null){
		list=list.subList(fromIndex, toIndex);
		}
		assendingSort(list);
		for(PostViewVO t : list){
			if(t.getPostIsDelete() == 1){
				t.setTitle("관리자에의해 삭제된 게시물입니다.");
				t.setContent("");
			}
		}
		request.setAttribute("list", list);
		RequestDispatcher rq = request.getRequestDispatcher("post/view_postlist.jsp");
		rq.forward(request, response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	public boolean assendingSort(List<PostViewVO> list) {
		if (list.isEmpty())
			return false;
		class Ascending implements Comparator<PostViewVO> {
			public int compare(PostViewVO o1, PostViewVO o2) {
				return -(o1.getPostDate().compareTo(o2.getPostDate()));
			}
		}
		Ascending as = new Ascending();
		Collections.sort(list, as);
		return true;
	}

}
