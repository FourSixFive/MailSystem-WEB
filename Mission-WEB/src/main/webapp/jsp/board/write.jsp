<%@page import="kr.ac.kopo.util.KopoFileNamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="kr.ac.kopo.board.BoardDAO"%>
<%@page import="kr.ac.kopo.board.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	/*
	if(request.getParameter("no")==null){
		// step 01
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		BoardVO board = new BoardVO();
		board.setTitle(title);
		board.setWriter(writer);
		board.setContent(content);
		
		// step 02
		BoardDAO boardDao = new BoardDAO();
		boardDao.insertBoard(board);
		
	}else if(request.getParameter("no")!=null){
		
		int no = Integer.parseInt(request.getParameter("no"));
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		BoardVO board = new BoardVO();
		board.setNo(no);
		board.setTitle(title);
		board.setWriter(writer);
		board.setContent(content);
		
		BoardDAO boardDao = new BoardDAO();
		boardDao.updateBoard(board);
	} */
	String saveDirectory = "C:\\Lecture\\java-server\\Mission-WEB\\src\\main\\webapp\\upload";
	
	MultipartRequest multi = new MultipartRequest(request, saveDirectory, 1024*1024*3, "utf-8", new KopoFileNamePolicy());
	
	//1. 게시물(t_board) 저장
	String title = multi.getParameter("title");
	String writer = multi.getParameter("writer");
	String content = multi.getParameter("content");
	
	BoardVO board = new BoardVO();
	board.setTitle(title);
	board.setWriter(writer);
	board.setContent(content);
%>
<script>
	//step 03
	/* alert('글 등록이 완료되었습니다')
	location.href = "list.jsp" */
</script>