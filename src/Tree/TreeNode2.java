 public class TreeNode2 {
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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> LL = new ArrayList<>();
        preorder(root, LL);
        return LL;
    }
    private void preorder(TreeNode root, List<Integer> LL){
        if(root == null){ 
            return;
        }
        LL.add(root.val);
        preorder(root.left, LL);
        preorder(root.right, LL);
        
        return ;
    }
}
