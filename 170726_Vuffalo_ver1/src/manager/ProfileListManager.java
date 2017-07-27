package manager;

import java.util.LinkedList;
import java.util.List;

import dao.ProfileViewListDAO;
import vo.ProfileViewVO;

public class ProfileListManager {
	public List<ProfileViewVO> showProfileList(){
		ProfileViewListDAO viewDAO = ProfileViewListDAO.getInstance();
		List<ProfileViewVO> list = viewDAO.searchAllProfileViewVO();
		//String[] stringArray[](){
		return list; 
	}
	
	public List<ProfileViewVO> selectBoxList(List<ProfileViewVO> list, String fileFlag){
		List<ProfileViewVO> returnList = new LinkedList<ProfileViewVO>();
		int flag;
		if(fileFlag==null)
			flag = 0;
		else
			flag = 1;
		for(ProfileViewVO temp : list){
			if(temp.getFileFlag() == flag)
				returnList.add(temp);
		}
		if(returnList.size() == 0)
			return null;
		return returnList;
	}
	public List<ProfileViewVO> selectAgeListUp(List<ProfileViewVO> list, String age){
		List<ProfileViewVO> returnList = new LinkedList<ProfileViewVO>();
		int upAge = Integer.parseInt(age);
		/*
		if(fileFlag.equals("on"))
			flag = 1;
		else
			flag = 0;
			*/
		for(ProfileViewVO temp : list){
			if(temp.getAge() >= upAge)
				returnList.add(temp);
		}
		if(returnList.size() == 0)
			return null;
		return returnList;
	}
	public List<ProfileViewVO> selectAgeListDown(List<ProfileViewVO> list, String age){
		List<ProfileViewVO> returnList = new LinkedList<ProfileViewVO>();
		int downAge = Integer.parseInt(age);
		/*
		if(fileFlag.equals("on"))
			flag = 1;
		else
			flag = 0;
			*/
		for(ProfileViewVO temp : list){
			if(temp.getAge() <= downAge)
				returnList.add(temp);
		}
		if(returnList.size() == 0)
			return null;
		return returnList;
	}
	public List<ProfileViewVO> selectGenderList(List<ProfileViewVO> list, String gender){
		List<ProfileViewVO> returnList = new LinkedList<ProfileViewVO>();
		int tempGender;
		System.out.println(gender);
		if(gender.equals("1"))
			tempGender = 1;
		else
			tempGender = 2;
		for(ProfileViewVO temp : list){
			if(temp.getGender() == tempGender)
				returnList.add(temp);
		}
		if(returnList.size() == 0)
			return null;
		return returnList;
	}
	public List<ProfileViewVO> selectCountryList(List<ProfileViewVO> list, String country){
		List<ProfileViewVO> returnList = new LinkedList<ProfileViewVO>();
		/*String country;
		if(gender.equals("1"))
			tempGender = 1;
		else
			tempGender = 0;*/
		for(ProfileViewVO temp : list){
			if(temp.getNationality().equals(country)){
				System.out.println(temp.getNationality());
				System.out.println(country);
				returnList.add(temp);
			}
		}
		if(returnList.size() == 0)
			return null;
		return returnList;
	}
	
	public List<ProfileViewVO> selectLanguageList(List<ProfileViewVO> list, String language){
		List<ProfileViewVO> returnList = new LinkedList<ProfileViewVO>();
		/*String country;
		if(gender.equals("1"))
			tempGender = 1;
		else
			tempGender = 0;*/
		for(ProfileViewVO temp : list){
			if(temp.getInterest().equals(language))
				returnList.add(temp);
		}
		if(returnList.size() == 0)
			return null;
		return returnList;
	}
}
