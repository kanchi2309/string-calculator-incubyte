package calculator.exceptions;

public class InvalidInputException extends IllegalArgumentException {
	
	public InvalidInputException() {
		super(String.format("Invalid input exception - Enter proper input."));
		
	}
}
