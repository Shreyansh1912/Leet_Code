public class TreeNode42 {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

 class Solution {
    public final TreeNode getTargetCopy(final TreeNode o, final TreeNode c, final TreeNode tar) {
        return find(o, c, tar);
    }
    private TreeNode find(TreeNode T1, TreeNode T2, TreeNode target){
        if(T1 == null)
            return null;
        
        if(T1 == target)
        {
            return T2;
        }
        TreeNode left = find(T1.left, T2.left, target);
        if(left != null)
            return left;
        TreeNode right = find(T1.right, T2.right, target);
        if(right != null)
            return right;
        
        
        
         return null;
    }
   
}
