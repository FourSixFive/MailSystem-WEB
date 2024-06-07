package kr.ac.kopo.service;

import java.util.List;
import kr.ac.kopo.dao.MailDAO;
import kr.ac.kopo.vo.MailVO;

public class MailService2 {

	private MailDAO dao2;
	
	public MailService2() {
		dao2 = new MailDAO();
	}
	
	public void writemail(MailVO mail) {
		dao2.writemail(mail);
	}
	
	public List<MailVO> receivedmail(String id) {
		return dao2.receivedmail(id);
	}
	
	public String receivedtitle(String id, int num) {
		return dao2.receivedtitle(id, num);
	}

	public String receivedcont(String id,int num) {
		return dao2.receivedcont(id, num);
	}

	public String deletetitle(String id,int num) {
		return dao2.deletetitle(id, num);
	}

	public String deletecont(String id,int num) {
		return dao2.deletecont(id, num);
	}

	public String senttitle(String id,int num) {
		return dao2.senttitle(id, num);
	}

	public String sentcont(String id,int num) {
		return dao2.sentcont(id, num);
	}
	
	public List<MailVO> sentmail(String id) {
		return dao2.sentmail(id);
	}
	
	public List<MailVO> deletemail(String id, int no) {
		return dao2.deletemail(id, no);
	}

	public List<MailVO> favoritesdeletemail(String id, int no) {
		return dao2.favoritesdeletemail(id, no);
	}

	public List<MailVO> sentdeletemail(String id, int no) {
		return dao2.sentdeletemail(id, no);
	}
	
	public List<MailVO> favoritesmail(String id, int no) {
		return dao2.favoritesmail(id, no);
	}

	public List<MailVO> favoriteMail(String id) {
		return dao2.favoritemail(id);
	}
	
	public List<MailVO> binmail(String id) {
		return dao2.binmail(id);
	}
	
	public List<MailVO> returnmail(String id, int num) {
		return dao2.returnmail(id, num);
	}
	
	public List<MailVO> permanentbinmail(String id, int num) {
		return dao2.permanentbinmail(id, num);
	}
	
	public String favoritestitle(String id, int num) {
		return dao2.favoritestitle(id, num);
	}

	public String favoritescont(String id, int num) {
		return dao2.favoritescont(id, num);
	}
	
	public List<MailVO> unfavorites(String id, int num) {
		return dao2.unfavorites(id, num);
	}
	
	public MailVO maildata(String id, int num) {
		return dao2.maildata(id, num);
	}
	
	public boolean receivecheck(String id) {
		return dao2.receivecheck(id);
	}

	public List<MailVO> adminmail() {
		return dao2.adminmail();
	}

	public String adminmailtitle(int num) {
		return dao2.adminmailtitle(num);
	}

	public String adminmailcont(int num) {
		return dao2.adminmailcont(num);
	}

	public List<MailVO> admindeletemail(int num) {
		return dao2.admindeletemail(num);
	}

	public void sendall(List<MailVO> list) {
		for(int i = 0 ; i < list.size() ; i++) {
			dao2.sendall(list.get(i));
		}
	}
}
