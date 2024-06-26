package kr.ac.kopo.board;

/*
	자바빈즈 클래스
	1. 패키지 선언
	2. 클래스 접근제한자 public
	3. 모든 멤버변수는 private
	4. 기본생성자 선언
	5. getter/setter 메소드 선언
 */
	
public class BoardVO {

	private int no;
	private String title;
	private String writer;
	private String content;
	private int viewCnt;
	private String regDate;

	public BoardVO() {
		super();
	}

	public BoardVO(int no, String title, String writer, String regDate) {
		this.no = no;
		this.title = title;
		this.writer = writer;
		this.regDate = regDate;
	}

	public BoardVO(int no, String title, String writer, String content, int viewCnt, String regDate) {
		super();
		this.no = no;
		this.title = title;
		this.writer = writer;
		this.content = content;
		this.viewCnt = viewCnt;
		this.regDate = regDate;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getViewCnt() {
		return viewCnt;
	}

	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	
}
