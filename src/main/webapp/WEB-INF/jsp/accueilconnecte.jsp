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
		<!-- div contenant le formulaire  avec les filtres-->
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
		</div>

		<!-- div contenant les formulaires achats et ventes -->
		<div class="centrageformulaireachatsventes">
			<div class="formulaireAchatsVentes">


				<div class="achats">
					<input type="radio" name="achatsventes" id="achats"
						onclick="activeDesactive(this.form.achatsventes);"> <label
						for="achatsventes">Achats</label>
					<div class="achatscheck">
						<input type="checkbox" name="encheresOuvertes" id="achatsa">
						<label for="achats">enchères ouvertes</label> <input
							type="checkbox" name="mesEncheresEnCours" id="achatsb"> <label
							for="achats">mes enchères en cours</label> <input type="checkbox"
							name="EncheresRemportees" id="achatsc"><label
							for="achats">mes enchères remportées</label>
					</div>
				</div>
				<div class="ventes">
					<input type="radio" name="achatsventes" id="mesventes"
						onclick="activeDesactive(this.form.achatsventes);"><label
						for="achatsventes">Ventes</label>
					<div class="ventescheck">
						<input type="checkbox" name="mesventesencours" id="ventesa"><label
							for="ventes">mes ventes en cours</label> <input type="checkbox"
							name="ventesnondebutees" id="ventesb"><label for="ventes">ventes
							non débutées</label> <input type="checkbox" name="ventesterminees"
							id="ventesc"><label for="ventes">ventes terminées</label>
					</div>
				</div>


			</div>
		</div>
		</div>
		</form>
		</div>

		<!-- div contenant les images et informations des ench�res -->
		<div class="touteslesencheres">
			<c:forEach items="${listeArticles}" var="article">
			
			
				<span class="article">
				<a href="<%=request.getContextPath()%>/AffichageArticle?id=${article.noArticle}">
							<div class="pieceetvaleur">
							<img class="piece" src="<%=request.getContextPath()%>/assets/img/piece.png" alt="piece">
							<h2 class="valeurarticle">${article.prixVente}</h2>
							</div>
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
 <script type='text/javascript'>
                 console.log("Avant Fonction activeDesactive");

        function activeDesactive(radio) {

                objForm = document.forms[0];
                if(radio[0].checked) {
                    objForm.elements["encheresOuvertes"].disabled = false;
                    objForm.elements["mesEncheresEnCours"].disabled = false;
                    objForm.elements["EncheresRemportees"].disabled = false;

                    objForm.elements["mesventesencours"].disabled = true;
                    objForm.elements["ventesnondebutees"].disabled = true;
                    objForm.elements["ventesterminees"].disabled = true;

                    document.getElementById("ventesa").checked = false;
                    document.getElementById("ventesb").checked = false;
                    document.getElementById("ventesc").checked = false;
                }
                else {
                    objForm.elements["mesventesencours"].disabled = false;
                    objForm.elements["ventesnondebutees"].disabled = false;
                    objForm.elements["ventesterminees"].disabled = false;
                    
                    objForm.elements["encheresOuvertes"].disabled = true;
                    objForm.elements["mesEncheresEnCours"].disabled = true;
                    objForm.elements["EncheresRemportees"].disabled = true;

                    document.getElementById("achatsa").checked = false;
                    document.getElementById("achatsb").checked = false;
                    document.getElementById("achatsc").checked = false;
                    console.log("Dans else");

                }
            }

        </script>


</body>
</html>