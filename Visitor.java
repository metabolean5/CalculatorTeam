import java.util.Stack;

public class Visitor {

	Node astRoot;
	Stack<Float> fValues = new Stack<Float>();
	String CURFNAME;
	
	
	public Visitor(Node ast) {
	
		astRoot = ast;
	}
	
	public float calculate() {
		computeExpr(astRoot);
		return fValues.peek();
	}
	
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

	private float applyFunction(float val) {
		

		switch (CURFNAME) {
        case "exp":
        	return (float) Calculator.Exponent(10, val);
        case "cosh":
        	return (float)  Calculator.Cosh(val);
        case "pow":
        	return Calculator.TenPower(val);
        case "sqrt":
        	return (float) Calculator.Sqrt(val);
        case "sin":
        	return (float) Calculator.Sine(val);
        case "neg":
        	return (float) -val;
		}
		System.out.println("\n\n INVALID INPUT: " + CURFNAME);
		System.exit(0);
		return 0;
	}


}
































