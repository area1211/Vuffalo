package vo;

public class PostViewVO {
	private int postNum;
	private int postBoardNum;
	private String title;
	private String content;
	private String postDate;
	private int postIsDelete;
	private String nickname;
	private int hit;
	
	public PostViewVO() {
	}
	
	public PostViewVO(int postNum, int postBoardNum, String title, String content, String postDate, int postIsDelete,
			String nickname, int hit) {
		super();
		this.postNum = postNum;
		this.postBoardNum = postBoardNum;
		this.title = title;
		this.content = content;
		this.postDate = postDate;
		this.postIsDelete = postIsDelete;
		this.nickname = nickname;
		this.hit = hit;
	}

	public int getPostNum() {
		return postNum;
	}
	public void setPostNum(int postNum) {
		this.postNum = postNum;
	}
	public int getPostBoardNum() {
		return postBoardNum;
	}
	public void setPostBoardNum(int postBoardNum) {
		this.postBoardNum = postBoardNum;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getPostDate() {
		return postDate;
	}
	public void setPostDate(String postDate) {
		this.postDate = postDate;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public int getPostIsDelete() {
		return postIsDelete;
	}
	public void setPostIsDelete(int postIsDelete) {
		this.postIsDelete = postIsDelete;
	}
	@Override
	public String toString() {
		return "PostViewVO [postNum=" + postNum + ", postBoardNum=" + postBoardNum + ", title=" + title + ", content="
				+ content + ", nickname=" + nickname + ", postDate=" + postDate + ", hit=" + hit + ", postIsDelete="
				+ postIsDelete + "]";
	}
	
	
}	
