package cyril.heap;

public class Heap_New {
	public static void main(String[] args) {

		int[] s = { 7, 6, 5, 4, 3, 2, 1 };

		organize(s);
	}

	private static void organize(int[] s) {

		int len = s.length;

		for (int i = len - 1 / 2; i >= 0; i--) {

			heapi(s, len, i);

		}

	}

	private static void heapi(int[] s, int len, int i) {
		if (len < i * 2 + 1) {
			if (s[i * 2 + 1] < s[i]) {
				int temp = s[i * 2 + 1];
				s[i * 2 + 1] = s[i];
				s[i] = temp;
			}
			return;
		}
		if (s[i * 2 + 1] > s[i * 2 + 2]) {
			int temp = s[i * 2 + 1];
			s[i * 2 + 1] = s[i * 2 + 2];
			s[i * 2 + 2] = temp;
			heapi(s, len , i * 2 + 2);
			heapi(s, len , i * 2 + 1);
		}
		if (s[i * 2 + 1] < s[i]) {
			int temp = s[i * 2 + 1];
			s[i * 2 + 1] = s[i];
			s[i] = temp;
			heapi(s, len , i * 2 + 1);
		}
		if (s[i * 2 + 1] < s[i]) {
			int temp = s[i * 2 + 1];
			s[i * 2 + 1] = s[i];
			s[i] = temp;
			heapi(s, len , i * 2 + 1);
		}
	}
}
