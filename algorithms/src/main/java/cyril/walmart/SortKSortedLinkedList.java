
package cyril.walmart;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// you can also use imports, for example:

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

//Merge K sorted linked lists and return it as a sorted list. 
//
//
//Example 1:
//
//
//Input: l1 = [1,2,4], l2 = [1,3,4] , l3 = [1,2,4], l4 = [1,3,4] 
//Output: [1,1,2,3,4,4]

public class SortKSortedLinkedList {

	public static void main(String[] args) {

		LinkedList<Integer> l1 = new LinkedList<>();
		l1.add(1);
		l1.add(2);
		l1.add(4);

		LinkedList<Integer> l2 = new LinkedList<>();
		l2.add(1);
		l2.add(3);
		l2.add(4);

		LinkedList<Integer> l3 = new LinkedList<>();
		l3.add(1);
		l3.add(2);
		l3.add(4);

		LinkedList<Integer> l4 = new LinkedList<>();
		l4.add(1);
		l4.add(3);
		l4.add(4);

		List<LinkedList<Integer>> s = new ArrayList<>();
		s.add(l1);
		s.add(l2);
		s.add(l3);
		s.add(l4);

		LinkedList<Integer> res = mergeSort(s, 0, s.size() - 1);

		disp(res);

	}

	private static LinkedList<Integer> mergeSort(List<LinkedList<Integer>> s, int start, int end) {

		if ((start + 1) == end) {
			// only 2 in list;
			return sort(s.get(start), s.get(end));
		}
		if (start == end) {
			// only 1 in list;
			return s.get(start);
		}

		int mid = (start + end) / 2;

		LinkedList<Integer> one = mergeSort(s, start, mid);
		LinkedList<Integer> two = mergeSort(s, mid + 1, end);

		return sort(one, two);

	}

	private static void disp(LinkedList<Integer> res) {
		while (!res.isEmpty()) {
			System.out.println(res.poll());
		}

	}

	private static LinkedList<Integer> sort(LinkedList<Integer> l1, LinkedList<Integer> l2) {

		LinkedList<Integer> res = new LinkedList<>();
		while (!l1.isEmpty() && !l2.isEmpty()) {
			Integer a = l1.peek();
			Integer b = l2.peek();
			if (a < b) {
				res.add(l1.poll());
			} else {
				res.add(l2.poll());
			}
		}

		while (!l1.isEmpty()) {
			res.add(l1.poll());
		}

		while (!l2.isEmpty()) {
			res.add(l2.poll());
		}

		return res;
	}

}
