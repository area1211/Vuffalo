package manager;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import dao.MailListDAO;
import dao.MailViewListDAO;
import dao.MemberListDAO;
import util.DateUtil;
import util.KeyDecoder;
import vo.MailVO;
import vo.MailViewVO;

public class MailManager {
	private static int lastNum;

	static{
		lastNum = 0;
		MailListDAO temp = MailListDAO.getInstance();
		if(temp.getMailVOList() != null){
			for(MailVO tempVO : temp.getMailVOList()){
				if(tempVO.getMailNum() > lastNum){
					lastNum = tempVO.getMailNum();
				}
			}
			
			lastNum++;
		}
	}

	public MailVO makeMailVO(int codeNum, String receiver, String title, String text, String fileUrl, byte flag){
		System.out.println(fileUrl);
		System.out.println(receiver);
		Calendar calendar = Calendar.getInstance();
		java.util.Date date = calendar.getTime();
		String today = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date));
		int num = setMailNum();
		MailVO tempVO = new MailVO(num, title, text, today, null, flag, fileUrl, KeyDecoder.decodeKey(codeNum), setReceiver(receiver));
		tempVO.getFileUrl();
		MailListDAO.getInstance().addMailVO(tempVO);
		MailListDAO.getInstance().writeToDB();
		MailViewListDAO.getInstance().addMailViewVO(tempVO);
		return tempVO;
	}
	public int setReceiver(String nickName){
		return MemberListDAO.getInstance().searchMemberNumByNickName(nickName);
	}
	public int setMailNum(){
		lastNum++;
		System.out.println(lastNum-1);
		return lastNum-1;
	}
	public void removeMailList(String[] list){
		for(String temp : list){
			MailListDAO.getInstance().deleteMailVO(Integer.parseInt(temp));
			MailListDAO.getInstance().writeToDB();
			MailViewListDAO.getInstance().deleteMailViewVO(Integer.parseInt(temp));
		}
	}
	public MailViewVO search(int mailNum){
		MailViewVO tempVO = MailViewListDAO.getInstance().searchMailViewVO(mailNum);
		if(tempVO == null)
			return null;
		String today = DateUtil.getToday();
		if(tempVO.getReadDate() == null){
			tempVO.setReadDate(DateUtil.getToday());
		}
		
		MailListDAO.getInstance().editMailVO(mailNum, today);
		return MailViewListDAO.getInstance().searchMailViewVO(mailNum);
	}
	public List<MailViewVO> searchList(int flag, String option, String keyword, String codeNum){
		List<MailViewVO> returnList = new ArrayList<MailViewVO>();
		int memNum = KeyDecoder.decodeKey(Integer.parseInt(codeNum));
		if(flag == 0){//수신
			if(option.equals("보낸사람")){
				for(MailViewVO temp : MailViewListDAO.getInstance().getMailViewList()){
					if(temp.getSenderNickName().contains(keyword) && temp.getReceiverNum() == memNum){
						returnList.add(temp);
					}
				}
				return returnList;
			}
			else if(option.equals("제목")){
				for(MailViewVO temp : MailViewListDAO.getInstance().getMailViewList()){
					if(temp.getTitle().contains(keyword)&& temp.getReceiverNum() == memNum){
						returnList.add(temp);
					}
				}
				return returnList;
			}
			else if(option.equals("내용")){
				for(MailViewVO temp : MailViewListDAO.getInstance().getMailViewList()){
					if(temp.getContent().contains(keyword)&& temp.getReceiverNum() == memNum){
						returnList.add(temp);
					}
				}
				return returnList;				
			}
			else{
				for(MailViewVO temp : MailViewListDAO.getInstance().getMailViewList()){
					if(temp.getSendDate().contains(keyword)){
						returnList.add(temp);
					}
				}
				return returnList;				
			}
		}
		else{//발신
			if(option.equals("받는사람")){
				for(MailViewVO temp : MailViewListDAO.getInstance().getMailViewList()){
					if(temp.getReceiverNickName().contains(keyword)&& temp.getSenderNum() == memNum){
						returnList.add(temp);
					}
				}
				return returnList;
			}
			else if(option.equals("제목")){
				for(MailViewVO temp : MailViewListDAO.getInstance().getMailViewList()){
					if(temp.getTitle().contains(keyword)&& temp.getSenderNum() == memNum){
						returnList.add(temp);
					}
				}
				return returnList;				
			}
			else if(option.equals("내용")){
				for(MailViewVO temp : MailViewListDAO.getInstance().getMailViewList()){
					if(temp.getContent().contains(keyword)&& temp.getSenderNum() == memNum){
						returnList.add(temp);
					}
				}
				return returnList;				
			}
			else{
				for(MailViewVO temp : MailViewListDAO.getInstance().getMailViewList()){
					if(temp.getSendDate().contains(keyword)&& temp.getSenderNum() == memNum){
						returnList.add(temp);
					}
				}
				return returnList;				
			}
		}
	}
}
