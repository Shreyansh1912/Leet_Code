public class TreeNode35 {
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int[] preIndex = {0};
        return constructTree(preorder, inorder, preIndex, 0 , inorder.length-1);
    }
    
    private TreeNode constructTree(int[] preorder, int[] inorder, int[] preIndex, int inStart, int inEnd){
        if(inStart > inEnd || preIndex[0] >= preorder.length)
            return null;
        
        int currentVal = preorder[preIndex[0]];
        TreeNode currentNode = new TreeNode(currentVal);
        preIndex[0] += 1;
        
        int i = -1;
        
        for(i = inStart; i < inEnd; i++){
            
            if(inorder[i] == currentVal)
                break;
        }
        
        currentNode.left = constructTree(preorder, inorder, preIndex, inStart, i-1);
        currentNode.right = constructTree(preorder, inorder, preIndex, i+1, inEnd);
        return currentNode;
    }
}
