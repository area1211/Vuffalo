package com.lecto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.lecto.vo.ProfileImageVO;

import connection.BaseDAO;
import connection.DAOException;

public class ProfileImageConnDAO extends BaseDAO{
	public ProfileImageVO searchProfileImageVO(int mNum){
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		ProfileImageVO result = null;
		try {
			conn = getConnection();
			
			stmt = conn.prepareStatement("select * from profile_image_tb where proimg_mem_num = ?");
			stmt.setInt(1, mNum);
			rs = stmt.executeQuery();
			
			while(rs.next()){
				result = new ProfileImageVO(rs.getInt(1), rs.getString(2));
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
