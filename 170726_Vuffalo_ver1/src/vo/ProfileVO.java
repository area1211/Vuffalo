package vo;

public class ProfileVO {
	private int memberNum;
	private int gender;
	private int age;
	private String country;
	private String motherTongue;
	private String interestLanguage;
	private String introduce;
	private byte fileFlag;
	private byte openRange;
	private String fileUrl;
	private int hit;
	public ProfileVO() {
		super();
	}
	public ProfileVO(int memberNum, int gender, int age, String country, String motherTongue,
			String interestLanguage, String introduce, byte fileFlag, byte openRange, String fileUrl, int hit) {
		super();
		this.memberNum = memberNum;
		this.gender = gender;
		this.age = age;
		this.country = country;
		this.motherTongue = motherTongue;
		this.interestLanguage = interestLanguage;
		this.introduce = introduce;
		this.fileFlag = fileFlag;
		this.openRange = openRange;
		this.fileUrl = fileUrl;
		this.hit = hit;
	}
	public int getMemberNum() {
		return memberNum;
	}
	public void setMemberNum(int memberNum) {
		this.memberNum = memberNum;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getMotherTongue() {
		return motherTongue;
	}
	public void setMotherTongue(String motherTongue) {
		this.motherTongue = motherTongue;
	}
	public String getInterestLanguage() {
		return interestLanguage;
	}
	public void setInterestLanguage(String interestLanguage) {
		this.interestLanguage = interestLanguage;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	public byte getFileFlag() {
		return fileFlag;
	}
	public void setFileFlag(byte fileFlag) {
		this.fileFlag = fileFlag;
	}
	public byte getOpenRange() {
		return openRange;
	}
	public void setOpenRange(byte openRange) {
		this.openRange = openRange;
	}
	public String getFileUrl() {
		return fileUrl;
	}
	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	@Override
	public String toString() {
		return "ProfileVO [memberNum=" + memberNum + ", gender=" + gender + ", age=" + age + ", country=" + country
				+ ", motherTongue=" + motherTongue + ", interestLanguage=" + interestLanguage + ", introduce="
				+ introduce + ", fileFlag=" + fileFlag + ", openRange=" + openRange + ", fileUrl=" + fileUrl + ", hit="
				+ hit + "]";
	}
	
	
}
