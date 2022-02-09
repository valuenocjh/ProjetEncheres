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
import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.DALException;

//Servlet appelée lors de l'appuis sur le bouton connexion de la page pageconnexion
//DoGet appelle la page jsp liste des accueilconnecté
//DoPost traite la liste des enchères en mode connecté et les filtres
@WebServlet("/Compte")
public class CompteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("/ProjetEncheres/");

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//creation de booleans pour verifier si les checkbox sont cochées 
		
		// verifier si la checkbox encheres ouvertes est cochée
		boolean ck_encheresouvertes = request.getParameter("encheresOuvertes") != null ;
		
		//vérifier si la checkbox mes encheres en cours est cochée
		boolean ck_mesencheresencours = request.getParameter("mesEncheresEnCours") !=null;
		
		//vérifier si la checkbox mes encheres remportées est cochée
		boolean ck_mesencheresremportees = request.getParameter("EncheresRemportees") !=null;
		
		// vérifier si la checkbox mes ventes en cours est cochée
		boolean ck_mesventesencours = request.getParameter("mesventesencours") !=null;
		
		// vérifier si la checkbox ventes non débutées est cochée
		boolean ck_ventesnondebutees = request.getParameter("ventesnondebutees") !=null;
		
		// vérifier si la checkbox ventes terminées est cochée
		boolean ck_ventesterminees = request.getParameter("ventesterminees") !=null;
		
		
		Article article = new Article();
		
		article.setNomArticle(request.getParameter("filtre_nom"));
		article.setUtilisateur((Utilisateur) request.getSession().getAttribute("rechercheUtilisateur"));
		System.out.println(article.getNomArticle());
		
		// recuperation de la categorie choisie par l'utilisateur
		String categorie = request.getParameter("categorie");
				
		// création d'un objet catégorie
		Categorie nouvelleCategorie = new Categorie();
		nouvelleCategorie.setLibelle(categorie);
		article.setCategorie(nouvelleCategorie);
		
		// Recuperer Article pour Input text sur page connectee
		
		request.setAttribute("article", article);
		
		ArticleManager am = ArticleManager.getInstance();
		List<Article> listeArticlesparcat;
		try {
			listeArticlesparcat = am.selectListeParCat(article, ck_encheresouvertes, ck_mesencheresencours, ck_mesencheresremportees, ck_mesventesencours, ck_ventesnondebutees, ck_ventesterminees);
			request.setAttribute("listeArticles", listeArticlesparcat);
		} catch (DALException e) {
          e.printStackTrace();
		}
		
		
		request.getRequestDispatcher("/WEB-INF/jsp/accueilconnecte.jsp").forward(request, response);
	
	
	
	}

}
