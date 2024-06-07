package kr.ac.kopo.member;

public class MemberVO {

	private String id;
	private String name;
	private String password;
	private String email;
	private String domain;
	private String phone;
	private String post;
	private String basicAddr;
	private String detailAddr;
	private String type;
	private String regDate;
	
	public MemberVO() {
		super();
	}

	public MemberVO(String id, String name, String password, String email, String domain, String phone, String post,
			String basicAddr, String detailAddr, String type, String regDate) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.email = email;
		this.domain = domain;
		this.phone = phone;
		this.post = post;
		this.basicAddr = basicAddr;
		this.detailAddr = detailAddr;
		this.type = type;
		this.regDate = regDate;
	}

	public MemberVO(String id, String name, String password, String email, String domain, String phone, String post,
			String basicAddr, String detailAddr) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.email = email;
		this.domain = domain;
		this.phone = phone;
		this.post = post;
		this.basicAddr = basicAddr;
		this.detailAddr = detailAddr;
	}
	
	public MemberVO(String id, String name, String password, String type) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.type = type;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}
	
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public String getBasicAddr() {
		return basicAddr;
	}

	public void setBasicAddr(String basicAddr) {
		this.basicAddr = basicAddr;
	}

	public String getDetailAddr() {
		return detailAddr;
	}

	public void setDetailAddr(String detailAddr) {
		this.detailAddr = detailAddr;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	
}
