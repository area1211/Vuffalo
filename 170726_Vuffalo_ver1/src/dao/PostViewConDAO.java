package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.BaseDAO;
import connection.DAOException;
import vo.PostViewVO;

public class PostViewConDAO extends BaseDAO {
	private static PostViewConDAO instance;
	
	static{
		instance = new PostViewConDAO();
	}
	private PostViewConDAO(){
	}
	public static PostViewConDAO getInstacne(){
		return instance;
	}
	public List<PostViewVO> searchAll() throws DAOException {
		Connection con = null;
		PreparedStatement psmt = null;
		ResultSet res = null;
		List<PostViewVO> resList = null;
		try {
			con = getConnection();
			String sql = "select *from post_list_view";
			psmt = con.prepareStatement(sql);
			res = psmt.executeQuery();
			resList = new ArrayList<PostViewVO>();
			while (res.next()){
				resList.add(new PostViewVO(res.getInt(1),res.getInt(2), res.getString(3),res.getString(4),res.getString(5), res.getInt(6),
						res.getString(7),res.getInt(8)));
			}
		} catch (SQLException e) {
			throw new DAOException();
		} finally {
			super.closeDBObjects(res, psmt, con);
		}
		return resList;
	}
	public List<PostViewVO> searchWhere(String query) throws DAOException {
		Connection con = null;
		PreparedStatement psmt = null;
		ResultSet res = null;
		List<PostViewVO> resList = null;
		try {
			con = getConnection();
			String sql = query;
			psmt = con.prepareStatement(sql);
			res = psmt.executeQuery();
			resList = new ArrayList<PostViewVO>();
			while (res.next()){
				resList.add(new PostViewVO(res.getInt(1),res.getInt(2), res.getString(3),res.getString(4),res.getString(5), res.getInt(6),
						res.getString(7),res.getInt(8)));
			}
		} catch (SQLException e) {
			throw new DAOException();
		} finally {
			super.closeDBObjects(res, psmt, con);
		}
		return resList;
	}
}
