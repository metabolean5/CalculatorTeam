import java.util.Scanner;




public class ConsoleApplication {
		
	public static void run() {
		
		
		boolean exit = false;
		Scanner scan = new Scanner(System.in);

	
		while(!exit) {
			System.out.println("POSSIBLE FUNCTIONS: \n\n -exp(x) \t -cosh(x) \n\n -sqrt(x)\t -sin(x) \n\n -pow(x)\t -+ - * / ()\n\n " );
			System.out.println("Enter Calculations (type 'exit' to end): " );
		
			String str= scan.nextLine();
			
			float result = ExpressionParser.calculate(str);

			System.out.println("\n\nRESULT = " + result+ "\n\n");
		
		}
			
	}

}
