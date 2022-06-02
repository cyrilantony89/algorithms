package cyril.tekion;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class TekionBST {

	/**
	 * 
	 * 6 4 8 2 5 7 9
	 * 
	 * 
	 * 7 6 8 5 9 4 3
	 * 
	 * 
	 * 2 ->3 4 5 6 7 8 9
	 * 
	 * 
	 * 
	 * -> 3 4 6 7 8 9
	 * 
	 * 
	 * 
	 * 
	 * 1 2 3 4 5 -> 80
	 * 
	 * 7 -> 8 9 10 11
	 * 
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		Node nine = new Node(9, null, null);
		Node five = new Node(5, null, null);
		Node seven = new Node(7, null, nine);
		Node six = new Node(6, five, seven);
		
		
		Node two = new Node(2, null, null);
		Node eight = new Node(8, null, null);
		Node five2 = new Node(5, two, eight);

		Map<Integer, Integer> map = new HashMap<>();

		inorder(six, map);

		inorderRemove(five2, map);

		for (Entry<Integer, Integer> entry : map.entrySet()) {
			if (entry.getValue() != 0) {
				System.out.println(entry.getKey());
			}

		}

	}

	private static void inorder(TekionBST.Node node, Map<Integer, Integer> map) {

		if (node == null) {
			return;
		}
		inorder(node.left, map);

		Integer count = map.get(node.val);
		if (count == null) {
			count = 0;
		}
		count++;
		map.put(node.val, count);

		inorder(node.right, map);

	}
	

	private static void inorderRemove(TekionBST.Node node, Map<Integer, Integer> map) {

		if (node == null) {
			return;
		}
		inorderRemove(node.left, map);

		Integer count = map.get(node.val);
		if (count == null) {
			System.out.println(node.val);
		} else if(count == 1) {
			map.remove(node.val);
		} else {
			count--;
			map.put(node.val, count);
		}

		inorderRemove(node.right, map);

	}

	static class Node {

		Node(int val, Node left, Node right) {
			this.val = val;
			this.left = left;
			this.right = right;

		}

		int val;
		Node left;
		Node right;

	}

}
