package fenwicktree_.binaryindexedtree;

public class FenwickTree {
    
    // this array contains the fenwick tree ranges
    private long [] tree;
    
    //////////////////////////////////////////////////////////////////////////////
   
    // constructors
    
    // creates an empty fenwick tree
    public FenwickTree(int size) {tree = new long [size + 1];}
    
    // make sure the 'values' array is one based meaning
    // values[0] does not get used, O(n) construction
    public FenwickTree(long [] values) {
        
        if (values == null) 
            throw new IllegalArgumentException("Values array is null");
        
        // make a clone of the 'values' array since we manipulate
        // the array in place destroying all its original content
        tree = values.clone();
        
        for (int i = 1; i < tree.length; i++) {
            int j = i + lsb(i);
            if (j < tree.length) tree[j] += tree[i];
        }
        
    }
    
    // returns the value of the least significant bit 
    // lsb(5) => 5 => 0101 => 010(1) => 0001 => 1
    private int lsb(int i) {
        
        // isolate the lowest one bit value
        return i & -i;
        
        // example1: i = 5 = 0101
        // -i = 1011 (2's compliment)
        // 0101 & 1011 = 0001 = 1
        
        // example2: i = 8 = 1000
        // -i = 1000 (2's compliment)
        // 1000 & 1000 = 1000 = 8
        
        // another alternate method is to use java's built
        // in method return Integer.lowestOneBit(i);
        
    }
    
    // computes the prefix sum from [1, i], one based
    public long prefixSum(int i) {
        long sum = 0L;
        while (i != 0) {
            sum += tree[i];
            i &= ~lsb(i); // pretty much i -= lsb(i) 
        }
        return sum;
    }
    
    // returns the sum of the interval [i, j], one based
    public long sum(int i, int j) {
        if (j < i) throw new IllegalArgumentException("j must be >= i");
        return prefixSum(j) - prefixSum(i-1);
    }
    
    // adds 'k' to index 'i', one based
    public void add(int i, long k) {
        while (i < tree.length) {
            tree[i] += k;
            i += lsb(i);
        }
    }
    
    // set index i to be equal to k, one based
    public void set(int i, long k) {
        long value = sum(i, i);
        add(i, k - value);
    }
    
    // returns a string of the fenwick tree
    @Override public String toString() {
        String string = "";
        for (int i = 0; i < tree.length; i++) string += "[" + tree[i] + "]";
        return string;
    }
    
}
