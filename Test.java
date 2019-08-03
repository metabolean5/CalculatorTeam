/*
 * Test
 * 
 * version 1
 * 
 * August 3, 2019 
 * 
 * Copyright © 2019 Sabrina Kim, Martial Pastor, Keven Presseau-St-Laurent, Marco Tropiano, Diana Zitting-Rioux.
 * All rights reserved.
 */

/**
 * Tests the ten power
 * 
 * @version 1
 * @author Sabrina Kim, Martial Pastor, Keven Presseau-St-Laurent, Marco Tropiano, Diana Zitting-Rioux
 *
 */

public class Test {

    public static boolean CheckTenPower(float exponent){
        double x = Calculator.calculateTenPower(exponent);
        double y = Math.pow(10, exponent);

        System.out.println("Calculator.TenPower: " + x + "\tMath.pow: " + y);

        if (x == y)
            return true;

        return false;
    }
}
