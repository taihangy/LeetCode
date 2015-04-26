public class PowXN{
    //时间复杂度O(logn),空间O(1)
	public double myPow(double x, int n) {
        if(n==0) return 1.0;
        double res=1.0;
        if(n<0){
            //此处也可以x!=0
            if(x>1.0/Double.MAX_VALUE||x<1.0/-Double.MAX_VALUE) x=1.0/x;
            else return Double.MAX_VALUE;
            if(n==Integer.MIN_VALUE){
                res*=x;
                n++;
            }
        }
        n=Math.abs(n);
        boolean isNeg=false;
        if(x<0&&n%2==1){
            isNeg=true;
        }
        x=Math.abs(x);
        while(n>0){
            if((n&1)==1){
                //注意res是否越界
                if(res>Double.MAX_VALUE/x) 
                     return Double.MAX_VALUE;
                res*=x;
            }
                x*=x;
                n>>=1;
        }
        return isNeg?-res:res;
    }
}