package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.BaseDAO;
import connection.DAOException;
import vo.MemberVO;

public class MemberConDAO extends BaseDAO {
	private static MemberConDAO	instance;
	
	static{
		instance = new MemberConDAO();
	}
	
	private MemberConDAO(){
		
	}
	
	public static MemberConDAO getInstance(){
		return instance;
	}
	public void editList(List<MemberVO> editList){
	      Connection con = null;
	      PreparedStatement pstmt1 = null;
//	      PreparedStatement pstmt2 = null;
//	      PreparedStatement pstmt3 = null;
	      try{
	         con = getConnection();
	         String sql1 = "update member_tb set mem_nickname = ?, mem_pwd = ?,"
	               + "mem_email = ?, mem_grade=?, mem_state=? where mem_num = ?";
//	         String sql2 = "update profile_image_tb set proimg_file_url = ? where proimg_mem_num = ?";
//	         String sql3 = "update profile_hits_tb set prohit_hit = ? where prohit_mem_num = ?";
	         pstmt1 = con.prepareStatement(sql1);
//	         pstmt2 = con.prepareStatement(sql2);
//	         pstmt3 = con.prepareStatement(sql3);
	         for(MemberVO temp : editList){
	            pstmt1.setString(1, temp.getNickName());
	            pstmt1.setString(2,  temp.getPassword());
	            pstmt1.setString(3, temp.getEmail());
	            pstmt1.setInt(4, temp.getGrade());
	            pstmt1.setInt(5,  temp.getState());
	            pstmt1.setInt(6,  temp.getMemberNum());
//	            pstmt2.setString(1, temp.getFileUrl());
//	            pstmt2.setInt(2,  temp.getMemberNum());
//	            pstmt3.setInt(1, temp.getHit());
//	            pstmt3.setInt(2,  temp.getMemberNum());
	            pstmt1.executeUpdate();
//	            pstmt2.executeUpdate();
//	            pstmt3.executeUpdate();
	         }
	      }catch (SQLException e) {
	         
	      } catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	      finally {
	         super.closeDBObjects(null, pstmt1, con);
//	         super.closeDBObjects(null, pstmt2, null);
//	         super.closeDBObjects(null, pstmt3, null);
	      }
	   }
	
	public void deleteList(List<MemberVO> deleteList){
	      Connection con = null;
	      PreparedStatement pstmt1 = null;
//	      PreparedStatement pstmt2 = null;
//	      PreparedStatement pstmt3 = null;
	      try{
	         con = getConnection();
	         String sql1 = "delete from member_tb where mem_num = ?";
//	         String sql2 = "delete from profile_image_tb where proimg_mem_num = ?";
//	         String sql3 = "delete from profile_hits_tb where prohit_mem_num = ?";
	         pstmt1 = con.prepareStatement(sql1);
//	         pstmt2 = con.prepareStatement(sql2);
//	         pstmt3 = con.prepareStatement(sql3);
	         for(MemberVO temp : deleteList){
	            pstmt1.setInt(1, temp.getMemberNum());
//	            pstmt2.setInt(1, temp.getMemberNum());
//	            pstmt3.setInt(1, temp.getMemberNum());
	            pstmt1.executeUpdate();
//	            pstmt2.executeUpdate();
//	            pstmt3.executeUpdate();
	         }
	      }catch (SQLException e) {
	         
	      } catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	      finally {
	         super.closeDBObjects(null, pstmt1, con);
//	         super.closeDBObjects(null, pstmt2, null);
//	         super.closeDBObjects(null, pstmt3, null);
	      }
	   }
	 public void addList(List<MemberVO> inputList){
	      Connection con = null;
	      PreparedStatement pstmt1 = null;
//	      PreparedStatement pstmt2 = null;
//	      PreparedStatement pstmt3 = null;
//	      PreparedStatement pstmt4 = null;
//	      PreparedStatement pstmt5 = null;
	      try{
	         con = getConnection();
	         String sql1 = "insert into member_tb values(?,?,?,?,?,?,?,?)";
//	         String sql2 = "insert into daily_profile_hit_tb values(?,?)";
//	         String sql3 = "insert into daily_active_tb values(?,?)";
//	         String sql4 = "insert into member_activity_tb values(?,?,?,?)";
//	         String sql5 = "insert into member_visitation_tb values(?, ?, ?, ?)";
	         pstmt1 = con.prepareStatement(sql1);
//	         pstmt2 = con.prepareStatement(sql2);
//	         pstmt3 = con.prepareStatement(sql3);
//	         pstmt4 = con.prepareStatement(sql4);
//	         pstmt5 = con.prepareStatement(sql5);
	         for(MemberVO temp : inputList){
	            pstmt1.setInt(1, temp.getMemberNum());
	            pstmt1.setString(2,  temp.getMemberId());
	            pstmt1.setString(3,  temp.getNickName());
	            pstmt1.setString(4, temp.getPassword());
	            pstmt1.setString(5, temp.getEmail());
	            pstmt1.setString(6, temp.getJoinDate());
	            pstmt1.setInt(7,  temp.getGrade());
	            pstmt1.setInt(8, temp.getState());
	            pstmt1.executeUpdate();
	            
//	            pstmt2.setInt(1, temp.getMemberNum());
//	            pstmt2.setInt(2,  0);
//	            pstmt3.setInt(1,  temp.getMemberNum());
//	            pstmt3.setInt(2,  0);
//	            pstmt4.setInt(1,  temp.getMemberNum());
//	            pstmt4.setInt(2,  0);
//	            Calendar calendar = Calendar.getInstance();
//	            java.util.Date date = calendar.getTime();
//	            String today = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date));
//	            pstmt4.setString(3,  today);
//	            pstmt4.setString(4,  today);
	            
//	            pstmt1.setInt(9, temp.getOpenRange());
//	            pstmt2.setInt(1, temp.getMemberNum());
//	            pstmt2.setString(2, temp.getFileUrl());
//	            pstmt3.setInt(1,  temp.getMemberNum());
//	            pstmt3.setInt(2,  temp.getHit());
	            
//	            pstmt2.executeUpdate();
//	            pstmt3.executeUpdate();
//	            pstmt4.executeUpdate();
	         }
	      }
	      catch (SQLException e) {
	         
	      } catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	      finally {
	         super.closeDBObjects(null, pstmt1, con);
//	         super.closeDBObjects(null, pstmt2, null);
//	         super.closeDBObjects(null, pstmt3, null);
	      }
	   }
	 public List<MemberVO> searchAll() throws DAOException{
	      Connection con = null;
	      PreparedStatement pstmt = null;
	      ResultSet res = null;
	      List<MemberVO> resList = null;
	      try{
	         con = getConnection();
	         String sql = "select mem_num, mem_id, mem_nickname, mem_pwd, mem_email, mem_grade, mact_active_point, mem_join_date,  mem_state from member_tb left outer join member_activity_tb on member_tb.mem_num = member_activity_tb.mact_mem_num";
	         pstmt = con.prepareStatement(sql);
	         res = pstmt.executeQuery();
	         resList = new ArrayList<MemberVO>();
	         while(res.next()){
	            resList.add(new MemberVO(res.getInt(1), res.getString(2), res.getString(3), 
	            		res.getString(4), res.getString(5), res.getByte(6), res.getInt(7), 
	            		res.getString(8), res.getByte(9)));
	            //System.out.println(resList);
	         }
	      }catch (SQLException e) {
	         throw new DAOException();
	      } finally {
	         super.closeDBObjects(res, pstmt, con);
	      }
	      return resList;
	   }
}
