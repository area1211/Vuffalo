package vo;

public class CommentVO {
	private int boardNum;
	private int postNum;
	private int commentNum;
	private int depth;
	private int upperCommentNum;
	private String description;
	private String writer;
	private String date;
	private int memberNum;

	public CommentVO() {
		super();
	}

	public CommentVO(int boardNum, int postNum, int commentNum, int depth, int upperCommentNum, String description,
			String writer, String date, int memberNum) {
		super();
		this.boardNum = boardNum;
		this.postNum = postNum;
		this.commentNum = commentNum;
		this.depth = depth;
		this.upperCommentNum = upperCommentNum;
		this.description = description;
		this.writer = writer;
		this.date = date;
		this.memberNum = memberNum;
	}

	public int getMemberNum() {
		return memberNum;
	}

	public void setMemberNum(int memberNum) {
		this.memberNum = memberNum;
	}

	public int getBoardNum() {
		return boardNum;
	}

	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}

	public int getPostNum() {
		return postNum;
	}

	public void setPostNum(int postNum) {
		this.postNum = postNum;
	}

	public int getCommentNum() {
		return commentNum;
	}

	public void setCommentNum(int commentNum) {
		this.commentNum = commentNum;
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	public int getUpperCommentNum() {
		return upperCommentNum;
	}

	public void setUpperCommentNum(int upperCommentNum) {
		this.upperCommentNum = upperCommentNum;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Comment [boardNum=" + boardNum + ", postNum=" + postNum + ", commentNum=" + commentNum + ", depth="
				+ depth + ", upperCommentNum=" + upperCommentNum + ", description=" + description + ", writer=" + writer
				+ ", date=" + date + "]";
	}

}
