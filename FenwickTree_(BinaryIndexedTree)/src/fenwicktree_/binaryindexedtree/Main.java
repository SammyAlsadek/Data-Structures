package fenwicktree_.binaryindexedtree;

/**
 * @author sammyalsadek
 *
 */
public class Main {

	public static void main(String[] args) {

		// test fenwick tree class
		int size = 10;
		FenwickTree tree = new FenwickTree(size);

		for (int i = 1; i <= size; i++)
			tree.set(i, 1);

		for (int i = 1; i <= size; i++)
			tree.add(i, 1);

		System.out.print("Tree -> ");
		for (int i = 1; i <= size; i++)
			System.out.print("[" + tree.prefixSum(i) + "]");

		System.out.print("\nFenwickTree -> " + tree.toString());

	}

}
