package priority_queue;

import java.util.*;

public class Priority_Queue<T> implements Priority_Queue_Interface<T> {

    //declare variables 
    private PNode maxElement;

//////////////////////////////////////////////////////////////////////////////////
    //inner Priority_Node class
    public class PNode<T> {

        //declare variables
        private T element;
        private int priority;
        private PNode nextNode;

        //////////////////////////////////////////////////////////////////////////
        //constructors
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
        //setter funtions 
        public void setElement(T e) {
            this.element = e;
        }

        public void setPriority(int p) {
            this.priority = p;
        }

        public void setNextNode(PNode n) {
            this.nextNode = n;
        }

        //getter functions
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

//////////////////////////////////////////////////////////////////////////////////
    //constructors
    public Priority_Queue() {
        this.maxElement = null;
    }

    public Priority_Queue(T element, int priority) {
        this.maxElement = new PNode(element, priority, null);
    }

//////////////////////////////////////////////////////////////////////////////////
    //methods
    //insert an element into the queue with a given priority (higher 
    //priority value, the higher the priority is for the data element)
    public void insert(T element, int priority) {

        //create a new Priority Node
        PNode newNode = new PNode(element, priority, null);

        //check to see if the Priority_Queue is empty
        //if it is insert in the front of the list
        if (this.maxElement == null) {
            this.maxElement = newNode;
        } //check to see if the new Priority Node has 
        //the greatest priority value
        else if (newNode.getPriority() > this.maxElement.priority) {
            newNode.setNextNode(this.maxElement);
            this.maxElement = newNode;
        } else {
            //traverse through the list and find where the new
            //Priority Node belongs (stop when reaching a node 
            //with a smaller Priority)
            PNode prevNode = null;
            PNode tempNode = this.maxElement;
            while (newNode.getPriority() <= tempNode.getPriority() && tempNode.getNextNode() != null) {
                prevNode = tempNode;
                tempNode = tempNode.getNextNode();
            }
            //if our new Priority Nodes value is the minimum
            //place it at the end of the Queue
            if (newNode.getPriority() <= tempNode.getPriority() && tempNode.getNextNode() == null) {
                tempNode.setNextNode(newNode);
            } else {
                prevNode.setNextNode(newNode);
                newNode.setNextNode(tempNode);
            }
        }

    }

    //removes the highest priority element from the priority queue
    public T remove_maximum() {

        T value = null;

        //check to see if the Queue is Empty
        if (this.maxElement != null) {
            value = (T) this.maxElement.getElement();
            PNode oldMax = this.maxElement;
            this.maxElement = this.maxElement.getNextNode();
            oldMax.setNextNode(null);
            oldMax = null;
        }

        return value;

    }

    //search for element in the priority queue and decrease its priority
    //to the new priority level (priority = priority – priority_delta)
    public void decrease(T element, int priority_delta) {

    }

    //search for element in the priority queue and increase its priority 
    //to the new priority level (priority = priority + priority_delta)
    public void increase(T element, int priority_delta) {

//        //loop through the Queue to find the element
//        PNode prevNode = null;
//        PNode tempNode = this.maxElement;
//        while (tempNode != null && tempNode.getElement() != element) {
//            prevNode = tempNode;
//            tempNode = tempNode.getNextNode();
//        }
//        if (tempNode != null && tempNode.getElement() == element) {
//            tempNode.setPriority(tempNode.getPriority() + priority_delta);
//            if (prevNode != null && tempNode.getPriority() > prevNode.getPriority()) {
//                //check to see if the new Priority Node has 
//                //the greatest priority value
//                if (tempNode.getPriority() > this.maxElement.priority) {
//                    tempNode.setNextNode(this.maxElement);
//                    this.maxElement = tempNode;
//                } else {
//                    //traverse through the list and find where the new
//                    //Priority Node belongs (stop when reaching a node 
//                    //with a smaller Priority)
//                    prevNode = null;
//                    PNode temp2Node = this.maxElement;
//                    while (tempNode.getPriority() <= temp2Node.getPriority()) {
//                        prevNode = tempNode;
//                        tempNode = tempNode.getNextNode();
//                    }
//                    prevNode.setNextNode(tempNode);
//                    tempNode.setNextNode(temp2Node);
//                }
//            }
//        } else {
//            throw new No­Such­Element­Exception("Element not found / Empty List");
//        }

    }

    //display the elements in the priority queue in order from highest 
    //priority to lowest priority
    public void display() {

        String string = "";

        //check to see if the list is empty
        if (this.maxElement == null) {
            string += "[Empty Queue]";
        } else {
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
