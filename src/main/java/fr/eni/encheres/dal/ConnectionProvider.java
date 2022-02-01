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
	
	static {
		Context context;
		
		try {
			context = new InitialContext();
			datasource = (DataSource) context.lookup("java:comp/env/jdbc/cnx_pool");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection seConnecter() throws SQLException {
		return datasource.getConnection();
	}
	
	public static void seDeconnecter(Connection cnx) {
		try {
			cnx.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void seDeconnecter(Connection cnx, PreparedStatement pstmt) {
		try {
			pstmt.close();
			cnx.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void seDeconnecter(Connection cnx, Statement stmt) {
		try {
			stmt.close();
			cnx.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
