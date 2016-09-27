<%@page import="com.dangogea.vo.ArticleVO"%>
<%@page import="com.dangogea.dao.ArticleDao"%>
<%@page import="com.dangogea.dao.ArticleDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
		
	String subject = request.getParameter("subject");
	String content = request.getParameter("content");

	content = content.replaceAll("\n", "<br/>").replaceAll("\r", "");
	
	ArticleVO article = new ArticleVO();
	article.setSubject(subject);
	article.setContent(content);
	
	ArticleDao dao = new ArticleDaoImpl();
	dao.addArticle(article);
	
	response.sendRedirect("./article.jsp");


%>