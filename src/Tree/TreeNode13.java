public class TreeNode13 {
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
    public int sumOfLeftLeaves(TreeNode root) {
        return leftLeavesSum(root, false);
        
    }
    private int leftLeavesSum(TreeNode root, Boolean onLeftLeaves){
        if(root == null) return 0;
        
        if(root.left == null && root.right == null){
            return onLeftLeaves ? root.val : 0;
        }
        
        int leftLeaves = leftLeavesSum(root.left, true);
        int rightLeaves = leftLeavesSum(root.right, false);
        
        return leftLeaves + rightLeaves;
    }
}
