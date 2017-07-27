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
import vo.MemberVO;

public class MemberActivityConDAO extends BaseDAO {
	
	private static MemberActivityConDAO instance;
	
	static{
		instance = new MemberActivityConDAO();
	}
	
	public static MemberActivityConDAO getInstance(){
		return instance;
	}
	
	public void addList(List<MemberActivityVO> addedList){
		Connection con = null;
	      PreparedStatement pstmt1 = null;
	      try{
	         con = getConnection();
	         String sql1 = "insert into member_activity_tb values(?,?,?,?)";
	         pstmt1 = con.prepareStatement(sql1);
	         for(MemberActivityVO temp : addedList){
	            pstmt1.setInt(1, temp.getMemberNum());
	            pstmt1.setInt(2, temp.getActivePoint());
	            pstmt1.setInt(3, temp.getCommentCount());
	            pstmt1.setInt(4, temp.getPostCount());
	            pstmt1.executeUpdate();
	         }
	      }
	      catch (SQLException e) {
	         
	      } catch (Exception e) {
			e.printStackTrace();
		} 
	      finally {
	         super.closeDBObjects(null, pstmt1, con);
	    }
	}
	
	public void editList(List<MemberActivityVO> editList){
		Connection con = null;
	      PreparedStatement pstmt1 = null;
	      try{
	         con = getConnection();
	         String sql1 = "update member_activity_tb set mact_active_point=?, mact_comment_count=?,mact_post_count=? where mact_mem_num=?";
	         pstmt1 = con.prepareStatement(sql1);
	         for(MemberActivityVO temp : editList){
	            pstmt1.setInt(1, temp.getActivePoint());
	            pstmt1.setInt(2, temp.getCommentCount());
	            pstmt1.setInt(3, temp.getPostCount());
	            pstmt1.setInt(4, temp.getMemberNum());
	            pstmt1.executeUpdate();
	         }
	      }catch (SQLException e) {
	         
	      } catch (Exception e) {
			e.printStackTrace();
		} 
	      finally {
	         super.closeDBObjects(null, pstmt1, con);
	      }	
	}
	
	public List<MemberActivityVO> searchAll() throws DAOException{
	      Connection con = null;
	      PreparedStatement pstmt = null;
	      ResultSet res = null;
	      List<MemberActivityVO> resList = null;
	      try{
	         con = getConnection();
	         String sql = "select * from member_activity_tb";
	         pstmt = con.prepareStatement(sql);
	         res = pstmt.executeQuery();
	         resList = new ArrayList<MemberActivityVO>();
	         while(res.next()){
	            resList.add(new MemberActivityVO(res.getInt(1), res.getInt(2), res.getInt(3),res.getInt(4)));
	         }
	      }catch (SQLException e) {
	         throw new DAOException();
	      } finally {
	         super.closeDBObjects(res, pstmt, con);
	      }
	      return resList;
	  }
}
