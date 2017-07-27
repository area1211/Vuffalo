package vo;

public class BoardVO {
	private int boardNum;
	private String boardName;
	private String description;
	private byte writePermission;
	private byte commentWritePermission;
	private byte openRange;
	
	
	
	public BoardVO() {
		super();
	}

	public BoardVO(int boardNum, String boardName, String description, byte writePermission,
			byte commentWritePermission, byte openRange) {
		super();
		this.boardNum = boardNum;
		this.boardName = boardName;
		this.description = description;
		this.writePermission = writePermission;
		this.commentWritePermission = commentWritePermission;
		this.openRange = openRange;
	}

	public int getBoardNum() {
		return boardNum;
	}

	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}

	public String getBoardName() {
		return boardName;
	}

	public void setBoardName(String boardName) {
		this.boardName = boardName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public byte getWritePermission() {
		return writePermission;
	}

	public void setWritePermission(byte writePermission) {
		this.writePermission = writePermission;
	}

	public byte getCommentWritePermission() {
		return commentWritePermission;
	}

	public void setCommentWritePermission(byte commentWritePermission) {
		this.commentWritePermission = commentWritePermission;
	}

	public byte getOpenRange() {
		return openRange;
	}

	public void setOpenRange(byte openRange) {
		this.openRange = openRange;
	}

	@Override
	public String toString() {
		return "BoardVO [boardNum=" + boardNum + ", boardName=" + boardName + ", description=" + description
				+ ", writePermission=" + writePermission + ", commentWritePermission=" + commentWritePermission
				+ ", openRange=" + openRange + "]";
	}
	
	
}
