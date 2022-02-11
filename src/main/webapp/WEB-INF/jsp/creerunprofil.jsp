<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Création de profil</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
</head>
<body>
<%@include file="headertitre.jsp"%>
 <div class="modifprofil">
		
			<form action="<%=request.getContextPath()%>/CreationprofilServlet"
				method="post">
				<div>
					<label>Pseudo: </label> <input type="text" name="pseudo" required>
      				  <br>
					<label>Prénom: </label> <input type="text" name="prenom" required>
       				 <br>	
					<label>Téléphone: </label> <input type="tel" name="telephone">
					   <br>
					<label>Code postal: </label> <input type="number" name="codepostal"
						required>
												        <br><label>Mot de passe: </label> <input
						type="password" name="motdepasse" required>


				</div>
				<div>
					<label>Nom: </label> <input type="text" name="nom" required>
	        <br>
					<label>Email: </label> <input type="email" name="email" required>
        <br>
					<label>Rue: </label> <input type="text" name="rue" required>
        <br>
					<label>Ville: </label> <input type="text" name="ville" required>
        <br>
					<label>Confirmation: </label> <input type="password"
						name="confirmation" required>

				</div>
				<div class="validation">
				<input type="submit" value="Créer">
				<a href="<%=request.getContextPath()%>/login"> <input type="button" value="Annuler" />
				</div>
			</form>
		
</div>
		
		</a>
</body>
</html>