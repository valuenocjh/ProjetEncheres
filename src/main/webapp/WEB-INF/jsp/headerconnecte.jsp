
    <!-- div pour le haut du header - Titre et connexion -->
  <div class="headercomplet">     
    <div class="headertop">
        <div>
           
            <a href="<%=request.getContextPath()%>"><img class="logo" src="<%=request.getContextPath()%>/assets/img/logo.jpg" alt="logo Encheres"></a>
        </div>
    
        <div>
            <nav>
                <ul class="connexion">
                    <li><a href="">Enchères</a></li>
                    <li><a href="<%=request.getContextPath()%>/VendreArticleServlet">Vendre un article</a></li>
					<li><a href="<%=request.getContextPath()%>/Monprofil">Mon profil</a></li>
                    <li><a href="<%=request.getContextPath()%>/logout">Déconnexion</a></li>
                </ul>
            </nav>
        </div>
    </div>
        <!-- div pour le bas du header - peut etre vide selon la jsp-->
    <div class="headerbottom">
        <h2>Liste des enchères</h2>
    </div>
</div>