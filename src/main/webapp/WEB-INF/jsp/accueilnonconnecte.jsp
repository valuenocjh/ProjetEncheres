<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="fr">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Bienvenue</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/style.css">
</head>
<body>
	<%@include file="headernonconnecte.jsp"%>
	<main class="mainConnecteEtNonConnecte"> <!-- div contenant le formulaire  avec les filtres-->
	<div class="filtresetrechercher">
		<form action="<%=request.getContextPath()%>/Compte" method="post">
			<div>
				<div>
					<label for="filtre_nom">Filtres : </label> <input type="text"
						name="filtre_nom" value="${article.nomArticle}">
				</div>

			</div>

			<div>
				<label>Catégorie : </label> <select name="categorie">
					<option>Toutes</option>
					<option>Informatique</option>
					<option>Ameublement</option>
					<option>Vetements</option>
					<option>Sport et Loisirs</option>
				</select>
			</div>
			<div>
				<input type="submit" value="Rechercher">
			</div>
		</form>
	</div>
	<!-- div contenant les images et informations des enchÃ¨res -->
	<div class="touteslesencheres">
		<c:forEach items="${listeArticles}" var="article">
			
			
				<span class="article">
				<a href="<%=request.getContextPath()%>/AffichageArticle?id=${article.noArticle}">
							<img class="piece" src="<%=request.getContextPath()%>/assets/img/piece.png" alt="piece">
							<h2 class="valeurarticle">${article.prixVente}</h2>
							<img class="imgarticle" src="<%=request.getContextPath()%>/assets/img/objet.png" alt="article">
							
							<div>
								<ul>
		
									<li class="nomProduit"><a href="<%=request.getContextPath()%>/AffichageArticle?id=${article.noArticle}">${article.nomArticle}</a></li>
									<br>
									<li>Fin de l'enchère : ${article.dateFinEncheres}</li>
									<li>Vendeur : <a href="<%=request.getContextPath()%>/Monprofil?id=${article.utilisateur.noUtilisateur}">${article.utilisateur.pseudo}</a></li>
								</ul>
							</div>
				</a>
				</span>
			
		</c:forEach>
		
	</div>
		
	</main>


</body>
</html>