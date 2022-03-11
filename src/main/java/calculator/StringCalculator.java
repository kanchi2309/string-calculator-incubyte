package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import calculator.exceptions.InvalidInputException;
import calculator.exceptions.NegativeNumberNotAllowedException;

public class StringCalculator {

	public int addNumbers(String numbers) {
			if (!numbers.isEmpty()) {
				int sum = 0;
				String[] nos = checkforCustomDelimeter(numbers);
				if (nos.length > 1) {
					List<Integer> negatives = new ArrayList<>();
					for (String s : nos) {
						int n = Integer.parseInt(s);
						if(n>=0 && n<=1000) {
							sum = sum + n;
						}else if(n<0){
							negatives.add(n);
						}
					}
					if(!negatives.isEmpty()) {
						throw new NegativeNumberNotAllowedException("negatives not allowed : "+negatives.toString().replace("[", "").replace("]", ""));
					}
				} else {
					throw new InvalidInputException();
				}
				return sum;
			}
		return 0;

	}

	private String[] checkforCustomDelimeter(String numbers) {
		if(numbers.startsWith("//")){
			String del  = numbers
	                .substring(0, numbers.indexOf("\n"))
	                .replace("//", "")
	                .replace("[", "")
	                .replace("]", "");
			String nos[] = numbers.substring(numbers.indexOf("\n")+1).split("["+del+"]");
			String[] objects = Arrays.stream(nos).filter(x -> !x.isEmpty()).toArray(String[]::new);
			return objects;
		}
		return numbers.split("[,\n]");
	}
}
