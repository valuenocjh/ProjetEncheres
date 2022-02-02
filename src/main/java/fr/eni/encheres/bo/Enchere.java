package fr.eni.encheres.bo;

import java.util.Date;

public class Enchere {
	
	//Declaration des variables
	private Date dateEnchere;
	private int montantEnchere;
	private ArticleVendu article;
	private Utilisateur utilisateur;

	//Constructeur vide
	public Enchere() {

	}

	//Constructeur surchargé
	public Enchere(Date dateEnchere, int montantEnchere, ArticleVendu article, Utilisateur utilisateur) {

		setDateEnchere(dateEnchere);
		setMontantEnchere(montantEnchere);
		setArticle(article);
		setUtilisateur(utilisateur);
	}

	//Accesseurs - Mutateurs
	
	public Date getDateEnchere() {
		return dateEnchere;
	}

	public void setDateEnchere(Date dateEnchere) {
		this.dateEnchere = dateEnchere;
	}

	public int getMontantEnchere() {
		return montantEnchere;
	}

	public void setMontantEnchere(int montantEnchere) {
		this.montantEnchere = montantEnchere;
	}

	public ArticleVendu getArticle() {
		return article;
	}

	public void setArticle(ArticleVendu article) {
		this.article = article;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

}
