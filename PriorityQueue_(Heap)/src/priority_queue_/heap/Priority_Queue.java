package priority_queue_.heap;

import java.util.*;

/**
 * @author sammyalsadek
 *
 */
public class Priority_Queue<T extends Comparable<T>> {

	// declare variables
	private int heapSize = 0; // number of elements currently inside the heap
	private int heapCapacity = 0; // the internal capacity of the heap

	// a dynamic list to track the elements inside the heap
	private List<T> heap = null;

	// this is a map that will be used to keep track of the possible indices a
	// particular node value is found in the heap
	private Map<T, TreeSet<Integer>> map = new HashMap<>();

	//////////////////////////////////////////////////////////////////////////////

	// constructors

	// initializes and empty priority queue
	public Priority_Queue() {
		this(1);
	}

	// creates a heap with an initial capacity
	public Priority_Queue(int capacityNumber) {
		this.heap = new ArrayList<>(capacityNumber);
	}

	// creates a heap with the elements as the argument to store within the
	// priority queue
	public Priority_Queue(T[] elements) {

		this.heapSize = this.heapCapacity = elements.length;
		this.heap = new ArrayList<T>(this.heapCapacity);

		// place all the elements within the heap
		for (int i = 0; i < this.heapSize; i++) {
			mapAdd(elements[i], i);
			heap.add(elements[i]);
		}

		// heapify process
		for (int i = Math.max(0, (this.heapSize / 2) - 1); i >= 0; i--)
			sink(i);

	}

	// creates priority queue with O(nlog(n))
	public Priority_Queue(Collection<T> elements) {

		this(elements.size());

		for (T element : elements)
			add(element);

	}

	//////////////////////////////////////////////////////////////////////////////

	// return true or false depending on if the heap is empty
	public boolean isEmpty() {
		return (this.heapSize == 0);
	}

	// returns the size of the heap
	public int size() {
		return this.heapSize;
	}

	// clears the heap
	public void clear() {

		for (int i = 0; i < this.heapCapacity; i++)
			heap.set(i, null);

		this.heapSize = 0;
		map.clear();

	}

	// return element in the front of the priority queue
	public T peek() {

		if (this.isEmpty())
			return null;

		return heap.get(0);

	}

	// remove and return the element at the front of the priority queue
	public T pull() {
		return removeAt(0);
	}

	// test if an element is found within the heap
	public boolean contains(T element) {

		if (element == null)
			return false;

		return map.containsKey(element);

	}

	// adds element to the priority queue
	public void add(T element) {

		// check to see if the argument is null
		if (element == null)
			throw new IllegalArgumentException();

		// add the element
		if (this.heapSize < this.heapCapacity)
			heap.set(heapSize, element);

		else {
			heap.add(element);
			this.heapCapacity++;
		}

		mapAdd(element, heapSize);
		swim(heapSize);
		this.heapSize++;

	}

	// helper method that tests to see if node i is <= node j
	private boolean less(int i, int j) {
		return heap.get(i).compareTo(heap.get(j)) <= 0;
	}

	// bottom up node swim
	private void swim(int nodeNumber) {

		int parent = (nodeNumber - 1) / 2;

		// keep swimming while root and while we're less that our parent
		while (nodeNumber > 0 && less(nodeNumber, parent)) {

			// swap the node with its parent
			swap(parent, nodeNumber);
			nodeNumber = parent;

			// get new parent
			parent = (nodeNumber - 1) / 2;

		}

	}

	// top to bottom node sink
	private void sink(int nodeNumber) {

		while (true) {

			int leftNode = 2 * nodeNumber + 1;
			int rightNode = 2 * nodeNumber + 2;
			int smallest = leftNode; // assume left node is the smallest of the two children

			// test to see if the rightNode is smaller
			// or stop when unable to sink anymore
			if (rightNode < this.heapSize && less(rightNode, leftNode))
				smallest = rightNode;

			// stop if we're outside the bounds of the tree
			// or stop if we cant sink anymore
			if (leftNode >= this.heapSize || less(nodeNumber, smallest))
				break;

			// sink the node down
			swap(smallest, nodeNumber);
			nodeNumber = smallest;

		}

	}

	// swaps two nodes assuming that i and j are valid
	private void swap(int i, int j) {

		T node1 = heap.get(i);
		T node2 = heap.get(j);

		heap.set(i, node2);
		heap.set(j, node1);

		mapSwap(node1, node2, i, j);

	}

	// removes an element within the heap
	public boolean remove(T element) {

		if (element == null)
			return false;

		Integer index = mapGet(element);

		if (index != null)
			removeAt(index);

		return (index != null);

	}

	// removes node at a particular index
	private T removeAt(int index) {

		if (isEmpty())
			return null;

		heapSize--;
		T removedData = heap.get(index);
		swap(index, heapSize);

		// obliterate the value
		heap.set(heapSize, null);
		mapRemove(removedData, heapSize);

		// removed last element
		if (index == heapSize)
			return removedData;

		T element = heap.get(index);

		// try to sink the element
		sink(index);

		// if sinking did not work try to swim
		if (heap.get(index).equals(element))
			swim(index);

		return removedData;

	}

	// add a node value and its index to the map
	private void mapAdd(T value, int index) {

		TreeSet<Integer> set = map.get(value);

		// new value being inserted in map
		if (set == null) {
			set = new TreeSet<>();
			set.add(index);
			map.put(value, set);
		}

		// if value already exists in the map
		else
			set.add(index);

	}

	// remove the index at a given value
	private void mapRemove(T value, int index) {

		TreeSet<Integer> set = map.get(value);
		set.remove(index);

		if (set.size() == 0)
			map.remove(value);

	}

	// get index of a given value
	private Integer mapGet(T value) {

		TreeSet<Integer> set = map.get(value);

		if (set != null)
			return set.last();

		return null;

	}

	// swap the index of two values within the map
	private void mapSwap(T value1, T value2, int value1Index, int value2Index) {

		TreeSet<Integer> set1 = map.get(value1);
		TreeSet<Integer> set2 = map.get(value2);

		set1.remove(value1Index);
		set2.remove(value2Index);

		set1.add(value2Index);
		set2.add(value1Index);

	}

}