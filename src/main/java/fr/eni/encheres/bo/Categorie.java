package fr.eni.encheres.bo;

public class Categorie {

	//Declaration des variables
	private int noCategorie;
	private String libelle;

	/*
	 * Constructeur
	 */

	public Categorie(String libelle) {
		setLibelle(libelle);
	}

	/*
	 * Constructeur
	 */

	public Categorie() {

	}

	//Accesseurs - Mutateurs
	
	public int getNoCategorie() {
		return noCategorie;
	}

	public void setNoCategorie(int noCategorie) {
		this.noCategorie = noCategorie;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

}
