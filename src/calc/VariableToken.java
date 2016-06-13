package calc;

public class VariableToken implements Token {

	VariableSet parent;
	String name;
	double value;

	protected VariableToken(VariableSet parent, String name, double value) {

		this.parent = parent;
		this.name = name;
		this.value = value;
	}
	
	public void setValue(double value) {
		
		this.value = value;
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
	public int size() {
		return name.length();
	}

	@Override
	public String toString() {

		return '[' + name + " = " + value + ']';
	}
}