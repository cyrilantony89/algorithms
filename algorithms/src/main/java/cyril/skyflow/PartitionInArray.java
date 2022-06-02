package cyril.skyflow;

import cyril.commons.Utils;

public class PartitionInArray {
	public static void main(String[] args) {
		int[] a = { 4, 5, 6, 7, 1, 2, 3, 4, 7, 8, 9, 10, 8, 11, 15, 16, 17, 12 };
		int[] b = new int[a.length];
		int[] c = new int[a.length];

		int leftMax = Integer.MIN_VALUE;
		int rightMin = Integer.MAX_VALUE;
		for (int i = 0; i < a.length; i++) {
			if (i != 0) {
				leftMax = Math.max(leftMax, a[i - 1]);
				rightMin = Math.min(rightMin, a[(a.length) - i]);
			}
			b[i] = leftMax;
			c[(a.length - 1) - i] = rightMin;
		}

		Utils.displayArray(a);
		Utils.displayArray(b);
		Utils.displayArray(c);

		for (int i = 0; i < a.length; i++) {
			if (b[i] < a[i] && c[i] > a[i])
				System.out.println("Found " + a[i]);
		}
	}

}
