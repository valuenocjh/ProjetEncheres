package fr.eni.encheres.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.encheres.bll.UtilisateurManager;
import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.DALException;

@WebServlet("/CreationprofilServlet")
public class CreationprofilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

//Servlet appel�e lors de l'appuie sur le bouton cr�er un compte de la jsp 
//pageconnexion

//DoGet appelle la jsp creerMonProfil

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/jsp/creerunprofil.jsp").forward(request, response);

	}

	// DoPost va traiter le formulaire de la page creerMonProfil
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String identifiant = request.getParameter("pseudo").trim().toLowerCase();
		String nom = request.getParameter("nom").trim().toLowerCase();
		String prenom = request.getParameter("prenom").trim().toLowerCase();
		String email = request.getParameter("email").trim().toLowerCase();
		String telephone = request.getParameter("telephone").trim().toLowerCase();
		String rue = request.getParameter("rue").trim().toLowerCase();
		String codepostal = request.getParameter("codepostal").trim();
		String ville = request.getParameter("ville").trim().toLowerCase();
		String motdepasse = request.getParameter("motdepasse").trim().toLowerCase();
		String confirmation = request.getParameter("confirmation").trim().toLowerCase();
// penser � g�rer si les mots de passe sont diff�rents.

		Utilisateur nouvelutilisateur = new Utilisateur();
		nouvelutilisateur.setPseudo(identifiant);
		nouvelutilisateur.setNom(nom);
		nouvelutilisateur.setPrenom(prenom);
		nouvelutilisateur.setEmail(email);
		nouvelutilisateur.setTelephone(telephone);
		nouvelutilisateur.setRue(rue);
		nouvelutilisateur.setCodePostal(codepostal);
		nouvelutilisateur.setVille(ville);
		nouvelutilisateur.setMotDePasse(motdepasse);

		UtilisateurManager um = UtilisateurManager.getInstance();

		try {
			um.addUser(nouvelutilisateur);
			if (!um.login(nouvelutilisateur)) {

			} else {
				request.setAttribute("error", "numeroderreur");
				request.getRequestDispatcher("/WEB-INF/jsp/pageConnexion.jsp").forward(request, response);

			}
		} catch (SQLException | DALException e) {
			System.out.println("test");
		}
	}
}
