public class TreeNode9 {
     int val;
     TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
         this.right = right;
      }
 }
 
class Solution {
    public int sumRootToLeaf(TreeNode root) {
    if(root == null){
            return 0;
        }
        
        return rootToLeaf(root, "");
    }
    
    private int rootToLeaf(TreeNode root, String currentString){
        if(root.left == null && root.right == null){
            
            return Integer.parseInt(currentString + String.valueOf(root.val), 2);
        }
        
        int leftSum = 0;
        int rightSum = 0;
        
        if(root.left != null){
            leftSum =  rootToLeaf(root.left, currentString + String.valueOf(root.val));
        }
        
        if(root.right != null){
            rightSum = rootToLeaf(root.right, currentString + String.valueOf(root.val));
        }
        return  leftSum + rightSum;
        
    }
    
}
