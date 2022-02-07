package fr.eni.encheres.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.encheres.bll.BLLException;
import fr.eni.encheres.bll.UtilisateurManager;
import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.DALException;

@WebServlet("/ConnexionServlet")
public class ConnexionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * le doGet renvoit vers la page de connexion utilisateur
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/jsp/pageConnexion.jsp").forward(request, response);
	}

	/**
	 * le doPost controle l'identifiant et le mot de passe, si la connexion est
	 * validée il nous renvoit vers la page accueilconnecte.jsp sinon
	 * retour sur la page de connexion
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// Récupération des identifiants et mot de passe
		String identifiant = request.getParameter("identifiant").trim().toLowerCase();
		String motdepasse = request.getParameter("motdepasse").trim().toLowerCase();

		// vérifier que l'identifiant contient un @, si c'est le cas
		// recuperer le mail sinon recuperer le pseudo

		Utilisateur rechercheUtilisateur = new Utilisateur();
		if (identifiant.contains("@")) {
			rechercheUtilisateur.setEmail(identifiant);
		} else {
			rechercheUtilisateur.setPseudo(identifiant);
		}

		rechercheUtilisateur.setMotDePasse(motdepasse);
		UtilisateurManager um = UtilisateurManager.getInstance();
		PrintWriter out = response.getWriter();
		// vérifie si il existe déja une session sur ce compte
		// debut
		try {
			if (um.login(rechercheUtilisateur)) {
				HttpSession session = request.getSession();
				// durée de vie de la session à 5 minutes
				session.setMaxInactiveInterval(300);
				Utilisateur user = um.loginInfo(rechercheUtilisateur);
				session.setAttribute("rechercheUtilisateur", user);
				response.sendRedirect(request.getContextPath() + "/Compte");

			} else {
				// si une session existe déja, il renvoit vers la page de connexion
				//System.out.println("Erreur connexion");
				out.print("<p style=\"color:red\">Authentification incorrecte</p>");    
		        RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/jsp/pageConnexion.jsp");    
		        rd.include(request,response);   
				request.setAttribute("error", "numeroderreur");
				//request.getRequestDispatcher("/WEB-INF/jsp/pageConnexion.jsp").forward(request, response);
				
			}
			
		} catch (DALException | BLLException e) {
			e.getStackTrace();
		}
	}
}
