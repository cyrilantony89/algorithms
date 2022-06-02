package cyril.amazon;

import java.util.PriorityQueue;

// you can also use imports, for example:

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

public class AmazonServerPower {

	static class Pair {
		Pair(int a, int b) {
			this.a = a;
			this.b = b;
		}

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "{" + a + ":" + b + "}";
		}

		int a, b;
	}

	static class Data {
		Data(int startIndex, long total, int indexrange) {
			this.startIndex = startIndex;
			this.total = total;
			this.indexrange = indexrange;

		}

		int startIndex, indexrange;
		long total;

	}

	public static void main(String[] args) {

		AmazonServerPower sol = new AmazonServerPower();
		int[] processingPower =  { 1, 1 };
			//{ 6, 6, 7, 1, 1, 1, 1 };
		int[] bootingPower = {40, 1};
			//{ 1, 40, 1, 1, 1, 1, 1 };

		int solution = sol.solutionOnline2(processingPower, bootingPower, 42);
		System.out.println(solution);
	}

	private int solutionOnline2(int[] processingPower, int[] bootingPower, int maxPower) {
		if (processingPower == null || bootingPower == null || processingPower.length == 0
				|| processingPower.length != bootingPower.length) {
			return 0;
		}

		if (bootingPower.length == 1 && processingPower[0] + bootingPower[0] <= maxPower) {
			return 1;
		}

		int ct = bootingPower.length;
		int windowStart = 0;
		int maxBootingPower = bootingPower[0];
		int maxProcessingPower = processingPower[0];
		int cluster = 0;
		int mCluster = 0;
		for (int windowEnd = 0; windowEnd < ct; windowEnd++) {
			maxBootingPower = Math.max(maxBootingPower, bootingPower[windowEnd]);
			maxProcessingPower += processingPower[windowEnd];
			int netPower = maxBootingPower + (maxProcessingPower) * cluster;
			cluster++;
			if (netPower > maxPower) {
				maxBootingPower -= bootingPower[windowStart];
				maxProcessingPower -= processingPower[windowStart];
				cluster--;
				windowStart++;
			}
			mCluster = Math.max(mCluster, cluster);
		}

		return mCluster;
	}

	public int solution(int[] processingPower, int[] bootingPower, long maxPower) {

		int start = 0;
		int maxlength = 0;
		int currentSumProcessingPower = 0;
		// O(n)
		for (int i = 0; i < processingPower.length; i++) {
			currentSumProcessingPower += processingPower[i];
			// O(n)
			long currentPower = maxbootingPower(bootingPower, start, i) + currentSumProcessingPower * (i - (start - 1));

			// if current i can be included in subArray
			if (currentPower <= maxPower) {
				maxlength = Math.max(maxlength, i - start + 1);
				continue;
			}

			// slide the window till sum comes within maxPower
			// O(n)
			while (maxbootingPower(bootingPower, start, i) + currentSumProcessingPower * (i - (start - 1)) > maxPower) {
				currentSumProcessingPower -= processingPower[start];
				start++;
			}
			// Now, subArray may be empty if start slide over current i
			if (start > i) {
				currentSumProcessingPower = 0;
			}

		}

		return maxlength;

	}

	/**
	 * https://leetcode.com/discuss/interview-question/1636493/amazon-online-assessment-questions
	 * idea here is to never decrease the size of window as we're looking for max
	 * length. If the elements in current window doesn't satisfy the condition, we
	 * just move window to next.
	 * 
	 * 
	 * 
	 * @param processingPower
	 * @param bootingPower
	 * @param maxPower
	 * @return
	 */
	public int solutionOnline(int[] processingPower, int[] bootingPower, int maxPower) {
		if (processingPower == null || bootingPower == null || processingPower.length == 0
				|| processingPower.length != bootingPower.length) {
			return 0;
		}

		PriorityQueue<Integer> maxBootingPower = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
		int maxlength = 0;
		int currentlength = 1;

		int start = 0;
		int end = 0;

		int currentSumProcessingPower = processingPower[0];
		maxBootingPower.add(bootingPower[0]);
		while (end < processingPower.length) {
			int currentBootingPower = maxBootingPower.peek();
			int currentPower = currentBootingPower + currentSumProcessingPower * currentlength;
			System.out.println("current :" + currentPower);
			if (currentPower <= maxPower) {
				maxlength = currentlength;
				System.out.println("maxlength :" + maxlength);
				System.out.println("end :" + end);
				end++;
				currentlength++;
			} else {
				currentSumProcessingPower -= processingPower[start];
				// O(n)
				maxBootingPower.remove(bootingPower[start]);
				start++;
				end++;
			}

			if (end < processingPower.length) {
				maxBootingPower.add(bootingPower[end]);
				currentSumProcessingPower += processingPower[end];
			}
		}

		return maxlength;
	}

	// O (n)
	private int maxbootingPower(int[] bootingPower, int start, int i) {
		int max = Integer.MIN_VALUE;
		for (int j = start; j <= i; j++) {
			max = Math.max(max, bootingPower[j]);

		}
		return max;
	}

}
