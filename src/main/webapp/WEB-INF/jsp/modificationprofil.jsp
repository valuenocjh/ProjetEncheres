<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mon espace membre</title>
</head>
<body>


<h1>Eni Enchère</h1>
<h3>Mon compte</h3>

<p>Liste des enchères connecté</p>


 

    <form action="<%=request.getContextPath()%>/modificationprofil" method="post">
<div>
        <label>Pseudo: </label>
        <input type="text" name="pseudo" required>
        
        <label>Nom: </label>
        <input type="text" name="nom" required> 

        <label>Prénom: </label>
        <input type="text" name="prenom" required> 

        
        <label>Email: </label>
        <input type="email" name="email" required> 

        <label>Téléphone: </label>
        <input type="tel" name="telephone"> 

        <label>Rue: </label>
        <input type="text" name="rue" required> 

        <label>Code postal: </label>
        <input type="number" name="codepostal" required> 

        <label>Ville: </label>
        <input type="text" name="ville" required> 

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