package vo;

public class BanWordVO {
	private String banWord;
	
	public BanWordVO() {
	}

	public BanWordVO(String banWord) {
		this.banWord = banWord;
	}

	public String getBanWord() {
		return banWord;
	}

	public void setBanWord(String banWord) {
		this.banWord = banWord;
	}

	@Override
	public String toString() {
		return "BanWordVO [banWord=" + banWord + "]";
	}
	
	
}