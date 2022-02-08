package fr.eni.encheres.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sun.net.httpserver.Authenticator.Result;

import java.sql.Date;
import fr.eni.encheres.bo.Article;

public class ArticleDAOImpl implements ArticleDAO {
	
	private final static String INSERT =" INSERT INTO articles ( nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, UTILISATEUR_no_utilisateur, CATEGORIE_no_categorie) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
	private final static String SELECT_ARTICLES="SELECT  no_article ,nom_article ,description, prix_vente, date_fin_encheres, UTILISATEUR_no_utilisateur FROM Articles;";
	private final static String SELECT_ALL="SELECT no_article FROM Articles WHERE nom_article = ? AND description = ?;";

	
	@Override
	public void insertArticle(Article article) throws DALException {
		//cr�er une connexion ainsi qu'un PreparedStatement qu'on initialise � null
		Connection cnx = null;
		PreparedStatement stmt = null;
		//d�clarer la date de d�but et de fin des encheres
		Date debEncheres =  new java.sql.Date(article.getDateDebutEncheres().getTime());
		Date finEncheres =  new java.sql.Date(article.getDateFinEncheres().getTime());
		try {
			cnx = ConnectionProvider.seConnecter();
			//appeler la requete sql 
			stmt = cnx.prepareStatement(INSERT);
			//R�cup�ration des param�tres des entr�es utilisateurs dans la BDD
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
		
		//cr�er une connexion ainsi qu'un PreparedStatement qu'on initialise � null
				Connection cnx = null;
				PreparedStatement stmt = null;
				ResultSet result = null;
				List<Article> listeArticles =  new ArrayList<Article>();
			
				
				//d�clarer la date de d�but et de fin des encheres
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


	@Override
	public Article selectArticle(Article article) throws DALException {
		Connection cnx = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			cnx= ConnectionProvider.seConnecter();
			pstmt = cnx.prepareStatement(SELECT_ALL);
			pstmt.setString(1, article.getNomArticle());
			pstmt.setString(2, article.getDescription());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				article.setNoArticle(rs.getInt("no_article"));
			}
		} catch (SQLException e) {
			throw new DALException("probleme dans la methode selectArticle()", e);
		}
		return article;
	}


	@Override
	public List<Article> selectListeParCat(Article article, String requete) throws DALException {
		Connection cnx = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Article> listeArticlesParCat =  new ArrayList<Article>();
		
		try {
			cnx=ConnectionProvider.seConnecter();
			pstmt = cnx.prepareStatement(requete);
			pstmt.setString(1, "'%" + article.getNomArticle() + "%'");
			pstmt.setString(2, article.getCategorie().getLibelle());
			rs= pstmt.executeQuery();
			while (rs.next()) {
				Article art = new Article();
				art.setNoArticle(rs.getInt("no_article"));
				art.setNomArticle(rs.getString("nom_article"));
				art.setPrixVente(rs.getInt("prix_vente"));
				art.setDateFinEncheres(rs.getDate("date_fin_encheres"));
				art.setUtilisateur((new UtilisateurDAOImpl()).selectById(rs.getInt("UTILISATEUR_no_utilisateur")));
				
				listeArticlesParCat.add(art);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionProvider.seDeconnecter(cnx, pstmt);
		}
		
		return listeArticlesParCat;
	}

}
