public class TreeNode11 {
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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leavesOfT1 = new ArrayList<>();
        List<Integer> leavesOfT2 = new ArrayList<>();
        
        findLeaves(root1, leavesOfT1);
        findLeaves(root2, leavesOfT2);
        
        return leavesOfT1.equals(leavesOfT2);
    }
    private void findLeaves(TreeNode root, List<Integer> leaves){
        if(root == null) return;
        
        if(root.left == null && root.right == null){
            leaves.add(root.val);
            return;
        }
        findLeaves(root.right, leaves);
        findLeaves(root.left, leaves);
        return;
    }  
}
