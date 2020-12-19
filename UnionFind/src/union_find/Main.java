package union_find;

/**
 * @author sammyalsadek
 *
 */
public class Main {

	public static void main(String[] args) {

		// test unionfind class
		UnionFind uf = new UnionFind(5);

		for (int i = 1; i < 5; i++) {
			System.out.println("Unified -> " + (i - 1) + " & " + i);
			uf.unify(i, i - 1);
		}

		System.out.println("\nNumber of components -> " + uf.components());
		System.out.println("\nSize of UnionFind -> " + uf.size());

		System.out.println();
		for (int i = 0; i < 5; i++)
			System.out.println("Component size of " + i + " -> " + uf.componentSize(i));

		System.out.println();
		for (int i = 1; i < 5; i++)
			System.out.println("Is " + (i - 1) + " & " + i + " connected -> " + uf.connected(i - 1, i));

		System.out.println();
		for (int i = 0; i < 5; i++)
			System.out.println("Root of " + i + " -> " + uf.find(i));

	}

}
