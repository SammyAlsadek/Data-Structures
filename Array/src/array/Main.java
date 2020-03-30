package array;

public class Main 
{
    
    public static void main(String[] args)
    {
        Array<Integer> array = new Array();
        
        array.add(1);
        array.add(2);
        array.add(3);
        array.add(4);
        array.add(5);
        array.add(6);
        
        array.removeAt(3);
        System.out.printf("Size: %d%nIndex: %d%n", array.size(), array.indexOf(0));
        array.print();
    }
    
}
