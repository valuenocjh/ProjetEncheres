
    <!-- div pour le haut du header - Titre et connexion -->
 <div class="headercomplet">   
    <div class="headertop">
        <div>
            <h3><a href="<%=request.getContextPath()%>">ENI Encheres</a></h3>
        </div>
    
        <div>
            <nav>
                <ul class="connexion">
                    <li><a href="<%=request.getContextPath()%>/login">S'inscrire - Se connecter</a> </li>               
                </ul>
            </nav>
        </div>
    </div>
        <!-- div pour le bas du header - peut etre vide selon la jsp-->
    <div class="headerbottom">
        <h2>Liste des enchères</h2>
    </div>
  </div>
