package fr.eni.encheres.dal;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

import fr.eni.encheres.bo.Enchere;

//classe qui hérite de l'interface EnchereDAO

public class EnchereDAOImpl implements EnchereDAO{

	//Requète SQL 
	public static final String INSERT = "Insert into Encheres Values (?, ?, ?, ?);";
	
	
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

}
