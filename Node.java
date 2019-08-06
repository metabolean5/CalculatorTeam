
/*
 * Calculator
 * 
 * version 1
 * 
 * August 3, 2019 
 * 
 * Copyright © 2019 Sabrina Kim, Martial Pastor, Keven Presseau-St-Laurent, Marco Tropiano, Diana Zitting-Rioux. All rights reserved.
 */

import java.util.ArrayList;

/**
 * Node class for the parser
 * 
 * @version 1
 * @author Martial Pastor
 *
 */
public class Node {
	
	String lexeme;
	String type;
	Node parent;
	ArrayList<Node> children = new ArrayList<Node>();
	int id;
	
	Node(String l, String t, int i){
		
		lexeme = l;
		type = t;
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
	 * Get lexeme
	 * @return lexeme
	 */
	public String getLexeme() {
		return lexeme;
	}
	
	/**
	 * get Type
	 * @return type
	 */
	public String getType() {
		return type;
	}
	
	/**
	 * Set parents
	 * @param p
	 */
	public void setParent(Node p){
		parent = p ;
	}
	
	/**
	 * Add children
	 * @param child
	 */
	public void addChildren(Node child) {
		children.add(child);
	}
	
	/**
	 * To string
	 */
	public String toString() {
		
		return type + "[" + lexeme + "]";
		
	}
	
	/**
	 * Get children
	 * @return
	 */
	public ArrayList<Node> getChildren(){
		return children;
	}

}

