package cyril.hillandvalley;

import java.util.Scanner;

public class HillValley {
    public int solution1(int[] A) {

        int hill = 0;
        int count = 0;
        for (int i = 1; i < A.length; i++) {
            if (hill != 1 && A[i] > A[i - 1]) {
                count++;
                hill = 1;
            } else if (hill != -1 && A[i] < A[i - 1]) {
                count++;
                hill = -1;
            }
        }

        return ++count;

    }

    public static void main(String[] args) {

        Scanner s = new Scanner(HillValley.class.getResourceAsStream("HillValley.txt"));
        int size = s.nextInt();
        int[] A = new int[size];
        for (int i = 0; i < size; i++) {
            A[i] = s.nextInt();
        }
        int solution = new HillValley().solution1(A);
        System.out.println(solution);
    }
}