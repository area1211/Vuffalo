package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.BaseDAO;
import connection.DAOException;
import vo.ProfileVO;

public class ProfileConDAO extends BaseDAO{
	private static ProfileConDAO instance;
	
	static{
		instance = new ProfileConDAO();
	}
	
	private ProfileConDAO(){
		
	}
	
	public static ProfileConDAO getInstance(){
		return instance;
	}
	public void deleteList(List<ProfileVO> deleteList){
		Connection con = null;
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt3 = null;
		try{
			con = getConnection();
			String sql1 = "delete from profile_tb where pfile_mem_num = ?";
			String sql2 = "delete from profile_image_tb where proimg_mem_num = ?";
			String sql3 = "delete from profile_hits_tb where prohit_mem_num = ?";
			pstmt1 = con.prepareStatement(sql1);
			pstmt2 = con.prepareStatement(sql2);
			pstmt3 = con.prepareStatement(sql3);
			for(ProfileVO temp : deleteList){
				pstmt1.setInt(1, temp.getMemberNum());
				pstmt2.setInt(1, temp.getMemberNum());
				pstmt3.setInt(1, temp.getMemberNum());
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
	public void editList(List<ProfileVO> editList){
		Connection con = null;
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt3 = null;
		try{
			con = getConnection();
			String sql1 = "update profile_tb set pfile_gender = ?, pfile_age = ?,"
					+ "pfile_nationality = ?, pfile_mother_tongue=?, pfile_interest_language=?,"
					+ "pfile_self_intro = ?, pfile_file_flag=?, pfile_open_range=? where pfile_mem_num = ?";
			String sql2 = "update profile_image_tb set proimg_file_url = ? where proimg_mem_num = ?";
			String sql3 = "update profile_hits_tb set prohit_hit = ? where prohit_mem_num = ?";
			pstmt1 = con.prepareStatement(sql1);
			pstmt2 = con.prepareStatement(sql2);
			pstmt3 = con.prepareStatement(sql3);
			for(ProfileVO temp : editList){
				pstmt1.setInt(1, temp.getGender());
				pstmt1.setInt(2,  temp.getAge());
				pstmt1.setString(3, temp.getCountry());
				pstmt1.setString(4, temp.getMotherTongue());
				pstmt1.setString(5,  temp.getInterestLanguage());
				pstmt1.setString(6, temp.getIntroduce());
				pstmt1.setInt(7, temp.getFileFlag());
				pstmt1.setInt(8, temp.getOpenRange());
				pstmt1.setInt(9,  temp.getMemberNum());
				if(pstmt1.executeUpdate()>0){
					System.out.println("1 성공");
				}else{
					System.out.println("1 실패");
				}
				pstmt2.setString(1, temp.getFileUrl());
				pstmt2.setInt(2,  temp.getMemberNum());
				pstmt2.executeUpdate();
				if(pstmt2.executeUpdate()>0){
					System.out.println("2 성공");
				} else{
					System.out.println("2 실패");
				}
				pstmt3.setInt(1, temp.getHit());
				pstmt3.setInt(2,  temp.getMemberNum());
				pstmt3.executeUpdate();
				if(pstmt3.executeUpdate()>0){
					System.out.println("3 성공");
				} else{
					System.out.println("3 실패");
				}
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
	public void addList(List<ProfileVO> inputList){
		Connection con = null;
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt3 = null;
		try{
			con = getConnection();
			String sql1 = "insert into profile_tb values(?,?,?,?,?,?,?,?,?)";
			String sql2 = "insert into profile_image_tb values(?,?)";
			String sql3 = "insert into profile_hits_tb values(?,?)";
			pstmt1 = con.prepareStatement(sql1);
			pstmt2 = con.prepareStatement(sql2);
			pstmt3 = con.prepareStatement(sql3);
			for(ProfileVO temp : inputList){
				pstmt1.setInt(1, temp.getMemberNum());
				pstmt1.setInt(2,  temp.getGender());
				pstmt1.setInt(3,  temp.getAge());
				pstmt1.setString(4, temp.getCountry());
				pstmt1.setString(5, temp.getMotherTongue());
				pstmt1.setString(6, temp.getInterestLanguage());
				pstmt1.setString(7,  temp.getIntroduce());
				pstmt1.setInt(8, temp.getFileFlag());
				pstmt1.setInt(9, temp.getOpenRange());
				pstmt2.setInt(1, temp.getMemberNum());
				pstmt2.setString(2, temp.getFileUrl());
				pstmt3.setInt(1,  temp.getMemberNum());
				pstmt3.setInt(2,  temp.getHit());
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
	public List<ProfileVO> searchAll() throws DAOException{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet res = null;
		List<ProfileVO> resList = null;
		try{
			con = getConnection();
			String sql = "select pfile_mem_num, pfile_gender, pfile_age, pfile_nationality, pfile_mother_tongue, pfile_interest_language, pfile_self_intro, pfile_file_flag, pfile_open_range, proimg_file_url, prohit_hit from profile_tb left outer join profile_image_tb on profile_tb.pfile_mem_num = profile_image_tb.proimg_mem_num left outer join profile_hits_tb on profile_hits_tb.prohit_mem_num = profile_tb.pfile_mem_num";
			pstmt = con.prepareStatement(sql);
			res = pstmt.executeQuery();
			resList = new ArrayList<ProfileVO>();
			while(res.next()){
				resList.add(new ProfileVO(res.getInt(1), res.getInt(2), res.getInt(3), res.getString(4), res.getString(5), res.getString(6), res.getString(7), res.getByte(8), res.getByte(9), res.getString(10), res.getInt(11)));
			}
		}catch (SQLException e) {
			throw new DAOException();
		} finally {
			super.closeDBObjects(res, pstmt, con);
		}
		return resList;
	}
	
}
