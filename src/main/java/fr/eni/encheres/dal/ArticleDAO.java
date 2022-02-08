package fr.eni.encheres.dal;



import java.util.List;

import fr.eni.encheres.bo.Article;

public interface ArticleDAO {
	
	//méthodes pour créer, supprimer un article 
		public void insertArticle(Article artcile) throws DALException;
		public void removeArticle(Article article) throws DALException;
		public List<Article> listeArticles() throws DALException;
		public Article selectArticle(Article article) throws DALException ;
}
