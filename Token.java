
public class Token {
	
	// instance var
	String word;
	String lexeme = "";
	String type;
	int id;
	
	public void setID(int i) {
		id = i;
	}
	
	public int getID() {
		return id;
	}
	
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
	
	public void concatLex(String next) {
		lexeme += next;
	}
	
	public String getLexeme() {
		return lexeme;
	}
	
	public String getType() {
		return type;
	}
	
}

