package dao;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import connection.DAOException;
import vo.ProfileViewVO;

public class ProfileViewListDAO {
	private static ProfileViewListDAO instance;
	private List<ProfileViewVO> profileViewVOList;
	private List<ProfileViewVO> addedProfileViewVOList;
	private List<ProfileViewVO> deletedProfileViewVOList;
	private List<ProfileViewVO> editedProfileViewVOList;
	
	static{
		instance = new ProfileViewListDAO();
	}
	
	public static ProfileViewListDAO getInstance(){
		instance.init();
		return instance;
	}

	public ProfileViewListDAO() {
		profileViewVOList = new ArrayList<ProfileViewVO>();
		this.addedProfileViewVOList = new ArrayList<ProfileViewVO>();
		this.deletedProfileViewVOList = new ArrayList<ProfileViewVO>();
		this.editedProfileViewVOList = new ArrayList<ProfileViewVO>();
	}
	
	public void init(){
		ProfileViewConDAO profileViewConDAO = ProfileViewConDAO.getInstance();
		try{
		this.profileViewVOList = profileViewConDAO.searchAll();
		} catch(DAOException e){
			e.printStackTrace();
		}
	}
	
	public ProfileViewVO searchProfileViewVO(int num){
		for(ProfileViewVO temp : profileViewVOList){
			if(temp.getNum()==num)
				return temp;
		}
		return null;
	}

	public List<ProfileViewVO> searchAllProfileViewVO(){
		return this.profileViewVOList;
		//		List<ProfileViewVO> list = new LinkedList<ProfileViewVO>();
//		for(ProfileViewVO temp : profileViewVOList){
//			
//		}
	}
}
