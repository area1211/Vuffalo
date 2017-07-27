package vo;

public class MailVO {
	private int mailNum;
	private String title;
	private String description;
	private String sendDate;
	private String readDate;
	private byte imgFlag;
	private String fileUrl;
	private int sender;
	private int receiver;
	public MailVO() {
		super();
	}
	public MailVO(int mailNum, String title, String description, String sendDate, String readDate, byte imgFlag,
			String fileUrl, int sender, int receiver) {
		super();
		this.mailNum = mailNum;
		this.title = title;
		this.description = description;
		this.sendDate = sendDate;
		this.readDate = readDate;
		this.imgFlag = imgFlag;
		this.fileUrl = fileUrl;
		this.sender = sender;
		this.receiver = receiver;
	}
	public int getMailNum() {
		return mailNum;
	}
	public void setMailNum(int mailNum) {
		this.mailNum = mailNum;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
	public byte getImgFlag() {
		return imgFlag;
	}
	public void setImgFlag(byte imgFlag) {
		this.imgFlag = imgFlag;
	}
	public String getFileUrl() {
		return fileUrl;
	}
	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}
	public int getSender() {
		return sender;
	}
	public void setSender(int sender) {
		this.sender = sender;
	}
	public int getReceiver() {
		return receiver;
	}
	public void setReceiver(int receiver) {
		this.receiver = receiver;
	}
	@Override
	public String toString() {
		return "MailVO [mailNum=" + mailNum + ", title=" + title + ", description=" + description + ", sendDate="
				+ sendDate + ", readDate=" + readDate + ", imgFlag=" + imgFlag + ", fileUrl=" + fileUrl + ", sender="
				+ sender + ", receiver=" + receiver + "]";
	}
	
	
}
