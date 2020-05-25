package exception;

public class OutLimitsMapException extends ArrayIndexOutOfBoundsException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public OutLimitsMapException(final String message) {
		super(message);
	}
}
