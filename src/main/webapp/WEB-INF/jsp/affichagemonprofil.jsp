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
<div align="center">
<div class="titre">
<h3>Mon compte</h3>
</div>
<div class="profil">

<p>Pseudo: ${rechercheUtilisateur.pseudo}</p>
<p>Nom: ${rechercheUtilisateur.nom}</p>
<p>Prenom:  ${rechercheUtilisateur.prenom}</p>
<p>E-mail:  ${rechercheUtilisateur.email}</p>
<p>Téléphone: ${rechercheUtilisateur.telephone}</p>
<p>Rue: ${rechercheUtilisateur.rue}</p>
<p>Code postal: ${rechercheUtilisateur.codePostal}</p>
<p>Ville: ${rechercheUtilisateur.ville}</p>
<p>Crédit: ${rechercheUtilisateur.credit}</p>
<div class="titre">
<a href="<%=request.getContextPath()%>/ModificationprofilServlet">Modifier</a>
</div>
</div>
</div>
</body>
</html>