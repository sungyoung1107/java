package bank;

public class UserException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public UserException() {	
	}
	
	public UserException(String msgcode) {
		super(msgcode);
	}

}
