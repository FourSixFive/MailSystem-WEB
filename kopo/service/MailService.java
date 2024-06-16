package kr.ac.kopo.service;

import java.util.List;

import kr.ac.kopo.dao.MemberDAO;
import kr.ac.kopo.vo.MemberVO;

public class MailService {

	private MemberDAO dao;

	public MailService() {
		dao = new MemberDAO();
	}
	
	public void addsignUp(MemberVO member) {
		dao.signup(member);
	}
	
	public MemberVO login(String id) {
		return dao.login(id);
	}
	
	public String idcheck(String id) {
		return dao.idcheck(id);
	}
	
	public int failcheck(String id, int cnt) {
		return dao.failcheck(id, cnt);
	}
	
	public String findmemberid(String name, String phone) {
		return dao.findmemberid(name, phone);
	}
	
	public String findmemberpwd(String id, String name, String phone) {
		return dao.findmemberpwd(id, name, phone);
	}
	
	public void updatemember(MemberVO member) {
		dao.updatemember(member);
	}
	
	public MemberVO editmember(MemberVO member) {
		return dao.editmember(member);
	}

	public List<MemberVO> admineditmember(MemberVO member) {
		return dao.admineditmember(member);
	}

	public List<MemberVO> allmember() {
		return dao.allmember();
	}

	public List<MemberVO> deletemember(String id) {
		return dao.deletemember(id);
	}

	public List<String> allid() {
		return dao.allid();
	}
}
