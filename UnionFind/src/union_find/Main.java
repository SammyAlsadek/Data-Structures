package union_find;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        String choice;
        int number, number1, number2;
        
        System.out.print("Enter Size of UnionFind Structure: ");
        int size = scan.nextInt();
        Union_Find UF = new Union_Find(size);
        System.out.println();
        
        do {
            
            System.out.println("--------------MENU--------------");
            System.out.println("(0) Exit Program");
            System.out.println("(1) Find Root of Element");
            System.out.println("(2) Unify Components");
            System.out.println("(3) Size of Component");
            System.out.println("(4) Number of Components");
            System.out.println("(5) Number of Elements");
            System.out.println("(6) isConnected?");
            System.out.println();
            System.out.print("Select Choice (0-6): ");
            choice = scan.next();
            System.out.println();

            switch (choice) {
                case "0":
                    break;
                case "1":
                    System.out.print("Enter Element Number: ");
                    number = scan.nextInt();
                    System.out.println();
                    System.out.println("Root of (" + number + ") is " + UF.find(number));
                    System.out.println();
                    break;
                case "2":
                    System.out.print("Enter First Element: ");
                    number1 = scan.nextInt();
                    System.out.println();
                    System.out.print("Enter Second Element: ");
                    number2 = scan.nextInt();
                    System.out.println();
                    UF.unify(number1, number2);
                    System.out.println("Elements (" + number1 +")'s component and (" + number2 + ")'s component are Unitied");
                    System.out.println();
                    break;
                case "3":
                    System.out.print("Enter Element Number: ");
                    number = scan.nextInt();
                    System.out.println();
                    System.out.println("(" + number + ")'s Component Size: " + UF.componentSize(number));
                    System.out.println();
                    break;
                case "4":
                    System.out.println("Number of Components in Union Find: " + UF.components());
                    System.out.println();
                    break;
                case "5":
                    System.out.println("Number of Elements in Union Find: " + UF.size());
                    System.out.println();
                    break;
                case "6":
                    System.out.print("Enter First Element: ");
                    number1 = scan.nextInt();
                    System.out.println();
                    System.out.print("Enter Second Element: ");
                    number2 = scan.nextInt();
                    System.out.println();
                    System.out.println("Elements (" + number1 +")'s component and (" + number2 + ")'s component are Connected: " + UF.connected(number1, number2));
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
