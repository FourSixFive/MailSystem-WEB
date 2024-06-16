package kr.ac.kopo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.ac.kopo.util.ConnectionFactory;
import kr.ac.kopo.vo.MailVO;

public class MailDAO {

	public void writemail(MailVO mail) {
		
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO tbl_mail(NO, id, title, contents, received_id) ");
		sql.append(" VALUES(seq_tbl_mail_no.nextval, ?, ?, ?, ?) ");
		
		try (
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		){
			pstmt.setString(1, mail.getId());
			pstmt.setString(2, mail.getTitle());
			pstmt.setString(3, mail.getContents());
			pstmt.setString(4, mail.getReceived_id());
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<MailVO> receivedmail(String inputid) {
		
		List<MailVO> list = new ArrayList<>();
		
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT no, id, title, contents, TO_CHAR(reg_date, 'YYYY-MM-DD') AS reg_date, received_id ");
		sql.append("  FROM tbl_mail ");
		sql.append(" WHERE received_id = ? ");
		sql.append("   AND delete_check = 1 ");
		
		try (
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		){
			pstmt.setString(1, inputid);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int no = rs.getInt("no");
				String id = rs.getString("id");
				String title = rs.getString("title");
				String contents = rs.getString("contents");
				String reg_date = rs.getString("reg_date");
				String received_id = rs.getString("received_id");
				
				MailVO mail = new MailVO(no, id, title, contents, reg_date, received_id);
				list.add(mail);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public MailVO receivedmail_WEB(int mailNo){
		MailVO mail = null;
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT no, id, title, contents, TO_CHAR(reg_date, 'YYYY-MM-DD') AS reg_date, received_id ");
		sql.append("  FROM tbl_mail ");
		sql.append(" WHERE no = ? ");
		sql.append("   AND delete_check = 1 ");
		
		try (
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		){
			pstmt.setInt(1, mailNo);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				int no = rs.getInt("no");
				String id = rs.getString("id");
				String title = rs.getString("title");
				String contents = rs.getString("contents");
				String reg_date = rs.getString("reg_date");
				String received_id = rs.getString("received_id");
				mail = new MailVO(no, id, title, contents, reg_date, received_id);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mail;
	}
	
	public String receivedcont(String inputid, int num) {
		
		String numcontents = "";
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT contents ");
		sql.append("  FROM tbl_mail ");
		sql.append(" WHERE received_id = ? ");
		sql.append("   AND no = ? ");
		sql.append("   AND delete_check = 1 ");
		
		try (
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		){
			pstmt.setString(1, inputid);
			pstmt.setInt(2, num);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				numcontents = rs.getString("contents");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return numcontents;
	}

	public String receivedtitle(String inputid, int num) {
		
		String numtitle = "";
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT title ");
		sql.append("  FROM tbl_mail ");
		sql.append(" WHERE received_id = ? ");
		sql.append("   AND no = ? ");
		sql.append("   AND delete_check = 1 ");
		
		try (
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
				){
			pstmt.setString(1, inputid);
			pstmt.setInt(2, num);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				numtitle = rs.getString("title");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return numtitle;
	}

	public String deletetitle(String inputid, int num) {
		
		String numtitle = "";
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT title ");
		sql.append("  FROM tbl_mail ");
		sql.append(" WHERE received_id = ? ");
		sql.append("   AND no = ? ");
		sql.append("   AND delete_check = 0 ");
		
		try (
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
				){
			pstmt.setString(1, inputid);
			pstmt.setInt(2, num);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				numtitle = rs.getString("title");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return numtitle;
	}

	public String deletecont(String inputid, int num) {
		
		String numcontents = "";
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT contents ");
		sql.append("  FROM tbl_mail ");
		sql.append(" WHERE received_id = ? ");
		sql.append("   AND no = ? ");
		sql.append("   AND delete_check = 0 ");
		
		try (
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
				){
			pstmt.setString(1, inputid);
			pstmt.setInt(2, num);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				numcontents = rs.getString("contents");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return numcontents;
	}

	public String senttitle(String inputid, int num) {
		
		String numtitle = "";
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT title ");
		sql.append("  FROM tbl_mail ");
		sql.append(" WHERE id = ? ");
		sql.append("   AND no = ? ");
		sql.append("   AND delete_check = 1 ");
		
		try (
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
				){
			pstmt.setString(1, inputid);
			pstmt.setInt(2, num);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				numtitle = rs.getString("title");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return numtitle;
	}

	public String sentcont(String inputid, int num) {
		
		String numcontents = "";
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT contents ");
		sql.append("  FROM tbl_mail ");
		sql.append(" WHERE id = ? ");
		sql.append("   AND no = ? ");
		sql.append("   AND delete_check = 1 ");
		
		try (
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
				){
			pstmt.setString(1, inputid);
			pstmt.setInt(2, num);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				numcontents = rs.getString("contents");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return numcontents;
	}
	
	public List<MailVO> sentmail(String inputid) {
		List<MailVO> list = new ArrayList<>();
		
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT no, id, title, contents, TO_CHAR(reg_date, 'YYYY-MM-DD') AS reg_date, received_id ");
		sql.append("  FROM tbl_mail ");
		sql.append(" WHERE id = ? ");
		sql.append("   AND delete_check = 1 ");
		
		try (
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		){
			pstmt.setString(1, inputid);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int no = rs.getInt("no");
				String id = rs.getString("id");
				String title = rs.getString("title");
				String contents = rs.getString("contents");
				String reg_date = rs.getString("reg_date");
				String received_id = rs.getString("received_id");
				
				MailVO mail = new MailVO(no, id, title, contents, reg_date, received_id);
				list.add(mail);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List<MailVO> deletemail(String ID, int num) {
		
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE tbl_mail ");
		sql.append("   SET delete_check = 0 ");
		sql.append("      ,favorites = 0 ");
		sql.append(" WHERE received_id = ? ");
		sql.append("   AND no = ? ");
		
		try (
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
				){
			pstmt.setString(1, ID);
			pstmt.setInt(2, num);
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		List<MailVO> list = new ArrayList<>();
		
		StringBuilder sql2 = new StringBuilder();
		sql2.append("SELECT no, id, title, contents, TO_CHAR(reg_date, 'YYYY-MM-DD') AS reg_date, received_id ");
		sql2.append("  FROM tbl_mail ");
		sql2.append(" WHERE received_id = ? ");
		sql2.append("   AND delete_check = 1 ");
		
		try (
				Connection conn2 = new ConnectionFactory().getConnection();
				PreparedStatement pstmt2 = conn2.prepareStatement(sql2.toString());
				){
			
			pstmt2.setString(1, ID);
			ResultSet rs = pstmt2.executeQuery();
			
			while(rs.next()) {
				int no = rs.getInt("no");
				String id = rs.getString("id");
				String title = rs.getString("title");
				String contents = rs.getString("contents");
				String reg_date = rs.getString("reg_date");
				String received_id = rs.getString("received_id");
				
				MailVO mail = new MailVO(no, id, title, contents, reg_date, received_id);
				list.add(mail);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<MailVO> favoritesdeletemail(String ID, int num) {
		
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE tbl_mail ");
		sql.append("   SET delete_check = 0 ");
		sql.append("      ,favorites = 0 ");
		sql.append(" WHERE received_id = ? ");
		sql.append("   AND no = ? ");
		
		try (
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		){
			pstmt.setString(1, ID);
			pstmt.setInt(2, num);
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		List<MailVO> list = new ArrayList<>();
		
		StringBuilder sql2 = new StringBuilder();
		sql2.append("SELECT no, id, title, contents, TO_CHAR(reg_date, 'YYYY-MM-DD') AS reg_date, received_id ");
		sql2.append("  FROM tbl_mail ");
		sql2.append(" WHERE received_id = ? ");
		sql2.append("   AND delete_check = 1 ");
		sql2.append("   AND favorites = 1 ");
		
		try (
				Connection conn2 = new ConnectionFactory().getConnection();
				PreparedStatement pstmt2 = conn2.prepareStatement(sql2.toString());
		){
			
			pstmt2.setString(1, ID);
			ResultSet rs = pstmt2.executeQuery();
			
			while(rs.next()) {
				int no = rs.getInt("no");
				String id = rs.getString("id");
				String title = rs.getString("title");
				String contents = rs.getString("contents");
				String reg_date = rs.getString("reg_date");
				String received_id = rs.getString("received_id");
				
				MailVO mail = new MailVO(no, id, title, contents, reg_date, received_id);
				list.add(mail);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<MailVO> sentdeletemail(String ID, int num) {
		
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE tbl_mail ");
		sql.append("   SET delete_check = 0 ");
		sql.append("      ,favorites = 0 ");
		sql.append(" WHERE id = ? ");
		sql.append("   AND no = ? ");
		
		try (
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		){
			pstmt.setString(1, ID);
			pstmt.setInt(2, num);
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		List<MailVO> list = new ArrayList<>();
		
		StringBuilder sql2 = new StringBuilder();
		sql2.append("SELECT no, id, title, contents, TO_CHAR(reg_date, 'YYYY-MM-DD') AS reg_date, received_id ");
		sql2.append("  FROM tbl_mail ");
		sql2.append(" WHERE id = ? ");
		sql2.append("   AND delete_check = 1 ");
		
		try (
			Connection conn2 = new ConnectionFactory().getConnection();
			PreparedStatement pstmt2 = conn2.prepareStatement(sql2.toString());
		){
			pstmt2.setString(1, ID);
			ResultSet rs = pstmt2.executeQuery();
			while(rs.next()) {
				int no = rs.getInt("no");
				String id = rs.getString("id");
				String title = rs.getString("title");
				String contents = rs.getString("contents");
				String reg_date = rs.getString("reg_date");
				String received_id = rs.getString("received_id");
				
				MailVO mail = new MailVO(no, id, title, contents, reg_date, received_id);
				list.add(mail);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<MailVO> favoritesmail(String ID, int num) {
		
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE tbl_mail ");
		sql.append("   SET favorites = 1 ");
		sql.append(" WHERE received_id = ? ");
		sql.append("   AND no = ? ");
		
		try (
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		){
			pstmt.setString(1, ID);
			pstmt.setInt(2, num);
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		List<MailVO> list = new ArrayList<>();
		
		StringBuilder sql2 = new StringBuilder();
		sql2.append("SELECT no, id, title, contents, TO_CHAR(reg_date, 'YYYY-MM-DD') AS reg_date, received_id ");
		sql2.append("  FROM tbl_mail ");
		sql2.append(" WHERE received_id = ? ");
		sql2.append("   AND delete_check = 1 ");
		
		try (
			Connection conn2 = new ConnectionFactory().getConnection();
			PreparedStatement pstmt2 = conn2.prepareStatement(sql2.toString());
		){
			pstmt2.setString(1, ID);
			ResultSet rs = pstmt2.executeQuery();
			while(rs.next()) {
				int no = rs.getInt("no");
				String id = rs.getString("id");
				String title = rs.getString("title");
				String contents = rs.getString("contents");
				String reg_date = rs.getString("reg_date");
				String received_id = rs.getString("received_id");
				
				MailVO mail = new MailVO(no, id, title, contents, reg_date, received_id);
				list.add(mail);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List<MailVO> binmail(String ID) {
		
		List<MailVO> list = new ArrayList<>();
		
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT no, id, title, contents, TO_CHAR(reg_date, 'YYYY-MM-DD') AS reg_date, received_id ");
		sql.append("  FROM tbl_mail ");
		sql.append(" WHERE received_id = ? ");
		sql.append("   AND delete_check = 0 ");
		
		try (
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		){
			
			pstmt.setString(1, ID);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int no = rs.getInt("no");
				String id = rs.getString("id");
				String title = rs.getString("title");
				String contents = rs.getString("contents");
				String reg_date = rs.getString("reg_date");
				String received_id = rs.getString("received_id");
				
				MailVO mail = new MailVO(no, id, title, contents, reg_date, received_id);
				list.add(mail);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List<MailVO> returnmail(String ID, int num) {
		
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE tbl_mail ");
		sql.append("   SET delete_check = 1 ");
		sql.append(" WHERE received_id = ? ");
		sql.append("   AND no = ? ");
		
		try (
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		){
			pstmt.setString(1, ID);
			pstmt.setInt(2, num);
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		List<MailVO> list = new ArrayList<>();
		
		StringBuilder sql2 = new StringBuilder();
		sql2.append("SELECT no, id, title, contents, TO_CHAR(reg_date, 'YYYY-MM-DD') AS reg_date, received_id ");
		sql2.append("  FROM tbl_mail ");
		sql2.append(" WHERE received_id = ? ");
		sql2.append("   AND delete_check = 0 ");
		
		try (
				Connection conn2 = new ConnectionFactory().getConnection();
				PreparedStatement pstmt2 = conn2.prepareStatement(sql2.toString());
		){
			
			pstmt2.setString(1, ID);
			ResultSet rs = pstmt2.executeQuery();
			
			while(rs.next()) {
				int no = rs.getInt("no");
				String id = rs.getString("id");
				String title = rs.getString("title");
				String contents = rs.getString("contents");
				String reg_date = rs.getString("reg_date");
				String received_id = rs.getString("received_id");
				
				MailVO mail = new MailVO(no, id, title, contents, reg_date, received_id);
				list.add(mail);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List<MailVO> permanentbinmail(String ID, int num) {
		
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE ");
		sql.append("  FROM tbl_mail ");
		sql.append(" WHERE received_id = ? ");
		sql.append("   AND no = ? ");
		sql.append("   AND delete_check = 0 ");
		sql.append("   AND favorites = 0 ");
		
		try (
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		){
			pstmt.setString(1, ID);
			pstmt.setInt(2, num);
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		List<MailVO> list = new ArrayList<>();

		StringBuilder sql2 = new StringBuilder();
		sql2.append("SELECT no, id, title, contents, TO_CHAR(reg_date, 'YYYY-MM-DD') AS reg_date, received_id ");
		sql2.append("  FROM tbl_mail ");
		sql2.append(" WHERE received_id = ? ");
		sql2.append("   AND delete_check = 0 ");
		
		try (
				Connection conn2 = new ConnectionFactory().getConnection();
				PreparedStatement pstmt2 = conn2.prepareStatement(sql2.toString());
		){
			
			pstmt2.setString(1, ID);
			ResultSet rs = pstmt2.executeQuery();
			
			while(rs.next()) {
				int no = rs.getInt("no");
				String id = rs.getString("id");
				String title = rs.getString("title");
				String contents = rs.getString("contents");
				String reg_date = rs.getString("reg_date");
				String received_id = rs.getString("received_id");
				
				MailVO mail = new MailVO(no, id, title, contents, reg_date, received_id);
				list.add(mail);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List<MailVO> favoritemail(String ID) {
		
		List<MailVO> list = new ArrayList<>();
		
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT no, id, title, contents, TO_CHAR(reg_date, 'YYYY-MM-DD') AS reg_date, received_id ");
		sql.append("  FROM tbl_mail ");
		sql.append(" WHERE received_id = ? ");
		sql.append("   AND delete_check = 1 ");
		sql.append("   AND favorites = 1 ");
		
		try (
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		){
			
			pstmt.setString(1, ID);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int no = rs.getInt("no");
				String id = rs.getString("id");
				String title = rs.getString("title");
				String contents = rs.getString("contents");
				String reg_date = rs.getString("reg_date");
				String received_id = rs.getString("received_id");
				
				MailVO mail = new MailVO(no, id, title, contents, reg_date, received_id);
				list.add(mail);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public String favoritestitle (String ID, int num) {
		
		String numtitle = "";
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT title ");
		sql.append("  FROM tbl_mail ");
		sql.append(" WHERE received_id = ? ");
		sql.append("   AND no = ? ");
		sql.append("   AND delete_check = 1 ");
		sql.append("   AND favorites = 1 ");
		
		try (
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		){
			pstmt.setString(1, ID);
			pstmt.setInt(2, num);
			ResultSet rs = pstmt.executeQuery();
			
			numtitle = rs.getString("title");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return numtitle;
	}
	
	public String favoritescont (String ID, int num) {
		
		String numcontents = "";
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT contents ");
		sql.append("  FROM tbl_mail ");
		sql.append(" WHERE received_id = ? ");
		sql.append("   AND no = ? ");
		sql.append("   AND delete_check = 1 ");
		sql.append("   AND favorites = 1 ");
		
		try (
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
				){
			pstmt.setString(1, ID);
			pstmt.setInt(2, num);
			ResultSet rs = pstmt.executeQuery();
			
			numcontents = rs.getString("contents");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return numcontents;
	}
	
	public List<MailVO> unfavorites(String ID, int num) {
		
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE tbl_mail ");
		sql.append("   SET favorites = 0 ");
		sql.append(" WHERE received_id = ? ");
		sql.append("   AND no = ? ");
		sql.append("   AND delete_check = 1 ");
		
		try (
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		){
			pstmt.setString(1, ID);
			pstmt.setInt(2, num);
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		List<MailVO> list = new ArrayList<>();
		
		StringBuilder sql2 = new StringBuilder();
		sql2.append("SELECT no, id, title, contents, TO_CHAR(reg_date, 'YYYY-MM-DD') AS reg_date, received_id ");
		sql2.append("  FROM tbl_mail ");
		sql2.append(" WHERE received_id = ? ");
		sql2.append("   AND delete_check = 1 ");
		sql2.append("   AND favorites = 1 ");
		
		try (
				Connection conn2 = new ConnectionFactory().getConnection();
				PreparedStatement pstmt2 = conn2.prepareStatement(sql2.toString());
		){
			
			pstmt2.setString(1, ID);
			ResultSet rs = pstmt2.executeQuery();
			
			while(rs.next()) {
				int no = rs.getInt("no");
				String id = rs.getString("id");
				String title = rs.getString("title");
				String contents = rs.getString("contents");
				String reg_date = rs.getString("reg_date");
				String received_id = rs.getString("received_id");
				
				MailVO mail = new MailVO(no, id, title, contents, reg_date, received_id);
				list.add(mail);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public boolean receivecheck(String inputid) {
		boolean check = true;
		
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT id");
		sql.append("  FROM tbl_member ");
		sql.append(" WHERE id = ? ");
		
		try (
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		){
			pstmt.setString(1, inputid);
			ResultSet rs = pstmt.executeQuery();
			
			check = rs.next();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return check;
	}
	
	public MailVO maildata(String ID, int num) {
		
		MailVO mail = null;
		
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT no, id, title, contents, TO_CHAR(reg_date, 'YYYY-MM-DD') AS reg_date, received_id ");
		sql.append("  FROM tbl_mail ");
		sql.append(" WHERE received_id = ? ");
		sql.append("   AND no = ? ");
		
		
		try (
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		){
			
			pstmt.setString(1, ID);
			pstmt.setInt(2, num);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				int no = rs.getInt("no");
				String id = rs.getString("id");
				String title = rs.getString("title");
				String contents = rs.getString("contents");
				String reg_date = rs.getString("reg_date");
				String received_id = rs.getString("received_id");
				
				mail = new MailVO(no, id, title, contents, reg_date, received_id);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mail;
	}

	public List<MailVO> adminmail() {
		
		List<MailVO> list = new ArrayList<>();
		
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT no, id, title, contents, TO_CHAR(reg_date, 'YYYY-MM-DD') AS reg_date, received_id ");
		sql.append("  FROM tbl_mail ");
		
		try (
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		){
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int no = rs.getInt("no");
				String id = rs.getString("id");
				String title = rs.getString("title");
				String contents = rs.getString("contents");
				String reg_date = rs.getString("reg_date");
				String received_id = rs.getString("received_id");
				
				MailVO mail = new MailVO(no, id, title, contents, reg_date, received_id);
				list.add(mail);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public String adminmailtitle(int num) {
		
		String admintitle = "";
		
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT title ");
		sql.append("  FROM tbl_mail ");
		sql.append(" WHERE no = ? ");
		
		try (
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		){
			
			pstmt.setInt(1, num);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				admintitle = rs.getString("title");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return admintitle;
	}

	public String adminmailcont(int num) {
		
		String admincontents = "";
		
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT contents ");
		sql.append("  FROM tbl_mail ");
		sql.append(" WHERE no = ? ");
		
		try (
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		){
			
			pstmt.setInt(1, num);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				admincontents = rs.getString("contents");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return admincontents;
	}

	public List<MailVO> admindeletemail(int num) {
		
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE ");
		sql.append("  FROM tbl_mail ");
		sql.append(" WHERE no = ? ");
		
		try (
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		){
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		List<MailVO> list = new ArrayList<>();
		
		StringBuilder sql2 = new StringBuilder();
		sql2.append("SELECT no, id, title, contents, TO_CHAR(reg_date, 'YYYY-MM-DD') AS reg_date, received_id ");
		sql2.append("  FROM tbl_mail ");
		
		try (
				Connection conn2 = new ConnectionFactory().getConnection();
				PreparedStatement pstmt2 = conn2.prepareStatement(sql2.toString());
		){
			ResultSet rs = pstmt2.executeQuery();
			
			while(rs.next()) {
				int no = rs.getInt("no");
				String id = rs.getString("id");
				String title = rs.getString("title");
				String contents = rs.getString("contents");
				String reg_date = rs.getString("reg_date");
				String received_id = rs.getString("received_id");
				
				MailVO mail = new MailVO(no, id, title, contents, reg_date, received_id);
				list.add(mail);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public void sendall(MailVO mail) {
	
			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO tbl_mail(no, id, title, contents, received_id) ");
			sql.append(" VALUES(seq_tbl_MAIL_no.nextval, ?, ?, ?, ?) ");
			
			try (
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			){
				pstmt.setString(1, "admin");
				pstmt.setString(2, mail.getTitle());
				pstmt.setString(3, mail.getContents());
				pstmt.setString(4, mail.getReceived_id());
				pstmt.executeUpdate();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		
	}
	
}
