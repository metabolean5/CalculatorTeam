public class Test {
	
	public static void TestCosh(){
	Boolean coshtest = true;
	int testCount = 10000;
	if(Calculator.Cosh(0) != 1)
		coshtest = false;
	for(int i = 0; i < testCount; i++){
		double x = 10000 - 20000*Math.random();
		double hcosh = Calculator.Cosh(x);
		double fcosh = Math.cosh(x);
			
		if(CheckPrecision(hcosh, fcosh)){
			coshtest = false;
			System.out.println("Cosh Fail: " + x + " / " 
						+ Double.toString(hcosh) + " != " + Double.toString(fcosh)); 
			}
		}
	System.out.println("Cosh function with a precision of 10^-10 has passed the test: " + coshtest);
	}
	public static Boolean CheckPrecision(double hcosh, double fcosh){
		double prec = 10E-10;
		double dif = hcosh - fcosh;
		if(dif < 0)
			dif = -dif;
		return (dif > prec);
	}
}


