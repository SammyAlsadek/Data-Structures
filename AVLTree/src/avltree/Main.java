package avltree;

/**
 * @author sammyalsadek
 *
 */
public class Main {

	public static void main(String[] args) {

		// test avl tree class
		AVLTree<Integer> tree = new AVLTree<Integer>();

		for (int i = 0; i <= 10; i++)
			tree.insert(i);
		
		for (int i = 20; i > 10; i--)
			tree.insert(i);

		for (int i = 0; i <= 20; i++)
			if (i % 2 == 0)
				tree.remove(i);

		for (int i = 0; i <= 20; i+=3)
			System.out.println("Contains " + i + " -> " + tree.contains(i));

		System.out.println("\nTree height -> " + tree.height());
		System.out.println("\nTree size -> " + tree.size());
		System.out.println("\nTree empty -> " + tree.isEmpty());
		
		System.out.println("\nTree:");
		tree.inOrder();

	}

}
