package fr.eni.encheres.dal;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import fr.eni.encheres.bo.Enchere;

//classe qui h�rite de l'interface EnchereDAO

public class EnchereDAOImpl implements EnchereDAO{

	//Requ�te SQL 
	public static final String INSERT = "Insert into encheres Values (?, ?, ?, ?);";
	
	
	@Override
	public void insertEnchere(Enchere enchere) {
		Connection cnx = null; 
		PreparedStatement pstmt = null;
		
		Date date_enchere =  new java.sql.Date(enchere.getDateEnchere().getTime());
		try {
			//Obtenir une connexion 
			cnx = ConnectionProvider.seConnecter();
			//Pr�parer la requ�te SQL
			pstmt = cnx.prepareStatement(INSERT);
			//R�cup�ration des entr�es utilisateur
			pstmt.setDate(1, date_enchere);
			pstmt.setInt(2, enchere.getUtilisateur().getNoUtilisateur());
			pstmt.setInt(3, enchere.getArticle().getNoArticle());
			pstmt.setInt(4, enchere.getMontantEnchere());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
