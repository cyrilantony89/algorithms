package cyril.bst;

/*
 * 
 * Total number of possible Binary Search Trees with n different keys = Catalan number
 * Cn = (2n)!/(n+1)!*n!
 * 
 * For n = 0, 1, 2, 3, … values of Catalan numbers are 1, 1, 2, 5, 14, 42, 132, 429, 1430, 4862, ….
 * So are numbers of Binary Search Trees.
 * 
 */
public class BSTCombination {

    public static void main(String[] args) {
        int total = catalan(0);
        System.out.println(total);
    }

    private static int catalan(int n) {
        if (n == 0) {
            return 1;
        }
        int sum = 0;
        for (int j = 1; j <= n; j++) {
            sum += catalan(j - 1) * catalan(n - j);
        }
        return sum;
    }
}