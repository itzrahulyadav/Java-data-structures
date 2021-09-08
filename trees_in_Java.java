import java.util.*;
//Compiler version JDK 11.0.2
class TreeNode
{
    int value;
    TreeNode left;
    TreeNode right;
    public TreeNode(int value)
    {
        this.value = value;
       
    }
    public TreeNode(int value,TreeNode left,TreeNode right)
    {
       this.value = value;
       this.left = left;
       this.right = right;
    }
}
class Tree{
   TreeNode root = null;
   
   public void add(int value)
   {
      if (root == null)
      {
         root = new TreeNode(value);
         return;
      }
      
      TreeNode curr = root;
      while(true)
      {
          if(value < curr.value)
          {
              if(curr.left != null)
              {
                 curr = curr.left;
              }
              else
              {
                 curr.left = new TreeNode(value);
                 break;
              }
          }
          else 
          {
            if(curr.right != null)
              {
                 curr = curr.right;
              }
              else
              {
                 curr.right = new TreeNode(value);
                 break;
              }

          }
      }
   }
   public TreeNode delete(int key)
   {
       if(root == null)
       {
          return null;
       }
       if(root.value == key)
       {
          return helper(root);
       }
       
       TreeNode dummy = root;
       
       while(root != null)
       {
          if(key < root.value)
          {
            if(root.left != null && root.left.value == key)
            {
              root.left = helper(root.left);
            }else
            {
               root = root.left;
            }
          }
          else
          {
             if(root.right != null && root.right.value == key)
            {
              root.right = helper(root.right);
            }else
            {
               root = root.right;
            }
          }
       }
       return dummy;
   }
   public TreeNode helper(TreeNode root)
   {
       if(root.left == null)
       {
          return root.right;
       }  
       else if(root.right == null)
       {
          return root.left;
       }
       else
       {
          TreeNode rightChild = root.right;
          TreeNode leftsRight =  findRight(root.left);
          leftsRight.right = rightChild;
          return root.left;
       }
   }
   public TreeNode findRight(TreeNode root)
   {
      while(root.right != null)
      {
         root = root.right;
      }
      return root;
   }
   
   //function to level order traversal
   public List<List<Integer>> levelOrder()
   {
      Queue<TreeNode> q = new LinkedList<>();
      List<List<Integer>> ans = new LinkedList<List<Integer>>();
      if(root == null) return null;
      
      q.offer(root);
      while(!q.isEmpty())
      {
         int listSize = q.size();
         List<Integer> temp = new LinkedList<>();
         for(int i = 0;i < listSize;i++)
         {
            if(q.peek().left != null) q.offer(q.peek().left);
            if(q.peek().right != null)q.offer(q.peek().right);
            temp.add(q.poll().value);
         }
         ans.add(temp);
      }
      return ans;
   }
   
  
}
 class Dcoder
 {
   public static void main(String args[])
   { 
       Tree tree = new Tree();
       tree.add(41);
       tree.add(23);
       tree.add(19);
       tree.add(61);
       tree.add(65);
       tree.add(47);
       tree.add(26);
       tree.add(32);
       tree.add(7);
       tree.add(21);
      // tree.root = tree.delete(19);
       List<List<Integer>> list = tree.levelOrder();
       System.out.println(list);
   }
 }
