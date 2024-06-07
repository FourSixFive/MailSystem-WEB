package test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Ignore;
import org.junit.Test;

import kr.ac.kopo.board.BoardDAO;
import kr.ac.kopo.board.BoardVO;

public class BoardDAOTest {

	private BoardDAO boardDao = new BoardDAO();
	@Ignore
	@Test
	public void 무시() throws Exception {
		BoardVO board = boardDao.selectByNo(3);

		assertNull(board);
	}
	
	@Test
	public void 글번호조회서비스() throws Exception {
		BoardVO board = boardDao.selectByNo(3);
		
		assertNotNull(board);
	}
	
	@Test
	public void 새글등록테스트() throws Exception {

		BoardVO board = new BoardVO();
		board.setTitle("TestTitle");
		board.setWriter("TestWriter");
		board.setContent("TestContent");
		
		boardDao.insertBoard(board);
	}
}
