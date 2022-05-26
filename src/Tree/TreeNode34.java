class TreeNode34 {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};

class Solution {
    public Node connect(Node root) {
        Queue<Node> queue = new LinkedList<>();
        
        if(root == null) return root;
        
        queue.add(root);
        while(!queue.isEmpty()){
            int currentSize = queue.size();
            
            ArrayList<Node> answer = new ArrayList<>();
            
            for(int i=0; i < currentSize; i++){
                Node currentNode = queue.remove();
                answer.add(currentNode);
                
            if(currentNode.left != null)
                queue.add(currentNode.left);
                
            if(currentNode.right != null)
                queue.add(currentNode.right);   
                
                }
            for(int i=0; i < currentSize; i++){
                if(i == currentSize-1)
                    answer.get(i).next = null;
                else  
                    answer.get(i).next = answer.get(i+1);
            }
        }
        return root;
    }
}
