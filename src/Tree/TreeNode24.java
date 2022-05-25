public class TreeNode24 {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
 
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<TreeNode, TreeNode> memo = findParent(root);
        return findNodesAtKDistance(root, target, k, memo);
    }
    private List<Integer> findNodesAtKDistance(TreeNode root, TreeNode target, int k, HashMap<TreeNode, TreeNode> memo){
        HashSet<TreeNode> visited = new HashSet<>();
        List<Integer> answer = new ArrayList<>();
        
        iterateTree(target, k, memo, visited, answer);
        return answer;
     }
    private void iterateTree(TreeNode current, int k, HashMap<TreeNode, TreeNode> memo, HashSet<TreeNode> visited, List<Integer> answer){
        
      if(current == null || visited.contains(current))
          return;
        
      visited.add(current);
        
        if(k == 0){
            answer.add(current.val);
        return;
        }
    
    iterateTree(current.left, k-1, memo, visited, answer);
    iterateTree(current.right, k-1, memo, visited, answer);
    iterateTree(memo.get(current), k-1, memo, visited, answer);  
    return;   
    }
                            
   private HashMap<TreeNode, TreeNode> findParent(TreeNode root){
       HashMap<TreeNode, TreeNode> memo = new HashMap<>();
       iterateTree(root, null, memo);
       return memo;
   }
   private void iterateTree(TreeNode currentNode, TreeNode currentParent, HashMap<TreeNode, TreeNode> memo){
       if(currentNode == null) return;
       
       memo.put(currentNode, currentParent);
       iterateTree(currentNode.left, currentNode, memo);
       iterateTree(currentNode.right, currentNode, memo);
       return;
   }                          
}
