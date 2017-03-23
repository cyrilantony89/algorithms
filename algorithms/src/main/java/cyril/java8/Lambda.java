package cyril.java8;

public class Lambda {

    interface MathOperation {
        int operation(int a, int b);
    }

    static MathOperation add   = (a, b) -> a + b;
    MathOperation        sub   = (a, b) -> a - b;
    MathOperation        multi = (a, b) -> a * b;
    MathOperation        div   = (a, b) -> a / b;

    public static void main(String[] args) {

        int res = perform(12, 13, add);
        System.out.println(res);

        int res1 = perform(12, 13, (c, d) -> Math.max(c, d));
        System.out.println(res1);
    }

    private static int perform(int a, int b, MathOperation op) {
        return op.operation(a, b);
    }

}
