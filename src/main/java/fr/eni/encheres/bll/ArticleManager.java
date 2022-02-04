package fr.eni.encheres.bll;

import java.sql.SQLException;

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
	 * @throws SQLException
	 * @throws DALException 
	 */
	
	public void addArticle(Article article) {
		ArticleDAO ad = DAOFactory.getArticleDAO();
		ad.insertArticle(article);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
