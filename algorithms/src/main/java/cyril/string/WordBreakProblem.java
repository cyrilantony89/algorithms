package cyril.string;

public class WordBreakProblem {

    public static void main(String[] args) {
        String uuid = "asfdasfasd-ss_.";
        if (!uuid.matches("[a-zA-Z0-9-_]*")) {

            System.out.println("invalid");
        } else {
            System.out.println("valid");
        }
    }

    boolean checkAvailable(String word) {
        return true;
    }

}
