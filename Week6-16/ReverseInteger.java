public class ReverseInteger{
    //和数有关的要注意越界和正负问题
	public int reverse(int x1) {
        long x=(long)x1;
        boolean flag=true;
        if(x<0) {
            flag=false;
            x=-x;
        }
        long res=0;
        long digit=0;
        while(x!=0){
            digit=x%10;
            x=x/10;
            res=10*res+digit;
        }
        if(flag&&res>(long)Integer.MAX_VALUE) return 0;
        if(!flag&&-res<(long)Integer.MIN_VALUE) return 0;
        
        return flag?(int)res:-(int)res;
    }
}