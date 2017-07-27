package vo;

public class MailViewVO {
	private int mailNum;
	private int receiverNum;
	private int senderNum;
	private String title;
	private String content;
	private byte fileFlag;
	private String sendDate;
	private String readDate;
	private String fileUrl;
	private String senderNickName;
	private String receiverNickName;
	public MailViewVO() {
		super();
	}
	public MailViewVO(int mailNum, int receiverNum, int senderNum, String title, String content, byte fileFlag,
			String sendDate, String readDate, String fileUrl, String senderNickName, String receiverNickName) {
		super();
		this.mailNum = mailNum;
		this.receiverNum = receiverNum;
		this.senderNum = senderNum;
		this.title = title;
		this.content = content;
		this.fileFlag = fileFlag;
		this.sendDate = sendDate;
		this.readDate = readDate;
		this.fileUrl = fileUrl;
		this.senderNickName = senderNickName;
		this.receiverNickName = receiverNickName;
	}
	public int getMailNum() {
		return mailNum;
	}
	public void setMailNum(int mailNum) {
		this.mailNum = mailNum;
	}
	public int getReceiverNum() {
		return receiverNum;
	}
	public void setReceiverNum(int receiverNum) {
		this.receiverNum = receiverNum;
	}
	public int getSenderNum() {
		return senderNum;
	}
	public void setSenderNum(int senderNum) {
		this.senderNum = senderNum;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public byte getFileFlag() {
		return fileFlag;
	}
	public void setFileFlag(byte fileFlag) {
		this.fileFlag = fileFlag;
	}
	public String getSendDate() {
		return sendDate;
	}
	public void setSendDate(String sendDate) {
		this.sendDate = sendDate;
	}
	public String getReadDate() {
		return readDate;
	}
	public void setReadDate(String readDate) {
		this.readDate = readDate;
	}
	public String getFileUrl() {
		return fileUrl;
	}
	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}
	public String getSenderNickName() {
		return senderNickName;
	}
	public void setSenderNickName(String senderNickName) {
		this.senderNickName = senderNickName;
	}
	public String getReceiverNickName() {
		return receiverNickName;
	}
	public void setReceiverNickName(String receiverNickName) {
		this.receiverNickName = receiverNickName;
	}
	@Override
	public String toString() {
		return "MailViewVO [mailNum=" + mailNum + ", receiverNum=" + receiverNum + ", senderNum=" + senderNum
				+ ", title=" + title + ", content=" + content + ", fileFlag=" + fileFlag + ", sendDate=" + sendDate
				+ ", readDate=" + readDate + ", fileUrl=" + fileUrl + ", senderNickName=" + senderNickName
				+ ", receiverNickName=" + receiverNickName + "]";
	}
	
	
}
