package priority_queue;

/**
 * @author sammyalsadek
 *
 */
public class Priority_Queue<T extends Object> {

	//////////////////////////////////////////////////////////////////////////////

	// inner Priority_Node class
	public class PNode {

		// declare variables
		private T element;
		private int priority;
		private PNode nextNode;

		//////////////////////////////////////////////////////////////////////////

		// constructors
		public PNode(T e, int p, PNode next) {
			this.element = e;
			this.priority = p;
			this.nextNode = next;
		}

		public PNode() {
			this.element = null;
			this.priority = -1;
			this.nextNode = null;
		}

		//////////////////////////////////////////////////////////////////////////

		// setter functions
		public void setElement(T e) {
			this.element = e;
		}

		public void setPriority(int p) {
			this.priority = p;
		}

		public void setNextNode(PNode n) {
			this.nextNode = n;
		}

		// getter functions
		public T getElement() {
			return this.element;
		}

		public int getPriority() {
			return this.priority;
		}

		public PNode getNextNode() {
			return this.nextNode;
		}

	}

	//////////////////////////////////////////////////////////////////////////////

	// declare variables
	private PNode maxElement;

	//////////////////////////////////////////////////////////////////////////////

	// constructors
	public Priority_Queue() {
		this.maxElement = null;
	}

	public Priority_Queue(T element, int priority) {
		this.maxElement = new PNode(element, priority, null);
	}

	//////////////////////////////////////////////////////////////////////////////

	// insert an element into the queue with a given priority (higher
	// priority value, the higher the priority is for the data element)
	public void insert(T element, int priority) {

		// create a new Priority Node
		PNode newNode = new PNode(element, priority, null);

		// check to see if the Priority_Queue is empty
		// if it is insert in the front of the list
		if (this.maxElement == null)
			this.maxElement = newNode;

		// place Node in correct position within the Queue
		else
			placeNode(newNode);

	}

	// removes the highest priority element from the priority queue
	public T remove_maximum() {

		T value = null;

		// check to see if the Queue is Empty
		if (this.maxElement != null) {

			value = (T) this.maxElement.getElement();
			PNode oldMax = this.maxElement;
			this.maxElement = this.maxElement.getNextNode();
			oldMax.setNextNode(null);
			oldMax = null;

		}

		return value;

	}

	// places Node in proper position within the queue
	private void placeNode(PNode newNode) {

		// check to see if the new Priority Node has
		// the greatest priority value
		if (newNode.getPriority() > this.maxElement.priority) {
			newNode.setNextNode(this.maxElement);
			this.maxElement = newNode;
		}

		// traverse through the list and find where the new
		// Priority Node belongs (stop when reaching a node
		// with a smaller Priority)
		else {

			PNode prevNode = null;
			PNode tempNode = this.maxElement;

			while (newNode.getPriority() <= tempNode.getPriority() && tempNode.getNextNode() != null) {
				prevNode = tempNode;
				tempNode = tempNode.getNextNode();
			}

			// if our new Priority Nodes value is the minimum
			// place it at the end of the Queue
			if (newNode.getPriority() <= tempNode.getPriority() && tempNode.getNextNode() == null) {
				tempNode.setNextNode(newNode);
				newNode.setNextNode(null);
			}

			else {
				prevNode.setNextNode(newNode);
				newNode.setNextNode(tempNode);
			}

		}

	}

	// search for element in the priority queue and decrease its priority
	// to the new priority level (priority = priority – priority_delta)
	public void decrease(T element, int priority_delta) {

		// check to see if priority_delta is a negative number
		if (priority_delta < 0)
			throw new IllegalArgumentException("Cannot input a negative number as an argument");

		// loop through the Queue to find the element
		PNode prevNode = null;
		PNode tempNode = this.maxElement;
		while (tempNode != null && tempNode.getElement() != element) {
			prevNode = tempNode;
			tempNode = tempNode.getNextNode();
		}

		if (tempNode != null && tempNode.getElement() == element) {

			tempNode.setPriority(tempNode.getPriority() - priority_delta);

			if (tempNode.getNextNode() != null && tempNode.getPriority() <= tempNode.getNextNode().getPriority()) {

				if (tempNode == this.maxElement)
					remove_maximum();

				// remove the tempNode from its existing position within the list
				else
					prevNode.setNextNode(tempNode.getNextNode());

				// place Node in correct position within the Queue
				placeNode(tempNode);

			}

		}

		else
			throw new IllegalArgumentException("Element not found / Empty List");

	}

	// search for element in the priority queue and increase its priority
	// to the new priority level (priority = priority + priority_delta)
	public void increase(T element, int priority_delta) {

		// check to see if priority_delta is a negative number
		if (priority_delta < 0)
			throw new IllegalArgumentException("Cannot input a negative number as an argument");

		// loop through the Queue to find the element
		PNode prevNode = null;
		PNode tempNode = this.maxElement;
		while (tempNode != null && tempNode.getElement() != element) {
			prevNode = tempNode;
			tempNode = tempNode.getNextNode();
		}

		if (tempNode != null && tempNode.getElement() == element) {

			tempNode.setPriority(tempNode.getPriority() + priority_delta);

			if (prevNode != null && tempNode.getPriority() > prevNode.getPriority()) {

				// remove the tempNode from its existing position within the list
				prevNode.setNextNode(tempNode.getNextNode());

				// place Node in correct position within the Queue
				placeNode(tempNode);

			}

		}

		else
			throw new IllegalArgumentException("Element not found / Empty List");

	}

	// display the elements in the priority queue in order from highest
	// priority to lowest priority
	public void display() {

		String string = "";

		// check to see if the list is empty
		if (this.maxElement == null)
			string += "[Empty Queue]";

		else {

			string += "(HIGHEST PRIORITY) ";
			PNode tempNode = this.maxElement;

			while (tempNode != null) {
				string += "[" + tempNode.getElement() + "]";
				tempNode = tempNode.getNextNode();
			}

			string += " (LOWEST PRIORITY)";

		}

		System.out.println(string);

	}

}
