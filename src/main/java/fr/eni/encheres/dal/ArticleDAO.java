package fr.eni.encheres.dal;



import java.util.List;

import fr.eni.encheres.bo.Article;

public interface ArticleDAO {
	
	//méthodes pour créer, supprimer un article 
		public void insertArticle(Article artcile) throws DALException;
		public void removeArticle(Article article) throws DALException;
		public List<Article> listeArticles() throws DALException;
		public Article selectArticle(Article article) throws DALException ;
		public List<Article> selectListeParCat(Article article, boolean ck_encheresouvertes, boolean ck_mesencheresencours, boolean ck_mesencheresremportees, boolean ck_mesventesencours, boolean ck_ventesnondebutees, boolean ck_ventesterminees) throws DALException;
		public Article selectArticleById(int id) throws DALException;
}
