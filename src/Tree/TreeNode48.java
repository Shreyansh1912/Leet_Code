/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth == 1){
            TreeNode ans = new TreeNode(val);
            ans.left = root;
            return ans;
        }
       Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
         while(depth-->2){
             Queue<TreeNode> temp = new LinkedList<>();
             while(queue.size() != 0){
                  TreeNode top = queue.poll();
                 if(top.left != null){
                     temp.add(top.left);
                 }
                 if(top.right != null){
                     temp.add(top.right);
                 }
             }
             queue = temp;
        }
        while(queue.size() > 0){
            TreeNode top = queue.poll();
            TreeNode temp = top.left;
            top.left = new TreeNode(val);
            top.left.left = temp;
            temp = top.right;
            top.right = new TreeNode(val);
            top.right.right = temp;
        }
        return root;
    }
}
