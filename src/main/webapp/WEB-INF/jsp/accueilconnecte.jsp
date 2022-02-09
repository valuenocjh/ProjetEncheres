<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bienvenue ${rechercheUtilisateur.pseudo}</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/style.css">
</head>
<body>

	<%@include file="headerconnecte.jsp"%>
	<main class="mainConnecteEtNonConnecte">
		<!-- div contenant le formulaire -->
		<div>
			<form action="<%=request.getContextPath()%>/Compte" method="post">
				<div class="filtresetrechercher">
					<div>
						<label for="filtre_nom">Filtres</label>
					</div>

					<div>
						<!-- div qui contient l'image de la loupe et l'input text -->
						<img src="" alt=""> 
						<input type="text" name="filtre_nom" value="${article.nomArticle}">
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
			
		</div>
					<div class="formulaireAchatsVentes">


						<div class="achats">
							<input type="radio" name="achatsventes" id="achats"><label
								for="achatsventes">Achats</label>
							<div class="achatscheck">
								<input type="checkbox" name="encheresOuvertes" id="achats"><label
									for="achats">enchères ouvertes</label> <input type="checkbox"
									name="mesEncheresEnCours" id="achats"><label for="achats">mes
									enchères en cours</label> <input type="checkbox" name="EncheresRemportees"
									id="achats"><label for="achats">mes enchères
									remportées</label>
							</div>
						</div>
						<div class="ventes">
							<input type="radio" name="achatsventes" id="mesventes"><label
								for="achatsventes">Ventes</label>
							<div class="ventescheck">
								<input type="checkbox" name="mesventesencours" id="ventes"><label
									for="ventes">mes ventes en cours</label> <input type="checkbox"
									name="ventesnondebutees" id="ventes"><label for="ventes">ventes
									non débutées</label> <input type="checkbox" name="ventesterminees" id="ventes"><label
									for="ventes">ventes terminées</label>
							</div>
						</div>


					</div>
					<input type="submit" value="Rechercher">
				</div>
			</form>
		</div>
		<!-- div contenant les images et informations des ench�res -->
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