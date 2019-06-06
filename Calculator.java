
public class Calculator {
//-------------- CONSTANTS ----------------
	final static double PICONST = 3.141592653589793238462643383279502884197169399375105820974944592307816406286;

//-------------- MAIN FUNCTIONS ----------------
	
<<<<<<< HEAD
	// Exponent (e^x) //////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public float exponent(int n, float x){
=======
	// Exponent (e^x)
	public float Exponent(int n, float x){
>>>>>>> f316e4479db407204411a6089a790bcd896dd9e5
			
		float result = 1;
		
		for (int i = 0 ; i < n ; ++i) {
			 result =  1 + x/(n-i) * result ;
			}
		
		return result;
	}

	//	10^x	
	public static float TenPower(float n){

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


		result = (float) Power(10, whole);

		//System.out.println("\nRemaining Fraction:" + decimal + "/" + denominator);


		double nRoot = FindNthRoot(10, denominator);
		
		float nextPart = (float) Power(nRoot, decimal);

		//System.out.println("\nnRoot: " + nRoot);

		//nextPart = nRoot;

		//System.out.println("Decimal: " + decimal);
		

		//System.out.println("nextPart: " + nextPart);

		result *= nextPart;

		if (isNegative)
			result = 1/result;

		return  result;
	}
<<<<<<< HEAD
	
	
	
	//	cosh(x)	//////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public double cosh(double x){
		
=======
	//cosh(x)
	public static double Cosh(double x){
		//Known integer value of cosh
>>>>>>> f316e4479db407204411a6089a790bcd896dd9e5
		if (x == 0){
			return 1;
		}	
		//Taylor series ((x^2n)/(2n)!) summation from n = 0 to 149 
		//n = 0
		double total = 1;
		//n = 1 to 149 
		for(int i = 1; i < 150; i++){
			total = total + Power(x, (2*i))/Fact((2*i));
		}
		return total;
	}
	
<<<<<<< HEAD
	//	Factorial (x)	//////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
=======
	// Square root of x (x^(1/2))
	
	public double Sqrt(double number) {
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
		
	//Sin(x)
	
	//Using rads
	public static double Sine(double inp){

		double inpMod = inp % (2.0*PICONST);
		double result = inpMod;

		for(int j = 3; j < 150; j+=4){
			result -= (Power(inpMod, j)/Fact(j));
			result += (Power(inpMod, j+2)/Fact(j+2));
		}

		return result;
	}
//-------------- SECONDARY FUNCTIONS ----------------
	//Factorial
>>>>>>> f316e4479db407204411a6089a790bcd896dd9e5
	public static double Fact(int val){
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
<<<<<<< HEAD
	
=======
	//Power with positive integer exponent 
>>>>>>> f316e4479db407204411a6089a790bcd896dd9e5
	public static double Power(double base, int expo) {

		if(expo == 0)
			return 1;

		return base * Power(base, expo-1);
	}
	
	//N Root
	private static double FindNthRoot(double base, int expo) {

		double x = 1;
		boolean accurate = false;

		while (!accurate) {
			double y = (1 / (double) expo) * ((expo - 1) * x + base / Power(x, expo - 1));
			accurate = Accuracy(x, y);
			x = y;
		}

		return x;
	}

	private static boolean Accuracy(double x, double y) {

		double result = y - x;

		if (result < 0)
			result *= -1;

		return result < 0.000001;
	}

	
<<<<<<< HEAD
	// Square root (x^(1/2)) //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
=======
>>>>>>> f316e4479db407204411a6089a790bcd896dd9e5
	


	


	

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
	}





		
	

}
