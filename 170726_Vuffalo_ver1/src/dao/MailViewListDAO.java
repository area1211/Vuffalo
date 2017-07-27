package dao;

import java.util.ArrayList;
import java.util.List;

import connection.DAOException;
import vo.MailVO;
import vo.MailViewVO;

public class MailViewListDAO {
	private static MailViewListDAO instance;
	private List<MailViewVO> mailViewList;
	
	static{
		instance = new MailViewListDAO();
	}
	private MailViewListDAO() {
		init();
		if(mailViewList == null){
			System.out.println("시발");
		}
	}
	
	private MailViewListDAO(List<MailViewVO> mailViewList) {
		super();
		this.mailViewList = mailViewList;
	}
	
	public static MailViewListDAO getInstance(){
		return instance;
	}
	public List<MailViewVO> getMailViewList() {
		return mailViewList;
	}

	public void setMailViewList(List<MailViewVO> mailViewList) {
		this.mailViewList = mailViewList;
	}

	public void addMailViewVO(MailVO mailVO){
		mailViewList.add(new MailViewVO(mailVO.getMailNum(), mailVO.getReceiver(),mailVO.getSender(),mailVO.getTitle(),mailVO.getDescription(),mailVO.getImgFlag(),mailVO.getSendDate(),mailVO.getReadDate(),mailVO.getFileUrl(),MemberListDAO.getInstance().searchNickNameByMemberNum(mailVO.getSender()),MemberListDAO.getInstance().searchNickNameByMemberNum(mailVO.getReceiver())));
	}
	public void deleteMailViewVO(MailVO mailVO){
		mailViewList.remove(searchMailViewVO(mailVO.getMailNum()));
	}
	public void deleteMailViewVO(int mailNum){
		mailViewList.remove(searchMailViewVO(mailNum));
	}
	public MailViewVO searchMailViewVO(int mailNum){
		if(mailViewList == null)
			return null;
		for(MailViewVO temp : mailViewList){
			if(temp.getMailNum() == mailNum){
				return temp;
			}
		}
		return null;
	}
	public List<MailViewVO> searchMailViewVO(String nickName, boolean sendOrReceive){
		if(mailViewList == null)
			return null;
		List<MailViewVO> tempList = new ArrayList<MailViewVO>();
		if(sendOrReceive){
			for(MailViewVO temp : mailViewList){
				if(temp.getSenderNickName().equals(nickName)){
					tempList.add(temp);
				}
			}
		}
		else{
			for(MailViewVO temp : mailViewList){
				if(temp.getReceiverNickName().equals(nickName)){
					tempList.add(temp);
				}
			}
		}
		return tempList;
	}
	public List<MailViewVO> searchMailViewVO(int memberNum, boolean sendOrReceive){
		if(mailViewList == null)
			return null;
		List<MailViewVO> tempList = new ArrayList<MailViewVO>();
		if(sendOrReceive){
			for(MailViewVO temp : mailViewList){
				System.out.println("발신함 들어옴");
				if(temp.getSenderNum() == memberNum){
					tempList.add(temp);
				}
			}
		}
		else{
			for(MailViewVO temp : mailViewList){
				System.out.println("수신함들어옴");
				if(temp.getReceiverNum()==memberNum){
					tempList.add(temp);
				}
			}
		}
		return tempList;	
	}
	public List<MailViewVO> searchMailViewVO(String nickName1, String nickName2){
		if(mailViewList == null)
			return null;
		List<MailViewVO> tempList = new ArrayList<MailViewVO>();
		for(MailViewVO temp : mailViewList){
			if((temp.getSenderNickName().equals(nickName1)&&temp.getReceiverNickName().equals(nickName2))||(temp.getSenderNickName().equals(nickName2)&&temp.getReceiverNickName().equals(nickName1))){
				tempList.add(temp);
			}
		}
		return tempList;
	}
	public List<MailViewVO> searchMailViewVO(int memberNum1, int memberNum2){
		if(mailViewList == null)
			return null;
		List<MailViewVO> tempList = new ArrayList<MailViewVO>();
		for(MailViewVO temp : mailViewList){
			if((temp.getSenderNum() ==memberNum1 &&temp.getReceiverNum() == memberNum2)||(temp.getSenderNum() == memberNum2 && temp.getReceiverNum() == memberNum1)){
				tempList.add(temp);
			}
		}
		return tempList;
	}
	public List<MailViewVO> MailViewVOFromTo(String sender, String receiver){
		if(mailViewList == null)
			return null;
		List<MailViewVO> tempList = new ArrayList<MailViewVO>();
		for(MailViewVO temp : mailViewList){
			if(temp.getSenderNickName().equals(sender) && temp.getReceiverNickName().equals(receiver)){
				tempList.add(temp);
			}
		}
		return tempList;
	}
	
	public List<MailViewVO> MailViewVOFromTo(int sender, int receiver){
		if(mailViewList == null)
			return null;
		List<MailViewVO> tempList = new ArrayList<MailViewVO>();
		for(MailViewVO temp : mailViewList){
			if(temp.getSenderNum() == sender && temp.getReceiverNum() == receiver){
				tempList.add(temp);
			}
		}
		return tempList;
	}
	public void editMailViewVO(int mailNum, String readDate){
		if(readDate == null || mailViewList == null)
			return;
		for(MailViewVO temp : mailViewList){
			if(temp.getMailNum()==mailNum){
				temp.setReadDate(readDate);
			}
		}
	}
	
	public void init(){
		try {
			mailViewList = MailViewConDAO.getInstance().searchAll();
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public String toString() {
		return "MailViewListDAO [mailViewList=" + mailViewList + "]";
	}

}
