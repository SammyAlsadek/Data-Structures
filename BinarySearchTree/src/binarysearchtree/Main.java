package binarysearchtree;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        Scanner scan = new Scanner(System.in);
        String choice; // users input
        
        do {

            System.out.println("--------------MENU--------------");
            System.out.println("(0) Exit Program");
            System.out.println("(1) Add Element");
            System.out.println("(2) Remove Element");
            System.out.println("(3) Size of tree");
            System.out.println("(4) isEmpty");
            System.out.println("(5) Contains");
            System.out.println("(6) PreOrder Traversal");
            System.out.println("(7) InOrder Traversal");
            System.out.println("(8) PostOrder Traversal");
            System.out.println();
            System.out.print("Select Choice (0-8): ");
            choice = scan.next();
            System.out.println();

            switch (choice) {
                case "0":
                    break;
                case "1":
                    System.out.print("What value would you like to add to the tree: ");
                    int number = scan.nextInt();
                    System.out.println();
                    System.out.println("Was the number (" + number + ") added: " + tree.add(number));
                    System.out.println();
                    break;  
                case "2":
                    System.out.print("What value would you like to remove from the tree: ");
                    int number1 = scan.nextInt();
                    System.out.println();
                    System.out.println("Was the number (" + number1 + ") removed: " + tree.remove(number1));
                    System.out.println();
                    break;   
                case "3":
                    System.out.println("The size of the tree is: " + tree.size());
                    System.out.println();
                    break;
                case "4":
                    System.out.println("Is the tree empty: " + tree.isEmpty());
                    System.out.println();
                    break;
                case "5":
                    System.out.print("What value would you like to search for in the tree: ");
                    int number2 = scan.nextInt();
                    System.out.println();
                    System.out.println("Does the list contain (" + number2 + "): " + tree.contains(number2));
                    System.out.println();
                    break;    
                case "6":
                    System.out.println("PreOrder Traversal: ");
                    tree.preOrder();
                    System.out.println();
                    break;
                case "7":
                    System.out.println("InOrder Traversal: ");
                    tree.inOrder();
                    System.out.println();
                    break;
                case "8":
                    System.out.println("PostOrder Traversal: ");
                    tree.postOrder();
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
