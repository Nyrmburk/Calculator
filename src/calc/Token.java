package calc;

public interface Token {

	public static Token getToken(int startIndex, char[] input) {
		return null;
	};
	public int size();
	public double operate(double... operand);
	public int operandCount();
}
