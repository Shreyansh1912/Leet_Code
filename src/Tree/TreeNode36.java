public class TreeNode36 {
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        
    int[] postIndex = {postorder.length-1};
        return constructTree(postorder, inorder, postIndex, 0 , inorder.length-1);
    }

    private TreeNode constructTree(int[] postorder, int[] inorder, int[] postIndex, int inStart, int inEnd){
        if(inStart > inEnd || postIndex[0] < 0)
            return null;

        int currentVal = postorder[postIndex[0]];
        TreeNode currentNode = new TreeNode(currentVal);
        postIndex[0] -= 1;

        int i = -1;

        for(i = inStart; i < inEnd; i++){

            if(inorder[i] == currentVal)
                break;
        }
        
        currentNode.right = constructTree(postorder, inorder, postIndex, i+1, inEnd);
        currentNode.left = constructTree(postorder, inorder, postIndex, inStart, i-1);
        
        return currentNode;
    }
}
