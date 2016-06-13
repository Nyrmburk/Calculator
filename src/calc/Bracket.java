package calc;

public class Bracket implements Token {
	
	private static final char[] TYPES = {'(', ')', '[', ']', '{', '}'};
	
	private char type;
	boolean left;
	
	private Bracket(char type, boolean left) {
		
		this.type = type;
		this.left = left;
	}
	
	public static Bracket getToken(int startIndex, char[] input) {
		
		for (int i = 0; i < TYPES.length; i++) {
			
			if (input[startIndex] == TYPES[i]) {
				
				return new Bracket(TYPES[i], i % 2 == 0);
			}
		}
		return null;
	}

	@Override
	public int size() {
		return 1;
	}

	@Override
	public double operate(double... operand) {
		
		return type % 3;
	}
	
	@Override
	public int operandCount() {
		return 0;
	}
	
	@Override
	public String toString() {
		
		return String.valueOf(type);
	}
}
