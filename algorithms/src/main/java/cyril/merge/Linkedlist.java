package cyril.merge;

public class Linkedlist {

	static class Node {
		int val = 0;
		Node next = null;

		@Override
		public String toString() {
			return listToString(Node.this);
		}
	}

	static Node createLinkedList(int n) {
		Node first = null;
		Node ret = null;
		while ((--n) >= 0) {
			Node s = new Node();
			Double a = 100 * Math.random();
			int d = a.intValue();
			s.val = d;
			if (ret == null) {
				first = s;
				ret = s;
			} else {
				ret.next = s;
				ret = ret.next;
			}
		}
		return first;
	}

	public static void main(String[] args) {
		Node list = createLinkedList(10);
		display(list);
		Node merged = mergeSort(list);
		display(merged);
	}

	private static void display(Node list) {
		System.out.println(listToString(list));
	}

	private static String listToString(Node list) {
		StringBuilder s = new StringBuilder("list : ");
		while (list != null) {
			s.append(list.val + " > ");
			list = list.next;
		}
		return s.toString();
	}

	static Node mergeSort(Node a) {
		if (a == null) {
			return null;
		}
		if (a.next == null) {
			return a;
		}
		Node mid = findmiddle(a);
		waith();
		Node one = mergeSort(a);
		Node two = mergeSort(mid);
		Node combined = mergeBoth(one, two);
		display(combined);
		return combined;
	}

	private static void waith() {

		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	private static Node mergeBoth(Node one, Node two) {
		if (one == null) {
			return two;
		}
		if (two == null) {
			return one;
		}
		if (one.val < two.val) {
			one.next = mergeBoth(one.next, two);
			return one;
		} else {
			two.next = mergeBoth(one, two.next);
			return two;
		}
	}

	private static Node findmiddle(Node a) {
		Node prev = null;
		if (a.next == null) {
			return null;
		}
		Node slow = a;
		Node fast = a;
		while (fast != null) {
			fast = fast.next;
			if (fast != null) {
				fast = fast.next;
			}
			prev = slow;
			slow = slow.next;
		}
		prev.next = null;
		return slow;
	}

}
