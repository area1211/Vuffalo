package manager;

import dao.MemberActivityListDAO;
import dao.MemberListDAO;
import dao.MemberVisitationListDAO;


public class LogoutManager {
	private MemberListDAO memberListDAO;
	private MemberVisitationListDAO memberVisitationListDAO;
	private MemberActivityListDAO MemberActivityListDAO;
	
	public LogoutManager(){
		this.memberListDAO=MemberListDAO.getInstance();
		this.memberVisitationListDAO=MemberVisitationListDAO.getInstance();
		this.MemberActivityListDAO=MemberActivityListDAO.getInstance();
	}

	public LogoutManager(MemberListDAO memberListDAO, MemberVisitationListDAO memberVisitationListDAO,MemberActivityListDAO memberActivityListDAO) {
		super();
		this.memberListDAO = memberListDAO;
		this.memberVisitationListDAO = memberVisitationListDAO;
		this.MemberActivityListDAO=memberActivityListDAO;
	}
	
	public void logout(int codeNum,int activePoint,String lastVisitDate){
		
		//��ȣȭ
		int decodeNum = codeNum;
		//System.out.println("�α׾ƿ��� ���� ������"+codeNum+","+activePoint+","+lastVisitDate);
		
		if(lastVisitDate!=null){
			boolean changeActivePoint = this.MemberActivityListDAO.editMemberActivityVOAddActivePoint(codeNum, activePoint);
			//System.out.println("Ȱ���������� : "+changeActivePoint);
			boolean changeVisitDate = this.memberVisitationListDAO.editLastVisitDate(codeNum, lastVisitDate);
			//System.out.println("�������湮 : "+changeVisitDate);
			
			this.memberVisitationListDAO.writeToDB();
			this.MemberActivityListDAO.writeToDB();
		}
		
	}
	
	public MemberListDAO getMemberListDAO() {
		return memberListDAO;
	}

	public void setMemberListDAO(MemberListDAO memberListDAO) {
		this.memberListDAO = memberListDAO;
	}

	public MemberVisitationListDAO getMemberVisitationListDAO() {
		return memberVisitationListDAO;
	}

	public void setMemberVisitationListDAO(MemberVisitationListDAO memberVisitationListDAO) {
		this.memberVisitationListDAO = memberVisitationListDAO;
	}

	public String toString() {
		return "LogoutManager [memberListDAO=" + memberListDAO + ", memberVisitationListDAO=" + memberVisitationListDAO
				+ "]";
	}
	
	
	
}
