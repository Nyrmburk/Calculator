package excep;

public class MismatchedBracketException extends IllegalArgumentException {
	private static final long serialVersionUID = 2274359791500706634L;
	public MismatchedBracketException() { super(); }
	public MismatchedBracketException(String message) { super(message); }
	public MismatchedBracketException(String message, Throwable cause) { super(message, cause); }
	public MismatchedBracketException(Throwable cause) {super(cause); }
	
}
