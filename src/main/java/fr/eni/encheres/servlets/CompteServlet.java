package fr.eni.encheres.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.encheres.bll.ArticleManager;
import fr.eni.encheres.bo.Article;
import fr.eni.encheres.bo.Categorie;
import fr.eni.encheres.dal.DALException;

//Servlet appelée lors de l'appuis sur le bouton connexion de la page pageconnexion
//DoGet appelle la page jsp liste des accueilconnecté
//DoPost traite la liste des enchères en mode connecté et les filtres
@WebServlet("/Compte")
public class CompteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/jsp/accueilconnecte.jsp").forward(request, response);

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// String requete ="SELECT * FROM Articles INNER JOIN Categories ON Articles.CATEGORIE_no_categorie = Categories.no_categorie INNER JOIN Utilisateurs ON Articles.UTILISATEUR_no_utilisateur=Utilisateurs.no_utilisateur  ";
		// String requete = "SELECT * from Articles LEFT JOIN encheres on articles.no_article = encheres.ARTICLE_no_article INNER JOIN Utilisateurs on Utilisateurs.no_utilisateur = Articles.UTILISATEUR_no_utilisateur INNER JOIN Categories on Categories.no_categorie = Articles.CATEGORIE_no_categorie ";
		
		//creation d'un boolean pour verifier si les checkbox sont cochées 
		boolean ck_encheresouvertes = request.getParameter("encheresOuvertes") != null ;
		//requete SQL de base que l'on va incrémenter selon la demande de l'utilisateur
		String encheresOuvertes ="select * from Articles WHERE ";
		Article article = new Article();
		
		
		article.setNomArticle(request.getParameter("filtre_nom"));
		
		encheresOuvertes += "nom_article LIKE ?";
		
		// si la case "encheres ouvertes" est cochée
		if(ck_encheresouvertes) { 
			encheresOuvertes+=" AND date_fin_encheres >= GETDATE() AND date_debut_encheres <= GETDATE() ";
		}
		

		String categorie = request.getParameter("categorie");
		

		
		// récupérer ce qu'a choisit l'utilisateur et le mettre dans la requete
		Categorie nouvelleCategorie = new Categorie();
		if (!categorie.equalsIgnoreCase("Toutes")) {
			encheresOuvertes += " AND libelle = ?;";
		}
		
		article.setCategorie(nouvelleCategorie);

		ArticleManager am = ArticleManager.getInstance();
		List<Article> listeArticlesparcat;
		try {
			listeArticlesparcat = am.selectListeParCat(article, encheresOuvertes);
			request.setAttribute("listeArticles", listeArticlesparcat);
		} catch (DALException e) {
          e.printStackTrace();
		}
		
		
		request.getRequestDispatcher("/WEB-INF/jsp/accueilnonconnecte.jsp").forward(request, response);
	
	
	
	}

}
