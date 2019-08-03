/*
 * Visitor
 * 
 * version 1
 * 
 * August 3, 2019 
 * 
 * Copyright © 2019 Sabrina Kim, Martial Pastor, Keven Presseau-St-Laurent, Marco Tropiano, Diana Zitting-Rioux. All rights reserved.
 */

import java.util.Stack;

/**
 * Visitor class for parser
 * 
 * @version 1
 * @author Martial Pastor
 *
 */

public class Visitor {

	Node astRoot;
	Stack<Float> fValues = new Stack<Float>();
	String CURFNAME;
	
	public Visitor(Node ast) {
	
		astRoot = ast;
	}
	
	/**
	 * Calculate
	 * @return float
	 */
	public float calculate() {
		computeExpr(astRoot);
		return fValues.peek();
	}
	
	/**
	 * Computer expression
	 * @param a
	 */
	public void computeExpr(Node a) {
		
		for (Node node: a.getChildren()) { // preorder traversal
			computeExpr(node);
		}
		
		if (a.getType().equals("integer") || a.getType().equals("double")) {
			
			float f = Float.parseFloat(a.getLexeme());
			fValues.push(f);
		}
		
		if(a.getType().equals("function")) {
			
			CURFNAME = a.getLexeme();
			float result = applyFunction(fValues.peek());
			fValues.pop();
			fValues.push(result);

		}
		
		if(a.getType().equals("operator")) {
		
			float v1 = fValues.peek();
			fValues.pop();
			float v2 = fValues.peek();
			fValues.pop();
			
			if (a.getLexeme().equals("*")) {
				fValues.push(v1*v2);
			}
			
			if (a.getLexeme().equals("/")) {
				fValues.push(v1/v2);
			}
			
			if (a.getLexeme().equals("+")) {
				fValues.push(v1+v2);
			}
			
			if (a.getLexeme().equals("-")) {
				fValues.push(v1-v2);
			}
		}
	}

	/**
	 * Apply function
	 * @param val
	 * @return function
	 */
	private float applyFunction(float val) {
		

		switch (CURFNAME) {
        case "exp":
        	return (float) Calculator.calculateExponent(10, val);
        case "cosh":
        	return (float)  Calculator.calculateCosh(val);
        case "pow":
        	return Calculator.calculateTenPower(val);
        case "sqrt":
        	return (float) Calculator.calculateSquareRoot(val);
        case "sin":
        	return (float) Calculator.calculateSine(val);
        case "neg":
        	return (float) -val;
		}
		System.out.println("\n\n INVALID INPUT: " + CURFNAME);
		System.exit(0);
		return 0;
	}
}
































