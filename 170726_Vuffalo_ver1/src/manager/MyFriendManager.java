package manager;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.lecto.dao.ProfileViewConnDAO;
import com.lecto.dao.RelationViewListDAO;
import com.lecto.vo.ProfileViewVO;
import com.lecto.vo.RelationViewVO;

import dao.MemberListDAO;
import util.DateUtil;
import util.KeyDecoder;
import util.KeyEncoder;

public class MyFriendManager {
	public static List<String[]> getFriends(byte requestType, int codeNum){
		RelationViewListDAO rcd = RelationViewListDAO.getInstance();
		ProfileViewConnDAO pvcd = ProfileViewConnDAO.getInstance();
		
		int memNum=KeyDecoder.decodeKey(codeNum);//회원번호 복호화
		List<String[]> result = new ArrayList<String[]>();
		System.out.println(requestType+"유형의  "+ codeNum+"친구목록가져와버리기~!~!~!");
		List<RelationViewVO> list = rcd.searchRelationVOBySender(memNum, (byte)requestType);
		if(list==null)return null;
		ProfileViewVO pvv = null;
		String gender="남자";
		for(RelationViewVO tmp: list){
			System.out.println("친구관계 : "+tmp);
			pvv = pvcd.searchProfileViewVO(tmp.getReceiver());
			if(pvv==null){
				System.out.println("프로필없어서 빈걸로만든다.");
				pvv = new ProfileViewVO();
			}
			if(pvv.getGender()==1){
				gender = "여자";
			}else{
				gender = "남자";
			}
			
			result.add(new String[]{tmp.getReceiverNick(), Integer.toString(pvv.getAge()), gender
					, pvv.getNationality(), pvv.getSelfIntro(), pvv.getFileURL(),Integer.toString(pvv.getFileFlag())
					, pvv.getmTongue(), tmp.getDate(), Integer.toString(KeyEncoder.encodeKey(tmp.getReceiver())) });
		}

		return result;
	}
	
	public static boolean acceptRequest(int sender, int receiver, String receiverNick){
		RelationViewListDAO rvld = RelationViewListDAO.getInstance();
	
        String today = DateUtil.getToday();
		//1.수정(상대방이보낸요청->상대방은이제친구)
		RelationViewVO editedVO=rvld.editRelationViewVO((byte)1, receiver, sender, (byte)2, today); //기존목록수정
		if(editedVO==null)return false;
		rvld.getEditedRelationVOList().add(editedVO);
		rvld.getDeletedRelationVOList().add(new RelationViewVO(receiver, (byte)1, sender, "senderNick", today));
		
		//2.친구관계반영(본인이받은요청->본인도이제친구)
		editedVO=rvld.editRelationViewVO((byte)4, sender, receiver, (byte)2, today); //기존목록수정
		if(editedVO==null)return false;
		rvld.getEditedRelationVOList().add(editedVO);
		rvld.getDeletedRelationVOList().add(new RelationViewVO(sender, (byte)4, receiver, receiverNick, today));
		
		rvld.writeToDB();//DB 반영
		return true;
	}
	
	public static boolean cutFriend(byte relation, int sender, int receiver, String receiverNick){
		RelationViewListDAO rvld = RelationViewListDAO.getInstance();
		
		boolean flag = rvld.deleteRelationVO(relation, sender, receiver);
		if(flag==false)return false;
		flag = rvld.deleteRelationVO(relation, receiver, sender);
		if(flag==false)return false;
		
		rvld.writeToDB();//DB 반영
		return true;
	}
	
	public static boolean sendRequest(int sender, int receiver, String receiverNick){
		RelationViewListDAO rvld = RelationViewListDAO.getInstance();
	
        String today = DateUtil.getToday();
		String senderNick = MemberListDAO.getInstance().searchNickNameByMemberNum(sender);
		System.out.println("보내는사람의 이름은~?"+senderNick);
		rvld.getAddedRelationVOList().add(new RelationViewVO(sender, (byte)1, receiver, receiverNick, today));
		rvld.getAddedRelationVOList().add(new RelationViewVO(receiver, (byte)4, sender, senderNick, today));
		
		boolean flag=rvld.writeToDB();//DB 반영
		System.out.println("관계업데이트결과:"+flag);
		if(flag==false) return false;
		
		
		rvld.addRelationVOList((byte)1, today, sender, receiver, receiverNick);
		rvld.addRelationVOList((byte)4, today, receiver, sender, senderNick);
		
		
		
		return true;
	}
	
	public static boolean cancelRequest(int sender, int receiver, String receiverNick){
		RelationViewListDAO rvld = RelationViewListDAO.getInstance();
	
		boolean flag =rvld.deleteRelationVO((byte)1, sender, receiver);
		if(flag==false)return false;
		flag=rvld.deleteRelationVO((byte)4, receiver, sender);
		if(flag==false)return false;
		
		rvld.writeToDB();//DB 반영
		return true;
	}
	
}
