package br.com.curso.services.exception;

public class ObjectNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public ObjectNotFoundException() {
		super();
	}
	
	public ObjectNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}
	
	
	

}
