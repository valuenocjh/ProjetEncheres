<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<header> </header>

	<main>
		<div>
			<div>
				<!-- formulaire regroupant l'identifiant et le mot de passe-->
				<form action="<%=request.getContextPath()%>/ConnexionServlet" method="post">
					<!-- div Identifiant-->
					<div class="id">
						<label>Identifiant : </label> <input type="text"
							name="identifiant" required />
					</div>
					<!-- div Mot de passe-->
					<div class="password">
						<label>Mot de passe : </label> <input type="password"
							name="motdepasse" required />
					</div>
					<div>
						<!-- div Connexion-->
						<div class="btnConnexion">
							<input type="submit" value="Connexion" />
						</div>
						<!-- div checkbox se souvenir de moi-->
						<div class="checkboxConnexion">
							<input type="checkbox" /> <label>Se souvenir de moi</label>
						</div>
						<!-- div avec un lien pour mot de passe oublié-->
						<div>
							<a href="#">Mot de passe oublié</a>
						</div>
					</div>
				</form>
			</div>
			<!-- div avec le bouton créer un compte qui renvoie vers un lien pour s'inscrire-->
			<div>
				<button>
					<a href="<%=request.getContextPath()%>/CreationprofilServlet">Créer un compte</a>
				</button>
			</div>
		</div>
	</main>

</body>
</html>