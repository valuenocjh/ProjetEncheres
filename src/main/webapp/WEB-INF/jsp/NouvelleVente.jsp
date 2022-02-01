<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Nouvelle Vente</title>
</head>
<body>
    
    <header>

    </header>

    <main>
        <form method="post">
            <div>
                <div id="article">
                    <label>Article : </label>
                    <input type="text" name="Article" required/>
                </div>
                <div id="description"> 
                    <label>Description : </label>
                    <input type="text" name="description" required/>
                </div>
                <div>
                    <label>Catégorie : </label>
                    <select id="categorie">
                        <option value="Informatique">Informatique</option>
                        <option value="Ameublement">Ameublement</option>
                        <option value="Vetement">Vetement</option>
                        <option value="Sport">Sport & Loisirs</option>
                    </select>
                </div>
                <div id="photo">
                    <label>Photo de l'article : </label>
                    <input type="file" name="photo" accept="image/png, image/jpeg">
                </div>
                <div id="miseaprix">
                    <label>Mise à prix</label>
                    <input type="number" name="miseaprix"/>
                </div>
                <div id="debutenchere">
                    <label>Début de l'enchère : </label>
                    <input type="date" name="debutenchere"/>
                </div>
                <div id="finenchere">
                    <label>Fin de l'enchère : </label>
                    <input type="date" name="finenchere"/>
                </div>
            </div>
            <div style="border:solid">
                <div id="rue">
                    <label>Rue : </label>
                    <input type="text" name="rue"/>
                </div>
                <div id="codepostal">
                    <label>Code postal : </label>
                    <input type="number" name="codepostal"/> 
                </div>
                <div id="ville">
                    <label>Ville : </label>
                    <input type="text" name="ville"/>
                </div>
            </div>
        </form>
    </main>

</body>
</html>