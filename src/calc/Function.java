package calc;

public class Function implements Token {

	public enum Functions {

		SINH, COSH, TANH, ASIN, ACOS, ATAN2, ATAN, SIN, COS, TAN, CEIL, FLOOR, SQRT, CBRT, ROOT, MODULO, INVERSE, NEGATE
	}

	private static String[] functionNames = { "sinh", "cosh", "tanh", "asin",
			"acos", "atan2", "atan", "sin", "cos", "tan", "ceil", "floor",
			"sqrt", "cbrt", "root", "mod", "inv", "neg" };

	private Functions currentFunction;

	public Function(Functions function) {

		this.currentFunction = function;
	}

	public double operate(double... operand) {

		double result;
		switch (currentFunction) {

		case SIN:
			result = Math.sin(operand[0]);
			break;
		case COS:
			result = Math.cos(operand[0]);
			break;
		case TAN:
			result = Math.tan(operand[0]);
			break;
		case ASIN:
			result = Math.asin(operand[0]);
			break;
		case ACOS:
			result = Math.acos(operand[0]);
			break;
		case ATAN:
			result = Math.atan(operand[0]);
			break;
		case ATAN2:
			result = Math.atan2(operand[0], operand[1]);
			break;
		case SINH:
			result = Math.sinh(operand[0]);
			break;
		case COSH:
			result = Math.cosh(operand[0]);
			break;
		case TANH:
			result = Math.tanh(operand[0]);
			break;
		case CEIL:
			result = Math.ceil(operand[0]);
			break;
		case FLOOR:
			result = Math.floor(operand[0]);
			break;
		case SQRT:
			result = Math.sqrt(operand[0]);
			break;
		case CBRT:
			result = Math.cbrt(operand[0]);
			break;
		case ROOT:
			result = Math.pow(operand[0], 1 / operand[1]);
			break;
		case MODULO:
			result = operand[0] % operand[1];
			if (result < 0)
				result += operand[1];
			break;
		case INVERSE:
			result = 1 / operand[0];
			break;
		case NEGATE:
			result = -operand[0];
			break;
		default:
			result = Double.NaN;
			break;
		}

		return result;
	}
	
	@Override
	public int operandCount() {
		
		int count = 0;
		switch (currentFunction) {
		
		case ATAN2:
		case ROOT:
		case MODULO:
			count = 2;
			break;
		default:
			count = 1;
		}
		
		return count;
	}

	public int size() {

		return functionNames[currentFunction.ordinal()].length();
	}

	public static boolean singleOperand(Functions function) {

		boolean singleOperand = true;
		switch (function) {

		case ATAN2:
		case ROOT:
			singleOperand = false;
			break;
		default:
			break;
		}
		return singleOperand;
	}

	public static Function getToken(int startIndex, char[] input) {

		for (Functions function : Functions.values()) {

			if (startsWith(startIndex, functionNames[function.ordinal()], input)) {

				return new Function(function);
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
	
	public static String getName(Functions function) {
		
		return functionNames[function.ordinal()];
	}
	
	@Override
	public String toString() {
		
		return getName(currentFunction);
	}
}
