package priority_queue_.heap;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        Priority_Queue<Integer> pq = new Priority_Queue<Integer>();
        Scanner scan = new Scanner(System.in);
        String choice;
        
        do {
            
            System.out.println("--------------MENU--------------");
            System.out.println("(0) Exit Program");
            System.out.println("(1) Insert Element");
            System.out.println("(2) Remove Next Element");
            System.out.println("(3) Remove Specific Element");
            System.out.println("(4) Peek At Next Element");
            System.out.println("(5) Queue Contains?");
            System.out.println("(6) Queue Empty?");
            System.out.println("(7) Clear Queue");
            System.out.println("(8) Size Of Queue");
            System.out.println();
            System.out.print("Select Choice (0-8): ");
            choice = scan.next();
            System.out.println();
            
            switch(choice) {
                case "0":
                    break;
                case "1":
                    try {
                        System.out.print("Input Integer to add to the Queue: ");
                        int number = scan.nextInt();
                        pq.add(number);
                        System.out.println();
                        System.out.println("Element (" + number + ") added");
                        System.out.println();
                    } catch (Exception e) {
                        System.out.println();
                        System.out.println(e + ": argument must be an integer");
                        System.out.println();
                        scan.next();
                    }
                    break;
                case "2":
                    System.out.println("Element Removed: " + pq.pull());
                    System.out.println();
                    break;
                case "3":
                    try {
                        System.out.print("Input Integer to remove from the Queue: ");
                        int number = scan.nextInt();
                        System.out.println();
                        System.out.println("Element (" + number + ") removed: " + pq.remove(number));
                        System.out.println();
                    } catch (Exception e) {
                        System.out.println();
                        System.out.println(e + ": argument must be an integer");
                        System.out.println();
                        scan.next();
                    }
                    break;
                case "4":
                    System.out.println("Next Element in Queue: " + pq.peek());
                    System.out.println();
                    break;
                case "5":
                    try {
                        System.out.print("Input Integer to check if it is contained in the Queue: ");
                        int number = scan.nextInt();
                        System.out.println();
                        System.out.println("Queue Contains (" + number + "): " + pq.contains(number));
                        System.out.println();
                    } catch (Exception e) {
                        System.out.println();
                        System.out.println(e + ": argument must be an integer");
                        System.out.println();
                        scan.next();
                    }
                    break;
                case "6":
                    System.out.println("Queue Empty: " + pq.isEmpty());
                    System.out.println();
                    break;
                case "7":
                    pq.clear();
                    System.out.println("Queue Cleared");
                    System.out.println();
                    break;
                case "8":
                    System.out.println("Size of Queue: " + pq.size());
                    System.out.println();
                    break;
                default:
                    System.out.println("Invalid Input");
                    System.out.println();
                    break;
            }
            
        } while(!choice.equals("0"));
        
    }
    
}
