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
<<<<<<< Updated upstream


//-------------- FUNCTIONS ----------------
	
	// Exponent (e^x)
	public float exponent(int n, float x){
=======
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
>>>>>>> Stashed changes
			
		float result = 1;
		
		for (int i = 0 ; i < n ; ++i) {
			 result =  1 + x / ( n - i ) * result ;
			}
		
		return result;
	}

<<<<<<< Updated upstream
	//	10^x	//////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public float TenPower(float n){
=======
	/**
	 * 10^x	
	 * @param n
	 * @return result
	 */
	public static float calculateTenPower(float n){
>>>>>>> Stashed changes

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


		double nRoot = FindNthRoot(10, denominator);
		
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
<<<<<<< Updated upstream
	public static double cosh(double x){
		
=======
	

	/**
	 * cosh(x)
	 * @param x
	 * @return total
	 */
	public static double calculateCosh(double x){
		//Known integer value of cosh

>>>>>>> Stashed changes
		if (x == 0){
			return 1;
		}	
		double total = 1;
		for(int i = 1; i < 150; i++){
			total = total + calculatePower(x, (2 * i)) / calculateFactorial((2 * i));
		}
		return total;
	}
<<<<<<< Updated upstream

	public static double Fact(int val){
=======
	
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
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
	public static double Power(double base, int expo) {
=======

	/**
	 * Power with positive integer exponent 
	 * @param base
	 * @param expo
	 * @return x
	 */
	public static double calculatePower(double base, int expo) {
>>>>>>> Stashed changes

		if(expo == 0)
			return 1;

		return base * calculatePower(base, expo-1);
	}
<<<<<<< Updated upstream

	private double FindNthRoot(double base, int expo) {
=======
	
	/**
	 * N root
	 * @param base
	 * @param expo
	 * @return x
	 */
	private static double FindNthRoot(double base, int expo) {
>>>>>>> Stashed changes

		double x = 1;
		boolean accurate = false;

		while (!accurate) {
			double y = (1 / (double) expo) * ((expo - 1) * x + base / calculatePower(x, expo - 1));
			accurate = isAccurate(x, y);
			x = y;
		}

		return x;
	}

<<<<<<< Updated upstream
	private boolean Accuracy(double x, double y) {
=======
	/**
	 * Accuracy for n root
	 * @param x
	 * @param y
	 * @return boolean result
	 */
	private static boolean isAccurate(double x, double y) {
>>>>>>> Stashed changes

		double result = y - x;

		if (result < 0)
			result *= -1;

		return result < 0.000001;
	}

<<<<<<< Updated upstream
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
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
=======

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

	public static double DegToRad(double inp){
		return inp * PICONST / 180.0;
>>>>>>> Stashed changes
	}





		
	

}
