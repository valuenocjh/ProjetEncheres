<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modifier mon profil</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
</head>
<body>
<%@include file="headertitre.jsp" %>
<!-- suite a gérer -->
<br>
<br>
<h3 align="center">Modifier mon compte</h3>


 
<div class="profilmodif">
<div class="profil">
    <form action="<%=request.getContextPath()%>/modification" method="post">
	<div>
        <label>Pseudo: </label>
        <input type="text" name="pseudo" value="${rechercheUtilisateur.pseudo}" required>
        <br>
        <label>Nom: </label>
        <input type="text" name="nom" value="${rechercheUtilisateur.nom}" required> 
        <br>
        <label>Prénom: </label>
        <input type="text" name="prenom" value="${rechercheUtilisateur.prenom}" required> 
                <br>
        <label>Email: </label>
        <input type="email" name="email" value="${rechercheUtilisateur.email}" required> 
        <br>
        <label>Téléphone: </label>
        <input type="tel" name="telephone"  value="${rechercheUtilisateur.telephone}"> 
        <br>
        <label>Rue: </label>
        <input type="text" name="rue"  value="${rechercheUtilisateur.rue}" required> 
        <br>
        <label>Code postal: </label>
        <input type="number" name="codepostal"  value="${rechercheUtilisateur.codePostal}" required> 
        <br>
        <label>Ville: </label>
        <input type="text" name="ville"  value="${rechercheUtilisateur.ville}" required> 
        <br>
        <label>Mot de passe actuel: </label>
        <input type="password" name="motdepasse" required> 
        <br>
        <label>Nouveau mot de passe: </label>
        <input type="password" name="nouveaumotdepasse" > 
        <br>
        <label>Confirmation: </label>
        <input type="password" name="confirmation" > 
   
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
</div>
</body>
</html>