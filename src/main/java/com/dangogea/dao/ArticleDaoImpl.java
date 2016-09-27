package com.dangogea.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dangogea.vo.ArticleVO;

public class ArticleDaoImpl implements ArticleDao {

	@Override
	public List<ArticleVO> getAriticlesOf() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e.getMessage(), e);
		}

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "ARTCL", "artcl");

			StringBuffer query = new StringBuffer();
			query.append(" SELECT 	ARTCL_ID ");
			query.append("			, SBJ ");
			query.append("			, CONT ");
			query.append("			, TO_CHAR(CRT_DT, 'YYYY/MM/DD HH:MI:SS') CRT_DT ");
			query.append(" FROM		ARTCL ");
			query.append(" ORDER 	BY ARTCL_ID DESC ");

			pstmt = conn.prepareStatement(query.toString());

			rs = pstmt.executeQuery();

			List<ArticleVO> articleList = new ArrayList<ArticleVO>();
			ArticleVO article = null;

			while (rs.next()) {
				article = new ArticleVO();
				article.setArticleId(rs.getInt("ARTCL_ID"));
				article.setSubject(rs.getString("SBJ"));
				article.setContent(rs.getString("CONT"));
				article.setCreatedDate(rs.getString("CRT_DT"));

				articleList.add(article);
			}

			return articleList;

		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}

	}

	@Override
	public void addArticle(ArticleVO article) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e.getMessage(), e);
		}

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "ARTCL", "artcl");

			StringBuffer query = new StringBuffer();
			query.append(" INSERT INTO	ARTCL 	( ARTCL_ID ");
			query.append(" 						, SBJ ");
			query.append(" 						, CONT ");
			query.append(" 						, CRT_DT ");
			query.append("						) ");
			query.append(" VALUES				( ARTCL_ID_SEQ.NEXTVAL ");
			query.append(" 						, ? ");
			query.append(" 						, ? ");
			query.append(" 						, SYSDATE ");
			query.append("						) ");

			pstmt = conn.prepareStatement(query.toString());
			pstmt.setString(1, article.getSubject());
			pstmt.setString(2, article.getContent());

			pstmt.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
	}

	@Override
	public void deleteArticle(int articleId) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e.getMessage(), e);
		}

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "ARTCL", "artcl");

			StringBuffer query = new StringBuffer();
			query.append(" DELETE ");
			query.append(" FROM	ARTCL ");
			query.append(" WHERE ARTCL_ID = ? ");

			pstmt = conn.prepareStatement(query.toString());
			pstmt.setInt(1, articleId);

			pstmt.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
	}

	@Override
	public ArticleVO getArticleAt(int articleId) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e.getMessage(), e);
		}

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "ARTCL", "artcl");

			StringBuffer query = new StringBuffer();
			query.append(" SELECT 	ARTCL_ID ");
			query.append("			, SBJ ");
			query.append("			, CONT ");
			query.append("			, TO_CHAR(CRT_DT, 'YYYY/MM/DD HH:MI:SS') CRT_DT ");
			query.append(" FROM		ARTCL ");
			query.append(" WHERE	ARTCL_ID = ? ");

			pstmt = conn.prepareStatement(query.toString());
			pstmt.setInt(1, articleId);

			rs = pstmt.executeQuery();

			ArticleVO article = null;
			if (rs.next()) {
				article = new ArticleVO();
				article.setArticleId(rs.getInt("ARTCL_ID"));
				article.setSubject(rs.getString("SBJ"));
				article.setContent(rs.getString("CONT"));
				article.setCreatedDate(rs.getString("CRT_DT"));
			}

			return article;

		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}

	}

	@Override
	public ArticleVO updateAricle(ArticleVO article) {
		// TODO Auto-generated method stub
		return null;
	}

}
