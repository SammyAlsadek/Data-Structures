package priority_queue;

import priority_queue.Priority_Queue.PNode;

interface Priority_Queue_Interface<T extends Object> {

    //insert an element into the queue with a given priority (higher 
    //priority value, the higher the priority is for the data element)
    public void insert(T element, int priority);

    //removes the highest priority element from the priority queue
    public T remove_maximum();

    //search for element in the priority queue and decrease its priority
    //to the new priority level (priority = priority – priority_delta)
    public void decrease(T element, int priority_delta);

    //search for element in the priority queue and increase its priority 
    //to the new priority level (priority = priority + priority_delta)
    public void increase(T element, int priority_delta);

    //display the elements in the priority queue in order from highest 
    //priority to lowest priority
    public void display();

    //places Node in proper position withing the queue
    public void placeNode(PNode newNode);

}
