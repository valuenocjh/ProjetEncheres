package fr.eni.encheres.servlets;

import java.io.IOException;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.encheres.bll.ArticleManager;
import fr.eni.encheres.bll.BLLException;
import fr.eni.encheres.bo.Article;
import fr.eni.encheres.bo.Categorie;
import fr.eni.encheres.dal.DALException;

/** 
 * Servlet appelée à l'ouveture de l'application 
 * DoGet renvoie vers la jsp listedesenecheresnonconnecte
 * DoPost va gérer l'affichage de la liste des enchères avec les filtres
 */
@WebServlet("")
public class AccueilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		ArticleManager am = ArticleManager.getInstance();
		List<Article> listeArticles;
		try {
			listeArticles = am.listeArticles();
			request.getSession().setAttribute("listeArticles", listeArticles);
		} catch (BLLException e) {
			e.printStackTrace();
		}
		
		// si une session existe : envoi vers accueilconnecte
		// sinon envoi vers accueilnonconnecte
		if (request.getSession().getAttribute("rechercheUtilisateur") == null) {
			request.getRequestDispatcher("/WEB-INF/jsp/accueilnonconnecte.jsp").forward(request, response);
	}else {
		request.getRequestDispatcher("/WEB-INF/jsp/accueilconnecte.jsp").forward(request, response);
	}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Création d'un objet article
		Article article = new Article();
		
		// on lui donne le nom mis dans le filtre
		article.setNomArticle(request.getParameter("filtre_nom"));
		
		// création d'un String catégorie à partir du choix de l'utilisateur
		String categorie = request.getParameter("categorie");
		
		// création d'un objet catégorie
		Categorie nouvelleCategorie = new Categorie();
		
		// on lui donne le libellé choisit par l'utilisateur
		nouvelleCategorie.setLibelle(categorie);
		//on donne la catégorie a l'article
		article.setCategorie(nouvelleCategorie);
		// on crée une instance d'articleManager dans la bll 
		ArticleManager am = ArticleManager.getInstance();
		// création d'une liste d'Articles
		List<Article> selectListeParFiltresModeDeconnecte;
		

		// execution de la methode selectlisteparfiltresmodedeconnecte sur am
		try {
			selectListeParFiltresModeDeconnecte = am.selectListeParFiltresModeDeconnecte(article);
			request.setAttribute("listeArticles", selectListeParFiltresModeDeconnecte);
		} catch (DALException e) {
          e.printStackTrace();
		}
		
		// renvoi vers la jsp accueilconnecte avec affichage des résultats
		request.getRequestDispatcher("/WEB-INF/jsp/accueilnonconnecte.jsp").forward(request, response);
		
		
	}

}
