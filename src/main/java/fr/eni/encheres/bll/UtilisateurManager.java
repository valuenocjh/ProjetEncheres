package fr.eni.encheres.bll;

import java.sql.SQLException;

import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.DALException;
import fr.eni.encheres.dal.DAOFactory;
import fr.eni.encheres.dal.UtilisateurDAO;

public class UtilisateurManager {

	private static UtilisateurManager instance;

	private UtilisateurManager() {
	}
/**
 * Créer une instance d'UtilisateurManager si il en existe pas déjà une
 * @return
 */
	public static UtilisateurManager getInstance() {

		if (instance == null) {

			instance = new UtilisateurManager();
		}

		return instance;

	}

	/**
	 * Créer un objet UtilisateurDAO grâce à la DAOFactory
	 * @param utilisateur
	 * @throws SQLException
	 * @throws DALException 
	 */
	public void addUser(Utilisateur utilisateur) throws SQLException, DALException {

		UtilisateurDAO ud = DAOFactory.getUserDAO();

		ud.insert(utilisateur);

	}

	/**
	 * Renvoie un boolean si l'utilisateur existe déjà en BDD
	 * @param user
	 * @return
	 * @throws DALException 
	 */
	public boolean login(Utilisateur user) throws DALException {

		UtilisateurDAO ud = DAOFactory.getUserDAO();

		return ud.selectByLogin(user);

	}
	
	public Utilisateur loginInfo (Utilisateur userInfo) {
		
		UtilisateurDAO ud = DAOFactory.getUserDAO();
		return ud.selectInfo(userInfo); 
	}

	public void modifierUser(Utilisateur user, Utilisateur userAModifier) {
		//appeler la methode private validerUser() méthode a créer pour valider les contraintes de l'user
		UtilisateurDAO ud = DAOFactory.getUserDAO();
		ud.modifierProfil(user, userAModifier);
	}
}