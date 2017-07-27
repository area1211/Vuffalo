package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.BaseDAO;
import connection.DAOException;
import vo.DailyActiveVO;
import vo.MemberVisitationVO;

public class DailyActiveConDAO extends BaseDAO {
	private static DailyActiveConDAO instance;
	
	static{
		instance= new DailyActiveConDAO();
	}
	public static DailyActiveConDAO getInstance(){
		return instance;
	}
	public void addList(List<DailyActiveVO> addedList){
		Connection con = null;
	      PreparedStatement pstmt1 = null;
	      try{
	         con = getConnection();
	         String sql1 = "insert into daily_active_tb values(?,?)";
	         pstmt1 = con.prepareStatement(sql1);
	         for(DailyActiveVO temp : addedList){
	            pstmt1.setInt(1, temp.getMemberNum());
	            pstmt1.setInt(2, temp.getActivePoint());
	            pstmt1.executeUpdate();
	         }
	      }
	      catch (SQLException e) {
	         
	      } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	      finally {
	         super.closeDBObjects(null, pstmt1, con);
	    }
	}
	
	public List<DailyActiveVO> searchAll() throws DAOException{
	      Connection con = null;
	      PreparedStatement pstmt = null;
	      ResultSet res = null;
	      List<DailyActiveVO> resList = null;
	      try{
	         con = getConnection();
	         String sql = "select * from daily_active_tb";
	         pstmt = con.prepareStatement(sql);
	         res = pstmt.executeQuery();
	         resList = new ArrayList<DailyActiveVO>();
	         while(res.next()){
	            resList.add(new DailyActiveVO(res.getInt(1), res.getInt(2)));
	         }
	      }catch (SQLException e) {
	         throw new DAOException();
	      } finally {
	         super.closeDBObjects(res, pstmt, con);
	      }
	      return resList;
	  }
}
