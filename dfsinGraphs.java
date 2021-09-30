package Nothing;

import java.util.ArrayList;


public class Graphyy {

  public static void main(String[] args) {
     int n = 4;
   //  int m = 5;
     ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
     
     for(int i = 0;i <= n; i++)
     {
        adj.add(new ArrayList<Integer>());
     }
     
     adj.get(1).add(2);
     adj.get(2).add(1);
     adj.get(1).add(4);
     adj.get(4).add(1);
     adj.get(1).add(3);
     adj.get(3).add(1);
     
     
     adj.get(2).add(3);
     adj.get(3).add(2);
     adj.get(3).add(4);
     adj.get(4).add(3);
     
     for(int i = 1;i <= n;i++)
     {
         System.out.print(i +"->");
        for(int j = 0;j < adj.get(i).size();j++)
        {
           
           System.out.print(adj.get(i).get(j));
        }
        System.out.println();
     }
     System.out.println("The nodes in graphs are-:");
     System.out.println(dfs(n,adj));
  }
  static ArrayList<Integer> dfs(int n,ArrayList<ArrayList<Integer>>adj)
  {
     ArrayList<Integer> result = new ArrayList<>();
     boolean[] vis = new boolean[n + 1];
     
     for(int i = 1;i <= n;i++)
     {
        if(vis[i] == false)
        {
          dfs2(i,vis,result,adj);
        }
     }
     return result;
  }
  static void dfs2(int node,boolean[] vis,ArrayList<Integer>result,ArrayList<ArrayList<Integer>>adj)
  {
     result.add(node);
     vis[node] = true;
     
     for(Integer it: adj.get(node))
     {
         if(vis[it] == false)
         {
            dfs2(it,vis,result,adj);
         }
     }
     
  }

}
