import java.util.*;

 // Compiler version JDK 11.0.2

 class Dcoder
 {
   public static void main(String args[])
   { 
     
     int arr[] = {1,5,2,54,78,91,2};
     
     
     for(int i = 0;i < arr.length-1;i++)
     {
        for(int j = i+1; j < arr.length;j++)
        {
           if(arr[j] < arr[i])
           {
              int temp = arr[j];
              arr[j] = arr[i];
              arr[i] = temp;
           }
        }
     }
     for(int i:arr)
     {
       System.out.println(i);
     }
   }
   
 }
