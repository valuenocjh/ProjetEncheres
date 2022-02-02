package fr.eni.encheres.bll;

import java.sql.SQLException;

import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.DAOFactory;
import fr.eni.encheres.dal.UtilisateurDAO;

public class UtilisateurManager {

	private static UtilisateurManager instance;

	private UtilisateurManager() {
	}
/**
 * Cr�er une instance d'UtilisateurManager si il en existe pas d�j� une
 * @return
 */
	public static UtilisateurManager getInstance() {

		if (instance == null) {

			instance = new UtilisateurManager();
		}

		return instance;

	}

	/**
	 * Cr�er un objet UtilisateurDAO gr�ce � la DAOFactory
	 * @param utilisateur
	 * @throws SQLException
	 */
	public void addUser(Utilisateur utilisateur) throws SQLException {

		UtilisateurDAO ud = DAOFactory.getUserDAO();

		ud.insert(utilisateur);

	}

	/**
	 * Renvoie un boolean si l'utilisateur existe d�j� en BDD
	 * @param user
	 * @return
	 */
	public boolean login(Utilisateur user) {

		UtilisateurDAO ud = DAOFactory.getUserDAO();

		return ud.selectByLogin(user);

	}

}