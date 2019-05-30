
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

	}

}
