package cyril.string;
/*
 * 
 * Find first index of substring occurrence
 */
public class SubString {
    public static void main(String[] args) {

        String s = "abcdefg";
        String x = "efg";

        int firstOccurrence = firstOccurrence(s, x);

        System.out.println(firstOccurrence);

    }

    static int firstOccurrence(String s, String x) {
        int length = s.length();
        for (int i = 0; i < length; i++) {
            if (i + x.length() > length) {
                return -1;
            }
            boolean ok = true;
            for (int k = 0, j = i; k < x.length(); k++) {
                if (x.charAt(k) != '*' && s.charAt(j++) != x.charAt(k)) {
                    ok = false;
                    break;
                }
            }
            if (ok) {
                return i;
            }
        }
        return -1;
    }
}
