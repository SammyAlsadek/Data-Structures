package array;

public class Main 
{
    
    public static void main(String[] args)
    {
    	// testing 
        Array<Integer> array = new Array();
        
        array.add(1);
        array.add(2);
        array.add(3);
        array.add(4);
        array.add(5);
        array.add(6);
        array.add(7);
        array.add(8);
        array.add(9);
        array.add(10);
        
        array.removeAt(array.indexOf(2));
        array.removeAt(array.indexOf(4));
        array.removeAt(array.indexOf(6));
        array.removeItem(8);
        array.removeItem(10);
        
        System.out.printf("Size of Array: %d%n", array.size());
        array.print();
    }
    
}
