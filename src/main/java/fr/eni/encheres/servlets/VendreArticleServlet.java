package fr.eni.encheres.servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.encheres.bll.ArticleManager;
import fr.eni.encheres.bll.BLLException;
import fr.eni.encheres.bll.EnchereManager;
import fr.eni.encheres.bo.Article;
import fr.eni.encheres.bo.Categorie;
import fr.eni.encheres.bo.Enchere;
import fr.eni.encheres.bo.Utilisateur;

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

		//TODO  voir pour la date
		try {
			// creation d'un article à l'aide du constructeur vide
			Article article = new Article();
			// recuperation des données entrées pour les placer dans article
			article.setNomArticle(request.getParameter("article").trim());
            article.setDescription(request.getParameter("description").trim());
            article.setDateDebutEncheres(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("debutenchere")));
            article.setDateFinEncheres(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("finenchere")));
            //récupération du prix initial en verifiant qu'il n'y ait que des chiffres
			if(request.getParameter("miseaprix").matches("\\d+")) {
				article.setPrixInitial(Integer.parseInt(request.getParameter("miseaprix")));
			}
			article.setPrixVente(50);
            article.setUtilisateur((Utilisateur) request.getSession().getAttribute("rechercheUtilisateur"));

			String categorie = request.getParameter("categorie");
			
			// Switch case selon la catégorie choisie
			Categorie nouvelleCategorie = new Categorie();
			switch (categorie) {
			case "Informatique":
				nouvelleCategorie.setLibelle("Informatique");
				nouvelleCategorie.setNoCategorie(0);
				break;
			case "Ameublement":
				nouvelleCategorie.setLibelle("Ameublement");
				nouvelleCategorie.setNoCategorie(1);
				
				break;
			case "Vetements":
				nouvelleCategorie.setLibelle("Vetements");
				nouvelleCategorie.setNoCategorie(2);
				
				break;
			case "Sport et Loisirs":
				nouvelleCategorie.setLibelle("Sport et Loisirs");
				nouvelleCategorie.setNoCategorie(3);
				
				break;
			}
			
			article.setCategorie(nouvelleCategorie);
			// VOIR ELSE si MODIF INSPECTER ELEMENT
			
			// création d'une instance d'articleManager
			ArticleManager am = ArticleManager.getInstance();
			am.addArticle(article);
			// creation d'un attribut article dans la session
			
			request.getSession().setAttribute("article", article);
			
			
//			Enchere enchere = new Enchere();
//			enchere.setArticle(article);
//			enchere.setDateEnchere(article.getDateFinEncheres());
//			enchere.setMontantEnchere(article.getPrixInitial());
//			enchere.setUtilisateur(article.getUtilisateur());
//			EnchereManager em = EnchereManager.getInstance();
//			em.insertEnchere(enchere);
//			
			//renvoi vers la page accueilconnecte
			request.getRequestDispatcher("/WEB-INF/jsp/accueilconnecte.jsp").forward(request, response);
		} catch (ParseException | BLLException e) {
			e.printStackTrace();
		}
		
	
		
	}

}
