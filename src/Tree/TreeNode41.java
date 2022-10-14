// { Driver Code Starts
import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class TreeNode41
{
    int data; //data of the node
    int hd; //horizontal distance of the node
    Node left, right; //left and right references
 
    // Constructor of tree node
    public Node(int key)
    {
        data = key;
        hd = Integer.MAX_VALUE;
        left = right = null;
    }
}



class GfG {
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    static void printInorder(Node root)
    {
        if(root == null)
            return;
            
        printInorder(root.left);
        System.out.print(root.data+" ");
        
        printInorder(root.right);
    }
    
	public static void main (String[] args) throws IOException{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
    
	        while(t-- > 0){
	            String s = br.readLine();
    	    	Node root = buildTree(s);
    	        Solution ob = new Solution();
			    ArrayList <Integer> res = ob.bottomView(root);
			    for (Integer num : res) System.out.print (num + " ");
		     	System.out.println();
	        }
	}
}

// } Driver Code Ends

class Pair{
    int hd;
    Node treeNode;
    
    Pair(Node treeNode, int hd){
        this.hd = hd;
        this.treeNode = treeNode;
    }
}

class Solution
{
    public ArrayList <Integer> bottomView(Node root)
    {
     Queue<Pair> queue = new LinkedList<>();
        ArrayList<Integer> answer = new ArrayList<>();
        
        HashMap<Integer, Integer> memo = new HashMap<>();
        int minHd = 1000000;
        int maxHd = -1000000;
        
        queue.add(new Pair(root, 0));
        
        while(!queue.isEmpty()){
            int currentSize = queue.size();
            
            for(int i = 0; i < currentSize; i++){
                Pair currentPair = queue.remove();
                Node currentNode = currentPair.treeNode;
                int hd = currentPair.hd;
                
                    memo.put(hd, currentNode.data);
                    minHd = Math.min(minHd, hd);
                    maxHd = Math.max(maxHd, hd);
                    
                if(currentNode.left != null)
                  queue.add(new Pair(currentNode.left, hd-1));
                  
                 if(currentNode.right != null)
                  queue.add(new Pair(currentNode.right, hd+1)); 
                
            }
        }
        for(int i = minHd; i <= maxHd ; i++)
          answer.add(memo.get(i));
          
        return answer;  
        
         
    }
}
