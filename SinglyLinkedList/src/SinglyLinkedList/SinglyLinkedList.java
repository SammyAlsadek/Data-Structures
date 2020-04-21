package SinglyLinkedList;

public class SinglyLinkedList<T extends Object> {

    // declare variables
    private Node head; // head of list
    private Node tail; // tail of list
    private int size; // number of items inside of list

    //////////////////////////////////////////////////////////////////////////////
    //Node class
    public class Node<T> {

        // decalre node variables
        private T data; // data of node
        private Node next; // next node in list

        //////////////////////////////////////////////////////////////////////////
        // constructors for node class
        public Node() {
            data = null; // initialize the data to null
            next = null; // as well as the next node
        }

        public Node(T d) {
            data = d; // initialize the data to the argument received
            next = null; // initialize the next node to null
        }

        //////////////////////////////////////////////////////////////////////////
        // setter and getter methods
        public void setData(T d) {
            data = d;
        }

        public void setNext(Node n) {
            next = n;
        }

        public T getData() {
            return data;
        }

        public Node getNext() {
            return next;
        }

    }

    //////////////////////////////////////////////////////////////////////////////
    // constructors for singlylinkedlist class
    public SinglyLinkedList() {
        head = null;
        tail = head;
        size = 0;
    }

    public SinglyLinkedList(T d) {
        head = new Node(d);
        tail = head;
        size = 1;
    }

    //////////////////////////////////////////////////////////////////////////////
    // method that returns the sixe of the linked list
    public int size() {
        return size;
    }

    // method that adds to the head of the list
    public void addHead(T d) {
        Node nNode = new Node(d); // create new node with data given

        // check if list is empty
        if (head == null) {
            head = nNode;
            tail = head;
            size++;
        } else {
            nNode.setNext(head);
            head = nNode;
            size++;
        }
    }

    // method that adds to the tail of the list
    public void addTail(T d) {
        Node nNode = new Node(d); // create new node with data given

        // check if list is empty
        if (head == null) {
            head = nNode;
            tail = head;
            size++;
        } else {
            tail.setNext(nNode);
            tail = nNode;
            size++;
        }
    }

    //method that adds to an index
    public void insertAt(T d, int p) {
        Node nNode = new Node(d); // create new node with data given

        // check if list is empty
        if (head == null) {
            head = nNode;
            tail = head;
            size++;
        } else {
            if (p < 0) {
                throw new IllegalArgumentException("position must be >= 0");
            } else if (p == 0) {
                addHead(d);
            } else if (p >= size) {
                addTail(d);
            } else {
                Node temp = head;
                for (int i = 1; i < p; i++) {
                    temp = temp.getNext();
                }
                nNode.setNext(temp.getNext());
                temp.setNext(nNode);
                size++;
            }
        }
    }

    // method that returns value at index
    public T valueAt(int index) {
        // check to see if the list is empty
        if (head == null) {
            throw new IllegalArgumentException("List is empty");
        }

        // check edge cases
        if (index < 0) {
            throw new IllegalArgumentException("index can not be less than 0");
        }
        // if the index is larger or equal to the list size just return the last item to the user
        if (index >= size) {
            index = size - 1;
        }

        // loop through array until the index is found
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.getNext();
        }
        return (T) temp.getData();
    }

    // method that returns the index of a value
    public int indexOf(T value) {
        int index = 0; // initialize index at 0
        Node temp = head; // and initialize the temp at head

        // check to see if the list is empty
        if (head == null) {
            throw new IllegalArgumentException("List is empty");
        }

        // loop through array until the value is found
        while (temp != null) {
            if (temp.getData() == value) {
                return index;
            }
            index++;
            temp = temp.getNext();
        }

        // if value was not found
        throw new IllegalArgumentException("Value was not found in the list");
    }
    
    // method to remove head of list
    public T removeHead() {
        // check to see if the list is empty
        if (head == null) {
            return null;
        }
        // check to see if the list only has one item
        if (head.getNext() == null) {
            T data = (T) head.getData();
            head = null;
            tail = null;
            size--;
            return data;
        }
        Node temp = head;
        head = temp.getNext(); // declare the second item in the node to be the head
        T data = (T) temp.getData(); // save the temps data
        temp = null; // and then make temp = null;
        size--; // decrement the size
        return data; // return the old heads data
    }
    
    // method to remove tail of list
    public T removeTail() {
        // check to see if the list is empty
        if (tail == null) {
            return null;
        }
        // check to see if the list only has one item
        if (head.getNext() == null) {
            T data = (T) head.getData();
            head = null;
            tail = null;
            size--;
            return data;
        }
        // loop through the list until the next item is the tail
        Node temp = head;
        while (temp.getNext() != tail) {
            temp = temp.getNext();
        }
        T data = (T) tail.getData(); // save the temps data
        tail = temp;
        temp.setNext(null);
        size--; // decrement the size
        return data; // return the old heads data
    }
    
//    // method to remove item at certain index
//    public T removeAt(int index) {
//        
//    }

    // method that prints out the list
    public void print() {
        if (head == null) {
            return;
        }
        //loop through list and print out each object
        Node temp = head;
        while (temp != null) {
            System.out.print("[" + temp.getData() + "]");
            temp = temp.getNext();
        }
        System.out.println();
    }

}
