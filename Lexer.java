/*
 * Lexer
 * 
 * version 1
 * 
 * August 3, 2019 
 * 
 * Copyright © 2019 Sabrina Kim, Martial Pastor, Keven Presseau-St-Laurent, Marco Tropiano, Diana Zitting-Rioux. All rights reserved.
 */

import java.util.*;  

/**
 * Lexer for the parser
 * 
 * @version 1
 * @author Martial Pastor
 *
 */


public class Lexer {
	
	// instance vars
	
	String expression;
	int currState;
	int charPosition = -1;
	int exprSize;
	int nbOfTokens = 0;
	ArrayList<Token> tokens = new ArrayList<>();
	ArrayList<Map<String , Integer>> fsmTable = new ArrayList<>();
	boolean EOF = false;
	
	// methods
	
	public Lexer(String expr) {
		
		// pre-computations on expression string
		expression = expr;
		exprSize = expression.length();
		
	
		
		// BUILD FSM TABLE
		
		// for state 0
		
		Map<String, Integer> s0 = new HashMap<String, Integer>();
		s0.put("final", 0);
		s0.put("backtrack", 0);
		s0.put("(", 1);
		s0.put(")", 2);
		s0.put("+", 6);
		s0.put("-", 5);
		s0.put("/", 11);
		s0.put("*", 9);
		s0.put("nz", 13);
		s0.put(".", 19);
		s0.put("0", 17);
		s0.put("letter", 20);
		
		
		fsmTable.add(0,s0);
		
	
		// for state 1
		
		Map<String, Integer> s1 = new HashMap<String, Integer>();
		s1.put("final", 0);
		s1.put("backtrack", 0);
		s1.put("(", 3);
		s1.put(")", 3);
		s1.put("+", 3);
		s1.put("-", 3);
		s1.put("/", 3);
		s1.put("*", 3);
		s1.put("nz",3);
		s1.put(".", 3);
		s1.put("0", 3);
		s1.put("letter", 3);
		
		fsmTable.add(1,s1);
		
		// for state 2
	
		Map<String, Integer> s2 = new HashMap<String, Integer>();
		s2.put("final", 0);
		s2.put("backtrack", 0);
		s2.put("(", 4);
		s2.put(")", 4);
		s2.put("+", 4);
		s2.put("-", 4);
		s2.put("/", 4);
		s2.put("*", 4);
		s2.put("nz",4);
		s2.put(".", 4);
		s2.put("0", 4);
		s2.put("letter", 4);
		
		fsmTable.add(2,s2);
		
		// for state 3
		
		Map<String, Integer> s3 = new HashMap<String, Integer>();
		s3.put("final", 1);
		s3.put("backtrack", 1);
		s3.put("(", 0);
		s3.put(")", 0);
		s3.put("+", 0);
		s3.put("-", 0);
		s3.put("/", 0);
		s3.put("*", 0);
		s3.put("nz",0);
		s3.put(".", 0);
		s3.put("0", 0);
		s3.put("letter", 0);
			
		fsmTable.add(3,s3);
		

		// for state 4
		
		Map<String, Integer> s4 = new HashMap<String, Integer>();
		s4.put("final", 1);
		s4.put("backtrack", 1);
		s4.put("(", 0);
		s4.put(")", 0);
		s4.put("+", 0);
		s4.put("-", 0);
		s4.put("/", 0);
		s4.put("*", 0);
		s4.put("nz",0);
		s4.put(".", 0);
		s4.put("0", 0);
		s4.put("letter", 0);
			
		fsmTable.add(4,s4);
		
		
		// for state 5

		Map<String, Integer> s5 = new HashMap<String, Integer>();
		s5.put("final", 0);
		s5.put("backtrack", 0);
		s5.put("(", 7);
		s5.put(")", 7);
		s5.put("+", 7);
		s5.put("-", 7);
		s5.put("/", 7);
		s5.put("*", 7);
		s5.put("nz",7);
		s5.put(".", 7);
		s5.put("0", 7);
		s5.put("letter", 7);

		fsmTable.add(5,s5);
		
		// for state 6
		
		Map<String, Integer> s6 = new HashMap<String, Integer>();
		s6.put("final", 0);
		s6.put("backtrack", 0);
		s6.put("(", 8);
		s6.put(")", 8);
		s6.put("+", 8);
		s6.put("-", 8);
		s6.put("/", 8);
		s6.put("*", 8);
		s6.put("nz",8);
		s6.put(".", 8);
		s6.put("0", 8);
		s6.put("letter", 8);
		
		fsmTable.add(6,s6);
		
		// for state 7

		Map<String, Integer> s7 = new HashMap<String, Integer>();
		s7.put("final", 1);
		s7.put("backtrack", 1);
		s7.put("(", 0);
		s7.put(")", 0);
		s7.put("+", 0);
		s7.put("-", 0);
		s7.put("/", 0);
		s7.put("*", 0);
		s7.put("nz",0);
		s7.put(".", 0);
		s7.put("0", 0);
		s7.put("letter", 0);
		
		fsmTable.add(7,s7);
	
		// for state 8
		
		Map<String, Integer> s8 = new HashMap<String, Integer>();
		s8.put("final", 1);
		s8.put("backtrack", 1);
		s8.put("(", 0);
		s8.put(")", 0);
		s8.put("+", 0);
		s8.put("-", 0);
		s8.put("/", 0);
		s8.put("*", 0);
		s8.put("nz",0);
		s8.put(".", 0);
		s8.put("0", 0);
		s8.put("letter", 0);
		
		fsmTable.add(8,s8);
		
		// for state 9

		Map<String, Integer> s9 = new HashMap<String, Integer>();
		s9.put("final", 0);
		s9.put("backtrack", 0);
		s9.put("(", 10);
		s9.put(")", 10);
		s9.put("+", 10);
		s9.put("-", 10);
		s9.put("/", 10);
		s9.put("*", 10);
		s9.put("nz",10);
		s9.put(".", 10);
		s9.put("0", 10);
		s9.put("letter", 10);
		
		fsmTable.add(9,s9);
		
		// for state 10

		Map<String, Integer> s10 = new HashMap<String, Integer>();
		s10.put("final", 1);
		s10.put("backtrack", 1);
		s10.put("(", 0);
		s10.put(")", 0);
		s10.put("+", 0);
		s10.put("-", 0);
		s10.put("/", 0);
		s10.put("*", 0);
		s10.put("nz",0);
		s10.put(".", 0);
		s10.put("0", 0);
		s10.put("letter", 0);
		
		fsmTable.add(10,s10);

		// for state 11
		
		Map<String, Integer> s11 = new HashMap<String, Integer>();
		s11.put("final", 0);
		s11.put("backtrack", 0);
		s11.put("(", 12);
		s11.put(")", 12);
		s11.put("+", 12);
		s11.put("-", 12);
		s11.put("/", 12);
		s11.put("*", 12);
		s11.put("nz",12);
		s11.put(".", 12);
		s11.put("0", 12);
		s11.put("letter", 12);
		
		fsmTable.add(11,s11);
		
		// for state 12

		Map<String, Integer> s12 = new HashMap<String, Integer>();
		s12.put("final", 1);
		s12.put("backtrack", 1);
		s12.put("(", 0);
		s12.put(")", 0);
		s12.put("+", 0);
		s12.put("-", 0);
		s12.put("/", 0);
		s12.put("*", 0);
		s12.put("nz",0);
		s12.put(".", 0);
		s12.put("0", 0);
		s12.put("letter", 0);
		
		fsmTable.add(12,s12);
		
		// for state 13

		Map<String, Integer> s13 = new HashMap<String, Integer>();
		s13.put("final", 0);
		s13.put("backtrack", 0);
		s13.put("(", 18);
		s13.put(")", 18);
		s13.put("+", 18);
		s13.put("-", 18);
		s13.put("/", 18);
		s13.put("*", 18);
		s13.put("nz",13);
		s13.put(".", 14);
		s13.put("0", 13);
		s13.put("letter", 18);
		
		fsmTable.add(13,s13);
		
		// for state 14

		Map<String, Integer> s14 = new HashMap<String, Integer>();
		s14.put("final", 0);
		s14.put("backtrack", 0);
		s14.put("(", 19);
		s14.put(")", 19);
		s14.put("+", 19);
		s14.put("-", 19);
		s14.put("/", 19);
		s14.put("*", 19);
		s14.put("nz",15);
		s14.put(".", 19);
		s14.put("0", 15);
		s14.put("letter", 19);
		
		fsmTable.add(14,s14);
		
		// for state 15
		
		Map<String, Integer> s15 = new HashMap<String, Integer>();
		s15.put("final", 0);
		s15.put("backtrack", 0);
		s15.put("(", 16);
		s15.put(")", 16);
		s15.put("+", 16);
		s15.put("-", 16);
		s15.put("/", 16);
		s15.put("*", 16);
		s15.put("nz",15);
		s15.put(".", 16);
		s15.put("0", 15);
		s15.put("letter", 16);
		
		fsmTable.add(15,s15);
		
		// for state 16

		Map<String, Integer> s16 = new HashMap<String, Integer>();
		s16.put("final", 1);
		s16.put("backtrack", 1);
		s16.put("(", 0);
		s16.put(")", 0);
		s16.put("+", 0);
		s16.put("-", 0);
		s16.put("/", 0);
		s16.put("*", 0);
		s16.put("nz",0);
		s16.put(".", 0);
		s16.put("0", 0);
		s16.put("letter", 0);
		
		fsmTable.add(16,s16);
	
		// for state 17

		Map<String, Integer> s17 = new HashMap<String, Integer>();
		s17.put("final", 0);
		s17.put("backtrack", 0);
		s17.put("(", 18);
		s17.put(")", 18);
		s17.put("+", 18);
		s17.put("-", 18);
		s17.put("/", 18);
		s17.put("*", 18);
		s17.put("nz",18);
		s17.put(".", 14);
		s17.put("0", 18);
		s17.put("letter", 18);
		
		fsmTable.add(17,s17);
		
		// for state 18
		
		Map<String, Integer> s18 = new HashMap<String, Integer>();
		s18.put("final", 1);
		s18.put("backtrack", 1);
		s18.put("(", 0);
		s18.put(")", 0);
		s18.put("+", 0);
		s18.put("-", 0);
		s18.put("/", 0);
		s18.put("*", 0);
		s18.put("nz",0);
		s18.put(".", 0);
		s18.put("0", 0);
		s18.put("letter", 0);
		
		fsmTable.add(18,s18);
		
		// for state 19
		
		Map<String, Integer> s19 = new HashMap<String, Integer>();
		s19.put("final", 1);
		s19.put("backtrack", 1);
		s19.put("(", 0);
		s19.put(")", 0);
		s19.put("+", 0);
		s19.put("-", 0);
		s19.put("/", 0);
		s19.put("*", 0);
		s19.put("nz",0);
		s19.put(".", 0);
		s19.put("0", 0);
		s19.put("letter", 0);
		
		fsmTable.add(19,s19);
		
		// for state 20
		
		Map<String, Integer> s20 = new HashMap<String, Integer>();
		s20.put("final", 0);
		s20.put("backtrack", 0);
		s20.put("(", 21);
		s20.put(")", 21);
		s20.put("+", 21);
		s20.put("-", 21);
		s20.put("/", 21);
		s20.put("*", 21);
		s20.put("nz",21);
		s20.put(".", 21);
		s20.put("0", 21);
		s20.put("letter", 20);
		
		fsmTable.add(20,s20);
		
		// for state 21
		
		Map<String, Integer> s21 = new HashMap<String, Integer>();
		s21.put("final", 1);
		s21.put("backtrack", 1);
		s21.put("(", 0);
		s21.put(")", 0);
		s21.put("+", 0);
		s21.put("-", 0);
		s21.put("/", 0);
		s21.put("*", 0);
		s21.put("nz",0);
		s21.put(".", 0);
		s21.put("0", 0);
		s21.put("letter", 0);
		
		fsmTable.add(21,s21);
		
	}
	
	/**
	 * Next char
	 * @return next
	 */
	public String nextChar() {
		
		charPosition++;
		return String.valueOf(expression.charAt(charPosition));
	}
	
	/**
	 * Set key
	 * @param next
	 * @return next
	 */
	public String setKey(String next) {
		
		if (next.matches("[a-zA-Z]+")){return "letter";}
		if (next.matches("[1-9]")) {return "nz";}
		return next;
	}
	
	
	
	/**
	 * Next token
	 * @return token
	 */
	public Token nextToken() {
		
		Token token = new Token();
		currState = 0;
		
		
		System.out.print("\n-->ROOT");
		
		boolean tokenFound =  false;
		while(!tokenFound) {
			
			
			String next = nextChar();
			String nextCharKey = setKey(next);
			
			System.out.print("(" + nextCharKey + ")" );
			
			
			if (next.equals("~")) { System.out.print(token.getLexeme()+ "<1>");tokenFound = true; EOF = true;break;}
			
			currState = fsmTable.get(currState).get(nextCharKey); //Transition to next state
			System.out.print("-->" + currState );
			
			if (fsmTable.get(currState).get("final") == 1) { // if state is final state
				
				tokenFound = true;
				token.setType(currState);
				
				if(fsmTable.get(currState).get("backtrack") == 1) { charPosition--;}
				
			}else {
				
				token.concatLex(next);
				
			}
		}
		
		token.setID(nbOfTokens);
		nbOfTokens++;
		return token;
	}
	
	
	/**
	 * Run lexer
	 */
	public void runLexer() {
		
		while(!EOF) {
			
			tokens.add(nextToken());
			
		}		
	}
	
	/**
	 * Print token stream
	 */
	public void printTokenStream() {
		
		
		System.out.print("\n\nTOKEN STREAM:");
		
		for(Token token : tokens) {
			
			System.out.print("\n" + token.getLexeme());
			
			
		}
		
		
	}
	
	/**
	 * Get token stream
	 * @return tokens
	 */
	public ArrayList<Token> getTokenStream() {
		
		//tokens.remove(tokens.size() -1 );
		return tokens;
		
	}
	
	
	
	
	

}
