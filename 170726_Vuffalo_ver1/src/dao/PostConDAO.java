package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.BaseDAO;
import connection.DAOException;
import vo.PostVO;

public class PostConDAO extends BaseDAO{
private static PostConDAO instance;
	
	static{
		instance = new PostConDAO();
	}
	private PostConDAO(){
	}
	public static PostConDAO getInstacne(){
		return instance;
	}
	public List<PostVO> searchAll() throws DAOException {
		Connection con = null;
		PreparedStatement psmt = null;
		ResultSet res = null;
		List<PostVO> resList = null;
		try {
			con = getConnection();
			String sql = "select post_num, post_board_num, post_title,post_content,post_file_flag,post_date,post_isdelete,post_mem_num,";
			sql = sql + "(select mem_nickname from member_tb where mem_num = post_mem_num) as nickname,";
			sql = sql + "(select poimg_file_url from post_image_tb where poimg_post_num = post_num and poimg_board_num = post_board_num) as file_url,";
			sql = sql + "(select pohit_hit from post_hits_tb where pohit_post_num = post_num and pohit_board_num = post_board_num) as hit";
			sql = sql + " from post_tb";
			//dao들이 부족해서 서브쿼리문으로 날렸다.
			psmt = con.prepareStatement(sql);
			res = psmt.executeQuery();
			resList = new ArrayList<PostVO>();
			while (res.next()){
				resList.add(new PostVO(res.getInt(1),res.getInt(2), res.getString(3),res.getString(4),res.getByte(5), res.getString(6),
						res.getByte(7),res.getInt(8),res.getString(9),res.getString(10),res.getInt(11)));
			}
		} catch (SQLException e) {
			throw new DAOException();
		} finally {
			super.closeDBObjects(res, psmt, con);
		}
		return resList;
	}
	public void addList(List<PostVO> inputList){
		Connection con = null;
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt3 = null;
		try{
			con = getConnection();
			String sql1 = "insert into post_tb values(?,?,?,?,?,?,?,?)";
			String sql2 = "insert into post_image_tb values(?,?,?)";
			String sql3 = "insert into post_hits_tb values(?,?,?)";
			pstmt1 = con.prepareStatement(sql1);
			pstmt2 = con.prepareStatement(sql2);
			pstmt3 = con.prepareStatement(sql3);
			for(PostVO temp : inputList){
				pstmt1.setInt(1, temp.getPostNum());
				pstmt1.setInt(2,  temp.getBoardNum());
				pstmt1.setInt(3,  temp.getMemberNum());
				pstmt1.setString(4, temp.getTitle());
				pstmt1.setString(5, temp.getText());
				pstmt1.setByte(6, temp.getImgFlag());
				pstmt1.setString(7,  temp.getWriteDate());
				pstmt1.setByte(8, temp.getDeleteFlag());
				
				pstmt2.setInt(1, temp.getPostNum());
				pstmt2.setInt(2, temp.getBoardNum());
				pstmt2.setString(3, temp.getFileUrl());
				
				pstmt3.setInt(1, temp.getPostNum());
				pstmt3.setInt(2, temp.getBoardNum());
				pstmt3.setInt(3, temp.getHit());
				
				pstmt1.executeUpdate();
				pstmt2.executeUpdate();
				pstmt3.executeUpdate();
			}
		}
		catch (SQLException e) {
			
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		finally {
			super.closeDBObjects(null, pstmt1, con);
			super.closeDBObjects(null, pstmt2, null);
			super.closeDBObjects(null, pstmt3, null);
		}
	}
	public void deleteList(List<PostVO> deleteList){
		Connection con = null;
		PreparedStatement pstmt1 = null;
		try{
			con = getConnection();
			String sql1 = "delete from post_tb where post_num = ? and post_board_num = ?";
			pstmt1 = con.prepareStatement(sql1);
	
			for(PostVO temp : deleteList){
				pstmt1.setInt(1, temp.getPostNum());
				pstmt1.setInt(2, temp.getBoardNum());
				pstmt1.executeUpdate();
			}
		}catch (SQLException e) {
			
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		finally {
			super.closeDBObjects(null, pstmt1, con);
		}
	}
	
	public void editList(List<PostVO> editList){
		Connection con = null;
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt3 = null;
		try{
			con = getConnection();
			
			String sql1 = "update post_tb set post_board_num = ?, post_title = ?, post_content = ?,"
					+ " post_file_flag=?, post_date=?, post_isdelete = ? where post_num = ? and post_board_num = ?"; 
			String sql2 = "update post_hits_tb set pohit_hit = ? where pohit_post_num = ? and pohit_board_num = ?;";
			String sql3 = "update post_image_tb set poimg_file_url = ? where poimg_post_num = ? and poimg_board_num = ?;";
			pstmt1 = con.prepareStatement(sql1);
			pstmt2 = con.prepareStatement(sql2);
			pstmt3 = con.prepareStatement(sql3);
			for(PostVO temp : editList){
				pstmt1.setInt(1, temp.getBoardNum());
				pstmt1.setString(2,  temp.getTitle());
				pstmt1.setString(3, temp.getText());
				pstmt1.setByte(4, temp.getImgFlag());
				pstmt1.setString(5,  temp.getWriteDate());
				pstmt1.setByte(6, temp.getDeleteFlag());
				pstmt1.setInt(7, temp.getPostNum());
				pstmt1.setInt(8, temp.getBoardNum());
				
				pstmt2.setInt(1, temp.getHit());
				pstmt2.setInt(1, temp.getPostNum());
				pstmt2.setInt(2, temp.getBoardNum());
				
				pstmt3.setString(1, temp.getFileUrl());
				pstmt3.setInt(2, temp.getPostNum());
				pstmt3.setInt(3, temp.getBoardNum());
				
				pstmt1.executeUpdate();
				pstmt2.executeUpdate();
				pstmt3.executeUpdate();
			}
		}catch (SQLException e) {
			
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		finally {
			super.closeDBObjects(null, pstmt1, con);
			super.closeDBObjects(null, pstmt2, null);
			super.closeDBObjects(null, pstmt3, null);
		}
	}
	public boolean editdeleteFlag(int postNum, int boardNum, byte flag) {
		Connection con = null;
		PreparedStatement pstmt1 = null;

		try {
			con = getConnection();

			String sql1 = "update post_tb set post_isdelete = ? where post_num = ?";
			pstmt1 = con.prepareStatement(sql1);
			
			pstmt1.setByte(1, flag);
			pstmt1.setInt(2, postNum);
			//pstmt1.setInt(3, boardNum);
			
			pstmt1.executeUpdate();
			return true;

		} catch (SQLException e) {

		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			super.closeDBObjects(null, pstmt1, con);
		}return false;
	}
}
