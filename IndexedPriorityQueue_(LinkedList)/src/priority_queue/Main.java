package priority_queue;

/**
 * @author sammyalsadek
 *
 */
public class Main {

	public static void main(String args[]) {

		// test indexed priority queue class
		Priority_Queue<Integer> pq = new Priority_Queue<Integer>();

		for (int i = 0; i < 10; i++)
			pq.insert(i, i);

		for (int i = 0; i < 10; i += 2)
			pq.increase(i, i);

		for (int i = 0; i < 10; i += 3)
			pq.decrease(i, i);

		for (int i = 0; i < 3; i++)
			pq.remove_maximum();

		pq.display();

	}

}
