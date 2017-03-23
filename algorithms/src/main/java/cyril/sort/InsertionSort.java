package cyril.sort;

import java.util.Scanner;

public class InsertionSort {

    public static void main(String[] args) {
        Scanner s = new Scanner(InsertionSort.class.getResourceAsStream("InsertionSort.txt"));
        int size = s.nextInt();
        int[] A = new int[size];
        for (int i = 0; i < size; i++) {
            A[i] = s.nextInt();
        }
        disp(A);
        insertionsort(A);
        disp(A);
    }

    private static void insertionsort(int[] a) {
        for (int i = 1; i < a.length; i++) {

            for (int j = i - 1; j >= 0; j--) {
                if (a[j] > a[j + 1]) {
                    swap(a, j, j + 1);
                } else {
                    break;
                }
            }
        }
    }

    private static void swap(int[] a, int j, int i) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private static void disp(int[] arr) {
        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            System.out.print(" " + arr[i]);
        }
    }

}
