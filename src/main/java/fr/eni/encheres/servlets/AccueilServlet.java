package fr.eni.encheres.servlets;

import java.io.IOException;
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
// a retirer du code
System.out.println("requete utilisée ?");
		Article article = new Article();
		
		article.setNomArticle(request.getParameter("filtre_nom"));
		String categorie = request.getParameter("categorie");
		
		// récupérer ce qu'a choisit l'utilisateur et le mettre dans la requete
		Categorie nouvelleCategorie = new Categorie();
		nouvelleCategorie.setLibelle(categorie);
		
		article.setCategorie(nouvelleCategorie);

		ArticleManager am = ArticleManager.getInstance();
		List<Article> selectListeParFiltresModeDeconnecte;
		

		
		try {
			selectListeParFiltresModeDeconnecte = am.selectListeParFiltresModeDeconnecte(article);
			request.setAttribute("listeArticles", selectListeParFiltresModeDeconnecte);
			System.out.println(selectListeParFiltresModeDeconnecte.size());
		} catch (DALException e) {
          e.printStackTrace();
		}
		
		
		request.getRequestDispatcher("/WEB-INF/jsp/accueilnonconnecte.jsp").forward(request, response);
		//response.sendRedirect("/ProjetEncheres/");
		
		
	}

}
