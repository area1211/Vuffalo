package vo;

public class SendMailVO {
	private int sendMailNum;
	private String receiver;
	private String title;
	private String mailText;
	private String date;
	
	public SendMailVO() {
	}
	public SendMailVO(int sendMailNum, String receiver, String title, String mailText, String date) {
		super();
		this.sendMailNum = sendMailNum;
		this.receiver = receiver;
		this.title = title;
		this.mailText = mailText;
		this.date = date;
	}
	public int getSendMailNum() {
		return sendMailNum;
	}
	public void setSendMailNum(int sendMailNum) {
		this.sendMailNum = sendMailNum;
	}
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String reciver) {
		this.receiver = reciver;
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
