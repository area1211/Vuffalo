package com.lecto.vo;

public class RelationViewVO {
	private int sender;
	private int relation;
	private int receiver;
	private String receiverNick;
	private String date;
	
	public RelationViewVO(){
		
	}

	public RelationViewVO(int sender, int relation, int receiver, String receiverNick, String date) {
		super();
		this.sender = sender;
		this.relation = relation;
		this.receiver = receiver;
		this.receiverNick = receiverNick;
		this.date = date;
	}

	public int getSender() {
		return sender;
	}

	public void setSender(int sender) {
		this.sender = sender;
	}

	public int getRelation() {
		return relation;
	}

	public void setRelation(int relation) {
		this.relation = relation;
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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "RelationVO [sender=" + sender + ", relation=" + relation + ", receiver=" + receiver + ", receiverNick="
				+ receiverNick + ", date=" + date + "]";
	}
	
	
}
