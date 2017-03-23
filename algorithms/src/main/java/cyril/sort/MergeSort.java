package cyril.sort;

import java.util.Scanner;

public class MergeSort {

    public static void main(String[] args) {
        Scanner s = new Scanner(MergeSort.class.getResourceAsStream("MergeSort.txt"));
        int size = s.nextInt();
        int[] A = new int[size];
        for (int i = 0; i < size; i++) {
            A[i] = s.nextInt();
        }
        disp(A);
        int start = 0;
        mergesort(A, start, size - 1);

        disp(A);
    }

    private static void disp(int[] arr) {
        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            System.out.print(" " + arr[i]);
        }
    }

    static void mergesort(int[] arr, int start, int end) {

        if (end - start <= 1) {
            if (arr[start] > arr[end]) {
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
            }
            return;
        }

        int mid = (start + end) / 2;
        mergesort(arr, start, mid);
        mergesort(arr, mid + 1, end);
        int[] newarr = new int[(end - start) + 1];
        int i = 0;
        int astart = start;
        int bstart = mid + 1;
        while (astart <= mid && bstart <= end) {
            if (arr[astart] < arr[bstart]) {
                newarr[i++] = arr[astart++];
            } else {
                newarr[i++] = arr[bstart++];
            }
        }
        while (astart <= mid) {
            newarr[i++] = arr[astart++];
        }
        while (bstart <= end) {
            newarr[i++] = arr[bstart++];
        }
        int s = 0;
        while (s < newarr.length) {
            arr[start++] = newarr[s++];
        }
    }
}
