package com.lecto.vo;

public class ProfileImageVO {
	private int num;
	private String fileURL;
	public ProfileImageVO() {
		super();
	}
	public ProfileImageVO(int num, String fileURL) {
		super();
		this.num = num;
		this.fileURL = fileURL;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getFileURL() {
		return fileURL;
	}
	public void setFileURL(String fileURL) {
		this.fileURL = fileURL;
	}
	@Override
	public String toString() {
		return "ProfileImageVO [num=" + num + ", fileURL=" + fileURL + "]";
	}
	
	
}
