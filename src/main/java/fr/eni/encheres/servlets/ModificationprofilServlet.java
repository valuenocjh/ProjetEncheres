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


@WebServlet("/modification")
public class ModificationprofilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// je tente  de recuperer mon utilisateur connecte en session
		if (request.getSession().getAttribute("rechercheUtilisateur")==null) {
			  //si null delegation à la page de connexion
			  request.getRequestDispatcher("/ConnexionServlet").forward(request, response);
			}
		// creation d'un utilisateur avec les informations de l'utilisateur en session
		Utilisateur userAModifier = (Utilisateur) request.getSession().getAttribute("rechercheUtilisateur");
		
		request.setAttribute("profil", userAModifier);
		//envoi vers la jsp de modification de profil
		request.getRequestDispatcher("/WEB-INF/jsp/modificationprofil.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  
		Utilisateur userAModifier = (Utilisateur) request.getSession().getAttribute("rechercheUtilisateur");
				
		// créer un utilisateur avec les informations entrées dans le formulaire
		Utilisateur UtilisateurModification = new Utilisateur();
		
		UtilisateurModification.setPseudo(request.getParameter("pseudo").trim().toLowerCase());
		UtilisateurModification.setNom(request.getParameter("nom").trim().toLowerCase());
		UtilisateurModification.setPrenom(request.getParameter("prenom").trim().toLowerCase());
		UtilisateurModification.setEmail(request.getParameter("email").trim().toLowerCase());
		UtilisateurModification.setTelephone(request.getParameter("telephone").trim().toLowerCase());
		UtilisateurModification.setRue(request.getParameter("rue").trim().toLowerCase());
		UtilisateurModification.setCodePostal(request.getParameter("codepostal").trim());
		UtilisateurModification.setVille(request.getParameter("ville").trim().toLowerCase());
		UtilisateurModification.setMotDePasse(request.getParameter("nouveaumotdepasse"));
		UtilisateurModification.setCredit(userAModifier.getCredit());
		PrintWriter out = response.getWriter();

		try {
		if(!request.getParameter("nouveaumotdepasse").equalsIgnoreCase(request.getParameter("confirmation"))){   
			throw new Exception();
		}
		
		if (request.getParameter("nouveaumotdepasse").isEmpty() & request.getParameter("confirmation").isEmpty()) {
			UtilisateurModification.setMotDePasse(request.getParameter("motdepasse"));
		}
		
		if(UtilisateurModification.getPseudo().matches("\\p{Alnum}+") & request.getParameter("motdepasse").equals(userAModifier.getMotDePasse()) &  request.getParameter("email").contains("@") & request.getParameter("telephone").matches("\\d+") & request.getParameter("codepostal").matches("\\d+")) {
			
		//appel de la bll pour créer un utilisateurManager nommé um
		UtilisateurManager um = UtilisateurManager.getInstance();
		
		
		// appel de la méthode modifieruser de la bll
		try {
			um.modifierUser(UtilisateurModification, userAModifier);
		} catch (BLLException e) {
			e.printStackTrace();
		}
		
		
		HttpSession session = request.getSession();
		session.setAttribute("rechercheUtilisateur", UtilisateurModification);
		userAModifier.setPseudo(request.getParameter("pseudo").trim().toLowerCase());
		response.sendRedirect(request.getContextPath() + "/Compte");
		
	}else {
		//affichage du message d'erreur 
		out.print("<p style=\"color:red\">caracteres alphanumeriques sur le pseudo ou mot de passe mal confirmé</p>");    
        RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/jsp/modificationprofil.jsp");    
        rd.include(request,response);
	
	}
		} catch(Exception e){
			out.print("<p style=\\\"color:red\\\">Les mots de passe ne correspondent pas</p>");
			request.getRequestDispatcher("/WEB-INF/jsp/modificationprofil.jsp").forward(request, response);
		}
	}
}
