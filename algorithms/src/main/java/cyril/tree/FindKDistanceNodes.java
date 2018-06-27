package cyril.tree;

public class FindKDistanceNodes {

	static class Node {
		public Node(int i) {
			val = i;
		}
		int val;
		Node left;
		Node right;
	}
	static int valueToFind = 0;
	static int distance = 0;

	public static void main(String[] args) {

		Node one = new Node(1);
		Node two = one.left = new Node(2);
		Node three = one.right = new Node(3);

		Node four = two.left = new Node(4);
		Node five = two.right = new Node(5);
		Node six = three.left = new Node(6);
		Node seven = three.right = new Node(7);

		Node eight = four.left = new Node(8);
		Node nine = four.right = new Node(9);
		Node ten = five.left = new Node(10);
		Node eleven = five.right = new Node(11);
		Node twelve = six.left = new Node(12);
		Node thirteen = six.right = new Node(13);
		Node fourteen = seven.left = new Node(14);
		Node fifteen = seven.right = new Node(15);

		valueToFind = 11;
		distance = 2;
		traverse(one, -1);
	}

	private static int traverse(Node one, int k) {
		if (one == null) {
			return -1;
		} else if (k == 0) {
			// This is a node at k distance . Print it.
			System.out.println(one.val);
			// No more processing down the tree, so return
			return -1;
		} else if (k > 0) {
			// Need to find a node at k distance in lower level of tree. Traverse it
			traverse(one.left, k - 1);
			traverse(one.right, k - 1);
			return -1;
		}

		// Below case is when we have not yet found the node. Somewhere in lower tree,
		// we will find node
		// and it will return k value up the tree
		// We should handle possible case of printing upper level nodes

		if (one.val == valueToFind) {
			// This is the searched node , Now should decrement k and traverse lower level.
			traverse(one.left, distance - 1);
			traverse(one.right, distance - 1);
			// Also return decremented k to handle printing upper level nodes at k distance.
			return distance - 1;
		} else {

			int left_K = traverse(one.left, -1);
			// Here We found node in left subtree. Now we have to find nodes at k distance
			// in right subtree
			// and at above levels.
			if (left_K == 0) {
				System.out.println(one.val);
				return -1;
			} else if (left_K > 0) {
				traverse(one.right, left_K - 1);
				return left_K - 1;
			}

			int right_K = traverse(one.right, -1);
			// Here We found node in right subtree. Now we have to find nodes at k distance
			// in left subtree
			// and at above levels.
			if (right_K == 0) {
				System.out.println(one.val);
				return -1;
			} else if (right_K > 0) {
				traverse(one.left, right_K - 1);
				return right_K - 1;
			}

			return -1;
		}
	}

}
