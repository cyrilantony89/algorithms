package cyril.concentric;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapToFlatMap {

	/**
	 * nested json
	 *
	 * @param args
	 */

	public static void main(String[] args) {

		// a : b : 'abc'
		// c : 'cde'

		Map<Object, Object> map = new HashMap<>();
		Map<Object, Object> obj1 = new HashMap<>();
		map.put("a", obj1);
		Object obj2 = "abc";
		obj1.put("b", obj2);
		Object obj3 = "cde";
		obj1.put("c", obj3);

		Map<Object, Object> map2 = new HashMap<>();
		System.out.println(map);
		recurse("", map, map2);
		System.out.println(map2);

	}

	static void recurse(Object  prefix , Map<Object, Object> from, Map<Object, Object> to) {
		Set<Entry<Object, Object>> entrySet = from.entrySet();
		for (Entry<Object, Object> entry : entrySet) {
			Object key = entry.getKey();
			Object val = entry.getValue();
			if(primary(val)) {
				to.put((prefix.toString().equals("")? "": prefix.toString()+".")+key, val);

			} else {
				recurse((prefix.toString().equals("")? "": prefix.toString()+".")+key ,(Map<Object, Object>) val, to);
			}

		}

	}

	private static boolean primary(Object val) {
		if(val instanceof Number) {
			return true;
		}
		if(val instanceof String) {
			return true;
		}
		if(val instanceof Character) {
			return true;
		}
		if(val instanceof Byte) {
			return true;
		}

		return false;
	}

}
