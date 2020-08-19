package fenwicktree_.binaryindexedtree;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        long [] array = {0,1,2,3,4,5,6,7,8,9};
        FenwickTree ft = new FenwickTree(array);
        Scanner scan = new Scanner(System.in);
        String choice;
        
        do {
            
            System.out.println("--------------MENU--------------");
            System.out.println("(0) Exit Program");
            System.out.println("(1) Add Value to an Index");
            System.out.println("(2) Set Value of an Index");
            System.out.println("(3) Get PrefixSum of an Index");
            System.out.println("(4) Get Sum Between Two Indices");
            System.out.println("(5) Print Fenwick Tree");
            System.out.println();
            System.out.print("Select Choice (0-5): ");
            choice = scan.next();
            System.out.println();

            switch (choice) {
                case "0":
                    break;
                case "1":
                    System.out.print("Insert index you would like to add a value to: ");
                    int index = scan.nextInt();
                    System.out.println();
                    System.out.print("Insert value you would like to add to the index: ");
                    long number = scan.nextLong();
                    System.out.println();
                    ft.add(index, number);
                    System.out.println(number + " added to index " + index + "!");
                    System.out.println();
                    break;  
                case "2":
                    System.out.print("Insert index you would like to set the value of: ");
                    int index1 = scan.nextInt();
                    System.out.println();
                    System.out.print("Insert value you would like to set the index to: ");
                    long value = scan.nextLong();
                    System.out.println();
                    ft.set(index1, value);
                    System.out.println("Index " + index1 + " set to " + value + "!");
                    System.out.println();
                    break;  
                case "3":
                    System.out.print("Insert index you would like to get the PrefixSum for: ");
                    int index2 = scan.nextInt();
                    System.out.println();
                    System.out.println("PrefixSum of index " + index2 + ": " + ft.prefixSum(index2));
                    System.out.println();
                    break;      
                case "4":
                    System.out.print("Insert first index (1st index <= 2nd index): ");
                    int i = scan.nextInt();
                    System.out.println();
                    System.out.print("Insert second index (1st index <= 2nd index): ");
                    int j = scan.nextInt();
                    System.out.println();
                    System.out.println("Sum between of index " + i + " and index " + j + ": " + ft.sum(i, j));
                    System.out.println();
                    break;    
                case "5":
                    System.out.println(ft.toString());
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
