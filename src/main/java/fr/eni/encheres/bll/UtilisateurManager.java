package fr.eni.encheres.bll;

import java.sql.SQLException;

import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.DALException;
import fr.eni.encheres.dal.DAOFactory;
import fr.eni.encheres.dal.UtilisateurDAO;

public class UtilisateurManager {
	//Création du Singleton UtilisateurManager

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
	
	//méthode pour créer un compte
	
	public Utilisateur loginInfo (Utilisateur userInfo) throws BLLException {
		
		UtilisateurDAO ud = DAOFactory.getUserDAO();
		try {
			return ud.selectInfo(userInfo);
		} catch (DALException e) {
			throw new BLLException("probleme dans la methode loginInfo()", e);
		} 
	}

	public void modifierUser(Utilisateur user, Utilisateur userAModifier) throws BLLException {
		//appeler la methode private validerUser() méthode a créer pour valider les contraintes de l'user
		UtilisateurDAO ud = DAOFactory.getUserDAO();
		try {
			ud.modifierProfil(user, userAModifier);
		} catch (DALException e) {
			throw new BLLException("probleme dans la methode modifierUser()", e);
		}
	}
	
	public Utilisateur SelectbyID (int id) throws BLLException, DALException {
		UtilisateurDAO ud = DAOFactory.getUserDAO();

			return ud.selectById(id);
		}	
}