public class TreeNode {
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
    public int findTilt(TreeNode root) {
        sumOfNodes(root);
        return sum;
    }
    private int sum=0;
    private int sumOfNodes(TreeNode root){
        if(root == null) return 0;
        
        int leftAns = sumOfNodes(root.left);
        int rightAns = sumOfNodes(root.right);
         sum += Math.abs(leftAns-rightAns);
        return root.val + leftAns + rightAns;
         
    }
}
