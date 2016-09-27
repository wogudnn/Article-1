package com.dangogea.dao;

import java.util.List;

import com.dangogea.vo.ArticleVO;

public interface ArticleDao {
	public List<ArticleVO> getAriticlesOf();
	
	public void addArticle(ArticleVO article);
	
	public void deleteArticle(int articleId);
	
	public ArticleVO getArticleAt(int articleId);
	
	public ArticleVO updateAricle(ArticleVO article);
}
