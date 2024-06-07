package kr.ac.kopo.vo;

public class MailVO {
	
	private int no;
	private String id;
	private String title;
	private String contents;
	private String reg_date;
	private String received_id;
	private int deletechk;
	private int favorites;
	
	public MailVO() {
		super();
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getReg_date() {
		return reg_date;
	}

	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}

	public String getReceived_id() {
		return received_id;
	}

	public void setReceived_id(String received_id) {
		this.received_id = received_id;
	}

	public int getDeletechk() {
		return deletechk;
	}
	
	public void setDeletechk(int deletechk) {
		this.deletechk = deletechk;
	}

	
	public int getFavorites() {
		return favorites;
	}
	
	public void setFavorites(int favorites) {
		this.favorites = favorites;
	}

	public MailVO(String id, String title, String contents, String received_id) {
		super();
		this.id = id;
		this.title = title;
		this.contents = contents;
		this.received_id = received_id;
	}

	public MailVO(int no, String id, String title, String contents, String reg_date, String received_id) {
		super();
		this.no = no;
		this.id = id;
		this.title = title;
		this.contents = contents;
		this.reg_date = reg_date;
		this.received_id = received_id;
	}



	
	
}
