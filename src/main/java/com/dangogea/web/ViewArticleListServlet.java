package com.dangogea.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dangogea.dao.ArticleDao;
import com.dangogea.dao.ArticleDaoImpl;
import com.dangogea.vo.ArticleVO;

public class ViewArticleListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ArticleDao dao;
    public ViewArticleListServlet() {
        super();
        dao = new ArticleDaoImpl();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		String viewPath = "/WEB-INF/view/article.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(viewPath);
		
		List<ArticleVO> articles = dao.getAriticlesOf();
		request.setAttribute("articles", articles);
		
		rd.forward(request, response);
	}

}
