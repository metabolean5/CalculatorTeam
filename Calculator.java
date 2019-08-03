/*
 * Calculator
 * 
 * version 1
 * 
 * August 3, 2019 
 * 
 * Copyright © 2019 Sabrina Kim, Martial Pastor, Keven Presseau-St-Laurent, Marco Tropiano, Diana Zitting-Rioux. 
 * All rights reserved.
 */

/**
 * Calculator class that has all the required functions for the calculator.
 * 
 * @version 1
 * @author Sabrina Kim, Martial Pastor, Keven Presseau-St-Laurent, Marco Tropiano, Diana Zitting-Rioux
 *
 */

public class Calculator {

/**
 * Constants
 */
	final static double PICONST = 3.141592653589793238462643383279502884197169399375105820974944592307816406286;

//-------------- MAIN FUNCTIONS ----------------

	/**
	 * Exponent (e^x)
	 * @param n
	 * @param x
	 * @return result
	 */
	public static float calculateExponent(int n, float x){
			
		float result = 1;
		
		for (int i = 0 ; i < n ; ++i) {
			 result =  1 + x / ( n - i ) * result ;
			}
		
		return result;
	}

	/**
	 * 10^x	
	 * @param n
	 * @return result
	 */
	public static float calculateTenPower(float n){

		float result = 1;

		if (n == 0)
			return result;

		boolean isNegative = false;

		if (n < 0){
			isNegative = true;
			n *= -1;
		}

		String text = Float.toString(n);
		int numbWhole = text.indexOf('.');
		int numbDeci = text.length() - numbWhole - 1;

		//System.out.println(text + "\tnumbDeci: " + numbDeci);

		int maxDigits = 1;

		for (int i = 0 ; i < numbDeci; ++i)
			maxDigits *= 10;

		//System.out.println("maxDigits: " + maxDigits);

		int numerator = (int) (n * maxDigits);
		int denominator = maxDigits;

		//System.out.println("Fraction: " + numerator + "/" + denominator + "\tDecimal: " + (float) numerator/denominator);

		int whole = 0;

		while (numerator >= denominator){

			whole++;

			numerator -= denominator;

		}

		int decimal = numerator;

		//System.out.println("Whole: " + whole + "\tDecimal: " + decimal);


		result = (float) calculatePower(10, whole);

		//System.out.println("\nRemaining Fraction:" + decimal + "/" + denominator);


		double nRoot = findNthRoot(10, denominator);
		
		float nextPart = (float) calculatePower(nRoot, decimal);

		//System.out.println("\nnRoot: " + nRoot);

		//nextPart = nRoot;

		//System.out.println("Decimal: " + decimal);
		

		//System.out.println("nextPart: " + nextPart);

		result *= nextPart;

		if (isNegative)
			result = 1 / result;

		return  result;
	}

	

	/**
	 * cosh(x)
	 * @param x
	 * @return total
	 */
	public static double calculateCosh(double x){
		//Known integer value of cosh

		if (x == 0){
			return 1;
		}	
		double total = 1;
		for(int i = 1; i < 150; i++){
			total = total + calculatePower(x, (2 * i)) / calculateFactorial((2 * i));
		}
		return total;
	}
	
	/**
	 * Square root of x (x^(1/2))
	 * @param number
	 * @return
	 */
	
	public static double calculateSquareRoot(double number) {
		if (number<0){ // Check that value is nonnegative
			throw new IllegalArgumentException("Number must be greater than zero."); // TODO handle better
		}
		if (number == 0){ // If passed number is 0, return value 0
			return number;
		}
		
		double t;
		 
		double squareRoot = number;
		 
		// Do guesses using Newthon's method until t is equal to squareRoot
		do {
			t = squareRoot;
			squareRoot = ((number / t + t)) / 2;
		} while ((t - squareRoot) != 0); 
		 
		return squareRoot;
	}
		
	/**
	 * Sin(x) using rads
	 * @param inp
	 * @return result
	 */
	public static double calculateSine(double inp){

		double inpMod = inp % (2.0*PICONST);
		double result = inpMod;

		for(int j = 3; j < 150; j+=4){
			result -= (calculatePower(inpMod, j) / calculateFactorial(j));
			result += (calculatePower(inpMod, j+2) / calculateFactorial(j+2));
		}

		return result;
	}
//-------------- SECONDARY FUNCTIONS ----------------
	
	/**
	 * Factorial
	 * @param val
	 * @return total
	 */
	public static double calculateFactorial(int val){
		if (val == 0){
			return 1;
		}
		else{
			double total = 1;
			for(int i = 0; i < val; i++){
				total = total * (val - i);
			}
			return total;
		}
	}

	/**
	 * Power with positive integer exponent 
	 * @param base
	 * @param expo
	 * @return x
	 */
	public static double calculatePower(double base, int expo) {
		if(expo == 0)
			return 1;

		return base * calculatePower(base, expo-1);
	}
	
	/**
	 * N root
	 * @param base
	 * @param expo
	 * @return x
	 */
	private static double findNthRoot(double base, int expo) {
		double x = 1;
		boolean accurate = false;

		while (!accurate) {
			double y = (1 / (double) expo) * ((expo - 1) * x + base / calculatePower(x, expo - 1));
			accurate = isAccurate(x, y);
			x = y;
		}

		return x;
	}

	/**
	 * Accuracy for n root
	 * @param x
	 * @param y
	 * @return boolean result
	 */
	private static boolean isAccurate(double x, double y) {
		double result = y - x;

		if (result < 0)
			result *= -1;

		return result < 0.000001;
	}

	// Square root (x^(1/2))
	
	public double sqrt(double number) {
		if (number<0){ // Check that value is nonnegative
			throw new IllegalArgumentException("Number must be greater than zero."); // TODO handle better
		}
		if (number == 0){ // If passed number is 0, return value 0
			return number;
		}
		
		double t;
	 
		double squareRoot = number;
	 
		// Do guesses using Newthon's method until t is equal to squareRoot
		do {
			t = squareRoot;
			squareRoot = ((number / t + t)) / 2;
		} while ((t - squareRoot) != 0); 
	 
		return squareRoot;
	}

	//getting pi somewhat accurate took a very long time
    /*
    public static double getPi(){
        double result = 0.0;
        for(double i = 1; i < 1500000000; i+=4){
            result += (4.0/i);
            result -= (4.0/(i+2.0));
        }
        return result;
    }
    */

	/**
	 * Deg to rad
	 * @param inp
	 * @return inp
	 */
	public static double DegToRad(double inp){
		return inp * PICONST / 180.0;
	}
}
