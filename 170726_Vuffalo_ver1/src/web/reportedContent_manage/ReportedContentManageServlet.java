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
		
		list.add(new DeleteHistoryVO(832,"��������","�����Ͽ�����������Ѥ�����","ũ�����Ϥ�","2017/07/16/11:11","������"));
		list.add(new DeleteHistoryVO(123,"��������2","�����Ͽ�����������Ѥ�����","ũ�����Ϥ�","2017/07/16/11:11","������"));
		list.add(new DeleteHistoryVO(032,"������3","�����������Ѥ�����","ũ�����Ϥ�","2017/07/16/11:11","������"));
		list.add(new DeleteHistoryVO(32,"���¹�","�������ָ����޾ƶ�","ũ�ķΤ�","2017/07/16/11:32","�弳"));
		list.add(new DeleteHistoryVO(342,"���¹�2","�������ָ���!!!!�޾ƶ�","ũ�ķΤ�","2017/07/16/11:32","�弳"));
		
		for(int i = 0; i<48; i++){
			list.add(new DeleteHistoryVO(20+i,"�����","���µ��赵��","�߽���","2017/07/16/11:32","����"));
		}
		
		int listNum = 8; // �⺻ �Խñ� ��� ����
		String lNum = request.getParameter("lNum");
		System.out.println(lNum+"���� �Ѹ��Ծ��ϴپ�.");
		if(lNum != null){
			listNum = Integer.parseInt(lNum);
		}
		request.setAttribute("lNum", listNum);

		// ��ü �� ��
		int listCount = list.size();
		
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
