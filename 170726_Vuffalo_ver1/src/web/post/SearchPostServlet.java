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
		
		if(option.equals("��ü")){
			list = PostViewListDAO.getInstacne().searchPostViewVOTotal(keyword);
		}else if(option.equals("�ۼ���")){
			list = PostViewListDAO.getInstacne().searchPostViewVONickname(keyword);
		}else if(option.equals("����")){
			list = PostViewListDAO.getInstacne().searchPostViewVOTitle(keyword);
		}else{ //����
			list = PostViewListDAO.getInstacne().searchPostViewVOContent(keyword);
		}
		
		/*List<PostVO> list = new ArrayList<PostVO>();
		list.add(new PostVO(923,"����","�����̴�","�����̴�~~","2017/07/05/12:05",0));
		list.add(new PostVO(933,"����1","�����̴�","�����̴�~~","2017/07/05/12:05",0));
		list.add(new PostVO(941,"����2","�����̴�","�����̴�~~","2017/07/05/12:05",0));
		list.add(new PostVO(922,"����3","�����̴�","�����̴�~~","2017/07/05/12:05",0));
		for(int i= 0; i<121;i++){
			list.add(new PostVO(i,"�ǿ�" +i,"�����̴�","�����̴�~~","2017/07/05/12:05",0));
		}*/
		
		int listNum = 8; // �⺻ �Խñ� ��� ����
		String lNum = request.getParameter("lNum");
		if(lNum != null){
			listNum = Integer.parseInt(lNum);
		}
		request.setAttribute("lNum", listNum);
		
		int listCount = 0;
		// ��ü �� ��
		if(list!=null){
			listCount = list.size();
		}
		
		// ���� ������ ��ȣ �����
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
