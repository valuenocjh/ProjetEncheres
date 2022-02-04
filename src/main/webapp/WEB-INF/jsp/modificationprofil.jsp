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
<!-- suite a gérer -->

<h3>Modifier mon compte</h3>


 
<div class="profil">
    <form action="<%=request.getContextPath()%>/ModificationprofilServlet" method="post">
	<div>
        <label>Pseudo: </label>
        <input type="text" name="pseudo" value="${rechercheUtilisateur.pseudo}" required>
        
        <label>Nom: </label>
        <input type="text" name="nom" value="${rechercheUtilisateur.nom}" required> 

        <label>Prénom: </label>
        <input type="text" name="prenom" value="${rechercheUtilisateur.prenom}" required> 
        
        <label>Email: </label>
        <input type="email" name="email" value="${rechercheUtilisateur.email}" required> 

        <label>Téléphone: </label>
        <input type="tel" name="telephone"  value="${rechercheUtilisateur.telephone}"> 

        <label>Rue: </label>
        <input type="text" name="rue"  value="${rechercheUtilisateur.rue}" required> 

        <label>Code postal: </label>
        <input type="number" name="codepostal"  value="${rechercheUtilisateur.codePostal}" required> 

        <label>Ville: </label>
        <input type="text" name="ville"  value="${rechercheUtilisateur.ville}" required> 

        <label>Mot de passe actuel: </label>
        <input type="password" name="motdepasse" required> 

        <label>Nouveau mot de passe: </label>
        <input type="password" name="nouveaumotdepasse" required> 

        <label>Confirmation: </label>
        <input type="password" name="confirmation" required> 
   
 </div>

    <div>
            <input type="submit" value="Enregistrer">     
    </div>
    <div>
        <a href="<%=request.getContextPath()%>/suppressioncompte">
            <input type="button" value="Supprimer mon compte" />
         </a> 
    </div>
</form>
</div>
</body>
</html>