
    <!-- div pour le haut du header - Titre et connexion -->
 <div class="headercomplet">   
    <div>
        <div>
            <h3>ENI-Ench�res</h3>
        </div>
    
        <div>
            <nav>
                <ul>
                    <li>S'inscrire</li>
                    <li><a href="<%=request.getContextPath()%>/ConnexionServlet">Se connecter</a> </li>
                    <li><a href="<%=request.getContextPath()%>/DeconnexionServlet">D�connexion</a></li>
                </ul>
            </nav>
        </div>
    </div>
        <!-- div pour le bas du header - peut etre vide selon la jsp-->
    <div>
        <h2>Liste des ench�res</h2>
    </div>
  </div>
