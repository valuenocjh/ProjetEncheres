package fr.eni.encheres.bo;

public class Retrait {

	private String rue;
	private String codePostal;
	private String ville;
	private ArticleVendu article;
	
	
	public Retrait() {
	}

	
	
	public Retrait(String rue, String codePostal, String ville, ArticleVendu article) {
		setRue(rue);
		setCodePostal(codePostal);
		setVille(ville);
		setArticle(article);
		
	}


	public String getRue() {
		return rue;
	}


	public void setRue(String rue) {
		this.rue = rue;
	}


	public String getCodePostal() {
		return codePostal;
	}


	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}


	public String getVille() {
		return ville;
	}


	public void setVille(String ville) {
		this.ville = ville;
	}


	public ArticleVendu getArticle() {
		return article;
	}


	public void setArticle(ArticleVendu article) {
		this.article = article;
	}
	
	
}


