package cyril.string;

public class Stringreversewords {

	public static void main(String[] args) {
		String ss = " i am a boy of the naytion   it   e pop  ";
		char[] s = ss.toCharArray();

		int start = 0, i = 0;
		while (true) {
			while (i < s.length && s[i] == ' ')
				i++;
			start = i;

			if (i == s.length) {
				System.out.println("STRING IS :" + new String(s));
				return;
			}

			while (i < s.length && s[i] != ' ')
				i++;
			swap(start, i - 1, s);
			if (i == s.length) {
				System.out.println("string is :" + new String(s));
				return;
			}
		}
	}

	private static void swap(int a, int b, char[] s) {
		for (int j = 0; j <= (b - a) / 2; j++) {
			char t = s[a + j];
			s[a + j] = s[b - j];
			s[b - j] = t;
		}
	}

}
