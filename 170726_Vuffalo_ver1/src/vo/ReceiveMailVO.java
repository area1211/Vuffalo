package vo;

public class ReceiveMailVO {
	private int recevieMailNum;
	private String sender;
	private String title;
	private String mailText;
	private String date;
	
	public ReceiveMailVO() {
	}
	public ReceiveMailVO(int recevieMailNum,String sender, String title, String mailText, String date) {
		super();
		this.recevieMailNum = recevieMailNum;
		this.sender = sender;
		this.title = title;
		this.mailText = mailText;
		this.date = date;
	}
	public int getRecevieMailNum() {
		return recevieMailNum;
	}
	public void setRecevieMailNum(int recevieMailNum) {
		this.recevieMailNum = recevieMailNum;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getMailText() {
		return mailText;
	}
	public void setMailText(String mailText) {
		this.mailText = mailText;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	
}
