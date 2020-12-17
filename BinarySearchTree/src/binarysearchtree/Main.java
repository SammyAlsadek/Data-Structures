package binarysearchtree;

/**
 * @author sammyalsadek
 *
 */
public class Main {

	public static void main(String[] args) {

		// test binary search tree class
		BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();

		for (int i = 0; i <= 10; i++)
			tree.add(i);

		for (int i = 20; i > 10; i--)
			tree.add(i);

		for (int i = 0; i <= 20; i++)
			if (i % 2 == 0)
				tree.remove(i);

		for (int i = 0; i <= 20; i += 3)
			System.out.println("Contains " + i + " -> " + tree.contains(i));

		System.out.println("\nTree size -> " + tree.size());
		System.out.println("\nTree empty -> " + tree.isEmpty());

		System.out.println("\nTree:");
		System.out.print("PreOrder -> ");
		tree.preOrder();
		System.out.print("\nInOrder -> ");
		tree.inOrder();
		System.out.print("\nPostOrder -> ");
		tree.postOrder();

	}

}
