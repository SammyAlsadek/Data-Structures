package hashtable_.openaddressing;

public class HashTable<K, V> {

	// declare variable
	private double loadFactor;
	private int capacity, threshold;

	// used buckets keeps track of the total number of used buckets within the
	// HashTable. Keycount tracks the number of unique keys held within the
	// HashTable
	private int usedBuckets = 0, keyCount = 0;

	// these arrays store the key-value pairs
	private K[] keyTable;
	private V[] valueTable;

	// flag used to indicate whether an item was found in the HashTable
	private boolean containsFlag = false;

	// special marker token used to indicate the deletion of a key-value pair
	@SuppressWarnings("unchecked")
	private final K TOMBSTONE = (K) new Object();

	// the default parameters of the HashTable
	private static final int DEFAULT_CAPACITY = 8;
	private static final double DEFAULT_LOAD_FACTOR = 0.45;

	//////////////////////////////////////////////////////////////////////////////

	// contructors
	public HashTable() {
		this(DEFAULT_CAPACITY, DEFAULT_LOAD_FACTOR);
	}

	public HashTable(int capacity) {
		this(capacity, DEFAULT_LOAD_FACTOR);
	}

	@SuppressWarnings("unchecked")
	public HashTable(int capacity, double loadFactor) {

		// capacity must be > 0, else throw exception
		if (capacity <= 0)
			throw new IllegalArgumentException("Illegal Capacity");

		// loadFactor must be > 0 and a finite number, else throw exception
		if (loadFactor <= 0 || Double.isNaN(loadFactor) || Double.isInfinite(loadFactor))
			throw new IllegalArgumentException("Illegal loadFactor");

		// initialize the variables
		this.loadFactor = loadFactor;
		this.capacity = Math.max(DEFAULT_CAPACITY, next2Power(capacity));
		threshold = (int) (this.capacity * this.loadFactor);

		// initialize the tables
		keyTable = (K[]) new Object[this.capacity];
		valueTable = (V[]) new Object[this.capacity];

	}

	//////////////////////////////////////////////////////////////////////////////

	// this method finds the next power of two of a given number
	private static int next2Power(int number) {
		return Integer.highestOneBit(number) << 1;
	}

	// quadratic probing function (x^2+x)/2
	private static int P(int x) {
		return ((x * x) + x) >> 1;
	}

	// converts a hash value into an index
	private int normalizeIndex(int keyHash) {
		return (keyHash & 0x7FFFFFFF) % capacity;
	}

	// clears the contents of the hash table
	public void clear() {

		for (int i = 0; i < capacity; i++) {
			keyTable[i] = null;
			valueTable[i] = null;
		}

		keyCount = usedBuckets = 0;

	}

	// method returns number of keys inside the hash table
	public int size() {
		return keyCount;
	}

	// return true/false depending on if the hash table is empty
	public boolean isEmpty() {
		return keyCount == 0;
	}

	// inserts a new key-value pair if non-existent in hash table,
	// else updates the value of the key
	public V insert(K key, V value) {

		if (key == null)
			throw new IllegalArgumentException("Null Key");

		if (usedBuckets >= threshold)
			resizeTable();

		final int hash = normalizeIndex(key.hashCode());
		int i = hash, j = -1, x = 1;

		do {

			// the current slot was previously deleted
			if (keyTable[i] == TOMBSTONE) {

				if (j == -1)
					j = i;

			}

			// the current cell already contains a key
			else if (keyTable[i] != null) {

				// the key we are trying to insert already exists in the
				// hash table, so update its value with the new value
				if (keyTable[i].equals(key)) {

					V oldValue = valueTable[i];

					if (j == -1) {
						valueTable[i] = value;
					}

					else {
						keyTable[i] = TOMBSTONE;
						valueTable[i] = null;
						keyTable[j] = key;
						valueTable[j] = value;
					}

					return oldValue;

				}

			}

			// current cell is null so an insertion/ update can occur
			else {

				// no previously encountered deleted buckets
				if (j == -1) {
					usedBuckets++;
					keyCount++;
					keyTable[i] = key;
					valueTable[i] = value;

				}

				// previously seen deleted bucket. Instead of inserting
				// the new element at i where the null is found, insert
				// it where the deleted element was found
				else {
					keyCount++;
					keyTable[j] = key;
					valueTable[j] = value;
				}

				return null;

			}

			i = normalizeIndex(hash + P(x++));

		} while (true);

	}

	// returns true/false on whether a given key if found within the hash table
	public boolean containsKey(K key) {

		// sets the 'containsFlag'
		get(key);

		// return the 'containsFlag'
		return containsFlag;

	}

	// returns the value associated with the key value.
	// returns null if the key is not found or if the
	// value itself is null
	public V get(K key) {

		if (key == null)
			throw new IllegalArgumentException("Null key");

		final int hash = normalizeIndex(key.hashCode());
		int i = hash, j = -1, x = 1;

		do {

			if (keyTable[i] == TOMBSTONE) {

				if (j == -1)
					j = i;

			}

			else if (keyTable[i] != null) {

				if (keyTable[i].equals(key)) {

					containsFlag = true;

					// if j != -1 thid means that a tombstone was passed.
					// to be more efficient we will swap the found index
					// with the tombstone to make the search more efficient
					if (j != -1) {

						// copy the values into the tombstone
						keyTable[j] = keyTable[i];
						valueTable[j] = valueTable[i];

						// delete all contents in bucket i and mark as deleted
						keyTable[i] = TOMBSTONE;
						valueTable[i] = null;

						return valueTable[j];

					}

					else
						return valueTable[i];

				}

			}

			else {

				containsFlag = false;

				return null;

			}

			i = normalizeIndex(hash + P(x++));

		} while (true);

	}

	// removes a key-value pair from within the hash table
	// and return the value. Returns null if the value does
	// not exist or if the value is equal to null
	public V remove(K key) {

		if (key == null)
			throw new IllegalArgumentException("Null key");

		final int hash = normalizeIndex(key.hashCode());
		int i = hash, x = 1;

		for (;; i = normalizeIndex(hash + P(x++))) {

			if (keyTable[i] == TOMBSTONE)
				continue;

			if (keyTable[i] == null)
				return null;

			if (keyTable[i].equals(key)) {

				keyCount--;
				V oldValue = valueTable[i];
				keyTable[i] = TOMBSTONE;
				valueTable[i] = null;
				return oldValue;

			}

		}

	}

	// double the size of the hash table
	@SuppressWarnings("unchecked")
	private void resizeTable() {

		capacity *= 2;
		threshold = (int) (capacity * loadFactor);

		K[] oldKeyTable = (K[]) new Object[capacity];
		V[] oldValueTable = (V[]) new Object[capacity];

		// perform key table pointer swapper
		K[] keyTableTemp = keyTable;
		keyTable = oldKeyTable;
		oldKeyTable = keyTableTemp;

		// perform value table pointer swapper
		V[] valueTableTemp = valueTable;
		valueTable = oldValueTable;
		oldValueTable = valueTableTemp;

		// reset the key counter and the used buckets counter
		keyCount = usedBuckets = 0;

		// loop through the old table and insert all of the elements
		// into the newly size table
		for (int i = 0; i < oldKeyTable.length; i++) {

			if (oldKeyTable[i] != null && oldKeyTable[i] != TOMBSTONE)
				insert(oldKeyTable[i], oldValueTable[i]);

			oldValueTable[i] = null;
			oldKeyTable[i] = null;

		}

	}

}
