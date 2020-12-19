package stack;

import java.util.EmptyStackException;

/**
 * @author sammyalsadek
 *
 */
public class Stack<T extends Object> {

	////////////////////////////////////////////////////////////////////////////

	// node class to use for stack
	public class Node {

		private T data; // data the this node holds
		private Node next; // reference to the next node in the stack

		////////////////////////////////////////////////////////////////////////

		// node constructor
		public Node(T d) {
			setData(d); // set the data of the node to the argument received
			setNext(null); // set the next reference to point to null
		}

		////////////////////////////////////////////////////////////////////////

		// setter and getter methods
		public T getData() {
			return data;
		}

		public Node getNext() {
			return next;
		}

		public void setData(T d) {
			data = d;
		}

		public void setNext(Node n) {
			next = n;
		}

	}

	////////////////////////////////////////////////////////////////////////////

	// initializ stack variable of the top
	private Node top;

	////////////////////////////////////////////////////////////////////////////

	// stack constructors
	public Stack() {
		setTop(null); // set top to null if no argument is received
	}

	public Stack(T d) {
		Node newNode = new Node(d); // create new node with the data received
		setTop(newNode); // set top to the new node
	}

	////////////////////////////////////////////////////////////////////////////

	// pushes new item to the top
	public void push(T d) {

		Node newNode = new Node(d); // create new node with the data received

		// check to see if the stack is empty
		// if it is set the new node to top
		if (top == null)
			setTop(newNode);

		// if the stack is not empty...
		else {
			newNode.setNext(top); // set the newly created nodes next reference to point to the current top
			setTop(newNode); // set the new node to top;
		}

	}

	// removes the top node
	public T pop() {

		// check if the stack is already empty, if so throw an argument
		if (top == null)
			throw new EmptyStackException();

		Node temp = top; // create temporary node
		setTop(top.getNext()); // set the top variable to the node that the current top is pointing to

		return (T) temp.getData(); // return the temps data

	}

	// checks to see what the top node is
	public T peek() {

		// check to see if stack is empty
		if (top == null)
			return null;

		// if the stack is not empty print and return the tops data
		return (T) top.getData();

	}

	// returns boolean for if the stack is empty or not
	public boolean empty() {

		if (top == null)
			return true;

		return false;

	}

	// searches for specific data in the stack
	public int search(T d) {

		int pos = 0; // initialize position
		Node temp = top; // create a temporary node holder

		// search through the stack
		while (temp != null) {

			// if find return the position of the data
			if (temp.getData() == d)
				return pos;

			temp = temp.getNext();
			pos++;

		}

		// if not found return -1
		return -1;

	}

	////////////////////////////////////////////////////////////////////////////

	// setter and getter method
	public Node getTop() {
		return top;
	}

	public void setTop(Node t) {
		top = t;
	}

}
