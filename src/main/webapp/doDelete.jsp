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
	dao.deleteArticle(articleId);
	
	response.sendRedirect("./article.jsp");
%>