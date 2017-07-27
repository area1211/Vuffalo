package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.BaseDAO;
import connection.DAOException;
import vo.MailViewVO;

public class MailViewConDAO extends BaseDAO {
	private static MailViewConDAO instance;
	
	static{
		instance = new MailViewConDAO();
	}
	
	private MailViewConDAO(){
		
	}
	public static MailViewConDAO getInstance(){
		return instance;
	}
	
	public List<MailViewVO> searchAll() throws DAOException{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet res = null;
		List<MailViewVO> resList = null;
		try{
			con = getConnection();
			String sql = "select * from mail_view";
			pstmt = con.prepareStatement(sql);
			res = pstmt.executeQuery();
			resList = new ArrayList<MailViewVO>();
			while(res.next()){
				resList.add(new MailViewVO(res.getInt(1), res.getInt(3), res.getInt(2), res.getString(4), res.getString(5), res.getByte(6), res.getString(7), res.getString(8),res.getString(9),res.getString(10),res.getString(11)));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			super.closeDBObjects(res, pstmt, con);
		}
		System.out.println(resList);
		return resList;
	}
	
	
	
}