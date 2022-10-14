public class TreeNode30 {
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
    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Double> answer = new ArrayList<>();
        
        queue.add(root);
        while(!queue.isEmpty()){
            int currentLevelSize = queue.size();
            int count = currentLevelSize;
            double sumOfNodesAtLevel = 0;
            
            while(currentLevelSize > 0){
                TreeNode currentNode = queue.remove();
                sumOfNodesAtLevel += currentNode.val;
            
             if(currentNode.left != null){
                queue.add(currentNode.left);
                }

            if(currentNode.right != null){
                queue.add(currentNode.right);
                }
                currentLevelSize --;
            }
          answer.add(sumOfNodesAtLevel/count); 
        }
        return answer;
       
    }
}
