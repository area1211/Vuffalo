package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.BaseDAO;
import connection.DAOException;
import vo.MemberActivityVO;
import vo.MemberVisitationVO;

public class MemberVisitationConDAO extends BaseDAO {
private static MemberVisitationConDAO instance;
	
	static{
		instance = new MemberVisitationConDAO();
	}
	
	public static MemberVisitationConDAO getInstance(){
		return instance;
	}
	
	public void addList(List<MemberVisitationVO> addedList){
		Connection con = null;
	      PreparedStatement pstmt1 = null;
	      try{
	         con = getConnection();
	         String sql1 = "insert into member_visitation_tb values(?,?,?,?)";
	         pstmt1 = con.prepareStatement(sql1);
	         for(MemberVisitationVO temp : addedList){
	            pstmt1.setInt(1, temp.getMemberNum());
	            pstmt1.setInt(2, temp.getVisitCount());
	            pstmt1.setString(3, temp.getLastVisitDate());
	            pstmt1.setString(4, temp.getLastProfileUpdateDate());
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
	
	public void editList(List<MemberVisitationVO> editList){
		Connection con = null;
	      PreparedStatement pstmt1 = null;
	      try{
	         con = getConnection();
	         String sql1 = "update member_visitation_tb set mvit_visit_count=?,mvit_last_visit_date=?,mvit_last_profile_update=? where mvit_mem_num=?";
	         pstmt1 = con.prepareStatement(sql1);
	         for(MemberVisitationVO temp : editList){
	            pstmt1.setInt(1, temp.getVisitCount());
	            pstmt1.setString(2, temp.getLastVisitDate());
	            pstmt1.setString(3, temp.getLastProfileUpdateDate());
	            pstmt1.setInt(4, temp.getMemberNum());
	            pstmt1.executeUpdate();
	         }
	      }catch (SQLException e) {
	         
	      } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	      finally {
	         super.closeDBObjects(null, pstmt1, con);
	      }	
	}
	
	public List<MemberVisitationVO> searchAll() throws DAOException{
	      Connection con = null;
	      PreparedStatement pstmt = null;
	      ResultSet res = null;
	      List<MemberVisitationVO> resList = null;
	      try{
	         con = getConnection();
	         String sql = "select * from member_visitation_tb";
	         pstmt = con.prepareStatement(sql);
	         res = pstmt.executeQuery();
	         resList = new ArrayList<MemberVisitationVO>();
	         while(res.next()){
	            resList.add(new MemberVisitationVO(res.getInt(1), res.getInt(2), res.getString(3),res.getString(4)));
	         }
	      }catch (SQLException e) {
	         throw new DAOException();
	      } finally {
	         super.closeDBObjects(res, pstmt, con);
	      }
	      return resList;
	  }
}
