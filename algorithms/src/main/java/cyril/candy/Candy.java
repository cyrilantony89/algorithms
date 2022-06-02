package cyril.candy;

public class Candy {

	public static void main(String[] args) {
		
		int c1 = 2;
		int c2 = 5;
		int n  = 10;
		
		long findMinCost = findMinCost(c1, c2, n);
		System.out.println(findMinCost);
		
		
	}

	private static long findMinCost(int c1, int c2, int n) {
		long min = Long.MAX_VALUE;
		
		for (int i = 0; i <= n; i++) {
			min = (long) Math.min(min, c1* Math.pow(i, 2) + c2* Math.pow(n-i, 2) );
		}
		
		return min;
	}
}
