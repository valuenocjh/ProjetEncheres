package fr.eni.encheres.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;

import fr.eni.encheres.bo.Article;

public class ArticleDAOImpl implements ArticleDAO {
	
	private final static String INSERT =" INSERT INTO articles ( nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, UTILISATEUR_no_utilisateur, CATEGORIE_no_categorie) VALUES ('?', '?', '?', '?', ?, ?, ?, ?);";


	@Override
	public void insertArticle(Article article) {
		//créer une connexion ainsi qu'un PreparedStatement qu'on initialise à null
		Connection cnx = null;
		PreparedStatement stmt = null;
		//déclarer la date de début et de fin des encheres
		Date debEncheres =  new java.sql.Date(article.getDateDebutEncheres().getTime());
		Date finEncheres =  new java.sql.Date(article.getDateFinEncheres().getTime());
		try {
			cnx = ConnectionProvider.seConnecter();
			//appeler la requete sql
			stmt = cnx.prepareStatement(INSERT);
			stmt.setString(1, article.getNomArticle());
			stmt.setString(2, article.getDescription());
			stmt.setDate(3, debEncheres);
			stmt.setDate(4, finEncheres);
			stmt.setInt(5, article.getPrixInitial());
			stmt.setInt(6, article.getPrixVente());
			stmt.setInt(7, article.getUtilisateur().getNoUtilisateur());
			stmt.setInt(8, article.getCategorie().getNoCategorie());
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
		

	@Override
	public void removeArticle(Article article) {
		// TODO Auto-generated method stub

	}

}
