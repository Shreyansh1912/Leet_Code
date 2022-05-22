public class TreeNode6 {
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
    public List<Integer> inorderTraversal(TreeNode root) {
         List<Integer> LL = new ArrayList<>();
        Inorder(root, LL);
        return LL;
    }
    private void Inorder(TreeNode root, List<Integer> LL){
        if(root == null){ 
            return;
        }
        Inorder(root.left, LL);
        LL.add(root.val);
        Inorder(root.right, LL);
        
        return ;
    }
}
    
