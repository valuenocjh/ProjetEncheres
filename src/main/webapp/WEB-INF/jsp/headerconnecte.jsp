
    <!-- div pour le haut du header - Titre et connexion -->
  <div class="headercomplet">     
    <div class="headertop">
        <div>
            <h3><a href="<%=request.getContextPath()%>/index.html">ENI Encheres</a></h3>
        </div>
    
        <div>
            <nav>
                <ul class="connexion">
                    <li><a href="">Ench�res</a></li>
                    <li><a href="<%=request.getContextPath()%>/VendreArticleServlet">Vendre un article</a></li>
					<li><a href="<%=request.getContextPath()%>/AffichageProfilServlet">Mon profil</a></li>
                    <li><a href="<%=request.getContextPath()%>/DeconnexionServlet">D�connexion</a></li>
                </ul>
            </nav>
        </div>
    </div>
        <!-- div pour le bas du header - peut etre vide selon la jsp-->
    <div class="headerbottom">
        <h2>Liste des ench�res</h2>
    </div>
</div>