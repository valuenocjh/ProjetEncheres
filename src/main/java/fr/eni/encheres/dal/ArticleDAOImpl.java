package fr.eni.encheres.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;
import fr.eni.encheres.bo.Article;

public class ArticleDAOImpl implements ArticleDAO {
	
	private final static String INSERT =" INSERT INTO articles ( nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, UTILISATEUR_no_utilisateur, CATEGORIE_no_categorie) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
	private final static String SELECT_ARTICLES="SELECT  no_article ,nom_article ,description, prix_vente, date_fin_encheres, UTILISATEUR_no_utilisateur FROM Articles;";
	
	@Override
	public void insertArticle(Article article) throws DALException {
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
			//Récupération des paramètres des entrées utilisateurs dans la BDD
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
			throw new DALException("probleme dans la methode insertArticle()", e);
		} finally {
			ConnectionProvider.seDeconnecter(cnx, stmt);
		}
		
	}
		

	@Override
	public void removeArticle(Article article) throws DALException{
		// TODO Auto-generated method stub

	}
	

	@Override
	public List<Article> listeArticles() throws DALException {
		
		//créer une connexion ainsi qu'un PreparedStatement qu'on initialise à null
				Connection cnx = null;
				PreparedStatement stmt = null;
				ResultSet result = null;
				List<Article> listeArticles =  new ArrayList<Article>();
			
				
				//déclarer la date de début et de fin des encheres
				try {
					cnx = ConnectionProvider.seConnecter();
					stmt= cnx.prepareStatement(SELECT_ARTICLES);
					result = stmt.executeQuery();
					while (result.next() ) {
						Article article = new Article();
						article.setNoArticle(result.getInt("no_article"));
						article.setNomArticle(result.getString("nom_article"));
						article.setPrixVente(result.getInt("prix_vente"));
						article.setDateFinEncheres(result.getDate("date_fin_encheres"));
						article.setUtilisateur((new UtilisateurDAOImpl()).selectById(result.getInt("UTILISATEUR_no_utilisateur")));
								
						listeArticles.add(article);
					}
				} catch (SQLException | DALException e) {
					throw new DALException("probleme dans la methode listeArticles()", e);
				} finally {
					ConnectionProvider.seDeconnecter(cnx, stmt);
				}
				
		return listeArticles;
	}

}
