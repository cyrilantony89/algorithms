package cyril.commons;

import java.util.Scanner;

import cyril.travellingsalesman.TravellingSalesman;

public class Utils {

	public static void displayMatrix(int[][] a) {
		int length = a.length;
		System.out.println("LENGTH :" + length);
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++) {
				System.out.print(a[i][j] + "\t");
			}
			System.out.println("");
		}
	}

	public static int[][] readMatrix(String fileName) {
		Scanner s = new Scanner(TravellingSalesman.class.getResourceAsStream(fileName));
		int size = s.nextInt();
		int[][] A = new int[size][size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				A[i][j] = s.nextInt();
			}
		}
		return A;
	}

}
