<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Liste des enchères</title>
       <link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
</head>
<body>
    <%@include file="headernonconnecte.jsp" %>
    <main class="mainConnecteEtNonConnecte">

    <!-- div contenant le formulaire -->
    <div>
        <form action="nomArticleContient" method="get">
            <div class="filtresetrechercher">
                        <div>
                        <label for="Filtres">Filtres</label>
                        </div>

                        <div>
                        <!-- div qui contient l'image de la loupe et l'input text -->
                        <img src="" alt="">
                        <input type="text" name="filtres" >
                    </div>
            </div>
            <div>
                <input type="submit" value="Rechercher">
            </div>
        </form>
    </div>
            <!-- div contenant les images et informations des enchÃ¨res -->
    <div class="articles">
        <div>
            <!-- div image -->
            <div><img src="" alt=""></div>
            <!-- div informations article -->
            <div class="article">
                <ul>
                    <li class="nomProduit">désignation produit</li>
                    <li>Prix : (prix produit) points</li>
                    <li>Fin de l'enchÃ¨re : (date)</li>
                    <li>Vendeur : (nomVendeur)</li>
                </ul>
            </div>
            
        </div>
    
    
        <div>
            <!-- div image -->
            <div><img src="" alt=""></div>
            <!-- div informations article -->
            <div class="article">
                <ul>
                    <li class="nomProduit">dï¿½signation produit</li>
                    <li>Prix : (prix produit) points</li>
                    <li>Fin de l'enchï¿½re : (date)</li>
                    <li>Vendeur : (nomVendeur)</li>
                </ul>
            </div>
            
        </div>
    </div>
</main>

    
</body>
</html>