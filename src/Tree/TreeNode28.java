public class TreeNode28 {
 *   int val;
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
    public int maxDepth(TreeNode root) {
       Queue<TreeNode> queue = new LinkedList<>();
       int height=0;
        
        if(root == null){
            return height;
        }

        queue.add(root);

        while(!queue.isEmpty()){

            int currentSize = queue.size();
            
            while(currentSize > 0){
                TreeNode currentNode = queue.remove();
           
            if(currentNode.left != null){
                queue.add(currentNode.left);
            }

            if(currentNode.right != null){
                queue.add(currentNode.right);
            }
                currentSize--;
            }

           height+=1;

        }

        return height;

    }
}
