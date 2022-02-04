package fr.eni.encheres.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** 
 * Servlet appel�e � l'ouveture de l'application 
 * DoGet renvoie vers la jsp listedesenecheresnonconnecte
 * DoPost va g�rer l'affichage de la liste des ench�res avec les filtres
 */
@WebServlet("/index.html")
public class AccueilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// si une session existe : envoi vers accueilconnecte
		// sinon envoi vers accueilnonconnecte
		if (request.getSession().getAttribute("rechercheUtilisateur") == null) {
			request.getRequestDispatcher("/WEB-INF/jsp/accueilnonconnecte.jsp").forward(request, response);
	}else {
		request.getRequestDispatcher("/WEB-INF/jsp/accueilconnecte.jsp").forward(request, response);
	}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/**
		 * filtres...
		 */
	}

}
