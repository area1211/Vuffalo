package dao;

import java.util.ArrayList;
import java.util.List;

import vo.ReportVO;

public class ReportListDAO {
	private static ReportListDAO instance;
	private List<ReportVO> reportVOList;
	private List<ReportVO> addedReportVOList;
	private List<ReportVO> deletedReportVOList;
	private List<ReportVO> editedReportVOList;
	
	static{
		instance = new ReportListDAO();
	}
	
	public static ReportListDAO getInstance(){
		return instance;
	}
	
	public ReportListDAO() {
		reportVOList = new ArrayList<ReportVO>();
		addedReportVOList = new ArrayList<ReportVO>();
		deletedReportVOList = new ArrayList<ReportVO>();
		editedReportVOList = new ArrayList<ReportVO>();
	}
	public ReportListDAO(List<ReportVO> reportVOList, List<ReportVO> addedReportVOList,
			List<ReportVO> deletedReportVOList, List<ReportVO> editedReportVOList) {
		super();
		this.reportVOList = reportVOList;
		this.addedReportVOList = addedReportVOList;
		this.deletedReportVOList = deletedReportVOList;
		this.editedReportVOList = editedReportVOList;
	}
	public List<ReportVO> getReportVOList() {
		return reportVOList;
	}
	public void setReportVOList(List<ReportVO> reportVOList) {
		this.reportVOList = reportVOList;
	}
	public List<ReportVO> getAddedReportVOList() {
		return addedReportVOList;
	}
	public void setAddedReportVOList(List<ReportVO> addedReportVOList) {
		this.addedReportVOList = addedReportVOList;
	}
	public List<ReportVO> getDeletedReportVOList() {
		return deletedReportVOList;
	}
	public void setDeletedReportVOList(List<ReportVO> deletedReportVOList) {
		this.deletedReportVOList = deletedReportVOList;
	}
	public List<ReportVO> getEditedReportVOList() {
		return editedReportVOList;
	}
	public void setEditedReportVOList(List<ReportVO> editedReportVOList) {
		this.editedReportVOList = editedReportVOList;
	}
	@Override
	public String toString() {
		return "ReportListDAO [reportVOList=" + reportVOList + ", addedReportVOList=" + addedReportVOList
				+ ", deletedReportVOList=" + deletedReportVOList + ", editedReportVOList=" + editedReportVOList + "]";
	}
	
	public void addReportVO(ReportVO reportVO){
		if(reportVO != null)
		{
			this.reportVOList.add(reportVO);
			this.addedReportVOList.add(reportVO);
		}
	}
	
	public ReportVO searchReportVO(List<ReportVO> list, int postNum, int boardNum){
	      if(list == null){
	         return null;
	      }
	      for(ReportVO temp : list){
	         if(temp.getPostNum() == postNum && temp.getBoardNum()==boardNum){
	            return temp;
	         }
	      }
	      return null;
	   }
	
	public void addReportVO(int postNum, int boardNum, int reportMemberNum,
			String reason, String reportDate){
		ReportVO reportVO = new ReportVO(postNum, boardNum, reportMemberNum,
				reason, reportDate);
		this.reportVOList.add(reportVO);
		this.addedReportVOList.add(reportVO);
	}
	
	
	
	public ReportVO searchReportVO(int postNum, int boardNum){
		if(this.reportVOList == null)
			return null;
		//List<ReportVO> returnList = new ArrayList<ReportVO>();
		for(ReportVO temp : reportVOList){
			if(temp.getPostNum() == postNum && temp.getBoardNum()==boardNum){
	            return temp;
			}
		}
		
		return null;
		/*
		if(returnList.size() == 0)
			return null;
		return returnList;
		*/
	}
	
	public List<ReportVO> searchReportVO(int reportMemberNum){
		if(this.reportVOList == null)
			return null;
		List<ReportVO> returnList = new ArrayList<ReportVO>();
		for(ReportVO temp : reportVOList){
			if(temp.getReportMemberNum() == reportMemberNum){
				returnList.add(temp);
			}
		}
		if(returnList.size() == 0)
			return null;
		return returnList;
	}
	
	public List<ReportVO> searchReportVO(String reportDate){
		if(this.reportVOList == null)
			return null;
		List<ReportVO> returnList = new ArrayList<ReportVO>();
		for(ReportVO temp : reportVOList){
			if(temp.getReportDate().equals(reportDate)){
				returnList.add(temp);
			}
		}
		if(returnList.size() == 0)
			return null;
		return returnList;
	}
	
	public boolean deleteReportVO(int postNum, int boardNum){
		if(reportVOList == null){
			return false;
		}
		
		ReportVO reportVO = this.searchReportVO(postNum, boardNum);
		if(!reportVOList.remove(reportVO)){
			return false;
		}
		this.deletedReportVOList.add(reportVO);
		return true;
	}
	
	public boolean deleteReportVO(ReportVO reportVO){
		if(reportVOList == null)
			return false;
		if(reportVO == null)
			return false;
		
		ReportVO temp = this.searchReportVO(reportVO.getPostNum(), reportVO.getBoardNum());
		if(!reportVOList.remove(temp)){
			return false;
		}
		this.deletedReportVOList.add(temp);
		return true;
	}
	
	public boolean editReportVO(int postNum, int boardNum, String reason, String reportDate){
		if(reportVOList == null)
			return false;
		if(searchReportVO(postNum, boardNum)==null)
			return false;
		
		ReportVO reportVO = this.searchReportVO(postNum, boardNum);
		reportVO.setReason(reason);
		reportVO.setReportDate(reportDate);
		
		this.editedReportVOList.add(searchReportVO(postNum, boardNum));
		return true;
	}
	
	public boolean editReason(int postNum, int boardNum, String reason){
		if(reportVOList == null)
			return false;
		if(searchReportVO(postNum, boardNum) == null)
			return false;
		
		ReportVO reportVO = this.searchReportVO(postNum,  boardNum);
		reportVO.setReason(reason);
		
		this.editedReportVOList.add(searchReportVO(postNum, boardNum));
		return true;
	}
	
	public boolean editReportDate(int postNum, int boardNum, String reportDate){
		if(reportVOList == null)
			return false;
		if(searchReportVO(postNum, boardNum) == null)
			return false;
		
		ReportVO reportVO = this.searchReportVO(postNum, boardNum);
		reportVO.setReportDate(reportDate);
		
		this.editedReportVOList.add(searchReportVO(postNum, boardNum));
		return true;
	}
	
	public void writeToDB(){
		
	}
	
	public void ReadFromDB(){
		
	}
}
