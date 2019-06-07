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
        	return calculator.Exponent(10, Float.parseFloat(num));
        case "co":
        	double result = Double.parseDouble(num);
        	return (float) calculator.Cosh(result);
        case "10":
        	String parts[] = str.split("\\^");
        	return Calculator.TenPower(Float.parseFloat(parts[1]));
        case "sq":
        	double res = Double.parseDouble(num);
        	return (float) calculator.Sqrt(res);
        case "si":
        	double res = Double.parseDouble(num);
        	return (float) calculator.Sine(res);
        case "exit":
        	System.exit(0);
        default:
            throw new IllegalArgumentException("Invalid input: " + str);
		
	
		
		
		}
	}
	
	
	

}
