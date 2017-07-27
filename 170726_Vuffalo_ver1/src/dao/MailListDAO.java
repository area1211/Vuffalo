package dao;

import java.util.ArrayList;
import java.util.List;

import connection.DAOException;
import vo.MailVO;

public class MailListDAO {
	
	private static MailListDAO instance;
	private List<MailVO> mailVOList;
	private List<MailVO> addedMailVOList;
	private List<MailVO> deletedMailVOList;
	private List<MailVO> editedMailVOList;
	static{
		instance = new MailListDAO();
	}
	private MailListDAO() {
		init();

	}
	private MailListDAO(List<MailVO> mailVOList, List<MailVO> addedMailVOList, List<MailVO> deletedMailVOList,
			List<MailVO> editedMailVOList) {
		super();
		this.mailVOList = mailVOList;
		this.addedMailVOList = addedMailVOList;
		this.deletedMailVOList = deletedMailVOList;
		this.editedMailVOList = editedMailVOList;
	}
	public static MailListDAO getInstance(){
		return instance;
	}
	public List<MailVO> getMailVOList() {
		return mailVOList;
	}
	public void setMailVOList(List<MailVO> mailVOList) {
		this.mailVOList = mailVOList;
	}
	public List<MailVO> getAddedMailVOList() {
		return addedMailVOList;
	}
	public void setAddedMailVOList(List<MailVO> addedMailVOList) {
		this.addedMailVOList = addedMailVOList;
	}
	public List<MailVO> getDeletedMailVOList() {
		return deletedMailVOList;
	}
	public void setDeletedMailVOList(List<MailVO> deletedMailVOList) {
		this.deletedMailVOList = deletedMailVOList;
	}
	public List<MailVO> getEditedMailVOList() {
		return editedMailVOList;
	}
	public void setEditedMailVOList(List<MailVO> editedMailVOList) {
		this.editedMailVOList = editedMailVOList;
	}
	
	public MailVO searchMailVO(int mailNum){
		if(mailVOList == null){
			return null;
		}
		for(MailVO temp : mailVOList){
			if(temp.getMailNum() == mailNum){
				return temp;
			}
		}
		return null;
	}
	public MailVO searchMailVO(List<MailVO> list, int mailNum){
		if(list == null){
			return null;
		}
		for(MailVO temp : list){
			if(temp.getMailNum() == mailNum){
				return temp;
			}
		}
		return null;
	}
	public List<MailVO> searchMailVOBySender(int sender){
		if(mailVOList == null){
			return null;
		}
		List returnList = new ArrayList<MailVO>();
		for(MailVO temp : mailVOList){
			if(temp.getSender() == sender){
				returnList.add(temp);
			}
		}
		if(returnList.size() == 0){
			return null;
		}
		return returnList;
	}
	public List<MailVO> searchMailVOByReceiver(int receiver){
		if(mailVOList == null){
			return null;
		}
		List returnList = new ArrayList<MailVO>();
		for(MailVO temp : mailVOList){
			if(temp.getReceiver() == receiver){
				returnList.add(temp);
			}
		}
		if(returnList.size() == 0){
			return null;
		}
		return returnList;
	}
	public void addMailVO(MailVO mailVO){
		if(mailVO == null){
			return;
		}
		mailVOList.add(mailVO);
		addedMailVOList.add(mailVO);
		if(addedMailVOList.size() >= 5){
			writeToDB();
		}
	}
	public void addMailVO(int mailNum, String title, String description, String sendDate, String readDate, byte imgFlag, String fileUrl, int sender, int receiver){
		addMailVO(new MailVO(mailNum, title, description, sendDate, readDate, imgFlag, fileUrl, sender, receiver));
	}
	public boolean deleteMailVO(MailVO mailVO){
		if(mailVO == null){
			return false;
		}
		if(mailVOList == null){
			return false;
		}
		if(!mailVOList.remove(mailVO)){
			return false;
		}
		deletedMailVOList.add(mailVO);
		if(deletedMailVOList.size() >= 5){
			writeToDB();
		}
		return true;
	}
	public boolean deleteMailVO(int mailNum){
		if(mailVOList == null){
			return false;
		}
		MailVO temp = searchMailVO(mailNum);
		if(!mailVOList.remove(temp)){
			return false;
		}
		deletedMailVOList.add(temp);
		if(deletedMailVOList.size() >= 5){
			writeToDB();
		}
		return true;
	}
	public boolean editMailVO(MailVO mailVO){
		if(mailVO == null){
			return false;
		}
		if(mailVOList == null){
			return false;
		}
		if(!(deleteMailVO(mailVO.getMailNum()))){
			return false;
		}
		mailVOList.add(mailVO);
		editedMailVOList.add(mailVO);
		if(editedMailVOList.size()>=5){
			writeToDB();
		}
		return true;
	}
	   public boolean editMailVO(int mailNum, String now){
		      MailVO temp = searchMailVO(mailNum);
		      if(temp == null)
		         return false;
		      temp.setReadDate(now);
		      editedMailVOList.add(temp);
		      writeToDB();
		      return true;
		      
		   }
	public boolean editMailVO(int mailNum, String title, String description, String sendDate, String readDate, byte imgFlag, String fileUrl, int sender, int receiver){
		return editMailVO(new MailVO(mailNum, title, description, sendDate, readDate, imgFlag, fileUrl, sender, receiver));
	}
	public void init(){
		
		try {
			mailVOList = MailConDAO.getInstance().searchAll();
			addedMailVOList = new ArrayList<MailVO>();
			deletedMailVOList = new ArrayList<MailVO>();
			editedMailVOList = new ArrayList<MailVO>();
		} catch (DAOException e) {
			e.printStackTrace();
		}

	}
	public void writeToDB(){
		MailConDAO.getInstance().addList(addedMailVOList);
		MailConDAO.getInstance().editList(editedMailVOList);
		MailConDAO.getInstance().deleteList(deletedMailVOList);
		addedMailVOList = new ArrayList<MailVO>();
		deletedMailVOList = new ArrayList<MailVO>();
		editedMailVOList = new ArrayList<MailVO>();
	}
}
