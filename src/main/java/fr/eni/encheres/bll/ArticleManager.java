package fr.eni.encheres.bll;

import java.sql.SQLException;
import java.util.List;

import fr.eni.encheres.bo.Article;
import fr.eni.encheres.dal.ArticleDAO;
import fr.eni.encheres.dal.DALException;
import fr.eni.encheres.dal.DAOFactory;

public class ArticleManager {

	private static ArticleManager instance;

	//Cr�ation du Singleton ArticleManager
	private ArticleManager() {
	}
	/**
	 * Cr�er une instance d'ArticleManager si il en existe pas d�j� une
	 * @return
	 */

	public static ArticleManager getInstance() {
		if(instance ==null) {
			instance = new ArticleManager();
			
		}
		
		return instance;
	}
	/**
	 * Cr�er un objet ArticleDAO gr�ce � la DAOFactory
	 * @param article
	 * @throws BLLException 
	 * @throws SQLException
	 * @throws DALException 
	 */
	
	public void addArticle(Article article) throws BLLException {
		ArticleDAO ad = DAOFactory.getArticleDAO();
		try {
			ad.insertArticle(article);
		} catch (DALException e) {
			throw new BLLException("probleme dans la methode addArticle()", e);
		}
	}
	
	public List<Article> listeArticles() throws BLLException {
		ArticleDAO ad = DAOFactory.getArticleDAO();
		try {
			return ad.listeArticles();
		} catch (DALException e) {
			throw new BLLException("probleme dans la methode listeArticles()", e);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
