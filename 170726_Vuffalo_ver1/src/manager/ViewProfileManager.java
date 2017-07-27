package manager;

import dao.ProfileViewListDAO;
import vo.ProfileViewVO;

public class ViewProfileManager {
	public ProfileViewVO viewProfile(int codeNum){
		
		ProfileViewListDAO profileViewListDAO 
		= ProfileViewListDAO.getInstance();
		
		ProfileViewVO profileViewVO =
				profileViewListDAO.searchProfileViewVO(codeNum);
		return profileViewVO;
//		List<String> list = new ArrayList<String>();
//		list.add(Integer.toString(profileViewVO.getNum()));
//		list.add(profileViewVO.getNickname());
//		list.add(profileViewVO.getEmail());
//		list.add(Integer.toString(profileViewVO.getAge()));
//		list.add(profileViewVO.getmTongue());
//		list.add(profileViewVO.getInterest());
//		list.add(Integer.toString(profileViewVO.getGender()));
//		list.add(profileViewVO.getNationality());
//		list.add(profileViewVO.getSelfIntro());
//		list.add(Integer.toString(profileViewVO.getOpenRange()));
//		list.add(Integer.toString(profileViewVO.getFileFlag()));
//		list.add(profileViewVO.getLastVisitDate());
//		list.add(profileViewVO.getLastProfileUpdate());
//		list.add(profileViewVO.getFileURL());
//		
//		return list;
	}
}
