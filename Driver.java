/*
 * Driver
 * 
 * version 3
 * 
 * August 3, 2019 
 * 
 * Copyright © 2019 Sabrina Kim, Martial Pastor, Keven Presseau-St-Laurent, Marco Tropiano, Diana Zitting-Rioux. 
 * All rights reserved.
 */

import java.lang.Math;


/**
 * Driver class for the calculator, runs the application and also can print the test cases
 * 
 * @version 3
 * @author Sabrina Kim, Martial Pastor, Keven Presseau-St-Laurent, Marco Tropiano, Diana Zitting-Rioux
 *
 */
public class Driver {

	public static void main(String[] args) {
		
		//printTestCases();
		
		ConsoleApplication.run();	
	}
	
	/**
	 * Free functions to print test cases
	 */

	public static void printTestCases() {
		

		
		System.out.println("*** e^x ***" );

		System.out.println("e^1.44 = " + Calculator.calculateExponent(10, (float) 1.44) );


		System.out.println("\n*** 10^x ***");
		System.out.println("Test 10^0 = " + Test.CheckTenPower(0f) );
		System.out.println("Test 10^5 = " + Test.CheckTenPower(5f) );
		System.out.println("Test 10^-5 = " + Test.CheckTenPower(-5f) );
		System.out.println("Test 10^0.5 = " + Test.CheckTenPower(0.5f) );
		System.out.println("Test 10^-999.99 = " + Test.CheckTenPower(-999.99f) );
		System.out.println("Test 10^999.99 = " + Test.CheckTenPower(999.99f) );
		System.out.println("Test 10^-25.3 = " + Test.CheckTenPower(-25.3f) );
		System.out.println("Test 10^1.51 = " + Test.CheckTenPower(1.51f) );
		System.out.println("Test 10^1.1111 = " + Test.CheckTenPower(1.1111f) );

		
		Boolean coshtest = true;
		int testCount = 10000;
		if(Calculator.calculateCosh(0) != 1)

			coshtest = false;
		for(int i = 0; i < testCount; i++){
			double x = 10000 - 20000*Math.random();


			double hcosh = Calculator.calculateCosh(x);


			double fcosh = Math.cosh(x);
			
			if(checkPrecision(hcosh, fcosh)){
				coshtest = false;
				System.out.println("Cosh Fail: " + x + " / " 
						+ Double.toString(hcosh) + " != " + Double.toString(fcosh)); 
			}
		}
		System.out.println("Cosh function with a precision of 10^-10 has passed the test: " + coshtest);

		//System.out.println(calculator.Power(2, 3));
		//System.out.println(calculator.Fact(4));

		System.out.println("Test sin(-15) = " + Calculator.calculateSine(-15));
		System.out.println("Test sin(0) = " + Calculator.calculateSine(0));
		System.out.println("Test sin(-17300) = " + Calculator.calculateSine(-17300));
		System.out.println("Test sin(38000) = " + Calculator.calculateSine(38000));
		System.out.println("Test sin(12) = " + Calculator.calculateSine(12));

		//System.out.println(calculator.getPi());
		//System.out.println(calculator.PICONST);
		System.out.println("Test Degree to Radian DegToRad(720) = " + Calculator.DegToRad(720));
		System.out.println("Test Degree to Radian DegToRad(180) = " + Calculator.DegToRad(180));
		System.out.println("Test Degree to Radian DegToRad(-18000) = " + Calculator.DegToRad(-18000));
		System.out.println("Test Degree to Radian DegToRad(0) = " + Calculator.DegToRad(0));

		System.out.println("\n4^(1/2) = " + checkSqrt(4));
		System.out.println("1005^(1/2) = " + checkSqrt(10053));
		System.out.println("(5)^(1/2) = " + checkSqrt(0.00001));
		System.out.println("0.01^(1/2) = " + checkSqrt(29980983));
		//System.out.println("(-2)^(1/2) = " + checkSqrt(calculator, -4)); // Negative value not accepted, causes an error
		
		
	}
	

	/**
	 * Check precision on hcosh
	 * @param hcosh
	 * @param fcosh
	 * @return dif>prec
	 */

	public static Boolean checkPrecision(double hcosh, double fcosh){
		double prec = 10E-10;
		double dif = hcosh - fcosh;
		if(dif < 0)
			dif = -dif;
		return (dif > prec);
	}
	

	/**
	 * Checks square root compared to inbuilt square-root
	 * @param c
	 * @param sqrtval
	 * @return boolean
	 */
	public static boolean checkSqrt(double sqrtval){
	    double x = Calculator.calculateSquareRoot(sqrtval);

        double y = Math.sqrt(sqrtval);

        System.out.println("Result for Calculator.sqrt: " + x);
        System.out.println("Result for Math.sqrt: " + y);


        if (x == y)
            return true;
        return false;
    }
}
