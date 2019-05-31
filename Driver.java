import java.lang.Math;
public class Driver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
		Calculator calculator = new Calculator();
		
		System.out.println("e^1.44 = " + calculator.exponent(10, (float) 1.44) );

		System.out.println("\n10^0 = " + calculator.TenPower(0f));
		System.out.println("10^1.51 = " + calculator.TenPower(1.51f));
		System.out.println("10^3.75 = " + calculator.TenPower(3.75f));
		System.out.println("10^2 = " + calculator.TenPower(2f));
		System.out.println("10^10 = " + calculator.TenPower(10f));
		System.out.println("10^-3 = " + calculator.TenPower(-3f));
		System.out.println("10^-9.99 = " + calculator.TenPower(-9.99f));
		System.out.println("10^-25.3 = " + calculator.TenPower(-25.3f));
		System.out.println("10^-999.99 = " + calculator.TenPower(-999.99f));	//Too small so shows 0.0
		System.out.println("10^999.99 = " + calculator.TenPower(999.99f));	//Too big so shows inf
		System.out.println("10^-0 = " + calculator.TenPower(-0f));
		
		Boolean coshtest = true;
		int testCount = 10000;
		if(func.cosh(0) != 1)
			coshtest = false;
		for(int i = 0; i < testCount; i++){
			double x = 10000 - 20000*Math.random();
			double hcosh = Calculator.cosh(x);
			double fcosh = Math.cosh(x);
			
			if(checkPrecision(hcosh, fcosh)){
				coshtest = false;
				System.out.println("Cosh Fail: " + x + " / " 
						+ Double.toString(hcosh) + " != " + Double.toString(fcosh)); 
			}
		}
		System.out.println("Cosh function with a precision of 10^-10 has passed the test: " + coshtest);

	}
	public static Boolean checkPrecision(double hcosh, double fcosh){
		double prec = 10E-10;
		double dif = hcosh - fcosh;
		if(dif < 0)
			dif = -dif;
		return (dif > prec);
	}

}
