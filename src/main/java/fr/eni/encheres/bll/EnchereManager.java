package fr.eni.encheres.bll;

import fr.eni.encheres.bo.Enchere;
import fr.eni.encheres.dal.DALException;
import fr.eni.encheres.dal.DAOFactory;
import fr.eni.encheres.dal.EnchereDAO;

//Cr�ation du Singleton EnchereManager
public class EnchereManager {
	
	private static EnchereManager instance;
	
	private EnchereManager(){
		
	}
	
	public static EnchereManager getInstance() {
		if(instance==null) {
			instance= new EnchereManager();
		}
		return instance;
	}
	
	//M�thode pour ins�rer une ench�re en passant par la DAOFactory
	public void insertEnchere(Enchere enchere) throws BLLException {
		EnchereDAO ed = DAOFactory.getEnchereDAO();
		try {
			ed.insertEnchere(enchere);
		} catch (DALException e) {
			throw new BLLException("probleme dans la methode insertEnchere()", e);
		}
	}
	
	public boolean selectEnchere(Enchere enchere) {
		EnchereDAO ed = DAOFactory.getEnchereDAO();
		return ed.selectEnchere(enchere);
	}
	
	public void updateEnchere(Enchere enchere) {
		EnchereDAO ed = DAOFactory.getEnchereDAO();
		ed.updateEnchere(enchere);
	}
}
