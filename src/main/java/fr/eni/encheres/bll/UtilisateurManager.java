package fr.eni.encheres.bll;

import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.DAOFactory;
import fr.eni.encheres.dal.UtilisateurDAO;

public class UtilisateurManager {

   

    private static UtilisateurManager instance;

   

    private UtilisateurManager() { }

  
    public static UtilisateurManager getInstance() {

        if(instance==null) {

            instance = new UtilisateurManager();
        }

        return instance;

    }      

    public void addUser(Utilisateur utilisateur) {

        UtilisateurDAO ud = DAOFactory.getUserDAO();


        ud.insert(utilisateur);

    }

    public boolean login(Utilisateur user) {

        UtilisateurDAO ud = DAOFactory.getUserDAO();

        return ud.selectByLogin(user);

    }

}