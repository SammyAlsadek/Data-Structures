package priority_queue;

public class Main {

    public static void main(String args[]) {
        Priority_Queue<Integer> PQueue = new Priority_Queue();
        
        PQueue.insert(1, 25);
        PQueue.insert(2, 20);
        PQueue.insert(3, 15);
        PQueue.insert(4, 10);
        PQueue.insert(5, 5);
        
        PQueue.remove_maximum();
        PQueue.remove_maximum();
        PQueue.remove_maximum();
        PQueue.remove_maximum();
        PQueue.remove_maximum();
        
        PQueue.display();
    }

}
