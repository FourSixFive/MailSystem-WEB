package kr.ac.kopo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.ac.kopo.util.ConnectionFactory;
import kr.ac.kopo.vo.MemberVO;

public class MemberDAO {

	public void signup(MemberVO member) {
		
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO tbl_member(NO, id, password, name, phone) ");
		sql.append(" VALUES(seq_tbl_member_no.nextval, ?, ?, ?, ?) ");
		
		try(
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		){
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPassword());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getPhone());
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public MemberVO login(String inputid) {
		
		MemberVO member = null;
		
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT no, id, password, name, phone, TO_CHAR(reg_date, 'YYYY-MM-DD') AS reg_date ");
		sql.append("  FROM tbl_member ");
		sql.append(" WHERE id = ? ");
		
		try (
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		){
			pstmt.setString(1, inputid);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				int no = rs.getInt("no");
				String id = rs.getString("id");
				String password = rs.getString("password");
				String name = rs.getString("name");
				String phone = rs.getString("phone");
				String reg_date = rs.getString("reg_date");
				
				member = new MemberVO(no, id, password, name, phone, reg_date);
			}else {
				int no = 0;
				String id = "id";
				String password = "password";
				String name = "name";
				String phone = "phone";
				member = new MemberVO(no, id, password, name, phone);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return member;
	}
	
	public String idcheck(String inputid) {
		String chk = "";
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * ");
		sql.append("  FROM tbl_member ");
		sql.append(" WHERE id = ? ");
		try (
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			){
				pstmt.setString(1, inputid);
				ResultSet rs = pstmt.executeQuery();
				
				if(rs.next()) {
					chk = rs.getString("id");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		return chk;
	}
	
	public String findmemberid(String inputname, String inputphone) {

		String foundid = null;
		
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT id ");
		sql.append("  FROM tbl_member ");
		sql.append(" WHERE name = ? ");
		sql.append("   AND phone = ? ");
		
		try (
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		){
			pstmt.setString(1, inputname);
			pstmt.setString(2, inputphone);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				foundid = rs.getString("id");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return foundid;
	}
	
	public String findmemberpwd(String inputid, String inputname, String inputphone) {
		
		String foundpwd = null;
		
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT id ");
		sql.append("  FROM tbl_member ");
		sql.append(" WHERE id = ? ");
		sql.append("   AND name = ? ");
		sql.append("   AND phone = ? ");
		
		try (
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		){
			pstmt.setString(1, inputid);
			pstmt.setString(2, inputname);
			pstmt.setString(3, inputphone);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				foundpwd = rs.getString("id");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return foundpwd;
	}
	
	public void updatemember(MemberVO member) {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE tbl_member ");
		sql.append("   SET password = ? ");
		sql.append(" WHERE id = ? ");
		sql.append("   AND name = ? ");
		sql.append("   AND phone = ? ");
		
		try (
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		){
			pstmt.setString(1, member.getPassword());
			pstmt.setString(2, member.getId());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getPhone());
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<MemberVO> admineditmember(MemberVO member) {
		
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE tbl_member ");
		sql.append("   SET phone = ? ");
		sql.append("      ,name = ? ");
		sql.append(" WHERE id = ? ");
		
		try (
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		){
			pstmt.setString(1, member.getPhone());
			pstmt.setString(2, member.getName());
			pstmt.setString(3, member.getId());
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return this.allmember();
	}
	
	public MemberVO editmember(MemberVO member) {
		
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE tbl_member ");
		sql.append("   SET password = ? ");
		sql.append("      ,name = ? ");
		sql.append("      ,phone = ? ");
		sql.append(" WHERE id = ? ");
		
		try (
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			){
				pstmt.setString(1, member.getPassword());
				pstmt.setString(2, member.getName());
				pstmt.setString(3, member.getPhone());
				pstmt.setString(4, member.getId());
				pstmt.executeUpdate();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		StringBuilder sql2 = new StringBuilder();
		sql2.append("SELECT no, id, password, name, phone, TO_CHAR(reg_date, 'YYYY-MM-DD') AS reg_date ");
		sql2.append("  FROM tbl_member ");
		sql2.append(" WHERE id = ? ");
		
		MemberVO member2 = null;
		
		try (
				Connection conn2 = new ConnectionFactory().getConnection();
				PreparedStatement pstmt2 = conn2.prepareStatement(sql2.toString());
			){
				pstmt2.setString(1, member.getId());
				ResultSet rs = pstmt2.executeQuery();
				
			if(rs.next()) {	
				int no = rs.getInt("no");
				String id = rs.getString("id");
				String password = rs.getString("password");
				String name = rs.getString("name");
				String phone = rs.getString("phone");
				String reg_date = rs.getString("reg_date");
				
				member2 = new MemberVO(no, id, password, name, phone, reg_date);
			}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		return member2;
	}
	
	public int failcheck(String ID, int cnt) {
		if(cnt == 5) {
			StringBuilder sql3 = new StringBuilder();
			sql3.append("UPDATE tbl_member ");
			sql3.append("   SET password = ? ");
			sql3.append(" WHERE id = ? ");
			
			try (
					Connection conn3 = new ConnectionFactory().getConnection();
					PreparedStatement pstmt3 = conn3.prepareStatement(sql3.toString());
			){
					pstmt3.setInt(1, (int)(Math.random()*899999999) + 100000000);
					pstmt3.setString(2, ID);
					pstmt3.executeUpdate();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
		}
		int chk = 0;
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE tbl_member ");
		sql.append("   SET fail_check  = ? ");
		sql.append(" WHERE id = ? ");
		
		try (
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		){
				pstmt.setInt(1, cnt);
				pstmt.setString(2, ID);
				pstmt.executeUpdate();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		StringBuilder sql2 = new StringBuilder();
		sql2.append("SELECT fail_check ");
		sql2.append("  FROM tbl_member ");
		sql2.append(" WHERE id = ? ");
		
		try (
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql2.toString());
		){
				pstmt.setString(1, ID);
				ResultSet rs = pstmt.executeQuery();
				
				if(rs.next()) {
					chk = rs.getInt("fail_check");
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		return chk;
	}

	public List<MemberVO> allmember() {
		
		List<MemberVO> list = new ArrayList<>();
		
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT no, id, password, name, phone, TO_CHAR(reg_date, 'YYYY-MM-DD') AS reg_date ");
		sql.append("  FROM tbl_member ");
		
		try (
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		){
				ResultSet rs = pstmt.executeQuery();
				
				while(rs.next()) {
					int no = rs.getInt("no");
					String id = rs.getString("id");
					String password = rs.getString("password");
					String name = rs.getString("name");
					String phone = rs.getString("phone");
					String reg_date = rs.getString("reg_date");
					
					MemberVO member = new MemberVO(no, id, password, name, phone, reg_date);
					list.add(member);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		return list;
	}

	public List<MemberVO> deletemember(String ID) {
		
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE ");
		sql.append("  FROM tbl_member ");
		sql.append(" WHERE id = ? ");
		
		try (
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		){
				pstmt.setString(1, ID);
				pstmt.executeUpdate();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		return this.allmember();
	}

	public List<String> allid() {
		
		List<String> list = new ArrayList<>();
		
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT id ");
		sql.append("  FROM tbl_member ");
		
		try (
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		){
				ResultSet rs = pstmt.executeQuery();
				
				while(rs.next()) {
					String id = rs.getString("id");
					list.add(id);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		return list;
	}
}
