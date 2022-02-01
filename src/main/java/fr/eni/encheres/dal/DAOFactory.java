package fr.eni.encheres.dal;

public class DAOFactory {

	public static UtilisateurDAO getUserDAO() {

	return new UtilisateurDAOImpl();

}
	}
