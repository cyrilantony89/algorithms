package cyril.array;

public class ArrayEqualSumDividerIndex {
    public int solution(int[] A) {
        int n = A.length;
        long sum = 0L;
        for (int i = 0; i < n ; i++) {
            sum += A[i];
        }
        long left = 0L;
        if (left == sum) {
            System.err.println("adsfsafd");
            return 0;
        }
        for (int i = 0; i < n; i++) {
            sum -= A[i];
            if (left == sum) {
                return i;
            }
            left += A[i];
        }
        if (left == sum) {
            return n - 1;
        }
        return -1;

        // write your code in Java SE 8
    }
    
    public static void main(String[] args) {
        int solution = new ArrayEqualSumDividerIndex().solution(new int[]{-1, 0, 1});
        System.out.println(solution);
    }
}