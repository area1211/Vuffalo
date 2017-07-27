package com.lecto.dao;

import java.util.ArrayList;
import java.util.List;

import com.lecto.vo.RelationViewVO;

public class RelationViewListDAO {
	private static RelationViewListDAO instance;
	private List<RelationViewVO> relationVOList;
	private List<RelationViewVO> addedRelationVOList;
	private List<RelationViewVO> deletedRelationVOList;
	private List<RelationViewVO> editedRelationVOList;
	
	static {
		instance = new RelationViewListDAO();
	}
	
	public static RelationViewListDAO getInstance(){
		return instance;
	}
	
	public RelationViewListDAO() {
		init();
	}


	public RelationViewListDAO(List<RelationViewVO> relationVOList, List<RelationViewVO> addedRelationVOList,
			List<RelationViewVO> deletedRelationVOList, List<RelationViewVO> editedRelationVOList) {
		super();
		this.relationVOList = relationVOList;
		this.addedRelationVOList = addedRelationVOList;
		this.deletedRelationVOList = deletedRelationVOList;
		this.editedRelationVOList = editedRelationVOList;
	}


	public List<RelationViewVO> getRelationVOList() {
		return relationVOList;
	}


	public void setRelationVOList(List<RelationViewVO> relationVOList) {
		this.relationVOList = relationVOList;
	}


	public List<RelationViewVO> getAddedRelationVOList() {
		return addedRelationVOList;
	}


	public void setAddedRelationVOList(List<RelationViewVO> addedRelationVOList) {
		this.addedRelationVOList = addedRelationVOList;
	}


	public List<RelationViewVO> getDeletedRelationVOList() {
		return deletedRelationVOList;
	}


	public void setDeletedRelationVOList(List<RelationViewVO> deletedRelationVOList) {
		this.deletedRelationVOList = deletedRelationVOList;
	}


	public List<RelationViewVO> getEditedRelationVOList() {
		return editedRelationVOList;
	}


	public void setEditedRelationVOList(List<RelationViewVO> editedRelationVOList) {
		this.editedRelationVOList = editedRelationVOList;
	}
	public RelationViewVO searchRelationVO(byte requestType, int sender, int receiver){
		if(relationVOList == null){
			return null;
		}
		for(RelationViewVO temp : relationVOList){
			if(temp.getRelation() == requestType && temp.getSender() == sender && temp.getReceiver() == receiver){
				return temp;
			}
		}
		return null;
	}
	public List<RelationViewVO> searchRelationVOBySender(int sender, byte requestType){
		if(relationVOList == null){
			return null;
		}
		List<RelationViewVO> tempList = new ArrayList<RelationViewVO>();
		for(RelationViewVO temp : relationVOList){
			if(temp.getRelation() == requestType && temp.getSender() == sender){
				tempList.add(temp);
			}
		}
		if(tempList.size() == 0)
			return null;
		return tempList;
	}
	public List<RelationViewVO> searchRelationVOByReceiver(byte requestType, int receiver){
		if(relationVOList == null){
			return null;
		}
		List<RelationViewVO> tempList = new ArrayList<RelationViewVO>();
		for(RelationViewVO temp : relationVOList){
			if(temp.getRelation() == requestType && temp.getReceiver() == receiver){
				tempList.add(temp);
			}
		}
		if(tempList.size() == 0)
			return null;
		return tempList;		
	}
	public void addRelationVO(RelationViewVO relationVO){
		relationVOList.add(relationVO);
		//addedRelationVOList.add(relationVO);
	}
	public void addRelationVOList(byte requestType, String date, int sender, int receiver, String receiverNick){
		addRelationVO(new RelationViewVO(sender,requestType,receiver,receiverNick,date));
	}
	public boolean deleteRelationVO(RelationViewVO relationVO){
		if(relationVOList == null)
			return false;
		if(!relationVOList.remove(relationVO)){
			return false;
		}
		deletedRelationVOList.add(relationVO);
		return true;
	}
	public boolean deleteRelationVO(byte requestType, int sender, int receiver){
		if(relationVOList == null)
			return false;
		RelationViewVO temp = searchRelationVO(requestType, sender, receiver);
		if(temp == null)
			return false;
		if(!relationVOList.remove(temp)){
			return false;
		}
		
		return deletedRelationVOList.add(temp);
	}
	
	public RelationViewVO editRelationViewVO(byte existingRequestType, int sender, int receiver, byte changingRequestType, String date){
		RelationViewVO target = this.searchRelationVO(existingRequestType, sender, receiver);
		if(target==null) return null;
		target.setRelation(changingRequestType);
		target.setDate(date);
		
		return target;
	}
	
	public void init(){
		RelationViewConnDAO rvcd = RelationViewConnDAO.getInstance();
		relationVOList=rvcd.readFromDB();
		System.out.println(relationVOList);
		addedRelationVOList = new ArrayList<RelationViewVO>();
		deletedRelationVOList = new ArrayList<RelationViewVO>();
		editedRelationVOList = new ArrayList<RelationViewVO>();
	}
	public boolean writeToDB(){
		boolean flag=false;
//		//추가리스트의 요소들을 DB 테이블에 싹 삽입한다.
//		RelationViewConnDAO rvcd = RelationViewConnDAO.getInstance();
//		flag = rvcd.friendInsert(addedRelationVOList);
//		if(flag==false) return;
//		//삭제리스트의 요소들을 DB 테이블에서 싹 삭제한다.
//		
//		//수정리스트의 요소들을 DB 테이블에 싹 삽입한다.
//		flag = rvcd.friendInsert(editedRelationVOList);
//		if(flag==false) return;
		RelationViewConnDAO rvcd = RelationViewConnDAO.getInstance();
		flag=rvcd.relationUpdate(this.deletedRelationVOList, this.editedRelationVOList, this.addedRelationVOList);
		System.out.println("writeToDB()결과:"+flag);
		//비운다.
		if(flag==true){
			this.addedRelationVOList.clear();
			System.out.println("wtd->추가된목록:"+addedRelationVOList);
			this.deletedRelationVOList.clear();
			System.out.println("wtd->삭제된목록:"+deletedRelationVOList);
			this.editedRelationVOList.clear();
			System.out.println("wtd->수정된목록:"+editedRelationVOList);
		}
		return flag;
	}
	
}
