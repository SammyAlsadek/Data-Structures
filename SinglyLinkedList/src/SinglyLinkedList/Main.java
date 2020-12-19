package SinglyLinkedList;

/**
 * @author sammyalsadek
 *
 */
public class Main {

	public static void main(String[] args) {

		// test singlylinkedlist class
		SinglyLinkedList<Integer> sll = new SinglyLinkedList<Integer>();

		for (int i = 0; i < 5; i++) {
			sll.addHead(i);
			sll.addTail(i);
		}

		for (int i = 0; i < 10; i++)
			sll.insertAt(i, i);

		for (int i = 0; i < 5; i++)
			System.out.println("Index of " + i + " -> " + sll.indexOf(i));

		for (int i = 0; i < 2; i++) {
			sll.removeHead();
			sll.removeAt(i);
			sll.removeTail();
			sll.removeValue(i);
		}

		System.out.println();
		for (int i = 0; i < sll.size(); i++)
			System.out.println("Value at index " + i + " -> " + sll.valueAt(i));

		System.out.println("\nSize of list -> " + sll.size());

		System.out.print("\nList -> ");
		sll.print();

	}

}
