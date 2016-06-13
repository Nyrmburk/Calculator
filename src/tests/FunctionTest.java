package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import calc.Postfix;
import calc.Token;
import calc.VariableSet;

public class FunctionTest {
	
	private static final double DELTA = 1e-15;
	private double value1 = 235.548;
	private double value2 = 35.158645;

	VariableSet variables = new VariableSet();
	Postfix shuntingYard = new Postfix(variables);
	
	@Test
	public void sin() {
		
		
		Token[] infix = shuntingYard.tokenize("sin(" + value1 + ")");
		Token[] postfix = Postfix.precedenceSort(infix);
		double answer = Postfix.interpret(postfix);
		
		assertEquals(answer, Math.sin(value1), DELTA);
	}
	
	@Test
	public void cos() {
		
		Token[] infix = shuntingYard.tokenize("cos(" + value1 + ")");
		Token[] postfix = Postfix.precedenceSort(infix);
		double answer = Postfix.interpret(postfix);
		
		assertEquals(answer, Math.cos(value1), DELTA);
	}

	@Test
	public void tan() {
		
		Token[] infix = shuntingYard.tokenize("tan(" + value1 + ")");
		Token[] postfix = Postfix.precedenceSort(infix);
		double answer = Postfix.interpret(postfix);
		
		assertEquals(answer, Math.tan(value1), DELTA);
	}

	@Test
	public void asin() {
		
		Token[] infix = shuntingYard.tokenize("asin(" + value1 + ")");
		Token[] postfix = Postfix.precedenceSort(infix);
		double answer = Postfix.interpret(postfix);
		
		assertEquals(answer, Math.asin(value1), DELTA);
	}
	
	@Test
	public void acos() {
		
		Token[] infix = shuntingYard.tokenize("acos(" + value1 + ")");
		Token[] postfix = Postfix.precedenceSort(infix);
		double answer = Postfix.interpret(postfix);
		
		assertEquals(answer, Math.acos(value1), DELTA);
	}
	
	@Test
	public void atan() {
		
		Token[] infix = shuntingYard.tokenize("atan(" + value1 + ")");
		Token[] postfix = Postfix.precedenceSort(infix);
		double answer = Postfix.interpret(postfix);
		
		assertEquals(answer, Math.atan(value1), DELTA);
	}
	
	@Test
	public void atan2() {
		
		Token[] infix = shuntingYard.tokenize("atan2(" + value1 + ", " + value2 + ")");
		Token[] postfix = Postfix.precedenceSort(infix);
		double answer = Postfix.interpret(postfix);
		
		assertEquals(answer, Math.atan2(value1, value2), DELTA);
	}
	
	@Test
	public void sinh() {
		
		Token[] infix = shuntingYard.tokenize("sinh(" + value1 + ")");
		Token[] postfix = Postfix.precedenceSort(infix);
		double answer = Postfix.interpret(postfix);
		
		assertEquals(answer, Math.sinh(value1), DELTA);
	}
	
	@Test
	public void cosh() {
		
		Token[] infix = shuntingYard.tokenize("cosh(" + value1 + ")");
		Token[] postfix = Postfix.precedenceSort(infix);
		double answer = Postfix.interpret(postfix);
		
		assertEquals(answer, Math.cosh(value1), DELTA);
	}
	
	@Test
	public void tanh() {
		
		Token[] infix = shuntingYard.tokenize("tanh(" + value1 + ")");
		Token[] postfix = Postfix.precedenceSort(infix);
		double answer = Postfix.interpret(postfix);
		
		assertEquals(answer, Math.tanh(value1), DELTA);
	}
	
	@Test
	public void ceil() {
		
		Token[] infix = shuntingYard.tokenize("ceil(" + value1 + ")");
		Token[] postfix = Postfix.precedenceSort(infix);
		double answer = Postfix.interpret(postfix);
		
		assertEquals(answer, Math.ceil(value1), DELTA);
	}
	
	@Test
	public void floor() {
		
		Token[] infix = shuntingYard.tokenize("floor(" + value1 + ")");
		Token[] postfix = Postfix.precedenceSort(infix);
		double answer = Postfix.interpret(postfix);
		
		assertEquals(answer, Math.floor(value1), DELTA);
	}
	
	@Test
	public void sqrt() {
		
		Token[] infix = shuntingYard.tokenize("sqrt(" + value1 + ")");
		Token[] postfix = Postfix.precedenceSort(infix);
		double answer = Postfix.interpret(postfix);
		
		assertEquals(answer, Math.sqrt(value1), DELTA);
	}
	
	@Test
	public void cbrt() {
		
		Token[] infix = shuntingYard.tokenize("cbrt(" + value1 + ")");
		Token[] postfix = Postfix.precedenceSort(infix);
		double answer = Postfix.interpret(postfix);
		
		assertEquals(answer, Math.cbrt(value1), DELTA);
	}
	
	@Test
	public void root() {
		
		Token[] infix = shuntingYard.tokenize("root(" + value1 + ", " + value2 + ")");
		Token[] postfix = Postfix.precedenceSort(infix);
		double answer = Postfix.interpret(postfix);
		
		assertEquals(answer, Math.pow(value1, 1 /value2), DELTA);
	}
	@Test
	public void modulo() {
		
		Token[] infix = shuntingYard.tokenize("modulo(" + value1 + ", " + value2 + ")");
		Token[] postfix = Postfix.precedenceSort(infix);
		double answer = Postfix.interpret(postfix);
		
		double actualAnswer = value1 % value2;
		if (actualAnswer < 0)
			actualAnswer += value2;
		
		assertEquals(answer, actualAnswer, DELTA);
	}
	
	@Test
	public void inverse() {
		
		Token[] infix = shuntingYard.tokenize("inverse(" + value1 + ")");
		Token[] postfix = Postfix.precedenceSort(infix);
		double answer = Postfix.interpret(postfix);
		
		assertEquals(answer, 1 / value1, DELTA);
	}
	
	@Test
	public void negate() {
		
		Token[] infix = shuntingYard.tokenize("negate(" + value1 + ")");
		Token[] postfix = Postfix.precedenceSort(infix);
		double answer = Postfix.interpret(postfix);
		
		assertEquals(answer, -value1, DELTA);
	}
	
	@Test
	public void functionMultiplication() {
		
		Token[] infix = shuntingYard.tokenize("sin(" + value1 + ")cos(" + value2 + ")");
		Token[] postfix = Postfix.precedenceSort(infix);
		double answer = Postfix.interpret(postfix);
		
		assertEquals(answer, Math.sin(value1) * Math.cos(value2), DELTA);
	}
	
	@Test
	public void negativeFunction() {
		
		Token[] infix = shuntingYard.tokenize("-sin(" + value1 + ")");
		Token[] postfix = Postfix.precedenceSort(infix);
		double answer = Postfix.interpret(postfix);
		
		assertEquals(answer, -Math.sin(value1), DELTA);
	}
	
	@Test
	public void functionMinusFunction() {
		
		Token[] infix = shuntingYard.tokenize("sin(" + value1 + ") - cos(" + value2 + ")");
		Token[] postfix = Postfix.precedenceSort(infix);
		double answer = Postfix.interpret(postfix);
		
		assertEquals(answer, Math.sin(value1) - Math.cos(value2), DELTA);
	}
	
	@Test
	public void positiveFunction() {
		
		Token[] infix = shuntingYard.tokenize("+sin(" + value1 + ")");
		Token[] postfix = Postfix.precedenceSort(infix);
		double answer = Postfix.interpret(postfix);
		
		assertEquals(answer, +Math.sin(value1), DELTA);
	}
}
