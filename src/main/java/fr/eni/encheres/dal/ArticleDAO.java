package fr.eni.encheres.dal;

import fr.eni.encheres.bo.Article;

public interface ArticleDAO {
	
	//méthodes pour créer, supprimer un article 
		public void insertArticle(Article artcile);
		public void removeArticle(Article article);
		
}
