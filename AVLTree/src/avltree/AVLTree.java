package avltree;

/**
 * @author sammyalsadek
 *
 */
public class AVLTree<T extends Comparable<T>> {

///////////////////////////////////////////////////////////////////////////////	

	// tree node class
	class Node {

		// declare variables
		int bf; // balance factor variable
		int height; // height of the node in the tree
		T value; // value contained within the node
		Node left, right; // left and right children nodes

		// constructor
		public Node(T value) {
			this.value = value;
		}

	}

///////////////////////////////////////////////////////////////////////////////	

	// declare variable
	private Node root; // root node of the tree
	private int nodeCount; // number of node inside of the tree

///////////////////////////////////////////////////////////////////////////////	

	// returns the height of the tree
	public int height() {
		return root.height;
	}

	// returns the number of nodes contained within the tree
	public int size() {
		return nodeCount;
	}

	// returns true/false whether the tree is empty or not
	public boolean isEmpty() {
		return size() == 0;
	}

	// returns true/false depending on if the
	// given value is found within the tree
	public boolean contains(T value) {
		return contains(root, value);
	}

	// contains helper method
	private boolean contains(Node node, T value) {

		if (node == null)
			return false;

		// if node exists compare it to the value given as an argument
		int cmp = value.compareTo(node.value);

		// search left subtree if the value is
		// less than the current node value
		if (cmp < 0)
			return contains(node.left, value);

		// search right subtree if the value is
		// greater than the current node value
		if (cmp > 0)
			return contains(node.right, value);

		// return true if the value is found
		return true;

	}

	// inserts a value into the tree
	public boolean insert(T value) {

		// return false if the value given is null
		if (value == null)
			return false;

		// if the value is already contained
		// within the tree return false
		if (contains(root, value))
			return false;

		// insert new value in the tree
		root = insert(root, value);
		nodeCount++; // increment the number of nodes in the tree
		return true;

	}

	// insert helper method
	private Node insert(Node node, T value) {

		// if the the node is empty insert new node in the position
		if (node == null)
			return new Node(value);

		// compare the current node value to the value given
		int cmp = value.compareTo(node.value);

		// if the value is less than the current node
		// value insert in the left subtree
		if (cmp < 0)
			node.left = insert(node.left, value);

		// if the value is greater than the current node
		// value insert in the right subtree
		else
			node.right = insert(node.right, value);

		// update the balance factor and height variables
		update(node);

		// balance the tree
		return balance(node);

	}

	// updates the balance factor and height of a node
	private void update(Node node) {

		// retrieve the height of the left and right subtree of the given node
		int leftNodeHeight = (node.left == null) ? -1 : node.left.height;
		int rightNodeHeight = (node.right == null) ? -1 : node.right.height;

		// update the height of this node
		node.height = 1 + Math.max(leftNodeHeight, rightNodeHeight);

		// update the balance factor of this node
		node.bf = rightNodeHeight - leftNodeHeight;

	}

	// balance the node of its balance factor is +2 or -2
	private Node balance(Node node) {

		// check to see if the tree is left heavy
		if (node.bf == -2) {

			// left-left case
			if (node.left.bf <= 0)
				return leftLeftCase(node);

			// left-right case
			else
				return leftRightCase(node);

		}

		// check to see if the tree is right heavy
		else if (node.bf == 2) {

			// right-right case
			if (node.right.bf >= 0)
				return rightRightCase(node);

			// right-left case
			else
				return rightLeftCase(node);

		}

		// return node if the balance
		// factor is neither -2 or +2
		// (-1, 0, +1)
		return node;

	}

	// left-left case
	private Node leftLeftCase(Node node) {
		return rightRotation(node);
	}

	// left-right case
	private Node leftRightCase(Node node) {
		node.left = leftRotation(node.left);
		return leftLeftCase(node);
	}

	// right-right case
	private Node rightRightCase(Node node) {
		return leftRotation(node);
	}

	// right-left case
	private Node rightLeftCase(Node node) {
		node.right = rightRotation(node.right);
		return rightRightCase(node);
	}

	// rotates the tree to the left
	private Node leftRotation(Node node) {

		Node newParent = node.right;
		node.right = newParent.left;
		newParent.left = node;

		// update the balance factor and height
		// of both the node and newParent node
		update(node);
		update(newParent);

		// return the new parent node of rotated tree
		return newParent;

	}

	// rotates the tree to the right
	private Node rightRotation(Node node) {

		Node newParent = node.left;
		node.left = newParent.right;
		newParent.right = node;

		// update the balance factor and height
		// of both the node and newParent node
		update(node);
		update(newParent);

		// return the new parent node of rotated tree
		return newParent;

	}

	// removes the given value from the tree
	public boolean remove(T value) {

		// if the value given is null return false
		if (value == null)
			return false;

		// if the value is not contained
		// within the tree return false
		if (!contains(root, value))
			return false;

		// remove the value from the tree
		root = remove(root, value);
		nodeCount--; // decrement the number of nodes in the tree
		return true;

	}

	// remove helper method
	private Node remove(Node node, T value) {

		// if we reach a null node return null
		if (node == null)
			return null;

		// compare the value to the current node value
		int cmp = value.compareTo(node.value);

		// if the value is less that the current node
		// value search in the left subtree
		if (cmp < 0)
			node.left = remove(node.left, value);

		// if the value is greater than the current
		// node value search in the right subtree
		else if (cmp > 0)
			node.right = remove(node.right, value);

		// if the values are equal then remove the current node
		else {

			// if the node only has a right subtree or no subtrees
			// at all set the node to its right child
			if (node.left == null)
				return node.right;

			// if the node only has a left subtree or no subtrees
			// at all set the node to its left child
			else if (node.right == null)
				return node.left;

			// if the node has both subtrees remove the largest value of the
			// left subtree or the smallest value of the right subtree
			else {

				// remove form the left subtree if the height
				// is greater than that of the right
				if (node.left.height > node.right.height) {

					// get the largest node of the left subtree
					// and set the node value to it
					T successorValue = findMax(node.left);
					node.value = successorValue;

					// remove the largest value in the left subtree
					node.left = remove(node.left, successorValue);

				}

				// remove form the right subtree if the height
				// is greater than that of the left
				else {

					// get the largest node of the left subtree
					// and set the node value to it
					T successorValue = findMin(node.right);
					node.value = successorValue;

					// remove the largest value in the left subtree
					node.right = remove(node.right, successorValue);

				}

			}

		}

		// update the balance factor and height of the node
		update(node);

		// balance the tree
		return balance(node);

	}

	// finds maximum value of tree
	private T findMax(Node node) {
		while (node.right != null)
			node = node.right;
		return node.value;
	}

	// finds maximum value of tree
	private T findMin(Node node) {
		while (node.left != null)
			node = node.left;
		return node.value;
	}
	
	// inOrder traversal
    public void inOrder() {
    	
    	// if the tree is empty print null
        if(isEmpty()) {
            System.out.println("[NULL]");
            return;
        }
        
        // else continue with the inOrder traversal
        inOrder(root);
        
    }
    
    // inOreder traversal 
    private void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print("[" + node.value + "]");
            inOrder(node.right);
        }
    }

}