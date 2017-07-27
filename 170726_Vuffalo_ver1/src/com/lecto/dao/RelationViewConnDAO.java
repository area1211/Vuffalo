package com.lecto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lecto.vo.RelationViewVO;

import connection.BaseDAO;
import connection.DAOException;

public class RelationViewConnDAO extends BaseDAO{
	private static RelationViewConnDAO instance;
	
	static {
		instance = new RelationViewConnDAO();
	}
	
	private RelationViewConnDAO(){
		
	}
	
	public static RelationViewConnDAO getInstance(){
		return instance;
	}
	
	public List<RelationViewVO> searchRelationViewVO(int sender, int relation){
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		List<RelationViewVO> list = new ArrayList<RelationViewVO>();

		try {
			conn = getConnection();
			
			stmt = conn.prepareStatement("select * from relation_view where sender_num = ? and request = ?;");
			stmt.setInt(1, sender);
			stmt.setInt(2, relation);
			rs = stmt.executeQuery();
			
			while(rs.next()){
				list.add(new RelationViewVO(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(5)));
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
		
		return list;
	}
	
	public List<RelationViewVO> readFromDB(){
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		List<RelationViewVO> list = new ArrayList<RelationViewVO>();

		try {
			conn = getConnection();			
			stmt = conn.prepareStatement("select * from relation_view;");
			rs = stmt.executeQuery();
			
			while(rs.next()){
				list.add(new RelationViewVO(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(5)));
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
		
		return list;
	}
	public boolean friendInsert(List<RelationViewVO> list){
		Connection conn = null;
		PreparedStatement stmt = null;
		int flag=0;
		boolean result=true;
		try {
			conn = getConnection();			
			conn.setAutoCommit(false);
			
			for(RelationViewVO vo:list){
				stmt = conn.prepareStatement("insert into friend_tb"
						+ "(frnd_request_type, frnd_sender, frnd,receiver, frnd_date)"
						+ "values (?, ?, ?, ?)");
				stmt.setByte(1, (byte)vo.getRelation());
				stmt.setInt(2, vo.getSender());
				stmt.setInt(3, vo.getReceiver());
				stmt.setString(4, vo.getDate());
				flag = stmt.executeUpdate();
				
				if(flag==0){
					result=false;
					break;
				}
			}
			
			if(result==true) conn.commit();
			else conn.rollback();
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			if(conn != null){
				try {
					conn.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		} finally {
			closeDBObjects(null, stmt, conn);
		}
		
		try {
			conn.setAutoCommit(true);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	public boolean relationUpdate(List<RelationViewVO> list1, List<RelationViewVO> list2, List<RelationViewVO> list3){
		Connection conn = null;
		PreparedStatement stmt = null;
		int flag=0;
		boolean result=true;
		try {
			conn = getConnection();			
			conn.setAutoCommit(false);
			System.out.println(list1);
			result = this.delete(conn, list1);
			
			System.out.println("DB삭제결과1:"+result);
			if(result==false) {
				conn.rollback();
				return result;
			}
			System.out.println(list2);
			result = this.insert(conn, list2);
			
			System.out.println("DB삭제결과2:"+result);
			if(result==false) {
				conn.rollback();
				return result;
			}
			System.out.println(list3);
			result = this.insert(conn, list3);
			
			System.out.println("DB삭제결과3:"+result);
			if(result==true) conn.commit();
			else conn.rollback();
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result = false;
			if(conn != null){
				try {
					conn.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		} finally {
			try {
				conn.setAutoCommit(true);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			closeDBObjects(null, stmt, conn);
		}
		
		
		
		return result;
	}
	
	public boolean insert(Connection conn, List<RelationViewVO> list) throws SQLException{
		PreparedStatement stmt = null;
		int flag=0;
		boolean result=true;
		
		for(RelationViewVO vo:list){
			stmt = conn.prepareStatement("insert into friend_tb"
					+ "(frnd_request_type, frnd_sender, frnd_receiver, frnd_date)"
					+ "values (?, ?, ?, ?)");
			stmt.setByte(1, (byte)vo.getRelation());
			stmt.setInt(2, vo.getSender());
			stmt.setInt(3, vo.getReceiver());
			stmt.setString(4, vo.getDate());
			flag = stmt.executeUpdate();
			if(flag==0){
				result=false;
				break;
			}
		}
		
		return result;
	}
	public boolean delete(Connection conn, List<RelationViewVO> list) throws SQLException{
		PreparedStatement stmt = null;
		int flag=0;
		boolean result=true;
		
		for(RelationViewVO vo:list){
			stmt = conn.prepareStatement("delete from friend_tb where frnd_request_type = ? and frnd_sender = ? and frnd_receiver = ?;");
			stmt.setByte(1, (byte)vo.getRelation());
			stmt.setInt(2, vo.getSender());
			stmt.setInt(3, vo.getReceiver());
			flag = stmt.executeUpdate();
			
			if(flag==0){
				result=false;
				break;
			}
		}
		
		return result;
	}
}
