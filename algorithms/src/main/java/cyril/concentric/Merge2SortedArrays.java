package cyril.concentric;
public class Merge2SortedArrays {

	/**
	 * 2 sorted array to 1
	 *
	 * @param args
	 */

	public static void main(String[] args) {

		int[] a1 = new int[] {  1 , 3 , 5 };
		int[] a2 = new int[] {   2 , 4 , 6 };

		int[] sort = sort(a1, a2);
		for (int i : sort) {
			System.out.println(i);

		}

	}

	private static int[] sort(int[] a1, int[] a2) {
		int[] res = new int[a1.length + a2.length];

		int i1 = 0;
		int i2 = 0;
		int ires = 0;

		while (i1 < a1.length && i2 < a2.length) {

			if (a1[i1] < a2[i2]) {
				res[ires++] = a1[i1++];
			} else {
				res[ires++] = a2[i2++];
			}
		}
		while (i1 < a1.length) {
			res[ires++] = a1[i1++];

		}
		while (i2 < a2.length) {
			res[ires++] = a2[i2++];
		}

		return res;

	}

}
