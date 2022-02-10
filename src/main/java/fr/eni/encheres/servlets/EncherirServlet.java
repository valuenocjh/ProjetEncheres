package fr.eni.encheres.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.encheres.bll.ArticleManager;
import fr.eni.encheres.bll.EnchereManager;
import fr.eni.encheres.bo.Article;
import fr.eni.encheres.bo.Enchere;
import fr.eni.encheres.bo.Utilisateur;

/**
 * Servlet implementation class EncherirServlet
 */
@WebServlet("/EncherirServlet")
public class EncherirServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			Article article = ArticleManager.getInstance().selectArticleById(id);
			if (article == null) {
				throw new Exception("Article not found !");
			}
			
			Utilisateur utilisateur = (Utilisateur) request.getSession().getAttribute("rechercheUtilisateur");
			
			Enchere enchere = new Enchere();
			enchere.setDateEnchere(Date.valueOf(LocalDate.now()));
			enchere.setUtilisateur(utilisateur);
			enchere.setArticle(article);
			enchere.setMontantEnchere(Integer.parseInt(request.getParameter("encherir")));
			EnchereManager em = EnchereManager.getInstance();
			
			if(article.getPrixVente()>=Integer.parseInt(request.getParameter("encherir"))) {
				throw new Exception("Prix proposé inférieur au prix actuel");
			}
			
			System.out.println(article.getPrixVente());
			System.out.println(request.getParameter("encherir"));
			
			if(!em.selectEnchere(enchere)) {
				em.insertEnchere(enchere);
			} else {
				em.updateEnchere(enchere);
			}
			// requete pour changer le prix de vente de l'article au tarif de l'enchere
			
			
			response.sendRedirect("/ProjetEncheres/AffichageArticle");
		} catch (Exception e) {
			out.print("<p style=\"color:red\">=Montant inférieur au montant actuel</p>");    
			response.sendRedirect("/ProjetEncheres/");
		}
	}

}
