package hashtable_.separatechaining;

import java.util.*;

//////////////////////////////////////////////////////////////////////////////////

class Entry <K, V> {
    
    int hash; // hash of this entry
    K key; V value; // key and value of the entry
    
    // initializes this entry with its variables
    public Entry(K key, V value) {
        this.key = key;
        this.value = value;
        this.hash = key.hashCode();
    }
    
    public boolean equals(Entry<K, V> other) {
        if (this.hash != other.hash) return false; // if hashes are not equal return false
        return key.equals(other.key); // else compare the keys and return the result
    }
    
} 

//////////////////////////////////////////////////////////////////////////////////

public class HashTable <K, V> { 

    // class variables 
    private static final int DEFAULT_CAPACITY = 3;
    private static final double DEFAULT_LOAD_FACTOR = 0.75;
    
    private double maxLoadFactor;
    private int capacity, threshold, size = 0;
    private LinkedList <Entry<K,V>> [] table;
    
    //////////////////////////////////////////////////////////////////////////////
    
    // contructors
    public HashTable () {this(DEFAULT_CAPACITY, DEFAULT_LOAD_FACTOR);}
    
    public HashTable (int capacity) {this(capacity, DEFAULT_LOAD_FACTOR);}
    
    public HashTable (int capacity, double maxLoadFactor) {
        
        // check for illegal arguments given by user 
        if (capacity < 0) 
            throw new IllegalArgumentException("Illegal Capacity");
        if (maxLoadFactor <= 0 || Double.isNaN(maxLoadFactor) || Double.isInfinite(maxLoadFactor))
            throw new IllegalArgumentException("Illegal maxLoadFactor");
        
        // initialize class variables
        this.maxLoadFactor = maxLoadFactor;
        this.capacity = Math.max(DEFAULT_CAPACITY, capacity);
        threshold = (int) (this.capacity * this.maxLoadFactor);
        table = new LinkedList[this.capacity];
        
    }
    
    //////////////////////////////////////////////////////////////////////////////
    
    // returns the number of elements within the HashTable
    public int size() {return size;}
    
    // returns a true/false depending on if the HashTabke is empty or not
    public boolean isEmpty() {return size == 0;}
    
    // converts the given hash value to a usable index. Gets rid of the values 
    // negative sign and places the value in the domain of [0, capacity)
    private int normalizeIndex(int keyHash) {return (keyHash & 0x7FFFFFFF) % capacity;}
    
    // clear all contents of the HashTable
    public void clear() {
        Arrays.fill(table, null);
        size = 0;
    }
    
    // returns true/false depending on whether the HashTable contains a key
    public boolean containsKey(K key) {
        int bucketIndex = normalizeIndex(key.hashCode());
        return bucketSeekEntry(bucketIndex, key) != null;
    }
    
    // inserts a key and its value in the HashTable
    public V insert(K key, V value) {
        if (key == null) throw new IllegalArgumentException("Null Key");
        Entry<K,V> newEntry = new Entry<>(key, value);
        int bucketIndex = normalizeIndex(newEntry.hash);
        return bucketInsertEntry(bucketIndex, newEntry);
    }
    
    // get return the value of a key found in the HashTable
    // return null if key not found or if value is null
    public V get(K key) {
        if (key == null) return null;
        int bucketIndex = normalizeIndex(key.hashCode());
        Entry<K,V> entry = bucketSeekEntry(bucketIndex, key);
        if (entry != null) return entry.value;
        return null;
    }
    
    // removes a key from the HashTable and returns its value
    // return null if the value is null and if the key does not exist
    public V remove(K key)  {
        if (key == null) return null;
        int bucketIndex = normalizeIndex(key.hashCode());
        return bucketRemoveEntry(bucketIndex, key);
    }
    
    // removes an entry from a given bucket if it exists
    private V bucketRemoveEntry(int bucketIndex, K key) {
        Entry<K,V> entry = bucketSeekEntry(bucketIndex, key);
        if (entry == null) return null;
        
        LinkedList <Entry<K,V>> links = table[bucketIndex];
        links.remove(entry);
        size--;
        return entry.value;
    }
    
    // inserts an entry to a given bucket if it does not exist
    // updates value if it does exist
    private V bucketInsertEntry(int bucketIndex, Entry<K,V> entry) {
        LinkedList <Entry<K,V>> bucket = table[bucketIndex];
        if (bucket == null) table[bucketIndex] = bucket = new LinkedList<>();
        
        Entry<K,V> existentEntry = bucketSeekEntry(bucketIndex, entry.key);
        if (existentEntry == null) {
            bucket.add(entry);
            if (size++ > threshold) resizeTable();
            return null; // indecates that there was no previous entry
        } else {
            V oldVal = existentEntry.value;
            existentEntry.value = entry.value;
            return oldVal;
        }
    }
    
    // finds and return an entry within a given bucket
    // returns null otherwise
    private Entry<K,V> bucketSeekEntry(int bucketIndex, K key) {
        if (key == null) return null; // returns null is key is null
        LinkedList<Entry<K,V>> bucket = table[bucketIndex];
        if (bucket == null) return null; // returns null if the bucket is empty
        for (Entry<K,V> entry : bucket)
            if (entry.key.equals(key))
                return entry;
        return null; // returns null if the entry is not found
    }
    
    // resizes the table holding bucekts of entries
    private void resizeTable() {
        capacity *= 2;
        threshold = (int) (capacity * maxLoadFactor);
        
        LinkedList <Entry<K,V>> [] newTable = new LinkedList[capacity];
        
        for (int i = 0; i < table.length; i++) {
            if (table[i] != null) {
                
                for (Entry<K,V> entry : table[i]) {
                    int bucketIndex = normalizeIndex(entry.hash);
                    LinkedList<Entry<K,V>> bucket = newTable[bucketIndex];
                    if (bucket == null) newTable[bucketIndex] = bucket = new LinkedList<>();
                    bucket.add(entry);
                }
                
                // to avoid any memory leaks
                table[i].clear();
                table[i] = null;
                
            }
        }
        
        table = newTable;
    }
    
}
