package vo;

public class ReportVO {
	private int postNum;
	private int boardNum;
	private int reportMemberNum;
	private String reason;
	private String reportDate;
	public ReportVO() {
		super();
	}
	public ReportVO(int postNum, int boardNum, int reportMemberNum, String reason, String reportDate) {
		super();
		this.postNum = postNum;
		this.boardNum = boardNum;
		this.reportMemberNum = reportMemberNum;
		this.reason = reason;
		this.reportDate = reportDate;
	}
	public int getPostNum() {
		return postNum;
	}
	public void setPostNum(int postNum) {
		this.postNum = postNum;
	}
	public int getBoardNum() {
		return boardNum;
	}
	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}
	public int getReportMemberNum() {
		return reportMemberNum;
	}
	public void setReportMemberNum(int reportMemberNum) {
		this.reportMemberNum = reportMemberNum;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getReportDate() {
		return reportDate;
	}
	public void setReportDate(String reportDate) {
		this.reportDate = reportDate;
	}
	@Override
	public String toString() {
		return "ReportVO [postNum=" + postNum + ", boardNum=" + boardNum + ", reportMemberNum=" + reportMemberNum
				+ ", reason=" + reason + ", reportDate=" + reportDate + "]";
	}
	
	
}
