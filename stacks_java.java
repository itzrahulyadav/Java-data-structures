import java.util.*;

 
//implementing stack using linkedlists collection 
 
 public class Stack <T> implements Iterable <T>
 {
    LinkedList<T> list=new LinkedList<T>();
    
    // create  an empty stack 
     public Stack(){}
     
    //create an stack with an initial element
     public Stack(T firstElem)
     {
        push(firstElem);
     } 
     //number of elements in the stack
     public int size()
     {
       return list.size();
     }
     //check if the stack is empty
     public boolean isEmpty()
     {
       return size()==0;
     }
     //push element on the stack
     public void push(T elem)
     {
        list.addLast(elem);
     }
     //pop an element from the stack if its not empty
     public T pop()
     {
       if(isEmpty())
        throw new java.util.EmptyStackException();
       
        return list.removeFirst();
     }
     //peek the top element of the stack without removing it 
     public T peek()
     {
       if(isEmpty())
        throw new java.util.EmptyStackException();
        
       return list.peekFirst();
     }
     //an iterator to allow users to iterate through the stack
     @Override public java.util.Iterator<T> iterator()
     {
       return list.iterator();
     }
     
 }
 class main 
 {
   public static void main(String args[])
   { 
     Stack<Integer> stack=new Stack<Integer>();
     for(int i=0;i<10;i++)
     {
       //pushing random elements in the stack
       Random random=new Random();
       int random_num=random.nextInt(1000);
       stack.push(random_num);
     }
     
     //iterating through the stack using iterator
     Iterator<Integer> it=stack.iterator();
     while(it.hasNext())
      System.out.println(it.next());
   }
 }
