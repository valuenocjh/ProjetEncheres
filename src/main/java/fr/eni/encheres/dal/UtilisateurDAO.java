package fr.eni.encheres.dal;

import java.sql.SQLException;

import fr.eni.encheres.bo.Utilisateur;

public interface UtilisateurDAO {

	//méthodes appelées pour insérer un nouvel utilisateur 
	//ou rechercher un utilisateur dans la base
	public void insert(Utilisateur utilisateur) throws DALException, SQLException;
	public boolean selectByLogin(Utilisateur utilisateur)throws DALException;
	public Utilisateur selectInfo(Utilisateur utilisateur);
	public void modifierProfil(Utilisateur utilisateur, Utilisateur userUtilisateur);

}
