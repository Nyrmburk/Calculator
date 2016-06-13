package calc;

import java.util.Stack;

import calc.Operator;

/**
 * Convert a string into a value.
 * 
 * @author Christopher Dombroski
 */
public class Postfix {

	enum TokenType {

		VALUE, FUNCTION, VARIABLE, OPERATOR, BRACKET
	}

	VariableSet variables;

	/**
	 * Make a new Postfix Object with a blank VariableSet.
	 */
	public Postfix() {

		this(new VariableSet());
	}

	/**
	 * @param variables
	 *            A VariableSet that holds all the variables.
	 */
	public Postfix(VariableSet variables) {

		this.variables = variables;
	}

	/**
	 * Go straight from input to answer.
	 * 
	 * @param input
	 *            Text containing math expressions.
	 * @return The result of the expression.
	 */
	public double parse(String input) {

		return interpret(precedenceSort(tokenize(input)));
	}

	/**
	 * Get a Token representation of the string. Does no reordering.
	 * 
	 * @param input
	 *            A String to tokenize in infix notation.
	 * @return An array of tokens in infix notation.
	 */
	public Token[] tokenize(String input) {

		Stack<Token> output = new Stack<>();

		char[] inputChars = input.toCharArray();
		Token token = null;

		int i = 0;
		while (i < inputChars.length) {

			boolean unknown = true;
			for (TokenType type : TokenType.values()) {

				switch (type) {
				case VALUE:
					token = Value.getToken(i, inputChars);
					break;
				case VARIABLE:
					token = variables.getToken(i, inputChars);
					break;
				case FUNCTION:
					token = Function.getToken(i, inputChars);
					break;
				case OPERATOR:
					token = Operator.getToken(i, inputChars);

//					if (token != null && ((Operator) token).isSign()) {
//						
//						if (!output.isEmpty()) {
//
//							if (output.peek() instanceof Bracket) {
//								
//								if (((Bracket) output.peek()).left)
//									output.push(new Value(0, 0));
//							}
//
//						} else {
//
//							output.push(new Value(0, 0));
//						}
//					}
					break;
				case BRACKET:
					token = Bracket.getToken(i, inputChars);
					break;
				}

				if (token != null) {

					output.push(token);
					i += token.size();
					unknown = false;
					break;
				}
			}

			if (unknown)
				i++;
		}

		return preprocess(output.toArray(new Token[output.size()]));
	}
	
	private Token[] preprocess(Token[] infix) {
		
		Stack<Token> flipped = new Stack<>();
		
		int i = infix.length;
		while (i --> 0) {
			
			Token currentToken = infix[i];
			Token rightToken = flipped.isEmpty() ? null : flipped.peek();
			Token leftToken = i > 0 ? infix[i - 1] : null;
			
			boolean padZero = false;
			
			if (rightToken != null) {
				
				if (currentToken instanceof Operator && ((Operator) currentToken).isSign()) {

					if ((leftToken instanceof Operator)) {
						
						if (((Operator) currentToken).isPositive())
							continue;

						if (rightToken instanceof Value) {

							((Value) rightToken).value = -((Value) rightToken).value;

						} else if (rightToken instanceof Bracket && ((Bracket) rightToken).left) {

							flipped.push(currentToken);
							flipped.push(new Value(0, 0));
						}
						continue;
					}
					
					if (leftToken == null)
						padZero = true;
					
					if (leftToken instanceof Bracket && ((Bracket) leftToken).left)
						padZero = true;
					
				} else if (leftToken instanceof Bracket && !((Bracket) leftToken).left) {
					
					if (!(currentToken instanceof Bracket && !((Bracket) currentToken).left)) {
						
						flipped.add(currentToken);
						flipped.push(new Operator(Operator.Operators.MULTIPLY));
						continue;
					}
				}
			}
			
			flipped.push(currentToken);
			
			if (padZero) {
				flipped.push(new Value(0, 0));
				padZero = false;
			}
		}
		
		Token[] processed = new Token[flipped.size()];
		for (int j = 0; j < processed.length; j++)
			processed[j] = flipped.pop();
		
		return processed;
	}

	/**
	 * Sort the infix notation into postfix notation.
	 * 
	 * @param tokens
	 *            A Token representation of an infix expression
	 * @return A Token array containing a postfix expression.
	 */
	public static Token[] precedenceSort(Token[] tokens) {

		Stack<Token> output = new Stack<Token>();
		Stack<Token> operators = new Stack<Token>();
		boolean nextValue = false;
		boolean nextOperator = false;

		for (int i = 0; i < tokens.length; i++) {

			if (nextValue || tokens[i] instanceof Value) {

				output.push(tokens[i]);
			} else if (tokens[i] instanceof Function) {

				operators.push(tokens[i]);
			} else if (tokens[i] instanceof VariableToken) {

				output.push(tokens[i]);

			} else if (nextOperator || tokens[i] instanceof Operator) {

				Operator currentOperator = (Operator) tokens[i];
				while (!operators.isEmpty()) {
					
					if (operators.peek() instanceof Operator) {

						if ((currentOperator.leftAssociative()
								&& currentOperator.compareTo((Operator) operators.peek()) <= 0)
								|| (!currentOperator.leftAssociative()
										&& currentOperator.compareTo((Operator) operators.peek()) < 0)) {

							output.push(operators.pop());
						} else {

							break;
						}
					} else if (operators.peek() instanceof Function) {
						
						output.push(operators.pop());
					} else {
						
						break;
					}
				}

				operators.push(currentOperator);

			} else if (tokens[i] instanceof Bracket) {

				Bracket currentBracket = (Bracket) tokens[i];

				if (currentBracket.left) {

					operators.push(currentBracket);
				} else {

					Token operator = null;
					while (true) {
						operator = operators.peek();

						if (operator instanceof Bracket
								&& ((Bracket) operator).left)
							break;

						output.push(operators.pop());
					}

					operators.pop();
				}
			}

			nextValue = false;
			nextOperator = false;
		}

		while (!operators.isEmpty()) {

			output.push(operators.pop());
		}

		return output.toArray(new Token[output.size()]);
	}

	/**
	 * Quickly calculate the result of the postfix notation. Changing variables
	 * and recalculating is a fast way to reuse a postfix expression with new
	 * data.
	 * 
	 * @param tokens a postfix expression
	 * @return The calculated value of the postfix expression.
	 * @throws NumberFormatException
	 */
	public static double interpret(Token[] tokens) throws NumberFormatException {

		Stack<Double> output = new Stack<Double>();

		for (int i = 0; i < tokens.length; i++) {

			double[] operands = new double[tokens[i].operandCount()];

			if (operands.length > output.size())
				throw new NumberFormatException("insufficient values at "
						+ tokens[i]);

			for (int j = 0; j < operands.length; j++)
				operands[operands.length - 1 - j] = output.pop();
			output.push(tokens[i].operate(operands));
		}

		if (output.size() > 1)
			throw new NumberFormatException("insufficient operators");

		double answer = 0.0;
		if (!output.isEmpty())
			answer = output.pop();
		return answer;
	}
}
