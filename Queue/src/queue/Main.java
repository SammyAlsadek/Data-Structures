package queue;

/**
 * @author sammyalsadek
 *
 */
public class Main {

	public static void main(String[] args) {

		// test queue class
		Queue<Integer> queue = new Queue<Integer>();

		for (int i = 0; i < 10; i++)
			queue.add(i);

		for (int i = 0; i < 10; i += 2)
			System.out.println("Removed -> " + queue.poll());

		System.out.println("\nSize of Queue -> " + queue.size());
		
		System.out.println("\nFirst in Queue -> " + queue.peek());
		
	}

}
