package vo;

public class MemberActivityVO {
	private int memberNum;
	private int activePoint;
	private int commentCount;
	private int postCount;
	
	public MemberActivityVO() {
	}
	public MemberActivityVO(int memberNum, int activePoint, int commentCount,int postCount) {
		super();
		this.memberNum = memberNum;
		this.activePoint = activePoint;
		this.commentCount = commentCount;
		this.postCount=postCount;
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
	public int getCommentCount() {
		return commentCount;
	}
	public void setCommentCount(int commentCount) {
		this.commentCount = commentCount;
	}
	public int getPostCount() {
		return postCount;
	}
	public void setPostCount(int postCount) {
		this.postCount = postCount;
	}
	public String toString() {
		return "MemberActivityVO [memberNum=" + memberNum + ", activePoint=" + activePoint + ", commentCount="
				+ commentCount + ", postCount=" + postCount + "]";
	}
	
}
