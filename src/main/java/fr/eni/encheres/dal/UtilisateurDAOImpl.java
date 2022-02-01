package fr.eni.encheres.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.eni.encheres.bo.Utilisateur;

public class UtilisateurDAOImpl implements UtilisateurDAO {

	private final static String SELECT_LOGIN ="SELECT * FROM Utilisateurs where pseudo = ? and mot_de_passe = ?;";
	
	
	@Override
	public void insert(Utilisateur utilisateur) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean selectByLogin(Utilisateur utilisateur){

		
		try {
			Connection cnx = ConnectionProvider.seConnecter();
			PreparedStatement stmt = cnx.prepareStatement(SELECT_LOGIN);
			stmt.setString(1, utilisateur.getPseudo());
			stmt.setString(2, utilisateur.getMotDePasse());
			ResultSet result = stmt.executeQuery();
		if(result.next()) { 
			utilisateur.setPseudo(result.getString("pseudo"));
			utilisateur.setMotDePasse(result.getString("mot_de_passe"));
			return true;
		}
		
		
		} 
		
		
		
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
