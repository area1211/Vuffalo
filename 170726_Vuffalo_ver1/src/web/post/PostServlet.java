package web.post;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PostConDAO;
import vo.PostVO;

public class PostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		/*for(int i = 18 ; i< 40; i++){
			
			PostVO vo = new PostVO(i,1,"Ÿ��Ʋ~"+i,"����~~"+i,(byte)0, "2017-07-19 10:02:58",(byte)0,1, "���","URL",0);
					PostListDAO.getInstance().addPostVO(vo);
		}
		List<PostVO> addList = PostListDAO.getInstance().getAddedPostVOList();
		PostConDAO.getInstacne().addList(addList);*/
		////DB�� insert
		/*for(int i = 18 ; i< 40; i++){
			
			PostVO vo = new PostVO(i,1,"Ÿ��Ʋ~"+i,"����~~"+i,(byte)0, "2017-07-19 10:02:58",(byte)0,1, "���","URL",0);
					PostListDAO.getInstance().getDeletedPostVOList().add(vo);
		}
		List<PostVO> deleteList = PostListDAO.getInstance().getDeletedPostVOList();
		PostConDAO.getInstacne().deleteList(deleteList);
		//DB�� DELETE
		*/
		/*for(int i = 18 ; i< 40; i++){
			PostVO vo = new PostVO(i,1,"Ÿ131��Ʋ~"+i,"����131~~"+i,(byte)1, "2017-07-19 10:02:58",(byte)0,1, "��1��","UeRL",0);
					PostListDAO.getInstance().getEditedPostVOList().add(vo);
		}
		List<PostVO> editList = PostListDAO.getInstance().getEditedPostVOList();*/
		//PostConDAO.getInstacne().editList(editList);
		//DB�� edit
		PostVO vo = new PostVO(3,1,"Ÿ131��Ʋ~","����131~~",(byte)1, "2017-07-19 10:02:58",(byte)0,1, "��1��","UeRL",0);
		
		List<PostVO> resList = new ArrayList<PostVO>();
		resList.add(vo);
		PostConDAO.getInstacne().editList(resList);
		
	/*	try {
			resList = PostConDAO.getInstacne().searchAll();
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		request.setAttribute("resList", resList);

		RequestDispatcher rd = request.getRequestDispatcher("res.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
