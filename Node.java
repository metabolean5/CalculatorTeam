import java.util.ArrayList;

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
	
	public int getID() {
		return id;
	}
	
	public String getLexeme() {
		return lexeme;
	}
	public String getType() {
		return type;
	}

	public void setParent(Node p){
		parent = p ;
	}
	
	public void addChildren(Node child) {
		children.add(child);
	}
	
	public String toString() {
		
		return type + "[" + lexeme + "]";
		
	}
	
	public ArrayList<Node> getChildren(){
		return children;
	}

}
