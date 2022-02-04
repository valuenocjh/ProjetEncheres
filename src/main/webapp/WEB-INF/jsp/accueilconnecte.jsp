<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
</head>
<body>

<%@include file="headerconnecte.jsp" %>
    <main class="mainConnecteEtNonConnecte">
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
            <!-- div contenant les images et informations des ench�res -->
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
                    <li>Fin de l'ench�re : (date)</li>
                    <li>Vendeur : (nomVendeur)</li>
                </ul>
            </div>
            
        </div>
    </div>
</main>

    
</body>
</html>