public class Test {

    public static boolean CheckTenPower(float exponent){
        double x = Calculator.TenPower(exponent);
        double y = Math.pow(10, exponent);

        System.out.println("Calculator.TenPower: " + x + "\tMath.pow: " + y);

        if (x == y)
            return true;

        return false;
    }
}
