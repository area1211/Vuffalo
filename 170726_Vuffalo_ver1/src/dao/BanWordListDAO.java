package dao;

import java.util.ArrayList;
import java.util.List;

import vo.BanWordVO;

public class BanWordListDAO {
	
	private static BanWordListDAO instance;
	private List<BanWordVO> banWordVOList;
	private List<BanWordVO> addedBanWordVOList;
	private List<BanWordVO> deletedBanWordVOList;
	private List<BanWordVO> editedBanWordVOList;
	
	
	static{
		instance = new BanWordListDAO();
	}
	
	public static BanWordListDAO getInstance(){
		return instance;
	}
	
	private BanWordListDAO() {
		this.banWordVOList = new ArrayList<BanWordVO>();
		this.addedBanWordVOList = new ArrayList<BanWordVO>();
		this.deletedBanWordVOList = new ArrayList<BanWordVO>();
		this.editedBanWordVOList = new ArrayList<BanWordVO>();
	}
	
	public List<BanWordVO> getBanWordVOList() {
		return banWordVOList;
	}

	public void setBanWordVOList(List<BanWordVO> banWordVOList) {
		this.banWordVOList = banWordVOList;
	}

	public List<BanWordVO> getAddedBanWordVOList() {
		return addedBanWordVOList;
	}

	public void setAddedBanWordVOList(List<BanWordVO> addedBanWordVOList) {
		this.addedBanWordVOList = addedBanWordVOList;
	}

	public List<BanWordVO> getDeletedBanWordVOList() {
		return deletedBanWordVOList;
	}

	public void setDeletedBanWordVOList(List<BanWordVO> deletedBanWordVOList) {
		this.deletedBanWordVOList = deletedBanWordVOList;
	}

	public List<BanWordVO> getEditedBanWordVOList() {
		return editedBanWordVOList;
	}

	public void setEditedBanWordVOList(List<BanWordVO> editedBanWordVOList) {
		this.editedBanWordVOList = editedBanWordVOList;
	}

	public static void setInstance(BanWordListDAO instance) {
		BanWordListDAO.instance = instance;
	}

	private BanWordListDAO(List<BanWordVO> banWordVOList, List<BanWordVO> addedBanWordVOList,
			List<BanWordVO> deletedBanWordVOList, List<BanWordVO> editedBanWordVOList) {
		super();
		this.banWordVOList = banWordVOList;
		this.addedBanWordVOList = addedBanWordVOList;
		this.deletedBanWordVOList = deletedBanWordVOList;
		this.editedBanWordVOList = editedBanWordVOList;
	}
	
	public void addBanWordVO(BanWordVO banWordVO){
		if(banWordVO != null){
			banWordVOList.add(banWordVO);
			addedBanWordVOList.add(banWordVO);
		}
	}
	
	public void addBanWordVO(String banWord){
		if(banWord!= null && banWord.length() != 0){
		BanWordVO banWordVO = new BanWordVO(banWord);
		banWordVOList.add(banWordVO);
		addedBanWordVOList.add(banWordVO);
		}
	}
	
	public BanWordVO searchBanWordVO(List<BanWordVO>tempList, String banWord){
		if(tempList == null){
			return null;
		}
		for(BanWordVO temp : tempList){
			if(temp.getBanWord().equals(banWord)){
				return temp;
			}
		}
		return null;
	}
	public BanWordVO searchBanWordVO(String banWord){
		if(banWord != null){
			for(BanWordVO temp : this.banWordVOList){
				if(temp.getBanWord().equals(banWord)){
					return temp;
				}
			}
		}
		return null;
	}
	
	public boolean deleteBanWordVO(String banWord){
		if(banWord == null||banWordVOList == null){
			return false;
		}
		BanWordVO temp = searchBanWordVO(banWord);
		if(temp == null){
			return false;
		}
		if(!banWordVOList.remove(temp)){
			return false;
		}
		deletedBanWordVOList.add(temp);
		return true;
	}
	public boolean deleteBanWordVO(BanWordVO banWordVO){
		if(banWordVO == null||banWordVOList == null){
			return false;
		}
		if(!(banWordVOList.remove(banWordVO))){
			return false;
		}
		deletedBanWordVOList.add(banWordVO);
		return true;
	}
}