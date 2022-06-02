package cyril.sort;

public class MatrixRowNColSorted {

	public static void main(String[] args) {

		int[][] mat = {
				//
				{ 10, 20, 30, 40 },
				//
				{ 15, 25, 37, 45 },
				//
				{ 27, 29, 38, 48 },
				//
				{ 32, 33, 39, 50 }
				//
		};

		int key = 10;

		int rowInd = 0;
		int colInd = mat[0].length - 1;

		while (indexIsValid(rowInd, colInd, mat)) {
			if (mat[rowInd][colInd] == key) {
				System.out.println(mat[rowInd][colInd]);
				return;
			}

			if (mat[rowInd][colInd] < key) {
				rowInd++;
			}
			if (mat[rowInd][colInd] > key) {
				colInd--;
			}
		}

	}

	private static boolean indexIsValid(int i, int j, int[][] mat) {
		return i <= mat.length - 1 && j >= 0;
	}

	/**
	 * public class MyMap {
	 * 
	 * public static void main(String []args) {
	 * 
	 * int[][] mat = {{10,20,30,40},{15, 25, 35, 45},{27, 37, 37, 48},{31, 33, 39,
	 * 50}}; System.out.println(find(mat, 33));
	 * 
	 * }
	 * 
	 * private static String find(int[][] mat, int x) { int n = mat.length, i = 0;
	 * for(int j=n-1;j>=0;j--) { while(i<n && mat[i][j] <= x) { if(mat[i][j] == x) {
	 * return i+", "+j; } i++; } } return "-1, -1"; }
	 * 
	 * }
	 */
}
