package fr.eni.encheres.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.encheres.bll.ArticleManager;
import fr.eni.encheres.bo.Article;

@WebServlet("/AffichageArticle")
public class AffichageArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			// Récupérer l'id de l'article à afficher
			int id = Integer.valueOf(request.getParameter("id"));

			// Appeler le manager pour récupérer l'article grace à l'identifiant
			Article article = ArticleManager.getInstance().selectArticleById(id);
			if (article == null) {
				throw new Exception("Article not found !");
			}

			// Envoyer l'article à la jsp
			request.setAttribute("article", article);
			
			// Attacher la jsp à la Servlet
			request.getRequestDispatcher("/WEB-INF/jsp/affichagearticle.jsp").forward(request, response);
		} catch (Exception e) {
			response.sendRedirect("/ProjetEncheres/");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
