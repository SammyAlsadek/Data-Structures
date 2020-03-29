package array;

public class Array<T extends Object> 
{

    private Object[] array;  // array of any data type
    private int size;   // number of items in array
    
    ////////////////////////////////////////////////////////////////////////////
    
    // general constructor in case nothing was passed in 
    public Array()
    {
        array = new Object[5];  // if no length is given create a 5 length array
        size = 0;   // initialize the size at 0
    }   
    
    // constructor for if the user inputs the arrays starting length
    public Array(int length)
    {
        array = new Object[length]; // create an array with the length given
        size = 0;   // size remains 0 until items are added
    }    
    
    ////////////////////////////////////////////////////////////////////////////
    
    // method to return the index of given values first instance in the array
    public int indexOf(T item)
    {
        int index = 0;  // initialize the index at 0
        
        // search for item in the array
        while(index < size)
        {
            if (array[index] == item) return index;
            index++;
        }
        
        // if item was not found return -1
        return -1;
    }
    
    // method to add item into array
    public void add(T item)
    {
        // if the array has to more space create a new array
        if ( array.length <= size) 
        {
            // new array with double the space
            Object[] new_array = new Object[array.length * 2]; 
            
            // copy old array to new array
            for (int i = 0; i < size; i++)
            {
                new_array[i] = array[i];
            }
            
            // set new array to array
            array = new_array;
        }
        
        // allocate item into the array and increment the size
        array[size++] = item;
    }
    
    // method that return the number of items in the array
    public int size()
    {
        return size;
    }
    
}
