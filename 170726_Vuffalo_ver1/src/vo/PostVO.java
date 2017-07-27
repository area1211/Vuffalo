package vo;

public class PostVO {
   private int postNum;
   private int boardNum;
   private String title;
   private String text;
   private byte imgFlag;
   private String writeDate;
   private byte deleteFlag;
   private int memberNum;
   private String nickName;
   private String fileUrl;
   private int hit;
   public PostVO() {
      super();
   }
   public PostVO(int postNum, int boardNum, String title, String text, byte imgFlag, String writeDate, byte deleteFlag,
		int memberNum, String nickName, String fileUrl, int hit) {
	super();
	this.postNum = postNum;
	this.boardNum = boardNum;
	this.title = title;
	this.text = text;
	this.imgFlag = imgFlag;
	this.writeDate = writeDate;
	this.deleteFlag = deleteFlag;
	this.memberNum = memberNum;
	this.nickName = nickName;
	this.fileUrl = fileUrl;
	this.hit = hit;
}

public int getHit() {
	return hit;
}
public void setHit(int hit) {
	this.hit = hit;
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
   public String getTitle() {
      return title;
   }
   public void setTitle(String title) {
      this.title = title;
   }
   public String getText() {
      return text;
   }
   public void setText(String text) {
      this.text = text;
   }
   public byte getImgFlag() {
      return imgFlag;
   }
   public void setImgFlag(byte imgFlag) {
      this.imgFlag = imgFlag;
   }
   public String getWriteDate() {
      return writeDate;
   }
   public void setWriteDate(String writeDate) {
      this.writeDate = writeDate;
   }
   public byte getDeleteFlag() {
      return deleteFlag;
   }
   public void setDeleteFlag(byte deleteFlag) {
      this.deleteFlag = deleteFlag;
   }
   public int getMemberNum() {
      return memberNum;
   }
   public void setMemberNum(int memberNum) {
      this.memberNum = memberNum;
   }
   public String getNickName() {
      return nickName;
   }
   public void setNickName(String nickName) {
      this.nickName = nickName;
   }
   public String getFileUrl() {
      return fileUrl;
   }
   public void setFileUrl(String fileUrl) {
      this.fileUrl = fileUrl;
   }
@Override
public String toString() {
	return "PostVO [postNum=" + postNum + ", boardNum=" + boardNum + ", title=" + title + ", text=" + text
			+ ", imgFlag=" + imgFlag + ", writeDate=" + writeDate + ", deleteFlag=" + deleteFlag + ", memberNum="
			+ memberNum + ", nickName=" + nickName + ", fileUrl=" + fileUrl + ", hit=" + hit + "]";
}
}