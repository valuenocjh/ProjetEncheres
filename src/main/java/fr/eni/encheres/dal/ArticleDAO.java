package fr.eni.encheres.dal;

import fr.eni.encheres.bo.Article;

public interface ArticleDAO {
	
	//m�thodes pour cr�er, supprimer un article 
		public void insertArticle(Article artcile);
		public void removeArticle(Article article);
		
}
