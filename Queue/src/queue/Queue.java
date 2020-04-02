package queue;

import java.util.NoSuchElementException;

public class Queue<T extends Object>
{
    // declaration of queue variable
    private Node head; // first in the queue
    private Node tail; // last in the queue
    private int size = 0; // number of items in the queue
    
////////////////////////////////////////////////////////////////////////////////
    
    // constructor
    public Queue()
    {
        head = null;
        tail = head;
    }
    
    public Queue(T d)
    {
        add(d);
    }
    
////////////////////////////////////////////////////////////////////////////////
    
    // node class to use within the queue class
    private class Node<T>
    {
        // variable declaration 
        private T data; // data held in node
        private Node next; // next node referneced
        
        ////////////////////////////////////////////////////////////////////////
        
        public Node(T d)
        {
            setData(d);
            setNext(null);
        }
        
        ////////////////////////////////////////////////////////////////////////
        
        // setter and getter methods for the node class
        public void setData(T d)
        {
            data = d;
        }
        
        public void setNext(Node n)
        {
            next = n;
        }
        
        public T getData()
        {
            return data;
        }
        
        public Node getNext()
        {
            return next;
        }
    }
    
////////////////////////////////////////////////////////////////////////////////

    // used to add an element to the tail of the queue
    public void add(T d)
    {
        Node new_node = new Node(d); // create new node that hold given data 
        
        // check to see if the queue is empty
        if(head == null)
        {
            head = new_node;
            tail = head;
        }
        else
        {
            tail.setNext(new_node);
            tail = new_node;
        }
        
        // increment the size of the queue
        size++;
    }
    
    // method that returns the head element. returns null if queue is empty
    public T peek()
    {
        if(head == null)
        {
            return null;
        }
        return (T) head.data;
    }
    
    // method that returns the head element. returns NoSuchElementException if queue is empty
    public T element()
    {
        if(head == null)
        {
            throw new NoSuchElementException();
        }
        return (T) head.data;
    }
    
    // removes the head of the queue. return NoSuchElementException if queue is empty
    public T remove()
    {
        if(head == null)
        {
            throw new NoSuchElementException();
        }
        
        Node temp = head;
        head = head.getNext();
        size--;
        return (T) temp.data;
    }
    
    // removes the head of the queue. return null if queue is empty
    public T poll()
    {
        if(head == null)
        {
            return null;
        } 
        
        Node temp = head;
        head = head.getNext();
        size--;
        return (T) temp.data;
    }
    
    // return the number of elements in the queue
    public int size()
    {
        return size;
    }
}