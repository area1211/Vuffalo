package dao;

import java.util.ArrayList;
import java.util.List;

import connection.BaseDAO;
import connection.DAOException;
import vo.DailyActiveVO;
import vo.MemberActivityVO;
import vo.MemberVisitationVO;

public class DailyActiveListDAO extends BaseDAO{
	private static DailyActiveListDAO instance;
	private List<DailyActiveVO> dailyActiveVOList;
	private List<DailyActiveVO> addedDailyActiveVOList;
	private List<DailyActiveVO> deletedDailyActiveVOList;
	private List<DailyActiveVO> editedDailyActiveVOList;

	static{
		instance=new DailyActiveListDAO();
	}
	
	private DailyActiveListDAO(){
		init();
	}
	
	public void addDailyActiveVO(DailyActiveVO dailyActiveVO){
		this.dailyActiveVOList.add(dailyActiveVO);
		this.addedDailyActiveVOList.add(dailyActiveVO);
	}
	
	public void addDailyActiveVO(int memberNum,int activePoint){
		addDailyActiveVO(new DailyActiveVO(memberNum,activePoint));
	}
	
	public int searchActivePoint(int memberNum){
		for(DailyActiveVO t : dailyActiveVOList){
	         if(t.getMemberNum() == memberNum){
	            return t.getActivePoint();
	         }
	      }
		return 0;
	}
	
	public void init(){
		this.addedDailyActiveVOList= new ArrayList<DailyActiveVO>();
		this.deletedDailyActiveVOList=new ArrayList<DailyActiveVO>();
		this.editedDailyActiveVOList=new ArrayList<DailyActiveVO>();
		try{
			this.dailyActiveVOList=DailyActiveConDAO.getInstance().searchAll();
		}catch(DAOException e){
			e.printStackTrace();
		}	
	}
	public void writeToDB(){
		DailyActiveConDAO.getInstance().addList(addedDailyActiveVOList);
		//DailyActiveConDAO.getInstance().editList(editedDailyActiveVOList);
		//DailyActiveConDAO.getInstance().deleteList(deleteDailyActiveVOList);
		addedDailyActiveVOList = new ArrayList<DailyActiveVO>();
		editedDailyActiveVOList = new ArrayList<DailyActiveVO>();
		deletedDailyActiveVOList = new ArrayList<DailyActiveVO>();
	}

	public static DailyActiveListDAO getInstance() {
		return instance;
	}

	public static void setInstance(DailyActiveListDAO instance) {
		DailyActiveListDAO.instance = instance;
	}

	public List<DailyActiveVO> getDailyActiveVOList() {
		return dailyActiveVOList;
	}

	public void setDailyActiveVOList(List<DailyActiveVO> dailyActiveVOList) {
		this.dailyActiveVOList = dailyActiveVOList;
	}

	public List<DailyActiveVO> getAddedDailyActiveVOList() {
		return addedDailyActiveVOList;
	}

	public void setAddedDailyActiveVOList(List<DailyActiveVO> addedDailyActiveVOList) {
		this.addedDailyActiveVOList = addedDailyActiveVOList;
	}

	public List<DailyActiveVO> getDeleteDailyActiveVOList() {
		return deletedDailyActiveVOList;
	}

	public void setDeleteDailyActiveVOList(List<DailyActiveVO> deletedDailyActiveVOList) {
		this.deletedDailyActiveVOList = deletedDailyActiveVOList;
	}

	public List<DailyActiveVO> getEditedDailyActiveVOList() {
		return editedDailyActiveVOList;
	}

	public void setEditedDailyActiveVOList(List<DailyActiveVO> editedDailyActiveVOList) {
		this.editedDailyActiveVOList = editedDailyActiveVOList;
	}

	public String toString() {
		return "DailyActiveListDAO [dailyActiveVOList=" + dailyActiveVOList + ", addedDailyActiveVOList="
				+ addedDailyActiveVOList + ", deletedDailyActiveVOList=" + deletedDailyActiveVOList
				+ ", editedDailyActiveVOList=" + editedDailyActiveVOList + "]";
	}
	
	
	
}
