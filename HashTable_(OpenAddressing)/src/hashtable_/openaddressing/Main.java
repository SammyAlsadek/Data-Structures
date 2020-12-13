package hashtable_.openaddressing;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        HashTable<String,Integer> table = new HashTable<>();
        Scanner scan = new Scanner(System.in);
        String choice;
        
        do {
            
            System.out.println("--------------MENU--------------");
            System.out.println("(0) Exit Program");
            System.out.println("(1) Add Entry");
            System.out.println("(2) Remove Entry");
            System.out.println("(3) Get Value");
            System.out.println("(4) Clear Table");
            System.out.println("(5) containsKey");
            System.out.println("(6) isEmpty");
            System.out.println("(7) Size");
            System.out.println();
            System.out.print("Select Choice (0-7): ");
            choice = scan.next();
            System.out.println();

            switch (choice) {
                case "0":
                    break;
                case "1":
                    System.out.print("Enter Key: ");
                    String k = scan.next();
                    System.out.println();
                    System.out.print("Enter Value: ");
                    int v = scan.nextInt();
                    System.out.println();
                    System.out.println("New Entry Inserted! Old Value (" + table.insert(k, v) + ")");
                    System.out.println();
                    break;  
                case "2":
                    System.out.print("Enter Key to Remove from Table: ");
                    String k1 = scan.next();
                    System.out.println();
                    System.out.println("Key Removed! Old Value (" + table.remove(k1) + ")");
                    System.out.println();
                    break;  
                case "3":
                    System.out.print("What key would to like to find the value of: ");
                    String key = scan.next();
                    System.out.println();
                    System.out.println("Value of (" + key + "): " + table.get(key));
                    System.out.println();
                    break;      
                case "4":
                    table.clear();
                    System.out.println("Table Cleared!");
                    System.out.println();
                    break;    
                case "5":
                    System.out.print("What key would to like to find in the table: ");
                    String string = scan.next();
                    System.out.println();
                    System.out.println("Table Contains (" + string + "): " + table.containsKey(string));
                    System.out.println();
                    break;
                case "6":
                    System.out.println("isEmpty: " + table.isEmpty());
                    System.out.println();
                    break;    
                case "7":
                    System.out.println("Size of the Table: " + table.size());
                    System.out.println();
                    break;
                default:
                    System.out.println("Invalid input");
                    System.out.println();
                    break;
            }

        } while (!"0".equals(choice));
    }
    
}
