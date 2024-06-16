<%@page import="kr.ac.kopo.vo.MailVO"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="kr.ac.kopo.util.ConnectionFactory"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String user = (String)session.getAttribute("user");
	
	List<MailVO> maillist = new ArrayList<>();

	StringBuilder sql = new StringBuilder();
	sql.append("select no, title, id, to_char(reg_date, 'yyyy-mm-dd')reg_date ");
	sql.append("  from tbl_mail ");
	sql.append(" where received_id = ? ");
	sql.append("   and favorites = 1 ");
	sql.append(" order by reg_date ");
	
	try(
		Connection conn = new ConnectionFactory().getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql.toString());
	){
		pstmt.setString(1, user);
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()){
			
			int location = 1;
			
			int no = rs.getInt(location++);
			String title = rs.getString(location++);
			String id = rs.getString(location++);
			String regDate = rs.getString(location++);
			
			MailVO mail = new MailVO(no, id, title, regDate, user);
			maillist.add(mail);
		}
	}catch(Exception e){
		e.printStackTrace();
	}
	
	pageContext.setAttribute("maillist", maillist);
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>메일함</title>
<!-- Favicon-->
<link rel="icon" type="image/x-icon" href="/MailSystem-WEB/resources/images/favicon.ico" />
<!-- Core theme CSS (includes Bootstrap)-->
<link href="/MailSystem-WEB/resources/css/styles.css" rel="stylesheet" />
<link rel="stylesheet" href="/MailSystem-WEB/resources/css/table.css">
</head>
<body>
    <div class="d-flex" id="wrapper">
        <!-- Sidebar-->
        <div class="border-end bg-white" id="sidebar-wrapper">
            <div class="sidebar-heading border-bottom bg-light">메일함</div>
            <div class="list-group list-group-flush">
                <a class="list-group-item list-group-item-action list-group-item-light p-3" href="receivedmail.jsp">받은 메일함</a>
                <a class="list-group-item list-group-item-action list-group-item-light p-3" href="sendmail.jsp">보낸 메일함</a>
                <a class="list-group-item list-group-item-action list-group-item-light p-3" href="favoritemail.jsp">즐겨찾기</a>
                <a class="list-group-item list-group-item-action list-group-item-light p-3" href="binmail.jsp">휴지통</a>
            </div>
        </div>
        <!-- Page content wrapper-->
        <div id="page-content-wrapper">
            <!-- Top navigation-->
            <nav class="navbar navbar-expand-lg navbar-light bg-light border-bottom">
                <div class="container-fluid">
                    <button class="btn btn-primary" id="sidebarToggle">Menu</button>
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
                    <div class="collapse navbar-collapse" id="navbarSupportedContent">
                        <ul class="navbar-nav ms-auto mt-2 mt-lg-0">
                            <li class="nav-item active">
                            	<a class="nav-link" href="#!">
                            		<c:if test="${ not empty user }">
										[${ user }님 환영합니다]
									</c:if>
									<c:if test="${ empty user }">
										[GUEST님 환영합니다]
									</c:if>
                            	</a>
                            </li>
                            <li class="nav-item"><a class="nav-link" href="#!">Link</a></li>
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Dropdown</a>
                                <div class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdown">
                                    <a class="dropdown-item" href="#!">Action</a>
                                    <a class="dropdown-item" href="#!">Another action</a>
                                    <div class="dropdown-divider"></div>
                                    <a class="dropdown-item" href="#!">Something else here</a>
                                </div>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>
            <!-- Page content-->
            <div class="container-fluid" align="center">
                <h1 class="mt-4">즐겨찾기</h1>
                <hr>
				<table border="1" style="width: 85%;" class="listodd">
					<tr>
						<th width="7%">번호</th>
						<th width="30%">제목</th>
						<th width="15%">보낸사람</th>
						<th width="20%">날짜</th>
					</tr>
					<c:forEach items="${ maillist }" var="mail">
						<tr>
							<td>${ mail.no }</td>
							<td>
								<a href="detail.jsp?no=${ mail.no }">
								${ mail.title }
								</a>
							</td>
							<td>${ mail.id }</td>
							<td>${ mail.reg_date }</td>
						</tr>
					</c:forEach>
				</table>
            </div>
        </div>
    </div>
    <!-- Bootstrap core JS-->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
    <!-- Core theme JS-->
    <script src="/MailSystem-WEB/resources/js/scripts.js"></script>
</body>
</html>