package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.BaseDAO;
import connection.DAOException;
import vo.BoardVO;

public class BoardConDAO extends BaseDAO{
	private static BoardConDAO instance;
	
	static{
		instance=new BoardConDAO();
	}
	
	private BoardConDAO(){
		
	}
	
	public static BoardConDAO getInstance(){
		return instance;
	}
	
	public void deleteList(List<BoardVO> deleteList){
		Connection con = null;
	      PreparedStatement pstmt1 = null;
	      try{
	         con = getConnection();
	         String sql1 = "delete from board_tb where board_num=?";
	         pstmt1 = con.prepareStatement(sql1);
	         for(BoardVO temp : deleteList){
	            pstmt1.setInt(1, temp.getBoardNum());
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
	public void editList(List<BoardVO> editList){
		Connection con = null;
	      PreparedStatement pstmt1 = null;
	      try{
	         con = getConnection();
	         String sql1 = "update board_tb set board_name=?,board_description=?,board_write_privilege=?,"
	         		+ "board_comment_privilege=?,board_open_range=? where board_num=?";
	         pstmt1 = con.prepareStatement(sql1);
	         for(BoardVO temp : editList){
	            pstmt1.setString(1, temp.getBoardName());
	            pstmt1.setString(2, temp.getDescription());
	            pstmt1.setInt(3, temp.getWritePermission());
	            pstmt1.setInt(4, temp.getCommentWritePermission());
	            pstmt1.setInt(5,  temp.getOpenRange());
	            pstmt1.setInt(6,  temp.getBoardNum());
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
	public void addList(List<BoardVO> addedList){
		Connection con = null;
	      PreparedStatement pstmt1 = null;
	      try{
	         con = getConnection();
	         String sql1 = "insert into board_tb values(?,?,?,?,?,?)";
	         pstmt1 = con.prepareStatement(sql1);
	         for(BoardVO temp : addedList){
	            pstmt1.setInt(1, temp.getBoardNum());
	            pstmt1.setString(2, temp.getBoardName());
	            pstmt1.setString(3, temp.getDescription());
	            pstmt1.setInt(4, temp.getWritePermission());
	            pstmt1.setInt(5,temp.getCommentWritePermission());
	            pstmt1.setInt(6,temp.getOpenRange());
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
	public List<BoardVO> searchAll() throws DAOException{
		Connection con = null;
	    PreparedStatement pstmt = null;
	    ResultSet res = null;
	    List<BoardVO> resList = null;
	    try{
	         con = this.getConnection();
	         String sql = "select * from board_tb";
	         pstmt = con.prepareStatement(sql);
	         res = pstmt.executeQuery();
	         resList = new ArrayList<BoardVO>();
	         while(res.next()){
	            resList.add(new BoardVO(
	            		res.getInt(1),
	            		res.getString(2), 
	            		res.getString(3), 
	            		res.getByte(4), 
	            		res.getByte(5), 
	            		res.getByte(6)));
	         }
	         
	         System.out.println(resList);
	      }catch (SQLException e) {
	         throw new DAOException();
	      } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
	         super.closeDBObjects(res, pstmt, con);
	      }
	      return resList;
	  }
}

