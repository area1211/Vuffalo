package manager;

import dao.DailyActiveListDAO;
import dao.MemberActivityListDAO;
import dao.MemberListDAO;
import dao.MemberVisitationListDAO;
import util.DateUtil;

public class JoinManager {
	private MemberListDAO memberListDAO;
	private MemberActivityListDAO memberActivityListDAO;
	private MemberVisitationListDAO memberVisitationListDAO;
	private DailyActiveListDAO dailyActiveListDAO;
	public JoinManager() {
		super();
		this.memberListDAO=MemberListDAO.getInstance();
		this.memberActivityListDAO=MemberActivityListDAO.getInstance();
		this.memberVisitationListDAO=MemberVisitationListDAO.getInstance();
		this.dailyActiveListDAO=DailyActiveListDAO.getInstance();
	}
	public JoinManager(MemberListDAO memberListDAO, MemberActivityListDAO memberActivityListDAO,
			MemberVisitationListDAO memberVisitationListDAO, DailyActiveListDAO dailyActiveListDAO) {
		super();
		this.memberListDAO = memberListDAO;
		this.memberActivityListDAO = memberActivityListDAO;
		this.memberVisitationListDAO = memberVisitationListDAO;
		this.dailyActiveListDAO = dailyActiveListDAO;
	}
	
	public void join(String nickName,String memberId,String password, String email){
		
		int memberNum = this.memberListDAO.getMemberNum();
		//System.out.println(memberNum);
		String today = DateUtil.getToday();
		this.memberListDAO.addMemberVO(memberNum,memberId, nickName, password, email, (byte)1, 0, today, (byte)1);
		this.memberActivityListDAO.addMemeberActivityListDAO(memberNum, 0, 0, 0);
		this.memberVisitationListDAO.addMemberVisitationVO(memberNum, 0, today, today);
		this.dailyActiveListDAO.addDailyActiveVO(memberNum, 0);
		
		this.memberListDAO.writeToDB();
		this.memberActivityListDAO.writeToDB();
		this.memberVisitationListDAO.writeToDB();
		this.dailyActiveListDAO.writeToDB();
		
		//System.out.println(this.memberListDAO);
		//System.out.println(this.memberActivityListDAO);
		//System.out.println(this.memberVisitationListDAO);
		//System.out.println(this.dailyActiveListDAO);
	}
	
	public MemberListDAO getMemberListDAO() {
		return memberListDAO;
	}
	public void setMemberListDAO(MemberListDAO memberListDAO) {
		this.memberListDAO = memberListDAO;
	}
	public MemberActivityListDAO getMemberActivityListDAO() {
		return memberActivityListDAO;
	}
	public void setMemberActivityListDAO(MemberActivityListDAO memberActivityListDAO) {
		this.memberActivityListDAO = memberActivityListDAO;
	}
	public MemberVisitationListDAO getMemberVisitationListDAO() {
		return memberVisitationListDAO;
	}
	public void setMemberVisitationListDAO(MemberVisitationListDAO memberVisitationListDAO) {
		this.memberVisitationListDAO = memberVisitationListDAO;
	}
	public DailyActiveListDAO getDailyActiveListDAO() {
		return dailyActiveListDAO;
	}
	public void setDailyActiveListDAO(DailyActiveListDAO dailyActiveListDAO) {
		this.dailyActiveListDAO = dailyActiveListDAO;
	}
	@Override
	public String toString() {
		return "JoinManager [memberListDAO=" + memberListDAO + ", memberActivityListDAO=" + memberActivityListDAO
				+ ", memberVisitationListDAO=" + memberVisitationListDAO + ", dailyActiveListDAO=" + dailyActiveListDAO
				+ "]";
	}
	
}
