package cyril.skyflow;

public class AirTravel {
	private static int permitted;

	/**
	 * You are given a list of flights in format [fromCity, toCity, price] Eg:
	 * [["Delhi", "Bangalore", 3500], ["Bangalore", "Mumbai", 4500], ["Delhi",
	 * "Mumbai", 9000]] You are given your source and destination cities and a max
	 * stops "x" which you can take in between. Return the cheapest possible travel
	 * price.
	 * 
	 * 
	 */

	public static void main(String[] args) {

		// 0 : Delhi
		// 1 : Bangalore
		// 2 : Mumbai
		//

		int[][] costarr = new int[3][2];

		costarr[0][1] = 3500;
		costarr[0][1] = 3500;

		int maxstops = 2;
		int amount = findcost(maxstops, costarr, 0, 2, 0);
	}

	private static int[] findneighbors(int node) {
		return null;
	}

	private static int findcost(int maxstops, int[][] costarr, int source, int destination, int hop) {
		int cost = costarr[source][destination];
		if (hop > permitted) {
			return Integer.MAX_VALUE;
		}

		int[] neighbors = findneighbors(source);
		for (int i : neighbors) {
			cost = Math.min(cost, findcost(maxstops, costarr, source, neighbors[i], hop + 1)
					+ findcost(maxstops, costarr, neighbors[i], destination, hop + 1));

		}
		return cost;

	}
}
