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

/** 
 * Servlet appelée à l'ouveture de l'application 
 * DoGet renvoie vers la jsp listedesenecheresnonconnecte
 * DoPost va gérer l'affichage de la liste des enchères avec les filtres
 */
@WebServlet("/index.html")
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

		
		
	}

}
