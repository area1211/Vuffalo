package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.BaseDAO;
import connection.DAOException;
import vo.MailVO;

public class MailConDAO extends BaseDAO{
	private static MailConDAO instance;
	static{
		instance = new MailConDAO();
	}
	private MailConDAO(){
		
	}
	public static MailConDAO getInstance(){
		return instance;
	}
	public List<MailVO> searchAll() throws DAOException{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet res = null;
		List<MailVO> resList = null;
		try{
			con = getConnection();
			String sql = "select mail_num, mail_title, mail_content, mail_send_date, mail_read_date, mail_file_flag,"
					+ " mimg_file_url, mail_sender, mail_receiver from mail_tb left outer join mail_image_tb"
					+ " on mail_tb.mail_num = mail_image_tb.mimg_mail_num";
			pstmt = con.prepareStatement(sql);
			res = pstmt.executeQuery();
			resList = new ArrayList<MailVO>();
			while(res.next()){
				resList.add(new MailVO(res.getInt(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getByte(6), res.getString(7),res.getInt(8),res.getInt(9)));
			}
		}catch (SQLException e) {
			throw new DAOException();
		} finally {
			super.closeDBObjects(res, pstmt, con);
		}
		return resList;
	}
	public void addList(List<MailVO> inputList){
		Connection con = null;
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		try{
			con = getConnection();
			String sql1 = "insert into mail_tb values(?,?,?,?,?,?,?,?)";
			String sql2 = "insert into mail_image_tb values(?,?)";
			pstmt1 = con.prepareStatement(sql1);
			pstmt2 = con.prepareStatement(sql2);
			for(MailVO temp : inputList){
				pstmt1.setInt(1, temp.getMailNum());
				pstmt1.setInt(2,  temp.getSender());
				pstmt1.setInt(3,  temp.getReceiver());
				pstmt1.setString(4,  temp.getTitle());
				pstmt1.setString(5,  temp.getDescription());
				pstmt1.setByte(6,  temp.getImgFlag());
				pstmt1.setString(7,  temp.getSendDate());
				pstmt1.setString(8,  temp.getReadDate());
				pstmt2.setInt(1,  temp.getMailNum());
				pstmt2.setString(2,  temp.getFileUrl());
				pstmt1.executeUpdate();
				pstmt2.executeUpdate();
			}
		}catch (SQLException e) {
			
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		finally {
			super.closeDBObjects(null, pstmt1, con);
			super.closeDBObjects(null, pstmt2, null);
		}
	}
	public void deleteList(List<MailVO> deleteList){
		Connection con = null;
		PreparedStatement pstmt1 = null;
		try{
			con = getConnection();
			String sql1 = "delete from mail_tb where mail_num = ?";
			pstmt1 = con.prepareStatement(sql1);
			
			for(MailVO temp : deleteList){
				pstmt1.setInt(1, temp.getMailNum());
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
	public void editList(List<MailVO> editList){
		Connection con = null;
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		try{
			con = getConnection();
			
			String sql1 = "update mail_tb set mail_sender = ?, mail_receiver = ?, mail_title = ?, mail_content = ? ,"
					+ "mail_file_flag = ?, mail_send_date = ?, mail_read_date = ? where mail_num = ?";
			String sql2 = "update mail_image_tb set mimg_file_url = ? where mimg_mail_num = ?";
			pstmt1 = con.prepareStatement(sql1);
			pstmt2 = con.prepareStatement(sql2);
			for(MailVO temp : editList){
				pstmt1.setInt(1, temp.getSender());
				pstmt1.setInt(2, temp.getReceiver());
				pstmt1.setString(3, temp.getTitle());
				pstmt1.setString(4, temp.getDescription());
				pstmt1.setByte(5,temp.getImgFlag());
				pstmt1.setString(6, temp.getSendDate());
				pstmt1.setString(7, temp.getReadDate());
				pstmt1.setInt(8, temp.getMailNum());
				pstmt2.setString(1, temp.getFileUrl());
				pstmt2.setInt(2, temp.getMailNum());
				
				pstmt1.executeUpdate();
				pstmt2.executeUpdate();
			}
		}catch (SQLException e) {
			
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		finally {
			super.closeDBObjects(null, pstmt1, con);
			super.closeDBObjects(null, pstmt2, null);
		}
	}
}
