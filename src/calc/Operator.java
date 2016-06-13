package calc;

public class Operator implements Token, Comparable<Operator> {

	public enum Operators {

		POWER, MULTIPLY, DIVIDE, REMAINDER, ADD, SUBTRACT
	}

	private static String[] operatorNames = { "^", "*", "/", "%", "+", "-" };

	private Operators currentOperator;

	public Operator(Operators operator) {

		currentOperator = operator;
	}

	public double operate(double... operand) {

		double result;
		switch (currentOperator) {

		case ADD:
			result = operand[0] + operand[1];
			break;
		case SUBTRACT:
			result = operand[0] - operand[1];
			break;
		case MULTIPLY:
			result = operand[0] * operand[1];
			break;
		case DIVIDE:
			result = operand[0] / operand[1];
			break;
		case REMAINDER:
			result = operand[0] % operand[1];
			break;
		case POWER:
			result = Math.pow(operand[0], operand[1]);
			break;
		default:
			result = Double.NaN;
			break;
		}

		return result;
	}

	@Override
	public int operandCount() {
		return 2;
	}

	public int precedence() {

		int precedence = 0;
		
		switch(currentOperator) {
		case POWER:
			precedence = 4;
			break;
		case MULTIPLY:
		case DIVIDE:
		case REMAINDER:
			precedence = 3;
			break;
		case ADD:
		case SUBTRACT:
			precedence = 2;
			break;
		default:
			break;
		}
		return precedence;
	}

	public int size() {

		return operatorNames[currentOperator.ordinal()].length();
	}

	public static Operator getToken(int startIndex, char[] input) {

		for (Operators operator : Operators.values()) {

			if (startsWith(startIndex, operatorNames[operator.ordinal()], input)) {

				return new Operator(operator);
			}
		}
		return null;
	}

	private static boolean startsWith(int startIndex, String phrase,
			char[] checkAgainst) {

		int index = 0;
		char[] phraseChars = phrase.toCharArray();
		while (index < phraseChars.length
				&& index + startIndex < checkAgainst.length) {

			if (phraseChars[index] != checkAgainst[index + startIndex])
				break;
			index++;
		}

		if (index == phraseChars.length)
			return true;

		return false;
	}

	public boolean leftAssociative() {

		if (currentOperator == Operators.POWER)
			return false;
		return true;
	}
	
	public boolean isSign() {
		
		switch (currentOperator) {
		
		case ADD:
		case SUBTRACT:
			return true;
		default:
			return false;
		}
	}
	
	public boolean isNegative() {
		
		switch (currentOperator) {
		
		case SUBTRACT:
			return true;
		default:
			return false;
		}
	}
	
	public boolean isPositive() {
		
		switch (currentOperator) {
		
		case ADD:
			return true;
		default:
			return false;
		}
	}

	public int compareTo(Operator operator) {

		return precedence() - operator.precedence();
	}

	public static String getName(Operators operator) {

		return operatorNames[operator.ordinal()];
	}

	@Override
	public String toString() {

		return getName(currentOperator);
	}
}
