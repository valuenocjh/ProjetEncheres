package fr.eni.encheres.bll;

import java.sql.SQLException;

import fr.eni.encheres.bo.Article;
import fr.eni.encheres.dal.ArticleDAO;
import fr.eni.encheres.dal.DALException;
import fr.eni.encheres.dal.DAOFactory;

public class ArticleManager {

	private static ArticleManager instance;

	//Création du Singleton ArticleManager
	private ArticleManager() {
	}
	/**
	 * Créer une instance d'ArticleManager si il en existe pas déjà une
	 * @return
	 */

	public static ArticleManager getInstance() {
		if(instance ==null) {
			instance = new ArticleManager();
			
		}
		
		return instance;
	}
	/**
	 * Créer un objet ArticleDAO grâce à la DAOFactory
	 * @param article
	 * @throws SQLException
	 * @throws DALException 
	 */
	
	public void addArticle(Article article) {
		ArticleDAO ad = DAOFactory.getArticleDAO();
		ad.insertArticle(article);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
