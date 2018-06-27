package cyril.travellingsalesman;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import cyril.commons.Utils;

public class TravellingSalesman {

	public static void main(String[] args) {
		String name = "TravellingSalesman.txt";
		int[][] A = Utils.readMatrix(name);
		Utils.displayMatrix(A);
		Set<Integer> set = new HashSet<Integer>(Arrays.asList(new Integer[] { 0, 1, 2, 3 }));
		set.remove(0);
		int cost = minCost(0, set, A);
		System.out.println("COST : "+cost);

	}

	private static int minCost(int start, Set<Integer> setOfNodes, int[][] A) {
		if (setOfNodes.size() == 1) {
			Integer num = setOfNodes.iterator().next();
			return A[0][num] + A[start][num];
		}
		int minCost = Integer.MAX_VALUE;
		for (int i = 1; i <= 3; i++) {
			HashSet<Integer> newSet = new HashSet<>(setOfNodes);
			if (newSet.contains(i)) {
				newSet.remove(i);
				minCost = Math.min(minCost, minCost(i, newSet, A) + A[i][start]);
			}
		}
		return minCost;

	}

}
