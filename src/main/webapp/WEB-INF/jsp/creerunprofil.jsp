<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mon profil</title>

</head>
<body>
 <div>

<form action="<%=request.getContextPath()%>/CreationprofilServlet" method="post">

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

        <label>Mot de passe: </label>
        <input type="password" name="motdepasse" required> 

        <label>Confirmation: </label>
        <input type="password" name="confirmation" required> 
        
        <input type="submit" value="Créer"> 
           </form>
 </div>


    <div>
        <a href="/ConnexionServlet">
            <input type="button" value="Annuler" />
         </a> 
    </div>

</body>
</html>