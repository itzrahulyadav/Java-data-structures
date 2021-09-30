package Nothing;
import java.util.*;
import java.util.PriorityQueue;

public class Graphs {

  public static void main(String[] args) {
     int n = 3;
     int m = 3;
     
    ArrayList<ArrayList<Integer>>  adj = new ArrayList<ArrayList<Integer>>();
    for(int i = 0;i <= n ;i++)
    {
       adj.add(new ArrayList<Integer>());
    }
    
    //edge 1 -> 2
    adj.get(1).add(2);
    adj.get(2).add(1);
    adj.get(3).add(1);
    adj.get(1).add(3);
    
    for(int i = 1; i <= n;i++)
    {
      for(int j = 0;j < adj.get(i).size();j++)
      {
        System.out.print( adj.get(i).get(j));
      }
      System.out.println();
    }
    ArrayList<Integer> l = bfs(n,adj);
    System.out.println(l);
   }
  
  static  ArrayList<Integer>  bfs(int n,ArrayList<ArrayList<Integer>>adj)
  {
     ArrayList<Integer>list = new ArrayList<>();
     boolean[] vis = new boolean[n + 1];
     
     for (int i = 1;i <= n;i++)
     {
        if(vis[i] == false)
        {
            Queue <Integer> q = new PriorityQueue<>();
            q.add(i);
            vis[i] = true;
            
            while(!q.isEmpty())
            {
               Integer node = q.poll();
               list .add(node);
               
               for(Integer it : adj.get(node))
               {
                   if(vis[it] == false)
                   {
                      vis[it] = true;
                      q.add(it);
                   }
               }
            }
        } 
     }
     return list;
  } 
  
}
