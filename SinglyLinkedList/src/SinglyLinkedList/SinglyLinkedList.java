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
        }
        else {
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
        }
        else {
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
        }
        else {
            if (p < 0) throw new IllegalArgumentException("position must be >= 0"); 
            else if (p == 0) addHead(d);
            else if (p >= size) addTail(d);
            else {
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
    
    // method that prints out the list
    public void print() {
        if (head == null) return;
        //loop through list and print out each object
        Node temp = head;
        while (temp != null) {
            System.out.print("[" + temp.getData() + "]");
            temp = temp.getNext();
        }
        System.out.println();
    }
    
}
