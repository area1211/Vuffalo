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
		
		int memNum=KeyDecoder.decodeKey(codeNum);//ȸ����ȣ ��ȣȭ
		List<String[]> result = new ArrayList<String[]>();
		System.out.println(requestType+"������  "+ codeNum+"ģ����ϰ����͹�����~!~!~!");
		List<RelationViewVO> list = rcd.searchRelationVOBySender(memNum, (byte)requestType);
		if(list==null)return null;
		ProfileViewVO pvv = null;
		String gender="����";
		for(RelationViewVO tmp: list){
			System.out.println("ģ������ : "+tmp);
			pvv = pvcd.searchProfileViewVO(tmp.getReceiver());
			if(pvv==null){
				System.out.println("�����ʾ�� ��ɷθ����.");
				pvv = new ProfileViewVO();
			}
			if(pvv.getGender()==1){
				gender = "����";
			}else{
				gender = "����";
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
		//1.����(�����̺�����û->����������ģ��)
		RelationViewVO editedVO=rvld.editRelationViewVO((byte)1, receiver, sender, (byte)2, today); //������ϼ���
		if(editedVO==null)return false;
		rvld.getEditedRelationVOList().add(editedVO);
		rvld.getDeletedRelationVOList().add(new RelationViewVO(receiver, (byte)1, sender, "senderNick", today));
		
		//2.ģ������ݿ�(�����̹�����û->���ε�����ģ��)
		editedVO=rvld.editRelationViewVO((byte)4, sender, receiver, (byte)2, today); //������ϼ���
		if(editedVO==null)return false;
		rvld.getEditedRelationVOList().add(editedVO);
		rvld.getDeletedRelationVOList().add(new RelationViewVO(sender, (byte)4, receiver, receiverNick, today));
		
		rvld.writeToDB();//DB �ݿ�
		return true;
	}
	
	public static boolean cutFriend(byte relation, int sender, int receiver, String receiverNick){
		RelationViewListDAO rvld = RelationViewListDAO.getInstance();
		
		boolean flag = rvld.deleteRelationVO(relation, sender, receiver);
		if(flag==false)return false;
		flag = rvld.deleteRelationVO(relation, receiver, sender);
		if(flag==false)return false;
		
		rvld.writeToDB();//DB �ݿ�
		return true;
	}
	
	public static boolean sendRequest(int sender, int receiver, String receiverNick){
		RelationViewListDAO rvld = RelationViewListDAO.getInstance();
	
        String today = DateUtil.getToday();
		String senderNick = MemberListDAO.getInstance().searchNickNameByMemberNum(sender);
		System.out.println("�����»���� �̸���~?"+senderNick);
		rvld.getAddedRelationVOList().add(new RelationViewVO(sender, (byte)1, receiver, receiverNick, today));
		rvld.getAddedRelationVOList().add(new RelationViewVO(receiver, (byte)4, sender, senderNick, today));
		
		boolean flag=rvld.writeToDB();//DB �ݿ�
		System.out.println("���������Ʈ���:"+flag);
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
		
		rvld.writeToDB();//DB �ݿ�
		return true;
	}
	
}
