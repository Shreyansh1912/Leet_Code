class Solution {
    public List<Integer> pathInZigZagTree(int n) {
      int llv = 1;
      int ctval = 0;
        
      while(ctval < n){
           ctval += llv ;
          llv*=2;
      }  
      llv/=2;
       ArrayList<Integer> ans = new ArrayList<>(); 
        while(n != 1){
            ans.add(n);
            int comp = (3*llv-n-1);
            int par = comp/2;
            n=par;
            llv/=2;
        }
        ans.add(1);
        Collections.reverse(ans);
        return ans;
        
    }
}
