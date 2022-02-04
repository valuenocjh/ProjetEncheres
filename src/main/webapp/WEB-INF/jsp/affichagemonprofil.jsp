<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mon espace membre</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
</head>
<body>
<%@include file="headertitre.jsp" %>
	<div class="titre">
		<h3>Mon compte</h3>
	</div>
	
	<div class="profil">
		<div>
		    <ul>
		        <li><p>Pseudo : </p></li>
		        <li><p>Nom : </p></li>
		        <li><p>Prenom : </p></li>
		        <li><p>E-mail : </p></li>
		        <li><p>Téléphone : </p></li>
		        <li><p>Rue : </p></li>
		        <li><p>Code postal : </p></li>
		        <li><p>Ville : </p></li>
		        <li><p>Crédit : </p></li>
		    </ul>
		</div>
		<div>
		    <ul>
		        <li><p>${rechercheUtilisateur.pseudo}</p></li>
		        <li><p>${rechercheUtilisateur.nom}</p></li>
		        <li><p>${rechercheUtilisateur.prenom}</p></li>
		        <li><p>${rechercheUtilisateur.email}</p></li>
		        <li><p>${rechercheUtilisateur.telephone}</p></li>
		        <li><p>${rechercheUtilisateur.rue}</p></li>
		        <li><p>${rechercheUtilisateur.codePostal}</p></li>
		        <li><p>${rechercheUtilisateur.ville}</p></li>
		        <li><p>${rechercheUtilisateur.credit}</p></li>
		    </ul>
		</div>
	</div>

	<div class="titre">
		<a href="<%=request.getContextPath()%>/ModificationprofilServlet">Modifier</a>
	</div>

</body>
</html>