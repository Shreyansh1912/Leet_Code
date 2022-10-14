public class TreeNode29 {
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
    public boolean isUnivalTree(TreeNode root) {
    Queue<TreeNode> queue = new LinkedList<>();
       queue.add(root);
        
        int requiredval = root.val;

        while(!queue.isEmpty()){
         TreeNode currentNode = queue.remove();
                
            if(currentNode.val != requiredval)
                return false;
           
            if(currentNode.left != null){
                queue.add(currentNode.left);
            }

            if(currentNode.right != null){
                queue.add(currentNode.right);
            }
                
          }
        return true;
    }
}
