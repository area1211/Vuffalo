package dao;

import java.util.ArrayList;
import java.util.List;

import connection.DAOException;
import vo.MemberActivityVO;
import vo.MemberVO;
import vo.MemberVisitationVO;

public class MemberVisitationListDAO {
	
	private static MemberVisitationListDAO instance;
	private List<MemberVisitationVO> memberVisitationVOList;
	private List<MemberVisitationVO> addedMemberVisitationVOList;
	private List<MemberVisitationVO> deletedMemberVisitationVOList;
	private List<MemberVisitationVO> editedMemberVisitationVOList;
	
	static{
		instance = new MemberVisitationListDAO();
	}
	private MemberVisitationListDAO() {
		init();
	}
	private MemberVisitationListDAO(List<MemberVisitationVO> memberVisitationVOList,
			List<MemberVisitationVO> addedMemberVisitationVOList,
			List<MemberVisitationVO> deletedMemberVisitationVOList,
			List<MemberVisitationVO> editedMemberVisitationVOList) {
		super();
		this.memberVisitationVOList = memberVisitationVOList;
		this.addedMemberVisitationVOList = addedMemberVisitationVOList;
		this.deletedMemberVisitationVOList = deletedMemberVisitationVOList;
		this.editedMemberVisitationVOList = editedMemberVisitationVOList;
	}
	public static MemberVisitationListDAO getInstance(){
		return instance;
	}
	public MemberVisitationVO searchMemberVisitationVO(int memberNum){
		if(memberVisitationVOList == null){
			return null;
		}
		for(MemberVisitationVO temp : memberVisitationVOList){
			if(temp.getMemberNum() == memberNum){
				return temp;
			}
		}
		return null;
	}
	public void addMemberVisitationVO(MemberVisitationVO memberVisitationVO){
		memberVisitationVOList.add(memberVisitationVO);
		addedMemberVisitationVOList.add(memberVisitationVO);
	}
	public void addMemberVisitationVO(int memberNum, int visitCount, String lastVisitDate, String lastProfileUpdateDate){
		addMemberVisitationVO(new MemberVisitationVO(memberNum, visitCount, lastVisitDate, lastProfileUpdateDate));
	}
	public boolean deleteMemberVisitationVO(MemberVisitationVO memberVisitationVO){
		if(memberVisitationVO == null || memberVisitationVOList == null)
			return false;
		if(!memberVisitationVOList.remove(memberVisitationVO)){
			return false;
		}
		deletedMemberVisitationVOList.add(memberVisitationVO);
		return true;
	}
	public boolean deleteMemberVisitationVO(int memberNum){
		MemberVisitationVO temp = searchMemberVisitationVO(memberNum);
		if(temp == null)
			return false;
		if(!memberVisitationVOList.remove(temp)){
			return false;
		}
		deletedMemberVisitationVOList.add(temp);
		return true;
	}
	public boolean editVisitCount(int memberNum){
		MemberVisitationVO temp = searchMemberVisitationVO(memberNum);
		if(temp == null)
			return false;
		temp.setVisitCount(temp.getVisitCount()+1);
		return true;
	}
	public boolean editLastVisitDate(int memberNum, String lastVisitDate){
		
		MemberVisitationVO temp = searchMemberVisitationVO(memberNum);
		if(temp == null)
			return false;
		temp.setLastVisitDate(lastVisitDate);
		
		this.editedMemberVisitationVOList.add(temp);
		//¶±ººÀÌ ¸Ô±âÀü ÀÛ¾÷Áß
		return true;
	}
	public boolean editLastProfileUpdateDate(int memberNum, String lastProfileUpdateDate){
		if(memberVisitationVOList == null)
			return false;
		
		MemberVisitationVO temp = searchMemberVisitationVO(memberNum);
		if(temp == null)
			return false;
		temp.setLastProfileUpdateDate(lastProfileUpdateDate);
		return true;
	}
	public void init(){
		addedMemberVisitationVOList = new ArrayList<MemberVisitationVO>();
		deletedMemberVisitationVOList = new ArrayList<MemberVisitationVO>();
		editedMemberVisitationVOList = new ArrayList<MemberVisitationVO>();
		try{
			memberVisitationVOList = MemberVisitationConDAO.getInstance().searchAll();
		}catch(DAOException e){
			e.printStackTrace();
		}
	}
	public void writeToDB(){
		MemberVisitationConDAO.getInstance().addList(addedMemberVisitationVOList);
		MemberVisitationConDAO.getInstance().editList(editedMemberVisitationVOList);
		//MemberActivityConDAO.getInstance().deleteList(deleteMemberActivityVOList);
		addedMemberVisitationVOList = new ArrayList<MemberVisitationVO>();
		editedMemberVisitationVOList = new ArrayList<MemberVisitationVO>();
		deletedMemberVisitationVOList = new ArrayList<MemberVisitationVO>();
	}
}
