<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bienvenue</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
</head>
<body>

<%@include file="headerconnecte.jsp" %>
    <main class="mainConnecteEtNonConnecte">
    <!-- div contenant le formulaire -->
    <div>
        <form action="nomArticleContient" method="get">
            <label for="Filtres">Filtres</label>
            <!-- div qui contient l'image de la loupe et l'input text -->
            <div>
                <img src="" alt="">
                <input type="text" name="filtres">
            </div>
            <div>
                <input type="submit" value="Rechercher">
            </div>
        </form>
    </div>
            <!-- div contenant les images et informations des ench�res -->
    <div class="touteslesarticles">


	<c:forEach items="${listeArticles}" var="article">
		<div  class="article">
            <!-- div image -->
            <div>
            <img src="" alt="">
            </div>
            <!-- div informations article -->
            <div>
                <ul>
                    <li class="nomProduit">${article.nomArticle}</li>
					<li>Prix : ${article.prixVente} points</li>
                    <li>Fin de l'enchère : ${article.dateFinEncheres}</li>
                    <li>Vendeur : ${article.utilisateur.pseudo}</li>
                </ul>
            </div>
            
        </div>
  
	</c:forEach>
    </div>  
    
</main>

    
</body>
</html>