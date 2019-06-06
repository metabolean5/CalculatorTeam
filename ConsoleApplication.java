import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConsoleApplication {
	
	
	
	public static void run() {
		
		
		boolean exit = false;
		Scanner scan = new Scanner(System.in);

		
		System.out.println("POSSIBLE FUNCTIONS: \n\n -e^x \t -coshx \n\n -sqrtx \t -10^x\n\n " );
		
		while(!exit) {
		
			System.out.println("Enter Calculations (type 'exit' to end): " );
		
			String str= scan.nextLine();
			
			float result = computeExpr(str);

			System.out.println(result);
		
			
			
			

		}
			
	}
	
	public static float computeExpr(String str) {
		
		String func = str.substring(0, 2);
		String num = "0";
		Calculator calculator = new Calculator();
		
		String regex = "(\\-)?\\d+(\\.\\d+)?";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(str);
		
		if (matcher.find())
		{
		    num = matcher.group(0);
		}
		
		
		switch (func) {
        case "e^":
        	return calculator.exponent(10, Float.parseFloat(num));
        case "co":
        	double result = Double.parseDouble(num);
        	return (float) calculator.cosh(result);
        case "10":
        	return calculator.TenPower(Float.parseFloat(num));
        case "sq":
        	double res = Double.parseDouble(num);
        	return (float) calculator.sqrt(res);
        case "exit":
        	System.exit(0);
        default:
            throw new IllegalArgumentException("Invalid input: " + str);
		
	
		
		
		}
	}
	
	
	

}
