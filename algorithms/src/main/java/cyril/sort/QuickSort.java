package cyril.sort;

import java.util.Scanner;

public class QuickSort {

    public static void main(String[] args) {
        Scanner s = new Scanner(QuickSort.class.getResourceAsStream("InsertionSort.txt"));
        int size = s.nextInt();
        int[] A = new int[size];
        for (int i = 0; i < size; i++) {
            A[i] = s.nextInt();
        }
        disp(A);
        quicksort(A, 0, A.length - 1);
        disp(A);
    }

    private static void quicksort(int[] a, int start, int end) {
        System.out.println("Called start:" + start + "  end:" + end);
        if (start >= end)
            return;
        int p = partition(a, start, end);
        quicksort(a, start, p);
        quicksort(a, p + 1, end);

    }

    private static int partition(int[] a, int start, int end) {

        int p = start;
        int i = start;
        int j = end;
        int pivot = a[p];

        while (true) {

            while (a[i] < pivot) {
                i++;
            }
            while (a[j] > pivot) {
                j--;
            }
            if (i < j) {
                swap(a, i, j);
            } else {
                return j;
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
