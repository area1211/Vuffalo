package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.BaseDAO;
import connection.DAOException;
import vo.ProfileViewVO;

public class ProfileViewConDAO extends BaseDAO{
	private static ProfileViewConDAO instance;
	
	static{
		instance = new ProfileViewConDAO();
	}
	
	public static ProfileViewConDAO getInstance(){
		return instance;
	}
	
	private ProfileViewConDAO(){
		
	}
	public List<ProfileViewVO> searchAll() throws DAOException {
		Connection con = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		List<ProfileViewVO> resList = null;
		try {
			con = getConnection();
			String sql = "select * from profileview";
			psmt = con.prepareStatement(sql);
			rs = psmt.executeQuery();
			resList = new ArrayList<ProfileViewVO>();
			while (rs.next()){
				resList.add(new ProfileViewVO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4)
		                  , rs.getString(5), rs.getString(6), rs.getInt(7), rs.getString(8), rs.getString(9)
		                  , rs.getInt(10), rs.getInt(11), rs.getString(12), rs.getString(13), rs.getString(14)));
			}
		} catch (SQLException e) {
			throw new DAOException();
		} finally {
			super.closeDBObjects(rs, psmt, con);
		}
		System.out.println(resList);
		return resList;
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
	         
	         
	      } catch (SQLException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      } catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
	         closeDBObjects(rs, stmt, conn);
	      }
	      
	      return result;
	      
	      
	   }

}
