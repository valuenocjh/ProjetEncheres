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
        <form action="<%=request.getContextPath()%>/VendreArticleServlet" method="post">
            <div>
                <div">
                    <label>Article : </label>
                    <input type="text" name="article" required/>
                </div>
                <div"> 
                    <label>Description : </label>
                    <input type="text" name="description" required/>
                </div>
                <div>
                    <label>Cat�gorie : </label>
                    <select name="categorie">
                        <option>Informatique</option>
                        <option>Ameublement</option>
                        <option>Vetement</option>
                        <option>Sport et Loisirs</option>
                    </select>
                </div>
                <div>
                    <label>Photo de l'article : </label>
                    <input type="file" name="photo" accept="image/png, image/jpeg">
                </div>
                <div">
                    <label>Mise � prix</label>
                    <input type="number" name="miseaprix" required/>
                </div>
                <div">
                    <label>D�but de l'ench�re : </label>
                    <input type="date" name="debutenchere" required/>
                </div>
                <div">
                    <label>Fin de l'ench�re : </label>
                    <input type="date" name="finenchere" required/>
                </div>
            </div>
            <div style="border:solid">
                <div id="rue">
                    <label>Rue : </label>
                    <input type="text" name="rue" value="${rechercheUtilisateur.rue}"required/>
                </div>
                <div id="codepostal">
                    <label>Code postal : </label>
                    <input type="number" name="codepostal" value="${rechercheUtilisateur.codePostal}"required/> 
                </div>
                <div id="ville">
                    <label>Ville : </label>
                    <input type="text" name="ville" value="${rechercheUtilisateur.ville}"required/>
                </div>
            </div>
            <input type="submit" value="envoyer"/>
        </form>
        </main>
</body>
</html>