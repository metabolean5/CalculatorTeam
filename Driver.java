import java.lang.Math;
public class Driver {


	/**
	 * @param args
	 */


	public static void main(String[] args) {
		
		
		
		//printTestCases();
		
		ConsoleApplication cApp = new ConsoleApplication();
		
		cApp.run();

		
		
	
		
	}
	
	
	
	
	//********* FREE FUNCTIONS **********
	
	
	public static void printTestCases() {
		
		Calculator calculator = new Calculator();
		
		System.out.println("*** e^x ***" );
		System.out.println("e^1.44 = " + calculator.Exponent(10, (float) 1.44) );

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
		if(calculator.Cosh(0) != 1)
			coshtest = false;
		for(int i = 0; i < testCount; i++){
			double x = 10000 - 20000*Math.random();

			double hcosh = calculator.Cosh(x);

			double fcosh = Math.cosh(x);
			
			if(checkPrecision(hcosh, fcosh)){
				coshtest = false;
				System.out.println("Cosh Fail: " + x + " / " 
						+ Double.toString(hcosh) + " != " + Double.toString(fcosh)); 
			}
		}
		System.out.println("Cosh function with a precision of 10^-10 has passed the test: " + coshtest);

		System.out.println(calculator.Power(2, 3));
		System.out.println(calculator.Fact(4));
		System.out.println(calculator.Sine(-150));
		//System.out.println(calculator.getPi());
		//System.out.println(calculator.PICONST);
		System.out.println(calculator.DegToRad(720));
		//System.out.println((9%(2.0*calculator.PICONST)));

		System.out.println("\n4^(1/2) = " + checkSqrt(calculator, 4));
		System.out.println("1005^(1/2) = " + checkSqrt(calculator, 10053));
		System.out.println("(5)^(1/2) = " + checkSqrt(calculator, 0.00001));
		System.out.println("0.01^(1/2) = " + checkSqrt(calculator, 29980983));
		//System.out.println("(-2)^(1/2) = " + checkSqrt(calculator, -4)); // Negative value not accepted, causes an error
		
		
	}
	
	
	public static Boolean checkPrecision(double hcosh, double fcosh){
		double prec = 10E-10;
		double dif = hcosh - fcosh;
		if(dif < 0)
			dif = -dif;
		return (dif > prec);
	}
	
	public static boolean checkSqrt(Calculator c, double sqrtval){
	    double x = c.sqrt(sqrtval);
        double y = Math.sqrt(sqrtval);

        System.out.println("Result for Calculator.sqrt: " + x);
        System.out.println("Result for Math.sqrt: " + y);

        if (x == y)
            return true;
        return false;
    }


}
