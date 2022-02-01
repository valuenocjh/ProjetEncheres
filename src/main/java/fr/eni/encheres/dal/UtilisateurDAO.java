package fr.eni.encheres.dal;

import fr.eni.encheres.bo.Utilisateur;

public interface UtilisateurDAO {

	public void insert(Utilisateur utilisateur);
	public boolean selectByLogin(Utilisateur utilisateur);
	
}
