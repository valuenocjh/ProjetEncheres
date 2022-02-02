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

@WebServlet("/ConnexionServlet")
public class ConnexionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	/**
	 * le doGet renvoit vers la page de connexion utilisateur
	 */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
request.getRequestDispatcher("/WEB-INF/jsp/pageConnexion.jsp").forward(request, response);
	}

	/**
	 * le doPostt controle l'identifiant et le mot de passe, si la connexion est valid�e
	 * il nous renvoit vers la page listedesencheresconnecte.jsp sinon retour sur la
	 * page de connexion
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		// R�cup�ration des identifiants et mot de passe
		String identifiant = request.getParameter("identifiant").trim().toLowerCase();
		String motdepasse = request.getParameter("motdepasse").trim().toLowerCase();
		
		// v�rifier que l'identifiant contient un @, si c'est le cas
		// recuperer le mail sinon recuperer le pseudo
		
		Utilisateur rechercheUtilisateur = new Utilisateur();
		if (identifiant.contains("@")) {
			rechercheUtilisateur.setEmail(identifiant);
		}else {
			rechercheUtilisateur.setPseudo(identifiant);
		}


		rechercheUtilisateur.setMotDePasse(motdepasse);
		UtilisateurManager um = UtilisateurManager.getInstance();
		
		// v�rifie si il existe d�ja une session sur ce compte
		if(um.login(rechercheUtilisateur)) {
			HttpSession session = request.getSession();
			session.setAttribute("identifiant", identifiant);
			response.sendRedirect(request.getContextPath()+"/Compte");
			}		
		else {
				// si une session existe d�ja, il renvoit vers la page de connexion
				request.setAttribute("error", "numeroderreur");
				request.getRequestDispatcher("/WEB-INF/jsp/pageConnexion.jsp").forward(request, response);
				
			}
	}

}
