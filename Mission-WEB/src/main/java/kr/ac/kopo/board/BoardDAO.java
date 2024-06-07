package kr.ac.kopo.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import kr.ac.kopo.util.ConnectionFactory;


public class BoardDAO {

	public void insertBoard(BoardVO board) throws Exception {
		
		StringBuilder sql = new StringBuilder();
		sql.append("insert into t_board(no, title, writer, content) ");
		sql.append(" values(seq_t_board_no.nextval, ?, ?, ?) ");
		
		try(
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		){
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getWriter());
			pstmt.setString(3, board.getContent());
			pstmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updateBoard(BoardVO board) throws Exception {
		
		StringBuilder sql = new StringBuilder();
		sql.append("update t_board ");
		sql.append("   SET title  = ?, writer = ?, content = ? ");
		sql.append(" where no = ? ");
		
		try(
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		){
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getWriter());
			pstmt.setString(3, board.getContent());
			pstmt.setInt(4, board.getNo());
			pstmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 *	글번호로 게시글 조회기능
	 *	@param boardNo 조회할 글 번호, 게시글이 없을경우 null
	 *	@return 조회된 게시글
	 */
	
	public BoardVO selectByNo(int BoardNo) throws Exception {
		StringBuilder sql = new StringBuilder();
		sql.append("select no, title, writer, content, view_cnt ");
		sql.append("      ,to_char(reg_date, 'yyyy-mm-dd') reg_date ");
		sql.append("  from t_board ");
		sql.append(" where no = ? ");
		
		try (
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		){
			pstmt.setInt(1, BoardNo);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				int no = rs.getInt("no");
				String title = rs.getString("title");
				String writer = rs.getString("writer");
				String content = rs.getString("content");
				int viewcnt = rs.getInt("view_cnt");
				String regDate = rs.getString("reg_date");
				
				BoardVO board = new BoardVO(no, title, writer, content, viewcnt, regDate);
				return board;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * @param boardNo 번호가 맞는 게시글 삭제
	 */
	
	public void deleteByNo(int BoardNo) throws Exception {
		
		StringBuilder sql = new StringBuilder();
		sql.append("delete ");
		sql.append("  from t_board ");
		sql.append(" where no = ? ");
		
		try(
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		){
			pstmt.setInt(1, BoardNo);
			pstmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void viewCnt(int BoardNo) throws Exception {
		
		BoardVO board = this.selectByNo(BoardNo);
		int cnt = board.getViewCnt()+1;
		
		StringBuilder sql = new StringBuilder();
		sql.append("update t_board ");
		sql.append("   SET view_cnt = ? ");
		sql.append(" where no = ? ");
		
		try(
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		){
			pstmt.setInt(1, cnt);
			pstmt.setInt(2, BoardNo);
			pstmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
