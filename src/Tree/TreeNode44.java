class TreeNode44 {
    public int[] intersection(int[] num1, int[] num2) {
        HashMap<Integer, Boolean> memo = new HashMap<>();
        
        for(int currentNum : num1)
            if(!memo.containsKey(currentNum)){
                memo.put(currentNum, true);
            }
        
        ArrayList<Integer> answer = new ArrayList<>();
        
        for(int currentNum : num2){
            if(memo.containsKey(currentNum) && memo.get(currentNum)){
               answer.add(currentNum);
               memo.remove(currentNum);
            }
            
        }
      int[] result = new int[answer.size()];
        
        for(int i=0;i<answer.size();i++)
            result[i] = answer.get(i);
        return result;
}
}
