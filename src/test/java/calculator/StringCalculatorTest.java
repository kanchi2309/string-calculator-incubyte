package calculator;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import calculator.exceptions.InvalidInputException;
import calculator.exceptions.NegativeNumberNotAllowedException;

public class StringCalculatorTest {
	
	StringCalculator calculator = new StringCalculator();
	
	@Rule
    public ExpectedException exceptionRule = ExpectedException.none();
	
	@Test
	public void testEmptyString() {
		assertEquals(0, calculator.addNumbers(""));
	}
	
	@Test
	public void testWithTwoNumbers() {
		assertEquals(25, calculator.addNumbers("10,15"));
	}
	
	@Test
	public void testWithThreeNumbers() {
		assertEquals(25, calculator.addNumbers("10,5,10"));
	}
	
	@Test
	public void testWithNewlineCharacter() {
		assertEquals(6, calculator.addNumbers("1\n2,3"));
	}
	
	@Test
	public void testWithInvalidInput() {
		exceptionRule.expect(InvalidInputException.class);
		exceptionRule.expectMessage("Invalid input exception - Enter proper input.");
		calculator.addNumbers("1\n,");
	}
	
	@Test
	public void testNegativeNumbers() {
		exceptionRule.expect(NegativeNumberNotAllowedException.class);
		exceptionRule.expectMessage("negatives not allowed : -1, -2");
		calculator.addNumbers("-1,-2");
	}
	
	@Test
	public void testNumberGreaterThan1000() {
		assertEquals(13, calculator.addNumbers("6,1001,7"));
	}
	
	@Test 
	public void testCustomDelimeters() {
		assertEquals(6, calculator.addNumbers("//[*][%]\n1*2%3"));
	}
	
	@Test 
	public void testCustomDelimetersAgain() {
		assertEquals(6, calculator.addNumbers("//[***]\n1***2***3"));
	}
	
	
}
