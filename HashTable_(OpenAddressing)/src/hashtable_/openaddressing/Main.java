package hashtable_.openaddressing;

/**
 * @author sammyalsadek
 *
 */
public class Main {

	public static void main(String[] args) {

		// test hash table
		HashTable<Integer, Integer> table = new HashTable<Integer, Integer>();

		for (int i = 0; i < 10; i++)
			table.insert(i, i);

		for (int i = 0; i < 10; i += 2)
			table.remove(i);

		for (int i = 0; i < 10; i++)
			System.out.println("Contains key " + i + " -> " + table.containsKey(i));

		System.out.println();
		for (int i = 0; i < 10; i++)
			System.out.println("Get key " + i + " -> " + table.get(i));

		System.out.println("\nSize -> " + table.size());

		table.clear();
		System.out.println("\nTable cleared");

		System.out.println("\nisEmpty -> " + table.isEmpty());

	}

}
