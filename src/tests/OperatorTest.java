package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import calc.Postfix;
import calc.Token;
import calc.VariableSet;

public class OperatorTest {

	private static final double DELTA = 1e-15;
	private double value1 = 235.548;
	private double value2 = 35.158645;

	VariableSet variables = new VariableSet();
	Postfix shuntingYard = new Postfix(variables);


	@Test
	public void power() {
		
		Token[] infix = shuntingYard.tokenize(value1 + " ^ " + value2);
		Token[] postfix = Postfix.precedenceSort(infix);
		double answer = Postfix.interpret(postfix);
		
		assertEquals(answer, Math.pow(value1, value2), DELTA);
	}
	
	@Test
	public void multiply() {
		
		Token[] infix = shuntingYard.tokenize(value1 + " * " + value2);
		Token[] postfix = Postfix.precedenceSort(infix);
		double answer = Postfix.interpret(postfix);
		
		assertEquals(answer, value1 * value2, DELTA);
	}
	
	@Test
	public void divide() {
		
		Token[] infix = shuntingYard.tokenize(value1 + " / " + value2);
		Token[] postfix = Postfix.precedenceSort(infix);
		double answer = Postfix.interpret(postfix);
		
		assertEquals(answer, value1 / value2, DELTA);
	}
	
	@Test
	public void remainder() {
		
		Token[] infix = shuntingYard.tokenize(value1 + " % " + value2);
		Token[] postfix = Postfix.precedenceSort(infix);
		double answer = Postfix.interpret(postfix);
		
		assertEquals(answer, value1 % value2, DELTA);
	}
	
	@Test
	public void add() {
		
		Token[] infix = shuntingYard.tokenize(value1 + " + " + value2);
		Token[] postfix = Postfix.precedenceSort(infix);
		double answer = Postfix.interpret(postfix);
		
		assertEquals(answer, value1 + value2, DELTA);
	}
	
	@Test
	public void subtract() {
		
		Token[] infix = shuntingYard.tokenize(value1 + " - " + value2);
		Token[] postfix = Postfix.precedenceSort(infix);
		double answer = Postfix.interpret(postfix);
		
		assertEquals(answer, value1 - value2, DELTA);
	}
	
	@Test
	public void pemdas() {
		
		double value3 = 36948.1; 
		
		Token[] infix = shuntingYard.tokenize(
				value1 + " - " + value2 + " + " + value3 + " / " + value1 + " ^ " + value2 + " * " + value1);
		Token[] postfix = Postfix.precedenceSort(infix);
		double answer = Postfix.interpret(postfix);
		
		assertEquals(answer, value1 - value2 + value3 / Math.pow(value1, value2) * value1, DELTA);
	}
	
	@Test
	public void negativePower() {
		
		Token[] infix = shuntingYard.tokenize(" -" + value1 + " ^- " + value2);
		Token[] postfix = Postfix.precedenceSort(infix);
		double answer = Postfix.interpret(postfix);
		
		assertEquals(answer, -Math.pow(value1, -value2), DELTA);
	}
	
	@Test
	public void negativeMultiply() {
		
		Token[] infix = shuntingYard.tokenize(" -" + value1 + " *- " + value2);
		Token[] postfix = Postfix.precedenceSort(infix);
		double answer = Postfix.interpret(postfix);
		
		assertEquals(answer, -value1 * -value2, DELTA);
	}
	
	@Test
	public void negativeDivide() {
		
		Token[] infix = shuntingYard.tokenize(" -" + value1 + " /- " + value2);
		Token[] postfix = Postfix.precedenceSort(infix);
		double answer = Postfix.interpret(postfix);
		
		assertEquals(answer, -value1 / -value2, DELTA);
	}
	
	@Test
	public void negativeRemainder() {
		
		Token[] infix = shuntingYard.tokenize(" -" + value1 + " %- " + value2);
		Token[] postfix = Postfix.precedenceSort(infix);
		double answer = Postfix.interpret(postfix);
		
		assertEquals(answer, -value1 % -value2, DELTA);
	}
	
	@Test
	public void negativeAdd() {
		
		Token[] infix = shuntingYard.tokenize(" -" + value1 + " +- " + value2);
		Token[] postfix = Postfix.precedenceSort(infix);
		double answer = Postfix.interpret(postfix);
		
		assertEquals(answer, -value1 - value2, DELTA);
	}
	
	@Test
	public void negativeSubtract() {
		
		Token[] infix = shuntingYard.tokenize(" -" + value1 + " -- " + value2);
		Token[] postfix = Postfix.precedenceSort(infix);
		double answer = Postfix.interpret(postfix);
		
		assertEquals(answer, -value1 + value2, DELTA);
	}
	
	@Test
	public void negativeValue() {
		
		Token[] infix = shuntingYard.tokenize(" -" + value1);
		Token[] postfix = Postfix.precedenceSort(infix);
		double answer = Postfix.interpret(postfix);
		
		assertEquals(answer, -value1, DELTA);
	}
	
	@Test
	public void positiveValue() {
		
		Token[] infix = shuntingYard.tokenize(" +" + value1);
		Token[] postfix = Postfix.precedenceSort(infix);
		double answer = Postfix.interpret(postfix);
		
		assertEquals(answer, value1, DELTA);
	}
	
	@Test
	public void negativePositiveValue() {
		
		Token[] infix = shuntingYard.tokenize(" -+" + value1);
		Token[] postfix = Postfix.precedenceSort(infix);
		double answer = Postfix.interpret(postfix);
		
		assertEquals(answer, -+value1, DELTA);
	}
	
	@Test
	public void positiveNegativeValue() {
		
		Token[] infix = shuntingYard.tokenize(" +-" + value1);
		Token[] postfix = Postfix.precedenceSort(infix);
		double answer = Postfix.interpret(postfix);
		
		assertEquals(answer, +-value1, DELTA);
	}
}
