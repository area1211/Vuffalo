package vo;

public class MemberVO {
	private int memberNum;
	private String memberId;
	private String nickName;
	private String password;
	private String email;
	private byte grade;
	private int activePoint;
	private String joinDate;
	private byte state;
	public MemberVO() {
		super();
	}
	public MemberVO(int memberNum, String memberId, String nickName, String password, String email, byte grade,
			int activePoint, String joinDate, byte state) {
		super();
		this.memberNum = memberNum;
		this.memberId = memberId;
		this.nickName = nickName;
		this.password = password;
		this.email = email;
		this.grade = grade;
		this.activePoint = activePoint;
		this.joinDate = joinDate;
		this.state = state;
	}
	
	public int getMemberNum() {
		return memberNum;
	}
	public void setMemberNum(int memberNum) {
		this.memberNum = memberNum;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public byte getGrade() {
		return grade;
	}
	public void setGrade(byte grade) {
		this.grade = grade;
	}
	public int getActivePoint() {
		return activePoint;
	}
	public void setActivePoint(int activePoint) {
		this.activePoint = activePoint;
	}
	public String getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}
	public byte getState() {
		return state;
	}
	public void setState(byte state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "MemberVO [memberNum=" + memberNum + ", memberId=" + memberId + ", nickName=" + nickName + ", password="
				+ password + ", email=" + email + ", grade=" + grade + ", activePoint=" + activePoint + ", joinDate="
				+ joinDate + ", state=" + state + "]";
	}
	
	
}
