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


@WebServlet("/supprimer")
public class supCompte extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public supCompte() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// traitement sup compte 
		if (request.getSession().getAttribute("rechercheUtilisateur")==null) {
			  //si null delegation à la page de connexion
			  request.getRequestDispatcher("/ConnexionServlet").forward(request, response);
			}
		// creation d'un utilisateur avec les informations de l'utilisateur en session
		Utilisateur userASup = (Utilisateur) request.getSession().getAttribute("rechercheUtilisateur");
		UtilisateurManager um = UtilisateurManager.getInstance();
		userASup.getNoUtilisateur();
		um.supUser(userASup);
		
	
		HttpSession session = request.getSession();
		session.invalidate();
		response.sendRedirect("/ProjetEncheres/");
	
	
	
	
	}

	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
