package cyril.string;

import java.util.ArrayList;
import java.util.List;

public class StringBomber {

	public static void main(String[] args) {
		String str 
//		= "abcdeedcbfgf";
//		= "abbabba";
		= "aabcccdee";
		List<Character> s = new ArrayList<Character>();
		for (char c : str.toCharArray()) {
			s.add(c);
		}
		int currentInd = 0;
		int nextindex = 1;
		while (nextindex < s.size()) {
			if (s.get(currentInd) == s.get(nextindex)) {
				while (nextindex < s.size() && s.get(currentInd) == s.get(nextindex)) {
					nextindex++;
				}
				int j = Math.min(nextindex, s.size());
				for (int i = currentInd; i < j; i++) {
					s.remove(currentInd);
				}
				if (currentInd > 0) {
					currentInd--;
				}
				nextindex = currentInd + 1;
			} else {
				currentInd++;
				nextindex++;
			}
		}
		System.out.println(s);

	}
}
