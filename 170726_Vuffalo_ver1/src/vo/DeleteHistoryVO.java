package vo;

public class DeleteHistoryVO {
	private int postNum;
	private String writer;
	private String title;
	private String postText;
	private String deleteDate;
	private String deleteReason;
	
	public DeleteHistoryVO() {
	}

	public DeleteHistoryVO(int postNum, String writer, String title, String postText, String deleteDate,
			String deleteReason) {
		super();
		this.postNum = postNum;
		this.writer = writer;
		this.title = title;
		this.postText = postText;
		this.deleteDate = deleteDate;
		this.deleteReason = deleteReason;
	}

	public int getPostNum() {
		return postNum;
	}

	public void setPostNum(int postNum) {
		this.postNum = postNum;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPostText() {
		return postText;
	}

	public void setPostText(String postText) {
		this.postText = postText;
	}

	public String getDeleteDate() {
		return deleteDate;
	}

	public void setDeleteDate(String deleteDate) {
		this.deleteDate = deleteDate;
	}

	public String getDeleteReason() {
		return deleteReason;
	}

	public void setDeleteReason(String deleteReason) {
		this.deleteReason = deleteReason;
	}
	
}
