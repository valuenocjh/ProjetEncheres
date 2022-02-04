package fr.eni.encheres.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConnectionProvider {
	private static DataSource datasource;
	//Externalisation de la cha�ne de connexion 
	
	static {
		Context context;
	
	//v�rification login administrateur
		try {
			context = new InitialContext();
			datasource = (DataSource) context.lookup("java:comp/env/jdbc/cnx_pool");
		} catch (NamingException e) {
			System.err.println("datasource non r�f�renc�e dans l'annuaire du serveur Tomcat");
			e.printStackTrace();
		}
	}
	
	//Obtenir une connexion 
	public static Connection seConnecter() throws SQLException {
		Connection cnx = null;
		cnx = datasource.getConnection();
		return cnx;
	}
	
	//Se d�connecter � partir d'une connexion
	public static void seDeconnecter(Connection cnx) {
		try {
			cnx.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	//Se d�connecter � partir d'une connexion et d'un pstmt
	public static void seDeconnecter(Connection cnx, PreparedStatement pstmt) {
		try {
			pstmt.close();
			cnx.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//Se d�connecter � partir d'une connexion et d'un stmt
	public static void seDeconnecter(Connection cnx, Statement stmt) {
		try {
			stmt.close();
			cnx.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
