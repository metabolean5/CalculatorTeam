import java.util.ArrayList;

public class ExpressionParser {

	
	
	public static float calculate(String expr) {
		
		if(expr.equals("exit")) {
			System.exit(0);
		}
		
		expr = expr.replace(" ", "");
		expr += "end~";
		
		//lexical analysis
		Lexer lexer = new Lexer(expr); 
		lexer.runLexer();
		ArrayList<Token> tokenStream = lexer.getTokenStream();
		lexer.printTokenStream();
		
		
		//syntax analysis
		
		//System.out.print("\n\nSYNTAX ANALYSIS");
		Parser parser = new Parser(tokenStream);
		Node ast = parser.run_Parser();
		
		//Semantic actions and expression computing
		Visitor visitor = new Visitor(ast);
		
		return  visitor.calculate();
		
	}
	
	
	
	
}
