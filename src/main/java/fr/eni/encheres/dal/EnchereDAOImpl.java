package fr.eni.encheres.dal;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import fr.eni.encheres.bo.Enchere;

public class EnchereDAOImpl implements EnchereDAO{

	public static final String INSERT = "Insert into encheres Values (?, ?, ?, ?);";
	
	@Override
	public void insertEnchere(Enchere enchere) {
		Connection cnx = null; 
		PreparedStatement pstmt = null;
		
		Date date_enchere =  new java.sql.Date(enchere.getDateEnchere().getTime());
		try {
			cnx = ConnectionProvider.seConnecter();
			pstmt = cnx.prepareStatement(INSERT);
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
