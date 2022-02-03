<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Nouvelle vente</title>
</head>
<body>
<main>
        <form action="/VendreArticleServlet" method="post">
            <div>
                <div id="article">
                    <label>Article : </label>
                    <input type="text" name="article" required/>
                </div>
                <div id="description"> 
                    <label>Description : </label>
                    <input type="text" name="description" required/>
                </div>
                <div>
                    <label>Catégorie : </label>
                    <select id="categorie">
                        <option value="0">Informatique</option>
                        <option value="1">Ameublement</option>
                        <option value="2">Vetement</option>
                        <option value="3">Sport & Loisirs</option>
                    </select>
                </div>
                <div id="photo">
                    <label>Photo de l'article : </label>
                    <input type="file" name="photo" accept="image/png, image/jpeg">
                </div>
                <div id="miseaprix">
                    <label>Mise à prix</label>
                    <input type="number" name="miseaprix" required/>
                </div>
                <div id="debutenchere">
                    <label>Début de l'enchère : </label>
                    <input type="date" name="debutenchere" required/>
                </div>
                <div id="finenchere">
                    <label>Fin de l'enchère : </label>
                    <input type="date" name="finenchere" required/>
                </div>
            </div>
            <div style="border:solid">
                <div id="rue">
                    <label>Rue : </label>
                    <input type="text" name="rue" required/>
                </div>
                <div id="codepostal">
                    <label>Code postal : </label>
                    <input type="number" name="codepostal" required/> 
                </div>
                <div id="ville">
                    <label>Ville : </label>
                    <input type="text" name="ville" required/>
                </div>
            </div>
        </form>
</body>
</html>