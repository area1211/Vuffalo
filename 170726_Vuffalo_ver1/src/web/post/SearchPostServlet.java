package web.post;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PostViewListDAO;
import vo.PostViewVO;

public class SearchPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		List<PostViewVO> list = null;
		String option = request.getParameter("search_select");
		String keyword = request.getParameter("search_keyword");
		
		if(option.equals("전체")){
			list = PostViewListDAO.getInstacne().searchPostViewVOTotal(keyword);
		}else if(option.equals("작성자")){
			list = PostViewListDAO.getInstacne().searchPostViewVONickname(keyword);
		}else if(option.equals("제목")){
			list = PostViewListDAO.getInstacne().searchPostViewVOTitle(keyword);
		}else{ //내용
			list = PostViewListDAO.getInstacne().searchPostViewVOContent(keyword);
		}
		
		/*List<PostVO> list = new ArrayList<PostVO>();
		list.add(new PostVO(923,"은선","제목이다","내용이다~~","2017/07/05/12:05",0));
		list.add(new PostVO(933,"은선1","제목이다","내용이다~~","2017/07/05/12:05",0));
		list.add(new PostVO(941,"은선2","제목이다","내용이다~~","2017/07/05/12:05",0));
		list.add(new PostVO(922,"은선3","제목이다","내용이다~~","2017/07/05/12:05",0));
		for(int i= 0; i<121;i++){
			list.add(new PostVO(i,"의연" +i,"제목이다","내용이다~~","2017/07/05/12:05",0));
		}*/
		
		int listNum = 8; // 기본 게시글 목록 개수
		String lNum = request.getParameter("lNum");
		if(lNum != null){
			listNum = Integer.parseInt(lNum);
		}
		request.setAttribute("lNum", listNum);
		
		int listCount = 0;
		// 전체 글 수
		if(list!=null){
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
		
		
		System.out.println("spage:"+spage+", maxPage:"+maxPage+", startPage:"+startPage+", endPage:"+endPage);
		request.setAttribute("spage", spage);
		request.setAttribute("maxPage", maxPage);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("search", "yes");
		int toIndex = listCount - (spage-1)*listNum;
		int fromIndex = toIndex - listNum;
		if(fromIndex <= 0)
			fromIndex = 0;
		
		System.out.println("from:"+fromIndex+", to:"+toIndex);
		list=list.subList(fromIndex, toIndex);
		request.setAttribute("list", list);
		RequestDispatcher rq = request.getRequestDispatcher("post/view_postlist.jsp");
		rq.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
