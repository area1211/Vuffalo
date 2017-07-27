package dao;

import java.util.ArrayList;
import java.util.List;

import connection.DAOException;
import vo.ProfileVO;

public class ProfileListDAO {
	private static ProfileListDAO instance;
	private List<ProfileVO> profileVOList;
	private List<ProfileVO> addedProfileVOList;
	private List<ProfileVO> deletedProfileVOList;
	private List<ProfileVO> editedProfileVOList;
	static{
		instance = new ProfileListDAO();
	}
	public ProfileListDAO() {
		this.profileVOList = new ArrayList<ProfileVO>();
		this.addedProfileVOList = new ArrayList<ProfileVO>();
		this.deletedProfileVOList = new ArrayList<ProfileVO>();
		this.editedProfileVOList = new ArrayList<ProfileVO>();
	}
	
	public ProfileListDAO(List<ProfileVO> profileVOList, List<ProfileVO> addedProfileVOList,
			List<ProfileVO> deletedProfileVOList, List<ProfileVO> editedProfileVOList) {
		super();
		this.profileVOList = profileVOList;
		this.addedProfileVOList = addedProfileVOList;
		this.deletedProfileVOList = deletedProfileVOList;
		this.editedProfileVOList = editedProfileVOList;
	}
	public static ProfileListDAO getInstance(){
		instance.readFromDB();
		return instance;
	}
	public List<ProfileVO> getProfileVOList() {
		return profileVOList;
	}
	public void setProfileVOList(List<ProfileVO> profileVOList) {
		this.profileVOList = profileVOList;
	}
	public List<ProfileVO> getAddedProfileVOList() {
		return addedProfileVOList;
	}
	public void setAddedProfileVOList(List<ProfileVO> addedProfileVOList) {
		this.addedProfileVOList = addedProfileVOList;
	}
	public List<ProfileVO> getDeletedProfileVOList() {
		return deletedProfileVOList;
	}
	public void setDeletedProfileVOList(List<ProfileVO> deletedProfileVOList) {
		this.deletedProfileVOList = deletedProfileVOList;
	}
	public List<ProfileVO> getEditedProfileVOList() {
		return editedProfileVOList;
	}
	public void setEditedProfileVOList(List<ProfileVO> editedProfileVOList) {
		this.editedProfileVOList = editedProfileVOList;
	}
	
	@Override
	public String toString() {
		return "ProfileListDAO [profileVOList=" + profileVOList + ", addedProfileVOList=" + addedProfileVOList
				+ ", deletedProfileVOList=" + deletedProfileVOList + ", editedProfileVOList=" + editedProfileVOList
				+ "]";
	}

	public void addProfileVO(ProfileVO profileVO){
		if(profileVO == null){
			return;
		}
		profileVOList.add(profileVO);
		addedProfileVOList.add(profileVO);
	}
	public void addProfileVO(int memberNum, int gender, int age, String country, String motherTongue, String interestLanguage, String introduce, byte fileFlag, byte openRange, String fileUrl, int hits){
		addProfileVO(new ProfileVO(memberNum, gender, age, country, motherTongue, interestLanguage, introduce, fileFlag, openRange, fileUrl, hits));
	}
	public ProfileVO searchProfileVO(List<ProfileVO> tempList, int memberNum){
		if(tempList == null)
			return null;
		for(ProfileVO temp : tempList){
			if(temp.getMemberNum()==memberNum){
				return temp;
			}
		}
		return null;
	}
	public ProfileVO searchProfileVO(int memberNum){
		for(ProfileVO temp : profileVOList){
			if(temp.getMemberNum() == memberNum){
				return temp;
			}
		}
		return null;
	}
	public List<ProfileVO> searchProfileVO(byte fileFlag, int startAge, int endAge, String country, String motherTongue){
		List<ProfileVO> returnList = new ArrayList<ProfileVO>();
		for(ProfileVO temp : profileVOList){
			if(temp.getFileFlag() == fileFlag && (temp.getAge()>=startAge && temp.getAge()<=endAge) && temp.getCountry() == country && temp.getMotherTongue().equals(motherTongue)){
				returnList.add(temp);
			}
		}
		if(returnList.size() == 0){
			return null;
		}
		return returnList;
	}
	public boolean deleteProfileVO(int memberNum){
		ProfileVO temp = searchProfileVO(memberNum);
		if(temp == null){
			return false;
		}
		if(!(profileVOList.remove(temp))){
			return false;
		}
		deletedProfileVOList.add(temp);
		return true;
	}
	public boolean deleteProfileVO(ProfileVO profileVO){
		if(profileVO == null){
			return false;
		}
		if(!(profileVOList.remove(profileVO))){
			return false;
		}
		deletedProfileVOList.add(profileVO);
		return true;
	}
	public boolean editProfileVO(ProfileVO profileVO){
		ProfileVO temp = searchProfileVO(profileVO.getMemberNum());
		if(temp == null){
			System.out.println("ddd");
			return false;
		}
		temp.setGender(profileVO.getGender());
		temp.setAge(profileVO.getAge());
		temp.setCountry(profileVO.getCountry());
		temp.setMotherTongue(profileVO.getMotherTongue());
		temp.setInterestLanguage(profileVO.getInterestLanguage());
		temp.setIntroduce(profileVO.getIntroduce());
		temp.setFileFlag(profileVO.getFileFlag());
		temp.setOpenRange(profileVO.getOpenRange());
		temp.setFileUrl(profileVO.getFileUrl());
		editedProfileVOList.add(temp);
		ProfileConDAO conDAO = ProfileConDAO.getInstance();
		conDAO.editList(editedProfileVOList);
		return true;
	}
	public boolean editProfileVO(int memberNum, int gender, int age, String country, String motherTongue, String interestLanguage, String introduce, byte fileFlag, byte openRange, String fileUrl, int hits){
		return editProfileVO(new ProfileVO(memberNum, gender, age, country, motherTongue, interestLanguage, introduce, fileFlag, openRange, fileUrl, hits));
	}
	public boolean editProfileVO(int memberNum){
		ProfileVO temp = searchProfileVO(memberNum);
		if(temp == null){
			return false;
		}
		temp.setHit(temp.getHit()+1);
		editedProfileVOList.add(temp);
		return true;
	}
	public boolean editProfileVO(int memberNum, byte fileFlag, String fileUrl){
		ProfileVO temp = searchProfileVO(memberNum);
		if(temp == null){
			return false;
		}
		temp.setFileFlag(fileFlag);
		temp.setFileUrl(fileUrl);
		editedProfileVOList.add(temp);
		return true;
	}
	public boolean editProfileVO(int memberNum, String introduce){
		ProfileVO temp = searchProfileVO(memberNum);
		if(temp == null){
			return false;
		}
		temp.setIntroduce(introduce);
		editedProfileVOList.add(temp);
		return true;
	}
	public void readFromDB(){
		addedProfileVOList = new ArrayList<ProfileVO>();
		deletedProfileVOList = new ArrayList<ProfileVO>();
		editedProfileVOList = new ArrayList<ProfileVO>();
		try {
			profileVOList = ProfileConDAO.getInstance().searchAll();
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void writeToDB(){
		
			ProfileConDAO.getInstance().addList(addedProfileVOList);
			ProfileConDAO.getInstance().editList(editedProfileVOList);
			ProfileConDAO.getInstance().deleteList(deletedProfileVOList);
			addedProfileVOList = new ArrayList<ProfileVO>();
			deletedProfileVOList = new ArrayList<ProfileVO>();
			editedProfileVOList = new ArrayList<ProfileVO>();
		
	}
}
