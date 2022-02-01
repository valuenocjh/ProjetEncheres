package fr.eni.encheres.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.eni.encheres.bo.Utilisateur;

public class UtilisateurDAOImpl implements UtilisateurDAO {

	private final static String SELECT_LOGIN ="SELECT * FROM Utilisateurs where pseudo = ? and mot_de_passe = ?;";
	private final static String INSERT="INSERT INTO Utilisateurs (pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, administrateur, credit) VALUES (?, ?,?, ?, ?,?,?,?,?,0,1000);";
	
	@Override
	public void insert(Utilisateur utilisateur) {

		try {
			Connection cnx = ConnectionProvider.seConnecter();
			PreparedStatement stmt = cnx.prepareStatement(INSERT);
			stmt.setString(1, utilisateur.getPseudo());
			stmt.setString(2, utilisateur.getNom());
			stmt.setString(3, utilisateur.getPrenom());
			stmt.setString(4, utilisateur.getEmail());
			stmt.setString(5, utilisateur.getTelephone());
			stmt.setString(6, utilisateur.getRue());
			stmt.setString(7, utilisateur.getCodePostal());
			stmt.setString(8, utilisateur.getVille());
			stmt.setString(9, utilisateur.getMotDePasse());
			stmt.executeUpdate();
		
		
		} catch (SQLException e) {
			System.out.println(e.getCause());
		} finally {
			ConnectionProvider.seDeconnecter(null, null);
		}
	
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
			
		}
		return false;
	}

}
