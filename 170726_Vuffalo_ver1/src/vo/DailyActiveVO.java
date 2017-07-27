package vo;

public class DailyActiveVO {
	private int memberNum;
	private int activePoint;
	
	public DailyActiveVO() {
		super();
	}
	public DailyActiveVO(int memberNum, int activePoint) {
		super();
		this.memberNum = memberNum;
		this.activePoint = activePoint;
	}
	public int getMemberNum() {
		return memberNum;
	}
	public void setMemberNum(int memberNum) {
		this.memberNum = memberNum;
	}
	public int getActivePoint() {
		return activePoint;
	}
	public void setActivePoint(int activePoint) {
		this.activePoint = activePoint;
	}
	public String toString() {
		return "DailyActiveVO [memberNum=" + memberNum + ", activePoint=" + activePoint + "]";
	}
}
