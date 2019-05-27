
public class Calculator {


//-------------- FUNCTIONS ----------------
	
	// Exponent (e^x)
	public float exponent(int n, float x){
			
		float result = 1;
		
		for (int i = 0 ; i < n ; ++i) {
			 result =  1 + x/(n-i) * result ;
			}
		
		return result;
	}
		
	

}
