package dao;

import java.util.ArrayList;
import java.util.List;

import vo.RelationVO;

public class RelationListDAO {
	private List<RelationVO> relationVOList;
	private List<RelationVO> addedRelationVOList;
	private List<RelationVO> deletedRelationVOList;
	private List<RelationVO> editedRelationVOList;
	
	
	public RelationListDAO() {
		relationVOList = new ArrayList<RelationVO>();
		addedRelationVOList = new ArrayList<RelationVO>();
		deletedRelationVOList = new ArrayList<RelationVO>();
		editedRelationVOList = new ArrayList<RelationVO>();
	}


	public RelationListDAO(List<RelationVO> relationVOList, List<RelationVO> addedRelationVOList,
			List<RelationVO> deletedRelationVOList, List<RelationVO> editedRelationVOList) {
		super();
		this.relationVOList = relationVOList;
		this.addedRelationVOList = addedRelationVOList;
		this.deletedRelationVOList = deletedRelationVOList;
		this.editedRelationVOList = editedRelationVOList;
	}


	public List<RelationVO> getRelationVOList() {
		return relationVOList;
	}


	public void setRelationVOList(List<RelationVO> relationVOList) {
		this.relationVOList = relationVOList;
	}


	public List<RelationVO> getAddedRelationVOList() {
		return addedRelationVOList;
	}


	public void setAddedRelationVOList(List<RelationVO> addedRelationVOList) {
		this.addedRelationVOList = addedRelationVOList;
	}


	public List<RelationVO> getDeletedRelationVOList() {
		return deletedRelationVOList;
	}


	public void setDeletedRelationVOList(List<RelationVO> deletedRelationVOList) {
		this.deletedRelationVOList = deletedRelationVOList;
	}


	public List<RelationVO> getEditedRelationVOList() {
		return editedRelationVOList;
	}


	public void setEditedRelationVOList(List<RelationVO> editedRelationVOList) {
		this.editedRelationVOList = editedRelationVOList;
	}
	public RelationVO searchRelationVO(byte requestType, int sender, int receiver){
		if(relationVOList == null){
			return null;
		}
		for(RelationVO temp : relationVOList){
			if(temp.getRequestType() == requestType && temp.getSender() == sender && temp.getReceiver() == receiver){
				return temp;
			}
		}
		return null;
	}
	public List<RelationVO> searchRelationVOBySender(byte requestType, int sender){
		if(relationVOList == null){
			return null;
		}
		List<RelationVO> tempList = new ArrayList<RelationVO>();
		for(RelationVO temp : relationVOList){
			if(temp.getRequestType() == requestType && temp.getSender() == sender){
				tempList.add(temp);
			}
		}
		if(tempList.size() == 0)
			return null;
		return tempList;
	}
	public List<RelationVO> searchRelationVOByReceiver(byte requestType, int receiver){
		if(relationVOList == null){
			return null;
		}
		List<RelationVO> tempList = new ArrayList<RelationVO>();
		for(RelationVO temp : relationVOList){
			if(temp.getRequestType() == requestType && temp.getReceiver() == receiver){
				tempList.add(temp);
			}
		}
		if(tempList.size() == 0)
			return null;
		return tempList;		
	}
	public void addRelationVO(RelationVO relationVO){
		relationVOList.add(relationVO);
		addedRelationVOList.add(relationVO);
	}
	public void addRelationVOList(byte requestType, String date, int sender, int receiver, String receiverNick){
		addRelationVO(new RelationVO(requestType,date,sender,receiver,receiverNick));
	}
	public boolean deleteRelationVO(RelationVO relationVO){
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
		RelationVO temp = searchRelationVO(requestType, sender, receiver);
		if(temp == null)
			return false;
		if(!relationVOList.remove(temp)){
			return false;
		}
		deletedRelationVOList.add(temp);
		return true;
	}
	
	public void readFromDB(){
		
	}
	public void writeToDB(){
			
	}
	
}
