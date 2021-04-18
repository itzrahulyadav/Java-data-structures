import java.util.*;

//Rahul yadav -doubly linked list

 public class DoublyLinkedList <T> implements Iterable<T>
 {
    int size=0;
    private Node<T> head=null;
    private Node<T> tail=null;
    
    //internal node class for representing data
    private class Node<T>
    {
      T data;
      Node<T> prev,next;
     
      public Node(T data,Node<T>prev,Node<T>next)
      {
        this.data=data;
        this.prev=prev;
        this.next=next;
      }
    
    @Override public String toString()
    {
      return data.toString();
    }
  }
  //method for clearing the linkedlist
   public void clear()
   {
     Node <T> trav=head;
     while(trav != null)
     {
        Node<T> next=trav.next=null;
        trav.data=null;
        trav=next;
     }
     head=tail=trav=null;
     size=0;
   }
   //method to return the size of list
   public int size()
   {
     return size;
   }
   //method to check if the list is empty
   public boolean isEmpty()
   {
     return size()==0;
   }
   //adding element to the end of linked list
   public void add(T elem)
   {
      addLast(elem);
   }
   
   //adding element to the beginning
   public void addFirst(T elem)
   {
     // if the list is empty
     if(isEmpty())
     {
       head=tail=new Node<T>(elem,null,null);
     }
     else
     {
       head.prev=new Node<T>(elem,null,head);
       head=head.prev;
     }
      size += 1;
   }
   //add to the tail of the linkedlist
    public void addLast(T elem)
    {
      //if list is empty
      if(isEmpty())
      {
         head=tail=new Node<T>(elem,null,null);
      }
      else
      {
        tail.next=new Node<T>(elem,tail,null);
        tail=tail.next;
      }
       size++;
    }
    //check the value of the first element
    public T peekFirst()
    {
      if(isEmpty())throw new RuntimeException("empty list");
      return head.data;
    }
    //check the value of the last element
    public T peekLast()
    {
      if(isEmpty())throw new RuntimeException("empty list");
      return tail.data;
    }
    //remove the first element of the list
    public T removeFirst()
    {
      if(isEmpty())
        throw new RuntimeException("empty list");
      
      T data=head.data;
      head=head.next;
      --size;
      //if the list becomes empty ,set the tail to null as well
      if(isEmpty())tail=null;
      else
        head.prev=null;//cleaning the memory
      //returning the removed data;
      return data;
    }
    
    //remove the last element of the list
    public T removeLast()
    {
      //checking if the list is empty
      if(isEmpty())
       throw new RuntimeException("empty list");
      
      T data=tail.data;
      tail=tail.prev;
      --size;
      //if the list becomes empty ,set the head to null as well
      if(isEmpty())
        head=null;
      else
       tail.next=null;//cleaning the memory
       
       
     //returning the removed data  
      return data;
    }
   //remove an random node from the list
    private T remove(Node<T> node)
    {
      if(node.prev==null)
        return removeFirst();
      if(node.next==null)
        return removeLast();
        
      //if the node to be removed is between head and tail
       node.next.prev=node.prev;
       node.prev.next=node.next;
       
       T data=node.data;
       
       node.data=null;
       node=node.prev=node.next=null;
       
       --size;
       //return the removed data
       
       return data;
       
    }
    //remove a node at a  particular index

    public T removeAt(int index)
    {
      //checking if the index is valid
      if(index < 0 || index >= size)
        throw new IllegalArgumentException();
        
      int i;
      Node<T> trav;
      
      //searching from the front of the list
      if(index < size/2)
      {
        for(i=0,trav=head;i!=index;i++)
            trav=trav.next;
      }
      else
      {
         for(i = size-1,trav=tail;i!=index;i--)
             trav=trav.prev;
      }
       return remove(trav);
     
    }
    //remove a particular value in linkedlist
    public boolean remove(Object obj)
    {
      Node<T> trav=head;
      
      if(obj==null)
      {
        for(trav=head;trav!=null;trav=trav.next)
        {
           if(trav.data == null)
           {
              remove(trav);
           }
            return true;
        }
      }
      else
      {
        for(trav=head;trav!=null;trav=trav.next)
        {
           if(obj.equals(trav.data))
           {
              remove(trav);
           }
            return true;
        }
      }
      return false;
    }
   //find the index of particular value in linked list
    public int indexOf(Object obj)
    {
       int index=0;
       Node<T>trav=head;
       
       if(obj==null)
       {
          trav=head;
          while(trav != null)
          {
            if(trav.data==null)
              return index;
            trav=trav.next;
            index++;
          }
       }
       else
       {
         trav=head;
         while(trav !=null)
         {
           if(obj.equals(trav.data))
             return index;
            trav=trav.next;
            index++;
         }
       }
       return -1;
    } 
    //check if list contains a particular value
    public boolean contains(Object obj)
    {
       return indexOf(obj) !=-1;
    }  
    @Override public java.util.Iterator<T> iterator()
    {
       return new java.util.Iterator<T>()
       {
         private Node<T> trav=head;
         @Override public boolean hasNext()
         {
            return trav !=null;
         }
         @Override public T next()
         {
           T data=trav.data;
           trav=trav.next;
           return data;
         }
       };
    }
 }

 class main
 {
   public static void main(String args[])
   { 
      DoublyLinkedList<Integer> list=new DoublyLinkedList<Integer>();
      list.add(45);
      System.out.println(list.size);
   }
 }
