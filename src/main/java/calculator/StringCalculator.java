package calculator;

public class StringCalculator {

	public int addNumbers(String numbers) {
		
		if(numbers.isEmpty()) {
			return 0;
		}else {
			int sum=0;
			String[] nos = numbers.replace("\n", ",").split(",");
			//.split(/[\n,]+/)
			for(String s:nos) {
				sum=sum+Integer.parseInt(s);
			}
			return sum;
		}
	}
}
