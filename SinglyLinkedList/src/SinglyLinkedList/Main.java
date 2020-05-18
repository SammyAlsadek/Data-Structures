package SinglyLinkedList;

public class Main {

    public static void main(String[] args) {
        SinglyLinkedList sll = new SinglyLinkedList();
        
        sll.addHead(0);
        sll.addHead(1);
        sll.addTail(2);
        sll.addTail(3);
        sll.addHead(4);
        sll.insertAt(5, 0);
        sll.insertAt(6, 6);
        sll.insertAt(7, 1);
        sll.insertAt(8, 3);
        sll.insertAt(9, 8);
        
        System.out.println("Removed -> " + sll.removeAt(9));
        System.out.println("Removed -> " + sll.removeAt(7));
        System.out.println("Removed -> " + sll.removeAt(1));
        System.out.println("Removed -> " + sll.removeAt(0));
        System.out.println("Removed -> " + sll.removeValue(4));
        System.out.println("Removed -> " + sll.removeValue(9));
        System.out.println("Removed -> " + sll.removeValue(0));
        System.out.println("Removed -> " + sll.removeValue(1));
        System.out.println("Removed -> " + sll.removeHead());
        System.out.println("Removed -> " + sll.removeTail());

        sll.print();
        System.out.println("Size of list -> " + sll.size());
        //System.out.println(sll.valueAt(sll.indexOf(9)));
    }

}
