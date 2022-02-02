package fr.eni.encheres.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.eni.encheres.bo.Utilisateur;

public class UtilisateurDAOImpl implements UtilisateurDAO {

	/*
	 * requetes SQL pour verifier qu'un utilisateur existe dans la base, soit avec
	 * un identifiant, soit avec un mail deuxieme requete pour insérer un nouvel
	 * utilisateur dans la base de données
	 */

	private final static String SELECT_LOGIN = "SELECT pseudo, email, mot_de_passe FROM Utilisateurs where (pseudo = ? or email = ?)and mot_de_passe = ?;";
	private final static String INSERT = "INSERT INTO Utilisateurs (pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, administrateur, credit) VALUES (?, ?,?, ?, ?,?,?,?,?,0,1000);";

	@Override
	// méthode pour insérer un utilisateur dans la base de données
	public void insert(Utilisateur utilisateur) throws DALException, SQLException {
		Connection cnx = ConnectionProvider.seConnecter();
		PreparedStatement stmt = cnx.prepareStatement(INSERT);

		try {
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
			throw new DALException("probleme methode insert", e);
		} finally {
			ConnectionProvider.seDeconnecter(cnx, stmt);
		}
	}
	@Override
	/*
	 * méthode pour vérifier si un utilisateur existe pour se connecter soit par
	 * identifiant, soit par email
	 */
	public boolean selectByLogin(Utilisateur utilisateur) throws DALException {
		Connection cnx = null;
		PreparedStatement stmt= null;
		ResultSet result=null;
		boolean existeUser = false;
		
		// tester le parametre de ma methode
		//if (utilisateur == null) {
		//	throw new DALException("utilisateur inexistant - Classe: UtilisateurDAOImpl - Methode: SelectByLogin - Ligne 61");
		//}
		
		// obtenir une connexion à la base de données du pool de connexion

		try {
			cnx = ConnectionProvider.seConnecter();
			//demande à la BDD de me renvoyer un objet pstmt
			stmt = cnx.prepareStatement(SELECT_LOGIN);
			//remplace au moment de l'execution sur la serveur des parametres
			// par leur valeur
			stmt.setString(1, utilisateur.getPseudo());
			stmt.setString(2, utilisateur.getEmail());
			stmt.setString(3, utilisateur.getMotDePasse());
			//demande au serveur d'executer la requete. Le serveur me renvoie
			//un rs parce que la requete est de type select
			result = stmt.executeQuery();

			//etant donné que le login et email UNIQUE j'utilise un if pour obtenir
			//l'enregistrement
			if (result.next()) {
				//utilisateur.setPseudo(result.getString("pseudo"));
				//utilisateur.setMotDePasse(result.getString("mot_de_passe"));
				existeUser= true;
			}

		}

		catch (SQLException e) {
			throw new DALException("Erreur dans la méthode SelectByLogin", e);
		}
		return existeUser;
	}

}
