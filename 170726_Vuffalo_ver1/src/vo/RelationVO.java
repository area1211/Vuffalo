package vo;

public class RelationVO {
	private byte requestType;
	private String date;
	private int sender;
	private int receiver;
	private String receiverNick;
	public RelationVO() {
		super();
	}
	public RelationVO(byte requestType, String date, int sender, int receiver, String receiverNick) {
		super();
		this.requestType = requestType;
		this.date = date;
		this.sender = sender;
		this.receiver = receiver;
		this.receiverNick = receiverNick;
	}
	public byte getRequestType() {
		return requestType;
	}
	public void setRequestType(byte requestType) {
		this.requestType = requestType;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
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
	public String getReceiverNick() {
		return receiverNick;
	}
	public void setReceiverNick(String receiverNick) {
		this.receiverNick = receiverNick;
	}
	@Override
	public String toString() {
		return "RelationVO [requestType=" + requestType + ", date=" + date + ", sender=" + sender + ", receiver="
				+ receiver + ", receiverNick=" + receiverNick + "]";
	}

	
	
}
