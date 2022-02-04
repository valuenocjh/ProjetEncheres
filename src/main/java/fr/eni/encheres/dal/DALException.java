package fr.eni.encheres.dal;

public class DALException extends Exception{

	private static final long serialVersionUID = 1L;
	
	//Constructeur vide qui h�rite des m�thodes de Exception
	public DALException() {
		super();
	}
	//Constructeur surcharg� 
	public DALException(String message, Throwable cause) {
		super(message, cause);
	}

	//Constructeur surcharg� 
	public DALException(String message) {
		super(message);
	}
	
	//M�thode qui retourne un message d'erreur
	@Override
	public String getMessage() {
		return "couche DAL - " +super.getMessage();
	}

	
}
