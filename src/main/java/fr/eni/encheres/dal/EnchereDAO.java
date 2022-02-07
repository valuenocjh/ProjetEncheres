package fr.eni.encheres.dal;

import fr.eni.encheres.bo.Enchere;

//Interface 

public interface EnchereDAO {
	//méthode pour insérer une enchère
	
	public void insertEnchere(Enchere enchere) throws DALException;
	
}
