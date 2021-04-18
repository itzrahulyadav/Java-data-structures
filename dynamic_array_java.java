import java.util.*;

 // Compiler version JDK 11.0.2
class Array{
  int[] arr;
  private  int len=0;//length user thinks array is
  private int capacity=0;//actual capacity of the array
  
  //constructor 
  public Array(int capacity)
  {
    if(capacity <=0 )
    throw new IllegalArgumentException("illegal Argument");
    
    this.capacity=capacity;
    arr=new int[capacity];
  }
  public int size()
  {
    return len;
  }
  public boolean isEmpty()
  {
     return size()==0;
  }
  
  //method to access random element
    
  public int get(int index)
  {
    return arr[index];
  }
  
  
  public void add(int elem)
  {
     if( len+1 >= capacity)
     {
       if(capacity==0) capacity=1;
       else
       {
         capacity *=2;//doubling the array capacity
       }
     
     //creating a new array with the increased  capacity
     int[] new_Arr=new int[capacity];
     
     for(int i=0;i<len;i++)
        new_Arr[i]=arr[i];
     arr=new_Arr;
    }
     arr[len++]=elem;
  }
   public int removeAt(int index)
   {
     if(index >=len || index < 0 )
      throw new IndexOutOfBoundsException();
     
      int data=arr[index];
      int[] new_Arr=new int[len-1];
      
     for(int i=0,j=0;i<len;i++,j++)
     {
       if(i==index)j--;//using j to skip the element which is to be remove
       else
       new_Arr[j]=arr[i];
     }
       arr=new_Arr;
       capacity=--len;
       return data;
   }
   public boolean remove(int elem)
   {
     for(int i=0;i<len;i++)
     {
       if(arr[i]==elem)
       {
         removeAt(i);
         return true;
       }
     }
      return false;
   }
   public int indexOf(int elem)
   {
     for(int i=0;i<len;i++)
        if(arr[i]==elem)
          return i;
     
     return -1;
        
   }
   public boolean contains(int elem)
   {
     return  indexOf(elem) != -1;
   }
} 
 class Dcoder
 {
   public static void main(String args[])
   { 
     Array arr=new Array(2);
     arr.add(56);
     arr.add(36);
     arr.add(90);
     arr.add(0);
   
   }
 }
