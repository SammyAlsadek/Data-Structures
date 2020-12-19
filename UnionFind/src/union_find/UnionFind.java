package union_find;

public class UnionFind {

	// number of elements in this union find
	private int size;
	// used to track the sizes of each components
	private int[] sz;
	// id[i] points to the parents of i, if id[i]=i then i is a rootnode
	private int[] id;
	// tracks the number of components in the union find
	private int numComponents;

	//////////////////////////////////////////////////////////////////////////////

	// constructor
	public UnionFind(int size) {

		if (size <= 0)
			throw new IllegalArgumentException();

		this.size = numComponents = size;
		sz = new int[size];
		id = new int[size];

		for (int i = 0; i < size; i++) {
			sz[i] = 1; // start the size of each component at one
			id[i] = i; // make all components link to themselves
		}

	}

	//////////////////////////////////////////////////////////////////////////////

	// find which component/set 'p' belongs to,takes amortized constant time
	public int find(int p) {

		int root = p;
		while (root != id[root])
			root = id[root];

		// compress the path leading back to the root
		// doing this operation is called "path compression"
		// and is what gives us amortized constant time complexity
		while (p != root) {
			int next = id[p];
			id[p] = root;
			p = next;
		}

		return root;

	}

	// return whether or not the elements 'p' and 'q'
	// are in the same components/set
	public boolean connected(int p, int q) {
		return (find(p) == find(q));
	}

	// return the size of the components/set 'p' belongs to
	public int componentSize(int p) {
		return sz[find(p)];
	}

	// return the number of elements in this UnionFind
	public int size() {
		return size;
	}

	// return the number of remaining components in the UnionFind
	public int components() {
		return numComponents;
	}

	// unify the components/sets containg elements 'p' and 'q'
	public void unify(int p, int q) {

		int root1 = find(p);
		int root2 = find(q);

		// if they dont belong in the same group already
		// merge two components/sets together
		// merge smaller component/set into the larger one
		if (root1 != root2) {

			if (sz[root1] < sz[root2]) {
				sz[root2] += sz[root1];
				id[root1] = root2;
			}

			else {
				sz[root1] += sz[root2];
				id[root2] = root1;
			}

			// decrease total number of components by one
			numComponents--;

		}

	}

}
