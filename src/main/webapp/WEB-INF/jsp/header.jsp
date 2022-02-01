
    <!-- div pour le haut du header - Titre et connexion -->
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <div>
        <div>
            <h3>ENI-Enchères</h3>
        </div>
    
        <div>
            <nav>
                <ul>
                    <li>S'inscrire</li>
                    <li><a href="<%=request.getContextPath()%>/ConnexionServlet">Se connecter</a> </li>
                </ul>
            </nav>
        </div>
    </div>
        <!-- div pour le bas du header - peut etre vide selon la jsp-->
    <div>
        <h2>Liste des enchères</h2>
    </div>
