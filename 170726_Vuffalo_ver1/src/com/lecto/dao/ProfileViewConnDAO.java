package com.lecto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.lecto.vo.ProfileViewVO;

import connection.BaseDAO;
import connection.DAOException;

public class ProfileViewConnDAO extends BaseDAO {
	private static ProfileViewConnDAO instance;
	
	static {
		instance = new ProfileViewConnDAO();
	}
	
	private ProfileViewConnDAO(){
		
	}
	
	public static ProfileViewConnDAO getInstance(){
		return instance;
	}
	
	public ProfileViewVO searchProfileViewVO(int memNum){
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		ProfileViewVO result = null;

		try {
			conn = getConnection();
			
			stmt = conn.prepareStatement("select * from profileview where mem_num = ?;");
			stmt.setInt(1, memNum);
			rs = stmt.executeQuery();
			
			
			while(rs.next()){
				result = new ProfileViewVO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4)
						, rs.getString(5), rs.getString(6), rs.getInt(7), rs.getString(8), rs.getString(9)
						, rs.getInt(10), rs.getInt(11), rs.getString(12), rs.getString(13), rs.getString(14));
			}
			
			
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeDBObjects(rs, stmt, conn);
		}
		
		return result;
		
		
	}
}
