import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;




public class Parser {
	
	ArrayList<Token> words;
	String[] terminals = { "id", "(" , ")" , "+", "-", "*", "/", "integer","double" };
	Stack<String> parseStack = new Stack<String>();
	Stack<Node> semanticStack = new Stack<Node>();
	Stack<String> functionStack = new Stack<String>();
	int id = 0;
	
	Map<String,Map<String,Integer>> syntaxMatrix = new HashMap<>();
	int wordPosition = -1;
	boolean error = false;
	

	Parser(ArrayList<Token> w){
		
		words = w;
		
		// Build Syntax Matrix table
		
		// production E
		Map<String, Integer> E = new HashMap<String, Integer>();
		E.put("+", 1);
		E.put("-", 1);
		E.put("*", 1);
		E.put("/", 1);
		E.put("double", 1);
		E.put("integer", 1);
		E.put("(", 1);
		E.put(")", 15);
		E.put("id", 1);
		E.put("$", 15);
		
		syntaxMatrix.put("E",E);
		
		// production E1
		Map<String, Integer> E1 = new HashMap<String, Integer>();
		E1.put("+", 2);
		E1.put("-", 3);
		E1.put("*", 16);
		E1.put("/", 16);
		E1.put("double", 16);
		E1.put("integer", 16);
		E1.put("(", 16);
		E1.put(")", 4);
		E1.put("id", 16);
		E1.put("$", 4);
		
		syntaxMatrix.put("E1",E1);
		
		// production T
		
		Map<String, Integer> T = new HashMap<String, Integer>();
		T.put("+", 15);
		T.put("-", 15);
		T.put("*", 5);
		T.put("/", 5);
		T.put("double", 5);
		T.put("integer", 5);
		T.put("(", 5);
		T.put(")", 15);
		T.put("id", 5);
		T.put("$", 15);
		
		syntaxMatrix.put("T",T);
		
		// production T1
		
		Map<String, Integer> T1 = new HashMap<String, Integer>();
		T1.put("+", 8);
		T1.put("-", 8);
		T1.put("*", 6);
		T1.put("/", 7);
		T1.put("double", 16);
		T1.put("integer", 16);
		T1.put("(", 16);
		T1.put(")", 8);
		T1.put("id", 16);
		T1.put("$", 8);
		
		syntaxMatrix.put("T1",T1);
		
		
		// production F
		Map<String, Integer> F = new HashMap<String, Integer>();
		F.put("+", 9);
		F.put("-", 9);
		F.put("*", 9);
		F.put("/", 9);
		F.put("double", 10);
		F.put("integer", 11);
		F.put("(", 13);
		F.put(")", 9);
		F.put("id", 12);
		F.put("$", 9);
		
		syntaxMatrix.put("F",F);
		
		// production F
		Map<String, Integer> FN = new HashMap<String, Integer>();
		FN.put("+", 16);
		FN.put("-", 16);
		FN.put("*", 16);
		FN.put("/", 16);
		FN.put("double", 16);
		FN.put("integer", 16);
		FN.put("(", 15);
		FN.put(")", 16);
		FN.put("id", 14);
		FN.put("$", 16);
		
		syntaxMatrix.put("FN",FN);
		
		
	}
	
	
	private String[] syntaxTable(String x, String a) {
		
		int ruleNb = syntaxMatrix.get(x).get(a);
		
		switch(ruleNb) {
		  case 1:
			  	String[] r1 = {"T", "E1"};
		    return r1 ;
		  case 2:
			  	String[] r2 = {"+", "T", "E1","~mf+"};
			    return r2 ;
		  case 3:
			  	String[] r3 = {"-","T", "E1","~mf-"};
			    return r3 ;
	      case 4:
	    	  	String[] r4 = {"EPSILON"};
				return r4 ;
		  case 5:
			  	String[] r5 = {"F", "T1"};
				return r5 ;
		  case 6:
			  	String[] r6 = {"*", "F", "T1" ,"~mf*"};
			    return r6 ;
		  case 7:
				String[] r7 = {"/", "F", "T1","~mf/"};
			    return r7 ;
		  case 8:
			    String[] r8 = {"EPSILON"};
				return r8 ;
		  case 9:
			 	String[] r9 = {"EPSILON"};
				return r9 ;
	      case 10:
			    String[] r10 = { "~mk", "double"};
			    return r10 ;
		  case 11:
				String[] r11 = { "~mk", "integer"};
			    return r11 ;
		  case 12:
				String[] r12 = {"~fn","FN", "(", "E", ")", "~attachF"};
				return r12 ;
		  case 13:
				String[] r13 = {"(", "E", ")"};
			    return r13 ;
		  case 14:
				String[] r14 = {"id"};
				return r14 ;
		  case 15:
				String[] r15 = {"error"};
				return r15 ;
		  case 16:
				String[] r16 = {"error"};
				return r16 ;
		
		  default:
			  String[] error = {"error"};
				return error ;
	
		}
	}
	
	
	
	public Token nextWord() {
		
		wordPosition++;
		
		return words.get(wordPosition);
		
		
		
		
	}
	
	
	public boolean isTerminal(String x) {
		
		for (int i = 0; i < terminals.length; i++) { 
			
			if (terminals[i].equals(x)) {
				return true;
			}
		}
		return false;
	}
	
	
	public void pushRHS(String[] rule) {
	
		for (int i = rule.length - 1; i >= 0 ; i--) { 
					
			parseStack.push(rule[i]);	
			
			}	
	}
	
	public void showParseStack() {
		
		System.out.print("\nParse Stack:");
		
		ArrayList<String> stackTemp = new ArrayList<String>();;
		
		while(!parseStack.empty()) {
			
			stackTemp.add(parseStack.peek());
			parseStack.pop();
			
			}
	
	
		for (int j = stackTemp.size() - 1; j >= 0; j--) {
			
			System.out.print("\t" + stackTemp.get(j));
			parseStack.push(stackTemp.get(j));
			
	    	}
	}
	
	
	public void showSEMStack() {
			
			System.out.print("\nSemantic Stack:");
			
			ArrayList<Node> stackTemp = new ArrayList<Node>();;
			
			while(!semanticStack.empty()) {
				
				stackTemp.add(semanticStack.peek());
				semanticStack.pop();
				
				}
		
			for (int j = stackTemp.size() - 1; j >= 0; j--) {
				
				System.out.print("\t" + stackTemp.get(j));
				semanticStack.push(stackTemp.get(j));
				
		    	}
		}
	
	//checks the contents of the parse stack at the end of parsing
	private void checkParseStackError() {
		
		while(!parseStack.empty()) {
					
					if (isTerminal(parseStack.peek()) || parseStack.peek().equals("T") || parseStack.peek().equals("E")){			
						System.out.print("\nSYNTAX ERROR 4");
						System.exit(0);		
					}
					Token temp = null;
					semanticRecord(parseStack.peek(), temp);
					parseStack.pop();		
				}
		}
	
	
	public Node run_Parser() {
		
		parseStack.push("$");
		parseStack.push("E");
		
		Token a  = nextWord();
		String x = "";
		
	
		
		showParseStack();
		
		while(!parseStack.peek().equals("$") && !a.getLexeme().equals("end")) {
			
			x = parseStack.peek();
			if(semanticRecord(x, a)) {continue;} 
			x = parseStack.peek(); // reset x if semantic action went through
			
			showParseStack();
			System.out.print("\na is -" + a.getLexeme() + "-");
			System.out.print("\nx is -" + x + "-");
			
			if (isTerminal(x)) {
				
				if (x.equals(a.getType())){
					
					parseStack.pop();
					System.out.print("\nConsumed " + a.getLexeme());
					if(parseStack.peek() != "$" && wordPosition < words.size() -1 ){ a = nextWord();}
						
				}else {
					
					error = true;
					System.out.print("\nSYNTAX ERROR 1");
					System.exit(0);
				}
					
			}else{
					
				if (!syntaxTable(x, a.getType())[0].equals("error")) {
				
					parseStack.pop();
					
					if ( syntaxTable(x,a.getType())[0] != "EPSILON") {
						pushRHS(syntaxTable(x,a.getType()));
						
					}			
				}else {
					
					if (wordPosition < words.size() -1 && !backtrack(a,x)) {
					
						error = true;
						System.out.print("\nSYNTAX ERROR 2");
						System.exit(0);
					}
					
					a = nextWord();
				}
			}
		}
		
		
		
		if (!a.getLexeme().equals("end")) { //in case expression is not fully consumed
			
			System.out.print("\nSYNTAX ERROR 3");
			System.exit(0);
			
			
		}
		
		
		checkParseStackError();
		System.out.print("\n\nsuccessfully parsed");
		
		traverse(semanticStack.peek());
		return semanticStack.peek();
		
	}


	
	private boolean backtrack(Token a, String x) {
		
		if (a.getLexeme().equals("-") && x.equals("T")) {
			
			parseStack.pop();
			parseStack.push("T1");
			parseStack.push("~neg");
			parseStack.push("F");
			return true;
		}
		
		return false;
	}


	private void traverse(Node root) {
		
		try {
			
			FileWriter fw = new FileWriter("dotcode.txt", true);
		
			System.out.print("\n\nParent : " + root + " has children ");
			fw.write(root.getID() + "[label = \" " + root.getLexeme() + "(" + root.getType()+ ") \" ] \n ");
			
			
			for (Node child: root.getChildren()) {
				fw.write(root.getID() + "--" + child.getID() + " \n");
				System.out.print("\t" + child);	
				}
			
			fw.close();
			
		}catch(IOException ioe){
		    System.err.println("IOException: " + ioe.getMessage());
		}	
	
		
		for (Node child: root.getChildren()) {
			traverse(child);
			}
		
		
	}


	private boolean semanticRecord(String x, Token a) {
		
		if (x.charAt(0) == '~') {
			
			showSEMStack();
			parseStack.pop();
			
			if(x.equals("~mf*")) { 
				makeFamily("*");
			}
			
			if(x.equals("~mf/")) { 
				makeFamily("/");
			}
			
			if(x.equals("~mf+")) { 
				makeFamily("+");
			}
			
			if(x.equals("~mf-")) { 
				makeFamily("-");
			}
			
			if (x.equals("~mk")) {
				makeNode(a);
			}
			
			if (x.equals("~neg")) {
				inject();
			}
			
			if (x.equals("~fn")) {
				functionStack.push(a.getLexeme());
			}
			
			if (x.equals("~attachF")) {
				attachF();
			}
		
			showSEMStack();
			return true;
		}
		
		return false;
	}


	private void inject() {
		id++;
		Node neg = new Node("neg" ,"function",id);
		
		neg.addChildren(semanticStack.peek());
		
		semanticStack.peek().setParent(neg);
		semanticStack.pop();
		semanticStack.push(neg);
		
	}


	private void attachF() {
			
			id++;
			Node function = new Node(functionStack.peek() ,"function",id);
			
			functionStack.pop();
			function.addChildren(semanticStack.peek());
			
			semanticStack.peek().setParent(function);
			semanticStack.pop();
			semanticStack.push(function);
			
		
	}


	private void makeFamily(String p) {
		
			id++;
			
			Node parent = new Node(p ,"operator", id);
			
			for (int i = 0 ; i < 2 ; i++) {		
				parent.addChildren(semanticStack.peek());
				semanticStack.peek().setParent(parent);
				semanticStack.pop();
			}
			
			semanticStack.push(parent);
			
	}


	public void makeNode(Token a) {
		
		id++;
		
		Node node = new Node(a.getLexeme(), a.getType() ,id);
		
		semanticStack.push(node);
		
	}
	
	
}

