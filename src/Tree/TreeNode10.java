public class TreeNode10 {
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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> answer = new ArrayList<>();
        rootToLeaf(root, "" + Integer.toString(root.val),answer);
        return answer;
    }
    private void rootToLeaf(TreeNode root, String currentPath,List<String> answer){
        if(root.left == null && root.right == null){
            answer.add(currentPath);
            return;
        }
        if(root.left != null){
            rootToLeaf(root.left, currentPath + "->" +Integer.toString(root.left.val),answer);
        }
        if(root.right != null){
             rootToLeaf(root.right, currentPath + "->" +Integer.toString(root.right.val),answer);
        }
        
    }
}
