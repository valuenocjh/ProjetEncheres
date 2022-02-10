package fr.eni.encheres.dal;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.eni.encheres.bo.Enchere;

//classe qui hérite de l'interface EnchereDAO

public class EnchereDAOImpl implements EnchereDAO{

	//Requète SQL 
	public static final String INSERT = "INSERT INTO Encheres VALUES (?, ?, ?, ?);";
	public static final String UPDATE = "UPDATE Encheres SET montant_enchere = ? WHERE UTILISATEUR_no_utilisateur = ? AND ARTICLE_no_article = ?;";
	public static final String SELECT = "SELECT * FROM Encheres WHERE UTILISATEUR_no_utilisateur = ? AND ARTICLE_no_article = ?;";
	
	@Override
	public void insertEnchere(Enchere enchere) throws DALException {
		Connection cnx = null; 
		PreparedStatement pstmt = null;
		
		Date date_enchere =  new java.sql.Date(enchere.getDateEnchere().getTime());
		try {
			//Obtenir une connexion 
			cnx = ConnectionProvider.seConnecter();
			//Préparer la requète SQL
			pstmt = cnx.prepareStatement(INSERT);
			//Récupération des entrées utilisateur
			pstmt.setDate(1, date_enchere);
			pstmt.setInt(2, enchere.getUtilisateur().getNoUtilisateur());
			pstmt.setInt(3, enchere.getArticle().getNoArticle());
			pstmt.setInt(4, enchere.getMontantEnchere());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new DALException("probleme dans la methode insertEnchere()", e);
		} finally {
			ConnectionProvider.seDeconnecter(cnx, pstmt);
		}
	}


	@Override
	public boolean selectEnchere(Enchere enchere) {
		Connection cnx = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean enchereExiste = false;
		
		try {
			cnx = ConnectionProvider.seConnecter();
			pstmt = cnx.prepareStatement(SELECT);
			pstmt.setInt(1, enchere.getUtilisateur().getNoUtilisateur());
			pstmt.setInt(2, enchere.getArticle().getNoArticle());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				enchereExiste = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			ConnectionProvider.seDeconnecter(cnx, pstmt);
		}
		
		
		return enchereExiste;
	}


	@Override
	public void updateEnchere(Enchere enchere) {
		Connection cnx = null;
		PreparedStatement pstmt = null;
		
		try {
			cnx = ConnectionProvider.seConnecter();
			pstmt = cnx.prepareStatement(UPDATE);
			pstmt.setInt(1, enchere.getMontantEnchere());
			pstmt.setInt(2, enchere.getUtilisateur().getNoUtilisateur());
			pstmt.setInt(3, enchere.getArticle().getNoArticle());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			ConnectionProvider.seDeconnecter(cnx, pstmt);
		}
		
		
	}

}
