package priority_queue;

import java.util.Scanner;

public class Main {

    public static void main(String args[]) {
        Priority_Queue<Integer> PQueue = new Priority_Queue();
        Scanner scan = new Scanner(System.in);
        String choice;
        
        do {
            System.out.println("--------------MENU--------------");
            System.out.println("(0) Exit Program");
            System.out.println("(1) Insert Element");
            System.out.println("(2) Remove Maximum Element");
            System.out.println("(3) Increase Element's Priority");
            System.out.println("(4) Decrease Element's Priority");
            System.out.println("(5) Display Priority Queue");
            System.out.println();
            System.out.print("Select Choice (0-5): ");
            choice = scan.next();
            System.out.println();
            
            switch (choice) {
                case "0":
                    break;
                case "1":
                    System.out.print("Enter New Elements Value: ");
                    int element = scan.nextInt();
                    System.out.print("Enter New Elements Priority: ");
                    int priority = scan.nextInt();
                    PQueue.insert(element, priority);
                    System.out.println();
                    System.out.println("New Element Has Been Insterted ");
                    System.out.println();
                    break;
                case "2":
                    System.out.println(PQueue.remove_maximum() + " has been removed from Queue");
                    System.out.println();
                    break;
                case "3":
                    System.out.print("Enter the Element you would like to increase the priority of: ");
                    int increase = scan.nextInt();
                    System.out.print("Enter the amount you would like to increase the priority: ");
                    int priorityInc = scan.nextInt();
                    PQueue.increase(increase, priorityInc);
                    System.out.println();
                    System.out.println("Priority has been increased ");
                    System.out.println();
                    break;
                case "4":
                    System.out.print("Enter the Element you would like to decrease the priority of: ");
                    int decrease = scan.nextInt();
                    System.out.print("Enter the amount you would like to decrease the priority: ");
                    int priorityDec = scan.nextInt();
                    PQueue.decrease(decrease, priorityDec);
                    System.out.println();
                    System.out.println("Priority has been decreased ");
                    System.out.println();
                    break;
                case "5":
                    PQueue.display();
                    System.out.println();
                    break;
                default:
                    System.out.println("Choice input by user is invalid...");
                    System.out.println();
                    break;
            }
            
        } while (!"0".equals(choice));
    }

}
