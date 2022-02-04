package fr.eni.encheres.dal;

public class DALException extends Exception{

	private static final long serialVersionUID = 1L;
	
	//Constructeur vide qui hérite des méthodes de Exception
	public DALException() {
		super();
	}
	//Constructeur surchargé 
	public DALException(String message, Throwable cause) {
		super(message, cause);
	}

	//Constructeur surchargé 
	public DALException(String message) {
		super(message);
	}
	
	//Méthode qui retourne un message d'erreur
	@Override
	public String getMessage() {
		return "couche DAL - " +super.getMessage();
	}

	
}
