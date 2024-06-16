package kr.ac.kopo.vo;

public class MemberVO {
	
	private int no;
	private String id;
	private String password;
	private String name;
	private String phone;
	private String reg_date;
	private int fail_chk;
	
	public MemberVO() {
		super();
	}

	public int getNo() {
		return no;
	}
	
	public String getId() {
		return id;
	}

	public String getPassword() {
		return password;
	}

	public String getName() {
		return name;
	}

	public String getPhone() {
		return phone;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getReg_date() {
		return reg_date;
	}
	
	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
	
	public int getFail_chk() {
		return fail_chk;
	}
	
	public void setFail_chk(int fail_chk) {
		this.fail_chk = fail_chk;
	}

	public MemberVO(String id, String password, String name, String phone) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.phone = phone;
	}

	public MemberVO(int no, String id, String password, String name, String phone) {
		super();
		this.no = no;
		this.id = id;
		this.password = password;
		this.name = name;
		this.phone = phone;
	}

	public MemberVO(int no, String id, String password, String name, String phone, String reg_date) {
		super();
		this.no = no;
		this.id = id;
		this.password = password;
		this.name = name;
		this.phone = phone;
		this.reg_date = reg_date;
	}

	public MemberVO(int no, String id, String password, String name, String phone, String reg_date, int fail_chk) {
		super();
		this.no = no;
		this.id = id;
		this.password = password;
		this.name = name;
		this.phone = phone;
		this.reg_date = reg_date;
		this.fail_chk = fail_chk;
	}

}
