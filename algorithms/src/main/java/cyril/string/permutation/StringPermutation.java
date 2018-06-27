package cyril.string.permutation;

public class StringPermutation {

	public static void main(String[] args) {
		String s = "abc";
		permute(s, 0, s.length() - 1);
	}

	private static void permute(String s, int i, int lastIndx) {

		if (i == lastIndx) {
			System.out.println(s);

		}
		for (int j = i; j <= lastIndx; j++) {
			String ss = swap(s, i, j);
			permute(ss, i + 1, lastIndx);
		}

	}

	private static String swap(String s, int i, int j) {
		char[] from = s.toCharArray();
		char a = from[i];
		from[i] = from[j];
		from[j] = a;
		return new String(from);
	}
}
