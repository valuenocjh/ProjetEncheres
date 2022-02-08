<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="fr">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Liste des enchères</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/style.css">
</head>
<body>
	<%@include file="headernonconnecte.jsp"%>
	<main class="mainConnecteEtNonConnecte">

		<!-- div contenant le formulaire -->
		<div>
			<form action="<%=request.getContextPath()%>/index.html" method="post">
				<div class="filtresetrechercher">
					<div>
						<label for="filtre_nom">Filtres</label>
					</div>

					<div>
						<!-- div qui contient l'image de la loupe et l'input text -->
						<img src="" alt=""> <input type="text" name="filtre_nom">
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
				<div class="article">
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