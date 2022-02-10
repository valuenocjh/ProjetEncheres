package fr.eni.encheres.dal;

import fr.eni.encheres.bo.Enchere;

//Interface 

public interface EnchereDAO {
	//m�thode pour ins�rer une ench�re
	
	public void insertEnchere(Enchere enchere) throws DALException;
	public boolean selectEnchere(Enchere enchere);
	public void updateEnchere(Enchere enchere);
}
