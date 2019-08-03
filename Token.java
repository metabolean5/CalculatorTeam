/*
 * Token
 * 
 * version 1
 * 
 * August 3, 2019 
 * 
 * Copyright © 2019 Sabrina Kim, Martial Pastor, Keven Presseau-St-Laurent, Marco Tropiano, Diana Zitting-Rioux. All rights reserved.
 */

/**
 * Token class for parser
 * 
 * @version 1
 * @author Martial Pastor
 *
 */
public class Token {
	
	// instance var
	String word;
	String lexeme = "";
	String type;
	int id;
	
	/**
	 * set id
	 * @param i
	 */
	public void setID(int i) {
		id = i;
	}
	
	/**
	 * Get ID
	 * @return id
	 */
	public int getID() {
		return id;
	}
	
	/**
	 * Set type
	 * @param state
	 */
	public void setType(int state) {
		
		if (state == 3) { type = "(";}
		if (state == 4) { type = ")";}
		if (state == 7) { type = "-";}
		if (state == 8) { type = "+";}
		if (state == 10) { type = "*";}
		if (state == 12) { type = "/";}
		if (state == 16) { type = "double";}
		if (state == 18) { type = "integer";}
		if (state == 19) { type = "Error";}
		if (state == 21) { type = "id";}
		
		System.out.print("--" + type + "--");
		
	}
	
	/**
	 * concatenate lex
	 * @param next
	 */
	public void concatLex(String next) {
		lexeme += next;
	}
	
	/**
	 * Get Lexeme
	 * @return lexeme
	 */
	public String getLexeme() {
		return lexeme;
	}
	
	/**
	 * Get type
	 * @return type
	 */
	public String getType() {
		return type;
	}
	
}

