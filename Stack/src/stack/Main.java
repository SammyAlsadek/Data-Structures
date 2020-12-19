package stack;

/**
 * @author sammyalsadek
 *
 */
public class Main {

	public static void main(String[] args) {

		// test stack class
		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < 10; i++)
			stack.push(i);

		for (int i = 0; i < 5; i++)
			System.out.println("Popped -> " + stack.pop());

		System.out.println("\nElement on top of stack -> " + stack.peek());

		System.out.println("\nisEmpty -> " + stack.empty());

		System.out.println();
		for (int i = 0; i < 10; i++)
			System.out.println(i + " found in posistion -> " + stack.search(i));

	}

}
