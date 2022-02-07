package fr.eni.encheres.bll;

public class BLLException extends Exception{

	private static final long serialVersionUID = 1L;

	public BLLException() {
		super();
	}

	public BLLException(String message, Throwable cause) {
		super(message, cause);
	}

	public BLLException(String message) {
		super(message);
	}
	
	//Méthode qui retourne un message d'erreur
		@Override
		public String getMessage() {
			return "couche BLL - " +super.getMessage();
		}


}
