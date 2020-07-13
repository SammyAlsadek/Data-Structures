package priority_queue_.heap;

import java.util.*;

public class Priority_Queue<T extends Comparable<T>> {

    private int heapSize = 0; // number of elements currently inside the heap
    private int heapCapacity = 0; // the internal capacity of the heap

    // a dynamic list to track the elements inside the heap
    private List<T> heap = null;

    // this is a map that will be used to keep track of the possible indicies a 
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
        this.heap = new ArrayList(capacityNumber);
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
        
        //heapify process
        for (int i = Math.max(0, (this.heapSize/2)-1); i >= 0; i--) {
            sink(i);
        }
    }
}
