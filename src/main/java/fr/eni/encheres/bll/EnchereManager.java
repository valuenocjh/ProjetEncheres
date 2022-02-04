package fr.eni.encheres.bll;

import fr.eni.encheres.bo.Enchere;
import fr.eni.encheres.dal.DAOFactory;
import fr.eni.encheres.dal.EnchereDAO;

//Création du Singleton EnchereManager
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
	
	//Méthode pour insérer une enchère en passant par la DAOFactory
	public void insertEnchere(Enchere enchere) {
		EnchereDAO ed = DAOFactory.getEnchereDAO();
		ed.insertEnchere(enchere);
	}
}
