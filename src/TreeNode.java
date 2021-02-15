public class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;

     private int i = 0;

     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }