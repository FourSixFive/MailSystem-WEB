package kr.ac.kopo.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import kr.ac.kopo.util.ConnectionFactory;

public class MemberDAO {

	public void insertmember(MemberVO member) throws Exception {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO t_member(id, name, password, email_id, email_domain, phone, post, basic_addr, detail_addr) ");
		sql.append(" VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?) ");
		
		try(
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		){
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getName());
			pstmt.setString(3, member.getPassword());
			pstmt.setString(4, member.getEmail());
			pstmt.setString(5, member.getDomain());
			pstmt.setString(6, member.getPhone());
			pstmt.setString(7, member.getPost());
			pstmt.setString(8, member.getBasicAddr());
			pstmt.setString(9, member.getDetailAddr());
			pstmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 로그인 여부 확인
	 * @param loginVO 조회할 id, password
	 * @return 조회된 MemberVO, 로그인 실패 시 null 반환
	 */
	public MemberVO login(MemberVO loginVO) {
		
		StringBuilder sql = new StringBuilder();
		sql.append("select id, password, name, type ");
		sql.append("  from t_member ");
		sql.append(" where id = ? and password = ? ");
		
		try(
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());	
		){
			pstmt.setString(1, loginVO.getId());
			pstmt.setString(2, loginVO.getPassword());
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				MemberVO member = new MemberVO();
				member.setId(rs.getString("id"));
				member.setPassword(rs.getString("password"));
				member.setName(rs.getString("name"));
				member.setType(rs.getString("type"));
				return member;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null; 
	}
}
