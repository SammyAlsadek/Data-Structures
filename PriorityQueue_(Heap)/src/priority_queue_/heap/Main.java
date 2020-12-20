package priority_queue_.heap;

/**
 * @author sammyalsadek
 *
 */
public class Main {

	public static void main(String[] args) {

		// test priority queue class
		Priority_Queue<Integer> pq = new Priority_Queue<Integer>();

		for (int i = 0; i < 10; i++)
			pq.add(i);

		for (int i = 0; i < 10; i += 2)
			System.out.println("Removed -> " + pq.remove(i));

		System.out.println();
		for (int i = 0; i < 3; i++)
			System.out.println("Removed -> " + pq.pull());

		System.out.println();
		for (int i = 0; i < 10; i++)
			System.out.println("Queue contains " + i + " -> " + pq.contains(i));

		System.out.println("\nNext element in queue ->" + pq.peek());

		System.out.println("\nisEmpty -> " + pq.isEmpty());

		pq.clear();
		System.out.println("\nQueue cleared");

		System.out.println("\nSize of queue -> " + pq.size());

	}

}
