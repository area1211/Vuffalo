package vo;

public class LogInfoVO {
	private int memberNum;
	private String logInTime;
	private String logOutTile;
	private int useTime;
	public LogInfoVO() {
		super();
	}
	public LogInfoVO(int memberNum, String logInTime, String logOutTile, int useTime) {
		super();
		this.memberNum = memberNum;
		this.logInTime = logInTime;
		this.logOutTile = logOutTile;
		this.useTime = useTime;
	}
	public int getMemberNum() {
		return memberNum;
	}
	public void setMemberNum(int memberNum) {
		this.memberNum = memberNum;
	}
	public String getLogInTime() {
		return logInTime;
	}
	public void setLogInTime(String logInTime) {
		this.logInTime = logInTime;
	}
	public String getLogOutTile() {
		return logOutTile;
	}
	public void setLogOutTile(String logOutTile) {
		this.logOutTile = logOutTile;
	}
	public int getUseTime() {
		return useTime;
	}
	public void setUseTime(int useTime) {
		this.useTime = useTime;
	}
	@Override
	public String toString() {
		return "LoginInfoVO [memberNum=" + memberNum + ", logInTime=" + logInTime + ", logOutTile=" + logOutTile
				+ ", useTime=" + useTime + "]";
	}
	
	
}
