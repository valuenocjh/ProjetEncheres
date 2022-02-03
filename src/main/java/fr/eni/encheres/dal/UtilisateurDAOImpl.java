package fr.eni.encheres.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import fr.eni.encheres.bo.Utilisateur;

public class UtilisateurDAOImpl implements UtilisateurDAO {

	/*
	 * requetes SQL pour verifier qu'un utilisateur existe dans la base, soit avec
	 * un identifiant, soit avec un mail deuxieme requete pour insérer un nouvel
	 * utilisateur dans la base de données
	 */

	private final static String SELECT_LOGIN = "SELECT pseudo, email, mot_de_passe FROM Utilisateurs where (pseudo = ? or email = ?)and mot_de_passe = ?;";
	private final static String INSERT = "INSERT INTO Utilisateurs (pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, administrateur, credit) VALUES (?, ?,?, ?, ?,?,?,?,?,0,1000);";
	private final static String SELECT_INFO ="SELECT pseudo, nom, prenom, email, telephone, rue, code_postal, ville, credit	FROM Utilisateurs WHERE (pseudo = ? or email =?);";
	private final static String MODIFIER_PROFIL="UPDATE Utilisateurs SET pseudo = ?, nom = ?, prenom = ?, email = ?, telephone = ?, rue = ? ,code_postal = ?, ville = ?, mot_de_passe = ? WHERE pseudo = ?;";
	
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

	
		public Utilisateur selectInfo (Utilisateur utilisateur) {
			
			// Initialisations des variables
			Connection cnx = null;
			PreparedStatement pstmt= null;
			ResultSet result=null;
			//Utilisateur user =null;
			
			
			// Recuperation des attributs par la BDD
			try {
				cnx = ConnectionProvider.seConnecter();
				pstmt = cnx.prepareStatement(SELECT_INFO);
				pstmt.setString(1, utilisateur.getPseudo());
				pstmt.setString(2, utilisateur.getEmail());
				result = pstmt.executeQuery();
				
				// donner les attributs de l'utilisateur en base de données
				// à l'utilisateur créee auparavant
				if(result.next()) { 
					utilisateur.setPseudo(result.getString("pseudo"));
					utilisateur.setNom(result.getString("nom"));
					utilisateur.setPrenom(result.getString("prenom"));
					utilisateur.setEmail(result.getString("email"));
					utilisateur.setTelephone(result.getString("telephone"));
					utilisateur.setRue(result.getString("rue"));
					utilisateur.setCodePostal(result.getString("code_postal"));
					utilisateur.setVille(result.getString("ville"));
					utilisateur.setCredit(result.getInt("credit"));

				}
				
				
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
			return utilisateur; 
		}
		@Override
		public void modifierProfil(Utilisateur utilisateur, Utilisateur userAModifier) {
			Connection cnx = null;
			PreparedStatement pstmt = null;
			try {
				cnx = ConnectionProvider.seConnecter();
				pstmt = cnx.prepareStatement(MODIFIER_PROFIL);
				pstmt.setString(1, utilisateur.getPseudo());
				pstmt.setString(2, utilisateur.getNom());
				pstmt.setString(3, utilisateur.getPrenom());
				pstmt.setString(4, utilisateur.getEmail());
				pstmt.setString(5, utilisateur.getTelephone());
				pstmt.setString(6, utilisateur.getRue());
				pstmt.setString(7, utilisateur.getCodePostal());
				pstmt.setString(8, utilisateur.getVille());
				pstmt.setString(9, utilisateur.getMotDePasse());
				pstmt.setString(10, userAModifier.getPseudo());
				pstmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
	
}
