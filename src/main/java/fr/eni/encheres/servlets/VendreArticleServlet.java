package fr.eni.encheres.servlets;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.encheres.bo.Categorie;

@WebServlet("/VendreArticleServlet")
public class VendreArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

// le doGet envoit vers la jsp nouvellevente
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("/WEB-INF/jsp/nouvellevente.jsp").forward(request, response);
	}

	// le doPost execute le traitement du formulaire
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String article = request.getParameter("article").trim();
		String description = request.getParameter("descritpion").trim();
		String categorie = request.getParameter("categorie");
		// Switch case selon la catégorie choisie
		Categorie nouvelleCategorie = new Categorie();
		switch (categorie) {
		case "0":
			nouvelleCategorie.setLibelle("informatique");
			break;
		case "1":
			nouvelleCategorie.setLibelle("Ameublement");
			break;
		case "2":
			nouvelleCategorie.setLibelle("Vetements");
			break;
		case "3":
			nouvelleCategorie.setLibelle("Sport et Loisir");
			break;
		}
		int miseAPrix = Integer.parseInt(request.getParameter("miseaprix"));
		
		//TODO  voir pour la date
	//	Date dateDebutEnchere = request.getParameter("debutenchere");
		

	}

}
