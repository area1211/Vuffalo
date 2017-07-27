package dao;

import java.util.ArrayList;
import java.util.List;

import connection.DAOException;
import vo.PostVO;
import vo.PostViewVO;

public class PostViewListDAO {
	private List<PostViewVO> postViewVOList;
	private static PostViewListDAO instance;

	static {
		instance = new PostViewListDAO();
	}

	private PostViewListDAO() {
		postViewVOList = new ArrayList<PostViewVO>();
		init();
	}

	public static PostViewListDAO getInstacne() {
		return instance;
	}

	public void addPostViewVOList(List<PostVO> postVOList) {
		for (PostVO t : postVOList) {
			PostViewVO vvo = new PostViewVO(t.getPostNum(), t.getBoardNum(), t.getTitle(), t.getText(),
					t.getWriteDate(), t.getDeleteFlag(), t.getNickName(), t.getHit());
			postViewVOList.add(vvo);
		}
	}

	public void addPostViewVO(PostVO t) {
		PostViewVO vvo = new PostViewVO(t.getPostNum(), t.getBoardNum(), t.getTitle(), t.getText(), t.getWriteDate(),
				t.getDeleteFlag(), t.getNickName(), t.getHit());
		postViewVOList.add(vvo);
	}

	public boolean deletePostViewVO(PostVO t) {
		/*
		 * PostViewVO vvo = new
		 * PostViewVO(t.getPostNum(),t.getBoardNum(),t.getTitle(),t.getText()
		 * ,t.getWriteDate(),t.getDeleteFlag(),t.getNickName(),t.getHit());
		 */
		for (PostViewVO temp : postViewVOList) {
			if (temp.getPostNum() == t.getPostNum()) {
				return true;
			}
		}
		return false;
	}

	public List<PostViewVO> searchPostViewVOAll() {
		try {
			return PostViewConDAO.getInstacne().searchAll();
		} catch (DAOException e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<PostViewVO> searchPostViewVOTotal(String total) {
		String query;
		try {
			query = "select * from post_list_view where nickname like '%" + total + "%' or title like '%" + total
					+ "%' or content like '%" + total + "%'";
			return PostViewConDAO.getInstacne().searchWhere(query);
		} catch (DAOException e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<PostViewVO> searchPostViewVODeleteAll() {
		String query;
		try {
			query = "select * from post_list_view where post_isdelete=1";
			return PostViewConDAO.getInstacne().searchWhere(query);
		} catch (DAOException e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<PostViewVO> searchPostViewVOBoardNum(int postBoardNum) {
		String query;
		try {
			query = "select * from post_list_view where post_board_num=" + postBoardNum;
			return PostViewConDAO.getInstacne().searchWhere(query);
		} catch (DAOException e) {
			e.printStackTrace();
			return null;
		}
	}

	public PostViewVO searchPostViewVONum(int postNum, int postBoardNum) {
		for (PostViewVO t : postViewVOList) {
			if (t.getPostNum() == postNum) {
				if (t.getPostBoardNum() == postBoardNum) {
					return t;
				}
			}
		}
		return null;
	}

	public List<PostViewVO> searchPostViewVONickname(String nickname) {
		String query;
		try {
			nickname = nickname + "%'";
			query = "select * from post_list_view where nickname like '%" + nickname;
			return PostViewConDAO.getInstacne().searchWhere(query);
		} catch (DAOException e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<PostViewVO> searchPostViewVOTitle(String title) {
		String query;
		try {
			title = title + "%'";
			query = "select * from post_list_view where title like '%" + title;
			return PostViewConDAO.getInstacne().searchWhere(query);
		} catch (DAOException e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<PostViewVO> searchPostViewVOContent(String content) {
		String query;
		try {
			content = content + "%'";
			query = "select * from post_list_view where content like '%" + content;
			return PostViewConDAO.getInstacne().searchWhere(query);
		} catch (DAOException e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<PostViewVO> getPostListVOList() {
		return postViewVOList;
	}

	public void setPostListVOList(List<PostViewVO> postViewVOList) {
		this.postViewVOList = postViewVOList;
	}

	public void init() {
		try {
			postViewVOList = PostViewConDAO.getInstacne().searchAll();
		} catch (DAOException e) {
			e.printStackTrace();
		}
	}

	public boolean editPostViewVO(PostVO t) {
		PostViewVO viewVO = null;
		for (PostViewVO temp : postViewVOList) {
			if (temp.getPostNum() == t.getPostNum()) {
				viewVO = temp;
				break;
			}
		}
		if(viewVO == null) return false;
		String title = t.getTitle();
		String text = t.getText();
		if(title.length() >12){
			title = title.substring(0, 11);
		}
		if(title.length() >16){
			text = text.substring(0,15);
		}
		viewVO.setTitle(title);
		viewVO.setContent(text);
		return true;
	}
}