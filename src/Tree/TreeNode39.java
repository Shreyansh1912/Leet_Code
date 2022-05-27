public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
    Set<TreeNode> nodeSet = new HashSet<>();
        nodeSet.add(p);
        nodeSet.add(q);
        
        return findLCA(root, nodeSet);
        }
        
       private TreeNode findLCA(TreeNode root, Set<TreeNode> nodeSet){ 
        
        if(root == null) 
         return null;
        
         if(nodeSet.contains(root))   // if(root.val == p.val || root.val == q.val)
         return root;
       
       TreeNode leftAns = findLCA(root.left, nodeSet);
       TreeNode rightAns = findLCA(root.right, nodeSet);   
        
        if(leftAns != null && rightAns != null)
          return root;
        
        if(leftAns != null)
          return leftAns;
        
        if(rightAns != null)
          return rightAns;
        
        return null;  
        
    }
}
        
