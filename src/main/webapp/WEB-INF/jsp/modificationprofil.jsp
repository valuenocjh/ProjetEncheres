<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mon espace membre</title>
</head>
<body>


<h1>Eni Ench�re</h1>
<h3>Mon compte</h3>
<h4>${profil.pseudo}</h4>
<h4>Ancien : ${profil.motDePasse}</h4>
${rechercheUtilisateur.motDePasse}
<p>Liste des ench�res connect�</p>


 

    <form action="<%=request.getContextPath()%>/ModificationprofilServlet" method="post">
<div>
        <label>Pseudo: </label>
        <input type="text" name="pseudo" value="${rechercheUtilisateur.pseudo}" required>
        
        <label>Nom: </label>
        <input type="text" name="nom" value="${rechercheUtilisateur.nom}" required> 

        <label>Pr�nom: </label>
        <input type="text" name="prenom" value="${rechercheUtilisateur.prenom}" required> 
        
        <label>Email: </label>
        <input type="email" name="email" value="${rechercheUtilisateur.email}" required> 

        <label>T�l�phone: </label>
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
</body>
</html>