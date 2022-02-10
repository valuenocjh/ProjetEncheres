<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="fr">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Article : ${article.nomArticle}</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
</head>
<body>
<%@include file="headertitre.jsp" %>

<div class="affichagearticle">
		<div class="affichagearticle_img">
			<img class="imgarticle" src="<%=request.getContextPath()%>/assets/img/objet.png" alt="image">
		</div>
		<div class="affichagearticle_infos">
			<div class="affichagearticle_infos_flex">		
				<div>
					<ul>
						<li><p class="nomProduit">${article.nomArticle}</p></li>
						<br>
						<li><p>Description : ${article.description}</p></li>
						<li><p>Catégorie : ${article.categorie.libelle}</p></li>
						<li><p>Meilleure offre : ${article.prixVente} </p></li>
						<li><p>Mise à prix : ${article.prixInitial}</p></li>
						<li><p>Fin de l'enchère : ${article.dateFinEncheres}</p></li>
						<li><p>Retrait : ${article.utilisateur.rue} </p></li>
					</ul>
				</div>
		
				<div>
					<form action="<%=request.getContextPath()%>/encherirServlet" method="post">
						<label for="encherir">Ma proposition : </label>
						<input type="number" name="encherir" value="${article.prixVente}">
						<input type="submit" value="Enchérir">
					</form>
				</div>
			</div>

	</div>

</body>
</html>