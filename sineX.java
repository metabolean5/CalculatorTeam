package Comp354;

public class sineX {
    final static double PICONST = 3.141592653589793238462643383279502884197169399375105820974944592307816406286;

    public static double positiveExpPower(double base, double exp){
        double result = base;
        for(int i = 1; i < exp; i++){
            result *= base;
        }
        return result;
    }

    public static double factorial(double inp){
        double result = 1;
        for(double start = inp; start >= 1; start--){
            result *= start;
        }
        return result;
    }

    //radian calculation
    public static double sine(double inp){

        double inpMod = inp % (2.0*PICONST);
        double result = inpMod;

        for(int j = 3; j < 150; j+=4){
            result -= (positiveExpPower(inpMod, j)/factorial(j));
            result += (positiveExpPower(inpMod, j+2)/factorial(j+2));
        }

        return result;
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

    public static double degToRad(double inp){
        return inp * PICONST / 180.0;
    }

    public static void main(String[] args) {
        System.out.println(positiveExpPower(2, 3));
        System.out.println(factorial(4));
        System.out.println(sine(-150));
        //System.out.println(getPi());
        //System.out.println(PICONST);
        System.out.println(degToRad(720));
        //System.out.println((9%(2.0*PICONST)));
    }
}
