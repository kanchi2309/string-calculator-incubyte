package calculator.exceptions;

public class NegativeNumberNotAllowedException extends IllegalArgumentException {
	public NegativeNumberNotAllowedException(String msg) {
		super(msg);
	}

}
