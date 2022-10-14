package Math;
class pow {
    public double myPow(double x, int n) {
        double ans = 1.0;
        long nn = n; //take as long beacz they give overflow error

        if(nn < 0) nn = -1 * nn;

        while(nn > 0){
            if(nn%2 == 1){
                ans = ans * x;
                nn -= 1;
            } else{
                x = x * x;
                nn /= 2;
            }
        }
        if(n < 0) ans = (double)(1.0)/(double)(ans);
        return ans;
    }
}
