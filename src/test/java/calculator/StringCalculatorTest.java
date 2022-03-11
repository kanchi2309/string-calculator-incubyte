package calculator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class StringCalculatorTest {
	
	StringCalculator calculator = new StringCalculator();
	
	@Test
	public void testWithTwoNumbers() {
		assertEquals(25, calculator.addNumbers("10,15"));
	}
	
	@Test
	public void testWithThreeNumbers() {
		assertEquals(25, calculator.addNumbers("10,5,10"));
	}

}
