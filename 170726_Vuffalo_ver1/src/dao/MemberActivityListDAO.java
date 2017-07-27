package dao;

import java.util.ArrayList;
import java.util.List;

import connection.DAOException;
import vo.MemberActivityVO;
import vo.MemberVO;

public class MemberActivityListDAO {
	private static MemberActivityListDAO instance;
	private List<MemberActivityVO> memberActivityVOList;
	private List<MemberActivityVO> addedMemberActivityVOList;
	private List<MemberActivityVO> deleteMemberActivityVOList;
	private List<MemberActivityVO> editedMemberActivityVOList;
   
   static{
		instance = new MemberActivityListDAO();
	}
   
   private MemberActivityListDAO(){
     init();
   }
     
   public void addMemeberActivityListDAO(MemberActivityVO memberActivityVO){
      if(memberActivityVO == null){ return;}
      memberActivityVOList.add(memberActivityVO);
      addedMemberActivityVOList.add(memberActivityVO);
   }
   public void addMemeberActivityListDAO(int memberNum,int activePoint ,int commentCount ,int postCount){
      MemberActivityVO memberActivityVO = new MemberActivityVO(memberNum,activePoint,commentCount,postCount);
      memberActivityVOList.add(memberActivityVO);
      addedMemberActivityVOList.add(memberActivityVO);
   }
   public boolean deleteMemberAcivityVO(MemberActivityVO memberActivityVO){
      if(memberActivityVO == null){ return false;}
      if(!memberActivityVOList.remove(memberActivityVO)){
         return false;
      }
      deleteMemberActivityVOList.add(memberActivityVO);
      return true;
   }
   public boolean deleteMemberAcivityVO(int memberNum){
      MemberActivityVO memberActivityVO = searchMemberActivityVO(memberNum);
      if(memberActivityVO == null) return false;
      deleteMemberActivityVOList.add(memberActivityVO);
      memberActivityVOList.remove(memberActivityVO);
      return true;
   }
   public MemberActivityVO searchMemberActivityVO(int memberNum){
      for(MemberActivityVO t : memberActivityVOList){
         if(t.getMemberNum() == memberNum){
            return t;
         }
      }
      return null;
   }
   public MemberActivityVO searchMemberActivityVO(List<MemberActivityVO> list, int memberNum){
      if(list == null) return null;
      for(MemberActivityVO t : list){
         if(t.getMemberNum() == memberNum){
            return t;
         }
      }
      return null;
   }
   public boolean editMemberActivityVO(MemberActivityVO memberActivityVO){
      MemberActivityVO originMemberActivityVO = searchMemberActivityVO(memberActivityVO.getMemberNum());
      if(originMemberActivityVO == null) return false;
      if(!memberActivityVOList.remove(originMemberActivityVO)) return false;
      memberActivityVOList.add(memberActivityVO);
      editedMemberActivityVOList.add(memberActivityVO);
      return true;
   }
   public boolean editMemberActivityVOAddActivePoint(int memberNum,int amount){
      MemberActivityVO memberActivityVO = searchMemberActivityVO(memberNum);
      if(memberActivityVO == null) return false;
      int sum = memberActivityVO.getActivePoint() + amount;
      memberActivityVO.setActivePoint(sum);
      editedMemberActivityVOList.add(memberActivityVO);
      return true;
   }
   public boolean editMemberActivityVOAddComment(int memberNum){
      MemberActivityVO memberActivityVO = searchMemberActivityVO(memberNum);
      if(memberActivityVO == null) return false;
      int sum = memberActivityVO.getCommentCount() + 1;
      memberActivityVO.setCommentCount(sum);
      editedMemberActivityVOList.add(memberActivityVO);
      return true;
   }
   public boolean editMemberActivityVOAddPost(int memberNum){
      MemberActivityVO memberActivityVO = searchMemberActivityVO(memberNum);
      if(memberActivityVO == null) return false;
      int sum = memberActivityVO.getPostCount() + 1;
      memberActivityVO.setPostCount(sum);
      editedMemberActivityVOList.add(memberActivityVO);
      return true;
   }
   public void init(){
	   	addedMemberActivityVOList = new ArrayList<MemberActivityVO>();
	   	deleteMemberActivityVOList = new ArrayList<MemberActivityVO>();
		editedMemberActivityVOList = new ArrayList<MemberActivityVO>();
		try{
			memberActivityVOList = MemberActivityConDAO.getInstance().searchAll();
		}catch(DAOException e){
			e.printStackTrace();
		}
   }
   public void writeToDB(){
		MemberActivityConDAO.getInstance().addList(addedMemberActivityVOList);
		MemberActivityConDAO.getInstance().editList(editedMemberActivityVOList);
		//MemberActivityConDAO.getInstance().deleteList(deleteMemberActivityVOList);
		addedMemberActivityVOList = new ArrayList<MemberActivityVO>();
		editedMemberActivityVOList = new ArrayList<MemberActivityVO>();
		deleteMemberActivityVOList = new ArrayList<MemberActivityVO>();
   };
   
   
   
   public static MemberActivityListDAO getInstance() {
	return instance;
}
public static void setInstance(MemberActivityListDAO instance) {
	MemberActivityListDAO.instance = instance;
}
public List<MemberActivityVO> getMemberActivityVOList() {
      return memberActivityVOList;
   }
   public void setMemberActivityVOList(List<MemberActivityVO> memberActivityVOList) {
      this.memberActivityVOList = memberActivityVOList;
   }
   public List<MemberActivityVO> getAddedMemberActivityVOList() {
      return addedMemberActivityVOList;
   }
   public void setAddedMemberActivityVOList(List<MemberActivityVO> addedMemberActivityVOList) {
      this.addedMemberActivityVOList = addedMemberActivityVOList;
   }
   public List<MemberActivityVO> getDeleteMemberActivityVOList() {
      return deleteMemberActivityVOList;
   }
   public void setDeleteMemberActivityVOList(List<MemberActivityVO> deleteMemberActivityVOList) {
      this.deleteMemberActivityVOList = deleteMemberActivityVOList;
   }
   public List<MemberActivityVO> getEditedMemberActivityVOList() {
      return editedMemberActivityVOList;
   }
   public void setEditedMemberActivityVOList(List<MemberActivityVO> editedMemberActivityVOList) {
      this.editedMemberActivityVOList = editedMemberActivityVOList;
   }
   
   
}