package fr.eni.encheres.dal;

import java.sql.SQLException;

import fr.eni.encheres.bo.Utilisateur;

public interface UtilisateurDAO {

	//m�thodes appel�es pour ins�rer un nouvel utilisateur 
	//ou rechercher un utilisateur dans la base
	public void insert(Utilisateur utilisateur) throws DALException;
	public boolean selectByLogin(Utilisateur utilisateur)throws DALException;
	public Utilisateur selectInfo(Utilisateur utilisateur) throws DALException;
	public Utilisateur selectById(int id) throws DALException;
	public void modifierProfil(Utilisateur utilisateur, Utilisateur userUtilisateur) throws DALException;
	public void supUser(Utilisateur utilisateur) throws DALException;

}
