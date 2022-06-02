import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combination_Transformation {
	
	static int cnt = 0;

	public static void main(String[] args) {

		String[] t1 = { "t1 upd", "t1 del arch", "t1 upd arch" };
		String[] t2 = { "		t2 upd", "		t2 del arch", "		t2 upd arch" };

		List<String> t1l = Arrays.asList(t1);
		List<String> t2l = Arrays.asList(t2);

		List<String> list = new ArrayList<>();

		recurse(t1l, t2l, list);

		System.out.println(cnt);
	}

	private static void recurse(List<String> t1l, List<String> t2l, List<String> list) {
		if (t1l.isEmpty() || t2l.isEmpty()) {
			if (t1l.isEmpty()) {
				list.addAll(t2l);
			} else {
				list.addAll(t1l);
			}
			cnt++;
			displ(list);
			return;
		}

		List<String> t1list = new ArrayList<>(t1l);
		String remove = t1list.remove(0);
		ArrayList<String> list1 = new ArrayList<>(list);
		list1.add(remove);
		recurse(t1list, t2l, list1);

		List<String> t2list = new ArrayList<>(t2l);
		String remove2 = t2list.remove(0);
		ArrayList<String> list2 = new ArrayList<>(list);
		list2.add(remove2);
		recurse(t1l, t2list, list2);

	}

	private static void displ(List<String> list) {
		list.forEach(a -> System.out.println(a));
		System.out.println("---------");

	}

}
