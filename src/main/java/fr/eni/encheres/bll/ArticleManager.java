package fr.eni.encheres.bll;

import java.sql.SQLException;
import java.util.List;

import fr.eni.encheres.bo.Article;
import fr.eni.encheres.bo.Categorie;
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
	
	public Article selectArticle(Article article) throws DALException {
		ArticleDAO ad = DAOFactory.getArticleDAO();
		return ad.selectArticle(article);
	}
	
	public List<Article> selectListeParFiltresModeConnecte (Article article, boolean ck_encheresouvertes, boolean ck_mesencheresencours, boolean ck_mesencheresremportees, boolean ck_mesventesencours, boolean ck_ventesnondebutees, boolean ck_ventesterminees) throws DALException {
		ArticleDAO ad = DAOFactory.getArticleDAO();
		return ad.selectListeParFiltresModeConnecte(article, ck_encheresouvertes, ck_mesencheresencours, ck_mesencheresremportees, ck_mesventesencours, ck_ventesnondebutees, ck_ventesterminees);
	}
	
	public List<Article> selectListeParFiltresModeDeconnecte (Article article) throws DALException {
		ArticleDAO ad = DAOFactory.getArticleDAO();
		return ad.selectListeParFiltresModeDeconnecte(article);
	}
	
	public Article selectArticleById(int id) throws DALException {
		ArticleDAO ad = DAOFactory.getArticleDAO();
		return ad.selectArticleById(id);
	}
	
	
}
