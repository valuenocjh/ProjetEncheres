package fr.eni.encheres.dal;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sun.net.httpserver.Authenticator.Result;

import java.sql.Connection;
import java.sql.Date;
import fr.eni.encheres.bo.Article;
import fr.eni.encheres.bo.Categorie;

public class ArticleDAOImpl implements ArticleDAO {

	private final static String INSERT = " INSERT INTO articles ( nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, UTILISATEUR_no_utilisateur, CATEGORIE_no_categorie) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
	private final static String SELECT_ARTICLES = "SELECT  no_article ,nom_article ,description, prix_vente, date_fin_encheres, UTILISATEUR_no_utilisateur FROM Articles;";
	private final static String SELECT_ALL = "SELECT no_article FROM Articles WHERE nom_article = ? AND description = ?;";
	private final static String SELECT_BY_ID = "SELECT * FROM Articles INNER JOIN Categories ON Articles.CATEGORIE_no_categorie = Categories.no_categorie INNER JOIN Utilisateurs ON Articles.UTILISATEUR_no_utilisateur=Utilisateurs.no_utilisateur LEFT JOIN Encheres ON Articles.no_article = Encheres.ARTICLE_no_article WHERE no_article = ? AND Encheres.montant_enchere = (SELECT MAX(montant_enchere) FROM Encheres e2 Where e2.ARTICLE_no_article = Articles.no_article);";

	@Override
	public void insertArticle(Article article) throws DALException {
		// créer une connexion ainsi qu'un PreparedStatement qu'on initialise à null
		Connection cnx = null;
		PreparedStatement stmt = null;
		// déclarer la date de début et de fin des encheres
		Date debEncheres = new java.sql.Date(article.getDateDebutEncheres().getTime());
		Date finEncheres = new java.sql.Date(article.getDateFinEncheres().getTime());
		try {
			cnx = ConnectionProvider.seConnecter();
			// appeler la requete sql
			stmt = cnx.prepareStatement(INSERT);
			// Récupération des paramètres des entrées utilisateurs dans la BDD
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
	public void removeArticle(Article article) throws DALException {
		// TODO Auto-generated method stub

	}

	@Override
	public Article selectArticleById(int id) throws DALException {

		// créer une connexion ainsi qu'un PreparedStatement qu'on initialise à null
		Connection cnx = null;
		PreparedStatement stmt = null;
		ResultSet result = null;

		// déclarer la date de début et de fin des encheres
		try {
			cnx = ConnectionProvider.seConnecter();
			stmt = cnx.prepareStatement(SELECT_BY_ID);
			stmt.setInt(1, id);
		
			result = stmt.executeQuery();
			
			if (result.next()) {
				
				Article article = new Article();
				
				article.setNoArticle(result.getInt("no_article"));
				article.setNomArticle(result.getString("nom_article"));
				article.setPrixVente(result.getInt("prix_vente"));
				article.setDateFinEncheres(result.getDate("date_fin_encheres"));
				article.setDescription(result.getString("description"));
				article.setPrixInitial(result.getInt("prix_initial"));
				Categorie cat = new Categorie();
				cat.setLibelle(result.getString("libelle"));
				cat.setNoCategorie(result.getInt("no_categorie"));
				
				article.setCategorie(cat);
				article.setUtilisateur((new UtilisateurDAOImpl()).selectById(result.getInt("UTILISATEUR_no_utilisateur")));

				return article;
			}
		} catch (SQLException | DALException e) {
			throw new DALException("probleme dans la methode listeArticles()", e);
		} finally {
			ConnectionProvider.seDeconnecter(cnx, stmt);
		}
		
		return null;
	}

	@Override
	public List<Article> listeArticles() throws DALException {

		// créer une connexion ainsi qu'un PreparedStatement qu'on initialise à null
		Connection cnx = null;
		PreparedStatement stmt = null;
		ResultSet result = null;
		List<Article> listeArticles = new ArrayList<Article>();

		// déclarer la date de début et de fin des encheres
		try {
			cnx = ConnectionProvider.seConnecter();
			stmt = cnx.prepareStatement(SELECT_ARTICLES);
			result = stmt.executeQuery();
			while (result.next()) {
				Article article = new Article();
				article.setNoArticle(result.getInt("no_article"));
				article.setNomArticle(result.getString("nom_article"));
				article.setPrixVente(result.getInt("prix_vente"));
				article.setDateFinEncheres(result.getDate("date_fin_encheres"));
				article.setUtilisateur(
						(new UtilisateurDAOImpl()).selectById(result.getInt("UTILISATEUR_no_utilisateur")));

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
			cnx = ConnectionProvider.seConnecter();
			pstmt = cnx.prepareStatement(SELECT_ALL);
			pstmt.setString(1, article.getNomArticle());
			pstmt.setString(2, article.getDescription());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				article.setNoArticle(rs.getInt("no_article"));
			}
		} catch (SQLException e) {
			throw new DALException("probleme dans la methode selectArticle()", e);
		}
		return article;
	}

	@Override
	// méthode de recherche avec filtres en mode connecte
	public List<Article> selectListeParFiltresModeConnecte(Article article, boolean ck_encheresouvertes, boolean ck_mesencheresencours,
			boolean ck_mesencheresremportees, boolean ck_mesventesencours, boolean ck_ventesnondebutees,
			boolean ck_ventesterminees) throws DALException {
		Connection cnx = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Article> selectListeParFiltresModeConnecte = new ArrayList<Article>();
		int i = 1;

		// création de la requette avec le nom de l'article
		String requete = "SELECT * FROM Articles INNER JOIN Categories ON Articles.CATEGORIE_no_categorie = Categories.no_categorie INNER JOIN Utilisateurs ON Articles.UTILISATEUR_no_utilisateur=Utilisateurs.no_utilisateur LEFT JOIN Encheres ON Articles.no_article = Encheres.ARTICLE_no_article WHERE nom_article LIKE :nom_article";

		// complement de la requete avec le traitement des categories
		if (!article.getCategorie().getLibelle().equalsIgnoreCase("Toutes")) {
			requete += "  AND libelle = :categorie_libelle ";
			i++;
		}

		String subRequest = "";

		
		// completement de la requete avec la checkbox encheres ouvertes cochée
		if (ck_encheresouvertes) {
			subRequest += "(date_fin_encheres >= GETDATE() AND date_debut_encheres <= GETDATE()) OR";
		}

		// complement de la requete avec la checkbox mes encheres en cours cochee
		if (ck_mesencheresencours) {
			subRequest += "(date_fin_encheres >= GETDATE() AND Encheres.UTILISATEUR_no_utilisateur = :numero_utilisateur) OR";
			i++;
		}

		// completement de la requete avec la checkbox mes encheres remportées cochée
		if (ck_mesencheresremportees) {
			subRequest += "(Encheres.UTILISATEUR_no_utilisateur = :numero_utilisateur AND Encheres.date_enchere < GETDATE() AND Encheres.montant_enchere = (SELECT MAX(montant_enchere) FROM Encheres e2 Where e2.ARTICLE_no_article = Articles.no_article)) OR";
			i++;
		}

		// completement de la requete avec la checkbox mes ventes en cours cochée
		if (ck_mesventesencours) {
			subRequest += "(Articles.UTILISATEUR_no_utilisateur = :numero_utilisateur AND date_fin_encheres >= GETDATE() AND date_debut_encheres <= GETDATE()) OR";
			i++;
		}

		// completement de la requete avec la checkbox mes ventes non débutées cochée
		if (ck_ventesnondebutees) {
			subRequest += "(Articles.UTILISATEUR_no_utilisateur = :numero_utilisateur AND date_debut_encheres > GETDATE()) OR";
			i++;
		}

		// complement de la requete avec la checkbox ventes terminées cochée
		if (ck_ventesterminees) {
			subRequest += "(Articles.UTILISATEUR_no_utilisateur = :numero_utilisateur AND date_fin_encheres < GETDATE()) OR";
			i++;
		}
		
		if (!subRequest.isEmpty()) {
			subRequest = " AND (" + subRequest.substring(0, subRequest.length() - 2) + ")";
		}
		
		
		requete += subRequest + ";";
		try {
			cnx = ConnectionProvider.seConnecter();

			// ajout du nom d'article à la requete
			// pstmt.setString(1, "%" + article.getNomArticle() + "%");

			// si filtre différent de toutes : ajout du libellé de la categorie à la requete
			/*
			 * if (!article.getCategorie().getLibelle().equalsIgnoreCase("Toutes")) {
			 * pstmt.setString(2, article.getCategorie().getLibelle()); }
			 * 
			 * // si une des checkbox est cochée, l'utilisateur devient celui de la session
			 * if(ck_mesencheresencours || ck_mesencheresremportees || ck_mesventesencours
			 * || ck_ventesnondebutees || ck_ventesterminees) { pstmt.setInt(3,
			 * article.getUtilisateur().getNoUtilisateur()); }
			 */ 
					

	requete = requete.replaceAll(":categorie_libelle", "'" + article.getCategorie().getLibelle() + "'")
						.replaceAll(":numero_utilisateur", String.valueOf(article.getUtilisateur().getNoUtilisateur()))
						.replaceAll(":nom_article", "'%" + article.getNomArticle() + "%'");			


	System.out.println(requete);


			pstmt = cnx.prepareStatement(requete);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Article art = new Article();
				art.setNoArticle(rs.getInt("no_article"));
				art.setNomArticle(rs.getString("nom_article"));
				art.setPrixVente(rs.getInt("prix_vente"));
				art.setDateFinEncheres(rs.getDate("date_fin_encheres"));
				art.setUtilisateur((new UtilisateurDAOImpl()).selectById(rs.getInt("UTILISATEUR_no_utilisateur")));
				selectListeParFiltresModeConnecte.add(art);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionProvider.seDeconnecter(cnx, pstmt);
		}

		return selectListeParFiltresModeConnecte;
	}
	
	@Override
	// méthode de recherche avec filtres en mode connecte
	public List<Article> selectListeParFiltresModeDeconnecte(Article article) throws DALException {
		Connection cnx = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Article> selectListeParFiltresModeDeconnecte = new ArrayList<Article>();
		int i = 1;

		// création de la requette avec le nom de l'article
		String requete = "SELECT * FROM Articles INNER JOIN Categories ON Articles.CATEGORIE_no_categorie = Categories.no_categorie INNER JOIN Utilisateurs ON Articles.UTILISATEUR_no_utilisateur=Utilisateurs.no_utilisateur LEFT JOIN Encheres ON Articles.no_article = Encheres.ARTICLE_no_article WHERE nom_article LIKE :nom_article ";

		// complement de la requete avec le traitement des categories
		if (!article.getCategorie().getLibelle().equalsIgnoreCase("Toutes")) {
			requete += " AND libelle = :categorie_libelle";
			i++;
		}

		requete += ";";
		try {
			cnx = ConnectionProvider.seConnecter();

	requete = requete.replaceAll(":categorie_libelle", "'" + article.getCategorie().getLibelle() + "'")
						.replaceAll(":nom_article", "'%" + article.getNomArticle() + "%'");			


			pstmt = cnx.prepareStatement(requete);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Article art = new Article();
				art.setNoArticle(rs.getInt("no_article"));
				art.setNomArticle(rs.getString("nom_article"));
				art.setPrixVente(rs.getInt("prix_vente"));
				art.setDateFinEncheres(rs.getDate("date_fin_encheres"));
				art.setUtilisateur((new UtilisateurDAOImpl()).selectById(rs.getInt("UTILISATEUR_no_utilisateur")));
				selectListeParFiltresModeDeconnecte.add(art);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionProvider.seDeconnecter(cnx, pstmt);
		}

		return selectListeParFiltresModeDeconnecte;
	}

}
