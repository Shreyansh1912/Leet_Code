public class TreeNode38 {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
 
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    boolean[] found ={false, false};
    TreeNode ans = lca(root, p, q, found);
    return found[0] == true && found[1] == true ? ans : null;    
}
    private TreeNode lca(TreeNode root, TreeNode p, TreeNode q, boolean[] found){
        if(root == null) 
            return null;
        
        TreeNode leftAns = lca(root.left, p, q, found);
        TreeNode rightAns = lca(root.right, p, q, found);
        
         if(root.val == p.val){
            found[0] = true;
            return root;
         }
        
         if(root.val == q.val){
            found[1] = true;
            return root;
         }
    
      if(leftAns != null && rightAns != null)
          return root;
        
      if(leftAns != null)
          return leftAns;
        
      if(rightAns != null)
          return rightAns;
        
      return null;  
        
    }
}
       
