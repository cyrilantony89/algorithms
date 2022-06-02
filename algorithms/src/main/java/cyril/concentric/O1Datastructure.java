package cyril.concentric;
import java.util.HashMap;
import java.util.Map;

public class O1Datastructure {

	/**
	 * Design a data structure which:
	 *
	 * add element - O(1) Lookup element - O(1) Remove elements. - O(1) Get random
	 * element. - O(1)
	 *
	 *
	 * @param args
	 */
	public static void main(String[] args) {

	}

	static class MyMap {

		int count = 0;
		Map<Object, Integer> mp;
		Object[] objArray;

		MyMap(int size) {

			mp = new HashMap<>();

			objArray = new Object[size];

		}

		void add(Object a) {

			objArray[count] = a;

			mp.put(a, count);

			count++;

		}

		boolean find(Object a) {

			Integer index = mp.get(a);
			return index != null;

		}

		Object remove(Object a) {
			Integer index = mp.get(a);
			objArray[index] = null;

			Object last = objArray[count];
			objArray[index] = last;
			count--;
			mp.put(last, index);

			return mp.remove(a);

		}

		Object getrandom() {
			int intValue = Double.valueOf(Math.random()).intValue();
			int mod = intValue % count;

			return objArray[mod];

		}

	}

}
