class TreeNode21 {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};


class Solution {
       public List<Integer> postorder(Node root) {
       List<Integer> answer = new ArrayList<>();
        Stack<Node> stack = new Stack<>();

        if(root == null)
            return answer;

        stack.push(root);

        while(!stack.isEmpty()){
            Node currentNode = stack.pop();
            answer.add(currentNode.val);

         List<Node> childrens = currentNode.children;
         for(int i = 0; i < childrens.size(); i++){
             Node currentChild = childrens.get(i);
             stack.push(currentChild);
           }
        }
                   
        Collections.reverse(answer);   
        return answer;

    }     
}
