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
			// R�cup�rer l'id de l'article � afficher
			int id = Integer.valueOf(request.getParameter("id"));

			// Appeler le manager pour r�cup�rer l'article grace � l'identifiant
			Article article = ArticleManager.getInstance().selectArticleById(id);
			if (article == null) {
				throw new Exception("Article not found !");
			}

			// Envoyer l'article � la jsp
			request.setAttribute("article", article);
			
			// Attacher la jsp � la Servlet
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
