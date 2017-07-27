package vo;

public class MemberVisitationVO {
	private int memberNum;
	private int visitCount;
	private String lastVisitDate;
	private String lastProfileUpdateDate;
	public MemberVisitationVO() {
		super();
	}
	public MemberVisitationVO(int memberNum, int visitCount, String lastVisitDate, String lastProfileUpdateDate) {
		super();
		this.memberNum = memberNum;
		this.visitCount = visitCount;
		this.lastVisitDate = lastVisitDate;
		this.lastProfileUpdateDate = lastProfileUpdateDate;
	}
	public int getMemberNum() {
		return memberNum;
	}
	public void setMemberNum(int memberNum) {
		this.memberNum = memberNum;
	}
	public int getVisitCount() {
		return visitCount;
	}
	public void setVisitCount(int visitCount) {
		this.visitCount = visitCount;
	}
	public String getLastVisitDate() {
		return lastVisitDate;
	}
	public void setLastVisitDate(String lastVisitDate) {
		this.lastVisitDate = lastVisitDate;
	}
	public String getLastProfileUpdateDate() {
		return lastProfileUpdateDate;
	}
	public void setLastProfileUpdateDate(String lastProfileUpdateDate) {
		this.lastProfileUpdateDate = lastProfileUpdateDate;
	}
	@Override
	public String toString() {
		return "MemberVisitationVO [memberNum=" + memberNum + ", visitCount=" + visitCount + ", lastVisitDate="
				+ lastVisitDate + ", lastProfileUpdateDate=" + lastProfileUpdateDate + "]";
	}
	
}
