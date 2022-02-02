package fr.eni.encheres.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//Servlet appel�e lors de l'appuis sur le bouton connexion de la page pageconnexion
//DoGet appelle la page jsp liste des encheresconnecte
//DoPost traite la liste des ench�res en mode connect� et les filtres
@WebServlet("/Compte")
public class CompteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public CompteServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/jsp/listedesencherchesconnecte.jsp").forward(request, response);

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
