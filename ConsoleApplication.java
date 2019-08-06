
/*
 * ConsoleApplication
 * 
 * version 1
 * 
 * August 3, 2019 
 * 
 * Copyright © 2019 Sabrina Kim, Martial Pastor, Keven Presseau-St-Laurent, Marco Tropiano, Diana Zitting-Rioux. 
 * All rights reserved.
 */

import java.util.Scanner;

/**
 * Console application that includes the run method.
 * 
 * @version 1
 * @author Sabrina Kim, Martial Pastor, Keven Presseau-St-Laurent, Marco Tropiano, Diana Zitting-Rioux
 * 
 */



public class ConsoleApplication {
		

	/**
	 * Run parser
	 */

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
