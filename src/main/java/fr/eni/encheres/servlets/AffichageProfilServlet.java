package fr.eni.encheres.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.encheres.bll.ArticleManager;
import fr.eni.encheres.bll.UtilisateurManager;
import fr.eni.encheres.bo.Article;
import fr.eni.encheres.bo.Utilisateur;

/**
 * Servlet implementation class affichageProfilServlet
 */
@WebServlet("/Monprofil")
public class AffichageProfilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// le doget envoit vers la page affichageprofil
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			int id = Integer.valueOf(request.getParameter("id"));
			Utilisateur utilisateur = UtilisateurManager.getInstance().SelectbyID(id);
			if (utilisateur == null) {
				throw new Exception("Utilisateur introuvable!");
			}
			request.setAttribute("utilisateur", utilisateur);

			// trois conditions, si l'utilisateur cherché = mon id alors envoyer vers mon
			// profil
			// avec le bouton modifier (affichagemonprofil.jsp
			// si l'utilisateur recherché = null alors envoyer vers liste encheres
			// si l'utilisateur recherché existe, envoyer vers
			// affichageprofilutilisateur.jsp
			
			// erreur a corriger : si erreur, envoi vers accueil a mettre en place
			// et si utilisateur connecté, envoyer vers la bonne jsp

			if (utilisateur == request.getSession().getAttribute("rechercheUtilisateur")) {
				request.getRequestDispatcher("/WEB-INF/jsp/affichagemonprofil.jsp").forward(request, response);
			} else {
				request.setAttribute("user", utilisateur);
				request.getRequestDispatcher("WEB-INF/jsp/affichageprofil.jsp").forward(request, response);
			}
		} catch (Exception e) {
			response.sendRedirect("/ProjetEncheres/");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}