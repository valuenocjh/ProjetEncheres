<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mon espace membre</title>
</head>
<body>

<div align="center">
<h1>Eni Enchère</h1>
<h3>Mon compte</h3>

<p>Liste des enchères connecté</p>
<p>pseudo: ${rechercheUtilisateur.pseudo}</p>
<p>Nom : ${rechercheUtilisateur.nom}</p>
<p>Prenom :  ${rechercheUtilisateur.prenom}</p>
<p>email :  ${rechercheUtilisateur.email}</p>
<p>telephone ${rechercheUtilisateur.telephone}</p>
<p>rue ${rechercheUtilisateur.rue}</p>
<p>code postal : ${rechercheUtilisateur.codePostal}</p>
<p>ville : ${rechercheUtilisateur.ville}</p>
<p>credit : ${rechercheUtilisateur.credit}</p>

<a href="<%=request.getContextPath()%>/ModificationprofilServlet">Modifier</a>

</div>
</body>
</html>