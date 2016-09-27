<%@page import="com.dangogea.vo.ArticleVO"%>
<%@page import="java.util.List"%>
<%@page import="com.dangogea.dao.ArticleDaoImpl"%>
<%@page import="com.dangogea.dao.ArticleDao"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>article</title>
<link rel="stylesheet" type="text/css" href="/Article/css/article.css">
</head>
<body>
	<div id="wrapper">
	<h1>Article</h1>
		<hr/>
		<div id="articles">
				<c:forEach items="${articles}" var="article" >
			<div class="article">
					<div class="subject">제목 : ${article.getSubject()}</div>
						<div>
							<div class="creator">글쓴이 : 이재형  </div>
							<div class="creatDate">작성일자 : ${article.getCreatedDate()} </div>
						</div>
					<div class="contents">
					<c:set var="content" value="${fn:replace(article.content,'<br/>',' ') }"/>
					<%-- 	<c:if test="${fn:length(content)>50}">
							${fn:substring(content, 0, 50)}...
						</c:if> --%>
						<c:choose>
							<c:when test="${fn:length(content)>50}">
								${fn:substring(content, 0, 50)}...
							</c:when>
							<c:otherwise>
								${content}
							</c:otherwise>
						</c:choose>
					</div>
			</div>
				</c:forEach>
		</div>
	</div>
	<input type="button" value="글쓰기" onclick="location.href='/Article/write'"/>
</body>
</html>