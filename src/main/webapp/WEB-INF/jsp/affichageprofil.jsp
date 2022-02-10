<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Profil de l'utilisateur ${user.pseudo}</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
</head>
<body>
<%@include file="headertitre.jsp" %>
	<div class="affichagemoncompte_2">
	<div>
			<p>Liste des enchères connecté</p>
			<p>pseudo: ${user.pseudo}</p>
			<p>Nom : ${user.nom}</p>
			<p>Prenom :  ${user.prenom}</p>
			<p>email :  ${user.email}</p>
			<p>telephone ${user.telephone}</p>
			<p>rue ${user.rue}</p>
			<p>code postal : ${user.codePostal}</p>
			<p>ville : ${user.ville}</p>
			<p>credit : ${user.credit}</p>
	</div>
<!-- bouton retour -->


	</div>
 
</body>
</html>