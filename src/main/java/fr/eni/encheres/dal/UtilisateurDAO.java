package fr.eni.encheres.dal;

import java.sql.SQLException;

import fr.eni.encheres.bo.Utilisateur;

public interface UtilisateurDAO {

	//m�thodes appel�es pour ins�rer un nouvel utilisateur 
	//ou rechercher un utilisateur dans la base
	public void insert(Utilisateur utilisateur) throws SQLException;
	public boolean selectByLogin(Utilisateur utilisateur);
	
}
