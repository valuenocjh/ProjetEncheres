package fr.eni.encheres.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.encheres.bll.UtilisateurManager;
import fr.eni.encheres.bo.Utilisateur;

/**
 * Servlet implementation class ConnexionServlet
 */
@WebServlet("/ConnexionServlet")
public class ConnexionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
request.getRequestDispatcher("/WEB-INF/jsp/pageConnexion.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String identifiant = request.getParameter("identifiant").trim().toLowerCase();
		String motdepasse = request.getParameter("motdepasse").trim().toLowerCase();
		
		Utilisateur rechercheUtilisateur = new Utilisateur();
		rechercheUtilisateur.setPseudo(identifiant);
		rechercheUtilisateur.setMotDePasse(motdepasse);
		UtilisateurManager um = UtilisateurManager.getInstance();
		if(um.login(rechercheUtilisateur)) {
			HttpSession session = request.getSession();
			session.setAttribute("identifiant", identifiant);
			response.sendRedirect(request.getContextPath()+"/Compte");
			} else {
				request.setAttribute("error", "numeroderreur");
				request.getRequestDispatcher("/WEB-INF/jsp/pageConnexion.jsp").forward(request, response);
				
			}
	}

}
