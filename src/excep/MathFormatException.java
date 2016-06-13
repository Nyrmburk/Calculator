package excep;

public class MathFormatException extends IllegalArgumentException {
	private static final long serialVersionUID = -5078103704829244478L;
	public MathFormatException() { super(); }
	public MathFormatException(String message) { super(message); }
	public MathFormatException(String message, Throwable cause) { super(message, cause); }
	public MathFormatException(Throwable cause) {super(cause); }
}