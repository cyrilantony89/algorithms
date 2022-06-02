import java.util.HashMap;
import java.util.Map;

// you can also use imports, for example:

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

public class Camelcase {

	public static void main(String[] args) {
		
		String s1 = "arms".toLowerCase();
		
		String s2 = "ram".toLowerCase();
		
		Map<Character, Integer> mp = new HashMap<>();
		for (int i = 0; i < s1.length(); i++) {
			Character charAt = s1.charAt(i);
			mp.merge(charAt, 1, Integer::sum);
		}
		for (int i = 0; i < s2.length(); i++) {
			Character charAt = s2.charAt(i);
			mp.merge(charAt, -1, Integer::sum);
		}
		
		boolean isAnagram = !mp.entrySet().stream().anyMatch(entry ->  entry.getValue()!=0);
		System.out.println(isAnagram);
		
		
	}

}
