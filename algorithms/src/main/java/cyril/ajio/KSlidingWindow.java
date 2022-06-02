package cyril.ajio;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KSlidingWindow {
	public static void main(String[] args) {

		int[] arr = {2 , 2 , 2  , 2 , 1 , 1};
		List<Integer> window = getMaxSlidingWindow(arr);

		System.out.println(window);
	}

	private static List<Integer> getMaxSlidingWindow(int[] arr) {

		int counter = 0;
		Map<Integer, Integer> map = new HashMap<>();
		for (int i : arr) {

			Integer countOfrabbit = map.get(i);
			if (countOfrabbit == null || countOfrabbit == 0) {
				counter += (i + 1);
				map.put(i, i);
			} else if (countOfrabbit > 0) {
				map.put(i, countOfrabbit - 1);
			}

		}
		return null;
	}

}
