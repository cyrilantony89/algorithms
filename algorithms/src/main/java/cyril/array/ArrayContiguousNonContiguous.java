package cyril.array;

import java.util.Scanner;

public class ArrayContiguousNonContiguous {

    public static void main(String[] args) {
        Scanner s = new Scanner(ArrayContiguousNonContiguous.class.getResourceAsStream("ArrayContiguousNonContiguous.txt"));
        int num = s.nextInt();
        for (int k = 0; k < num; k++) {
            int size = s.nextInt();
            int[] arr = new int[size];
            for (int i = 0; i < size; i++) {
                arr[i] = s.nextInt();
            }
            int cont = findCont(arr);
            int noncont = findNonCont(arr);
            System.out.println("cont:" + cont+" noncont:" + noncont);

        }
    }

    private static int findCont(int[] arr) {
        int finalmax = 0;
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            int max = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                max = Math.max(max, sum);
            }
            finalmax = Math.max(finalmax, max);

        }
        return finalmax;
    }

    private static int findNonCont(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                sum += arr[i];
            }
        }
        return sum;
    }
}
