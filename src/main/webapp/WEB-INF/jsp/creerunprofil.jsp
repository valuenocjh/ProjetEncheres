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
 <div class="formulairecreation">
		<div class="creation">
			<form action="<%=request.getContextPath()%>/CreationprofilServlet"
				method="post">
				<div>
					<label>Pseudo: </label> <input type="text" name="pseudo" required>

					<label>Prénom: </label> <input type="text" name="prenom" required>

					<label>Téléphone: </label> <input type="tel" name="telephone">

					<label>Code postal: </label> <input type="number" name="codepostal"
						required> <label>Mot de passe: </label> <input
						type="password" name="motdepasse" required>

				</div>
				<div>

					<label>Nom: </label> <input type="text" name="nom" required>

					<label>Email: </label> <input type="email" name="email" required>

					<label>Rue: </label> <input type="text" name="rue" required>

					<label>Ville: </label> <input type="text" name="ville" required>

					<label>Confirmation: </label> <input type="password"
						name="confirmation" required>

				</div>
				<input type="submit" value="Créer">
			</form>
		</div>
</div>
		<a href="<%=request.getContextPath()%>/login"> <input type="button" value="Annuler" />
		</a>
</body>
</html>