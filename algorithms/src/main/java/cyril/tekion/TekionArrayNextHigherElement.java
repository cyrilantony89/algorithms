package cyril.tekion;
import java.util.Stack;

public class TekionArrayNextHigherElement {

	
	/**
	 * 
	 * int[]  arr;
	 * next higher element to the right.
	 * 
	 * arr = [ 3 7 3 9 10 2 4 ]
	 * 
	 * 
	 * 
	 *  3 
	 *  
	 *  7th index - pop-count = 1-1 = 0 
	 *  
	 *  
	 *  3
	 *  7
	 *  
	 *  
	 *  9   3rd index 
	 *  
	 *  
	 *  4
	 *  10
	 *  
	 *  
	 *  2 
	 *   
	 * 
	 * arr = [ 7 , 9, 9, 10 , 4 , -1 ]
	 * 
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		int [] arr = { 1,2, 3, 4, 5, 6, 7, 8,  7, 6, 5, 4 , 3, 2};
		
		int [] res = new int[arr.length];
		
		for (int i = 0; i < res.length; i++) {
			res[i] = -1;
			
		}
		
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < arr.length; i++) {
			
			int prec = 0;
			while(!stack.isEmpty() && stack.peek()< arr[i]) {
				
				stack.pop();
				prec++;
				res[i-prec] = arr[i];
			}
			
			stack.push( arr[i]);
			
		}
		
		
		for (int i = 0; i < res.length; i++) {
			System.out.println(res[i]);
			
		}
		
		
		
	}

}
