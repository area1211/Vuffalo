package manager;

import java.util.ArrayList;
import java.util.List;

import dao.MemberListDAO;
import dao.ProfileListDAO;
import dao.ProfileViewListDAO;
import vo.ProfileVO;
import vo.ProfileViewVO;

public class ProfileEditManager {
	
	public boolean editProfile(String[] list){
	
		ProfileVO profileVO = null;
		if(list[10].equals("0")){
		profileVO = new ProfileVO(Integer.parseInt(list[0]), Integer.parseInt(list[6])
				, Integer.parseInt(list[3]), list[7], list[4]
				, list[5], list[8], Byte.valueOf(list[10]), Byte.parseByte(list[9]), "", 0);
		}
		else{
		profileVO = new ProfileVO(Integer.parseInt(list[0]), Integer.parseInt(list[6])
				, Integer.parseInt(list[3]), list[7], list[4]
				, list[5], list[8], Byte.valueOf(list[10]), Byte.parseByte(list[9]), list[13], 0);
		}
		ProfileListDAO profileListDAO = ProfileListDAO.getInstance();
		System.out.println(profileListDAO.toString());
		if(!profileListDAO.editProfileVO(profileVO))
			return false;
		MemberListDAO memberListDAO = MemberListDAO.getInstance();

		if(!(list[14].equals(list[1]))){
			if(!memberListDAO.editMemberVONickname(Integer.parseInt(list[0]), list[1])){
				return false;
			}
			memberListDAO.editMemberVOEmail(Integer.parseInt(list[0]), list[2]);
			
		}
		return true;
	}
	
	public List<String> viewProfile(int codeNum){
		ProfileViewListDAO profileViewListDAO 
		= ProfileViewListDAO.getInstance();
		
		ProfileViewVO profileViewVO =
				profileViewListDAO.searchProfileViewVO(codeNum);
		
		List<String> list = new ArrayList<String>();
		list.add(Integer.toString(profileViewVO.getNum()));
		list.add(profileViewVO.getNickname());
		list.add(profileViewVO.getEmail());
		list.add(Integer.toString(profileViewVO.getAge()));
		list.add(profileViewVO.getmTongue());
		list.add(profileViewVO.getInterest());
		list.add(Integer.toString(profileViewVO.getGender()));
		list.add(profileViewVO.getNationality());
		list.add(profileViewVO.getSelfIntro());
		list.add(Integer.toString(profileViewVO.getOpenRange()));
		list.add(Integer.toString(profileViewVO.getFileFlag()));
		list.add(profileViewVO.getLastVisitDate());
		list.add(profileViewVO.getLastProfileUpdate());
		list.add(profileViewVO.getFileURL());
		
		return list;
	}
}
