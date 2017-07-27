package com.lecto.vo;

public class ProfileViewVO {
	private int num;
	private String nickname;
	private String email;
	private int age;
	private String mTongue;
	private String interest;
	private int gender;
	private String nationality;
	private String selfIntro;
	private int openRange;
	private int fileFlag;
	private String lastVisitDate;
	private String lastProfileUpdate;
	private String fileURL;
	public ProfileViewVO() {
		super();
	}
	public ProfileViewVO(int num, String nickname, String email, int age, String mTongue, String interest, int gender,
			String nationality, String selfIntro, int openRange, int fileFlag, String lastVisitDate,
			String lastProfileUpdate, String fileURL) {
		super();
		this.num = num;
		this.nickname = nickname;
		this.email = email;
		this.age = age;
		this.mTongue = mTongue;
		this.interest = interest;
		this.gender = gender;
		this.nationality = nationality;
		this.selfIntro = selfIntro;
		this.openRange = openRange;
		this.fileFlag = fileFlag;
		this.lastVisitDate = lastVisitDate;
		this.lastProfileUpdate = lastProfileUpdate;
		this.fileURL = fileURL;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getmTongue() {
		return mTongue;
	}
	public void setmTongue(String mTongue) {
		this.mTongue = mTongue;
	}
	public String getInterest() {
		return interest;
	}
	public void setInterest(String interest) {
		this.interest = interest;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public String getSelfIntro() {
		return selfIntro;
	}
	public void setSelfIntro(String selfIntro) {
		this.selfIntro = selfIntro;
	}
	public int getOpenRange() {
		return openRange;
	}
	public void setOpenRange(int openRange) {
		this.openRange = openRange;
	}
	public int getFileFlag() {
		return fileFlag;
	}
	public void setFileFlag(int fileFlag) {
		this.fileFlag = fileFlag;
	}
	public String getLastVisitDate() {
		return lastVisitDate;
	}
	public void setLastVisitDate(String lastVisitDate) {
		this.lastVisitDate = lastVisitDate;
	}
	public String getLastProfileUpdate() {
		return lastProfileUpdate;
	}
	public void setLastProfileUpdate(String lastProfileUpdate) {
		this.lastProfileUpdate = lastProfileUpdate;
	}
	public String getFileURL() {
		return fileURL;
	}
	public void setFileURL(String fileURL) {
		this.fileURL = fileURL;
	}
	@Override
	public String toString() {
		return "ProfileViewVO [num=" + num + ", nickname=" + nickname + ", email=" + email + ", age=" + age
				+ ", mTongue=" + mTongue + ", interest=" + interest + ", gender=" + gender + ", nationality="
				+ nationality + ", selfIntro=" + selfIntro + ", openRange=" + openRange + ", fileFlag=" + fileFlag
				+ ", lastVisitDate=" + lastVisitDate + ", lastProfileUpdate=" + lastProfileUpdate + ", fileURL="
				+ fileURL + "]";
	}
	
}
