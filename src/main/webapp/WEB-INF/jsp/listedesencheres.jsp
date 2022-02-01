<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Liste des enchères</title>
</head>
<body>
    <%@include file="header.jsp" %>
    <main>
    <!-- div contenant le formulaire -->
    <div>
        <form action="nomArticleContient" method="get">
            <label for="Filtres">Filtres</label>
            <!-- div qui contient l'image de la loupe et l'input text -->
            <div>
                <img src="" alt="">
                <input type="text" name="filtres">
            </div>
            <div>
                <input type="submit" value="Rechercher">
            </div>
        </form>
    </div>
            <!-- div contenant les images et informations des enchères -->
    <div>
        <div>
            <!-- div image -->
            <div><img src="" alt=""></div>
            <!-- div informations article -->
            <div>
                <ul>
                    <li class="nomProduit">désignation produit</li>
                    <li>Prix : (prix produit) points</li>
                    <li>Fin de l'enchère : (date)</li>
                    <li>Vendeur : (nomVendeur)</li>
                </ul>
            </div>
            
        </div>
    
    
        <div>
            <!-- div image -->
            <div><img src="" alt=""></div>
            <!-- div informations article -->
            <div>
                <ul>
                    <li class="nomProduit">désignation produit</li>
                    <li>Prix : (prix produit) points</li>
                    <li>Fin de l'enchère : (date)</li>
                    <li>Vendeur : (nomVendeur)</li>
                </ul>
            </div>
            
        </div>
    </div>
</main>

    
</body>
</html>