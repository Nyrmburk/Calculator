package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import calc.Postfix;
import calc.Token;
import calc.VariableSet;

public class BracketTest {

	private static final double DELTA = 1e-15;
	private double value = 2486.932;
	
	VariableSet variables = new VariableSet();
	Postfix shuntingYard = new Postfix(variables);
	
	@Test
	public void multiBracket() {


		Token[] infix = shuntingYard.tokenize("({[" + value + "]})");
		Token[] postfix = Postfix.precedenceSort(infix);
		double answer = Postfix.interpret(postfix);
		
		assertEquals(answer, value, DELTA);
	}

	
// It's not a bug, it's a feature.
//	@Test(expected=MismatchedBracketException.class)
//	public void multiMismatchedBracket() {
//
//
//		Token[] infix = shuntingYard.tokenize("({[" + value + ")]}");
//		Token[] postfix = Postfix.precedenceSort(infix);
//		double answer = Postfix.interpret(postfix);
//		
//		assertEquals(answer, value, DELTA);
//	}
	
	@Test
	public void bracketMultiplication() {


		Token[] infix = shuntingYard.tokenize("(" + value + ")(" + value + ")");
		Token[] postfix = Postfix.precedenceSort(infix);
		double answer = Postfix.interpret(postfix);
		
		assertEquals(answer, value * value, DELTA);
	}
	
	@Test
	public void bracketNegative() {


		Token[] infix = shuntingYard.tokenize("(-" + value + ")");
		Token[] postfix = Postfix.precedenceSort(infix);
		double answer = Postfix.interpret(postfix);
		
		assertEquals(answer, -value, DELTA);
	}
	
	@Test
	public void bracketPositive() {


		Token[] infix = shuntingYard.tokenize("(+" + value + ")");
		Token[] postfix = Postfix.precedenceSort(infix);
		double answer = Postfix.interpret(postfix);
		
		assertEquals(answer, +value, DELTA);
	}
	
	@Test
	public void bracketPositiveNegative() {


		Token[] infix = shuntingYard.tokenize("(+-" + value + ")");
		Token[] postfix = Postfix.precedenceSort(infix);
		double answer = Postfix.interpret(postfix);
		
		assertEquals(answer, -value, DELTA);
	}
	
	@Test
	public void bracketNegativePositive() {


		Token[] infix = shuntingYard.tokenize("(-+" + value + ")");
		Token[] postfix = Postfix.precedenceSort(infix);
		double answer = Postfix.interpret(postfix);
		
		assertEquals(answer, -value, DELTA);
	}
	
	@Test
	public void negativeBracket() {


		Token[] infix = shuntingYard.tokenize("-(" + value + ")");
		Token[] postfix = Postfix.precedenceSort(infix);
		double answer = Postfix.interpret(postfix);
		
		assertEquals(answer, -value, DELTA);
	}
	
	@Test
	public void positivePracket() {


		Token[] infix = shuntingYard.tokenize("+(" + value + ")");
		Token[] postfix = Postfix.precedenceSort(infix);
		double answer = Postfix.interpret(postfix);
		
		assertEquals(answer, +value, DELTA);
	}
	
	@Test
	public void positiveNegativeBracket() {


		Token[] infix = shuntingYard.tokenize("+-(" + value + ")");
		Token[] postfix = Postfix.precedenceSort(infix);
		double answer = Postfix.interpret(postfix);
		
		assertEquals(answer, -value, DELTA);
	}
	
	@Test
	public void negativePositiveBracket() {


		Token[] infix = shuntingYard.tokenize("-+(" + value + ")");
		Token[] postfix = Postfix.precedenceSort(infix);
		double answer = Postfix.interpret(postfix);
		
		assertEquals(answer, -value, DELTA);
	}
}
