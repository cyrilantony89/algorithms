// you can also use imports, for example:

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

public class Divisibleby3 {
	int size;

	public static void main(String[] args) {

		Divisibleby3 sol = new Divisibleby3();
		int solution = sol.solution("00081");
		System.out.println(solution);
	}

	public int solution(String str) {
		int count = 0;
		for (int digitIndex = str.length() - 1; digitIndex >= 0; digitIndex--) {
			for (int i = 0; i <= 9; i++) {
				StringBuilder sb = new StringBuilder(str);
				char schar = (char) ('0' + i);
				if (str.charAt(digitIndex) != schar) {
					sb.setCharAt(digitIndex, (char) ('0' + i));
					if (Integer.valueOf(sb.toString()) % 3 == 0) {
						count++;
					}
				}
			}

		}
		if (Integer.valueOf(str) % 3 == 0) {
			count++;
		}
		return count;
	}

}
