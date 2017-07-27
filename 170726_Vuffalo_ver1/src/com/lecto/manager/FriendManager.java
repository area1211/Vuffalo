package com.lecto.manager;

import java.util.ArrayList;
import java.util.List;

import com.lecto.dao.ProfileViewConnDAO;
import com.lecto.dao.RelationViewConnDAO;
import com.lecto.dao.RelationViewListDAO;
import com.lecto.vo.ProfileViewVO;
import com.lecto.vo.RelationViewVO;

public class FriendManager {
	
	public FriendManager(){
		
	}
	
	public List<String[]> getFriends2(int user_num, int relation){
		RelationViewConnDAO rcd = RelationViewConnDAO.getInstance();
		ProfileViewConnDAO pvcd = ProfileViewConnDAO.getInstance();
		
		List<String[]> result = new ArrayList<String[]>();
		
		List<RelationViewVO> list = rcd.searchRelationViewVO(user_num, relation);
		ProfileViewVO pvv = null;
		String gender="����";
		for(RelationViewVO tmp: list){
			
			pvv = pvcd.searchProfileViewVO(tmp.getReceiver());
			System.out.println(pvv.getFileURL() + ", " +pvv.getFileFlag());
			if(pvv.getGender()==1){
				gender = "����";
			}else{
				gender = "����";
			}
			result.add(new String[]{tmp.getReceiverNick(), Integer.toString(pvv.getAge()), gender
					, pvv.getNationality(), pvv.getSelfIntro(), pvv.getFileURL(),Integer.toString(pvv.getFileFlag())
					, pvv.getmTongue(), tmp.getDate(), "����Ƚ�����ٰ�10" });
		}

		return result;
	}
	
	public List<String[]> getFriends(int user_num, int relation){
		RelationViewListDAO rcd = RelationViewListDAO.getInstance();
		ProfileViewConnDAO pvcd = ProfileViewConnDAO.getInstance();
		
		List<String[]> result = new ArrayList<String[]>();
		
		List<RelationViewVO> list = rcd.searchRelationVOBySender(user_num, (byte)relation);
		if(list==null)return null;
		ProfileViewVO pvv = null;
		String gender="����";
		for(RelationViewVO tmp: list){
			
			pvv = pvcd.searchProfileViewVO(tmp.getReceiver());
			System.out.println(pvv.getFileURL() + ", " +pvv.getFileFlag());
			if(pvv.getGender()==1){
				gender = "����";
			}else{
				gender = "����";
			}
			result.add(new String[]{tmp.getReceiverNick(), Integer.toString(pvv.getAge()), gender
					, pvv.getNationality(), pvv.getSelfIntro(), pvv.getFileURL(),Integer.toString(pvv.getFileFlag())
					, pvv.getmTongue(), tmp.getDate(), "����Ƚ�����ٰ�10" });
		}

		return result;
	}
}
