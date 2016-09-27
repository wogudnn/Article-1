<%@page import="com.dangogea.vo.ArticleVO"%>
<%@page import="com.dangogea.dao.ArticleDaoImpl"%>
<%@page import="com.dangogea.dao.ArticleDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String articleIdParam = request.getParameter("articleId");
	if (articleIdParam == null) {
		response.sendRedirect("./article.jsp");
	}

	int articleId = Integer.parseInt(articleIdParam);

	ArticleDao dao = new ArticleDaoImpl();
	ArticleVO article = dao.getArticleAt(articleId);
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><%=article.getSubject()%></title>
</head>
<body>
	<h1><%=article.getSubject()%></h1>
	<h6><%=article.getCreatedDate() %></h6>
	<hr />

	<p><%=article.getContent()%></p>

	<a href="./doDelete.jsp?articleId=<%=article.getArticleId()%>">삭제</a>
	<a href="./article.jsp">되돌아가기</a>
</body>
</html>