package queue;

public class Main {

    public static void main(String[] args) {
        Queue queue = new Queue();
        
        System.out.println("Size of Queue: " + queue.size());
        System.out.println("First in Queue: " + queue.peek());
        
        for(int i = 0; i < 5; i++)
            queue.add(i);
        
        System.out.println("Size of Queue: " + queue.size());
        System.out.println("First in Queue: " + queue.element());
        
        for(int i = 0; i < 2; i++)
            System.out.println("Remove -> " + queue.poll());
        
        for(int i = 0; i < 3; i++)
            System.out.println("Remove -> " + queue.remove());
        
        System.out.println("Size of Queue: " + queue.size());
        System.out.println("First in Queue: " + queue.peek());
    }
    
}
