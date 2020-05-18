package stack;

public class Main 
{

   public static void main(String[] args) 
   {
       Stack<Integer> stack = new Stack<>();
       
       stack.push(1);
       stack.push(2);
       stack.push(3);
       stack.push(4);
       stack.push(5);
       
       stack.pop();
       stack.pop();
       stack.pop();
       
       stack.push(1);
       stack.push(2);
       
       stack.pop();
       stack.pop();
       stack.pop();
       stack.pop();
       
       stack.peek();
       System.out.println("Empty = " + stack.empty());
       
       stack.push(1);
       stack.push(2);
       
       stack.peek();
       System.out.println("Empty = " + stack.empty());
       
       stack.search(2);
       stack.search(5);
   }
}
