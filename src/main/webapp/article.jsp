<%@page import="com.dangogea.vo.ArticleVO"%>
<%@page import="java.util.List"%>
<%@page import="com.dangogea.dao.ArticleDaoImpl"%>
<%@page import="com.dangogea.dao.ArticleDao"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>

<%
	ArticleDao articleDao = new ArticleDaoImpl();
	List<ArticleVO> articleList = articleDao.getAriticlesOf();
%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<h1>Article</h1>

	<hr />

	<table
		style="border-collapse: collapse; border: 1px solid #000000; width: 100%; background-color: #CCCCCC;">
		<tr>
			<th>Article ID</th>
			<th>Subject</th>
			<th>Created Date</th>
		</tr>

		<%
			ArticleVO article = null;
			int articleListSize = articleList.size();
			for (int i = 0; i < articleListSize; i++) {
				article = articleList.get(i);
		%>

		<tr style="text-align: center;">
			<td><%=article.getArticleId()%></td>
			<td><a href="./detail.jsp?articleId=<%=article.getArticleId()%>"><%=article.getSubject()%></a></td>
			<td><%=article.getCreatedDate()%></td>
		</tr>

		<%
			}
		%>

	</table>
	<a href="./write.jsp">글 작성</a>
</body>
</html>