package calc;

public class Value implements Token {

	double value;
	int charLength;

	public Value(double value, int charLength) {

		this.value = value;
		this.charLength = charLength;
	}

	public static Value getToken(int startIndex, char[] input) {

		double value = 0;
		int charLength = 0;

		int index = startIndex;
		while (index < input.length && ((input[index] >= '0' && input[index] <= '9')
				|| input[index] == '.')) {
			index++;
		}
		
		charLength = index - startIndex;
		if (charLength > 0) {
			
			value = Double.valueOf(String.valueOf(input).substring(startIndex, index));
			return new Value(value, charLength);
		}

		return null;
	}

	@Override
	public int size() {
		return charLength;
	}

	@Override
	public double operate(double... operand) {
		return value;
	}
	
	@Override
	public int operandCount() {
		return 0;
	}

	@Override
	public String toString() {

		return Double.toString(value);
	}
}
