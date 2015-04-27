public class DivideTwoIntegers{
	public int divide(int dividend, int divisor) {
        if(dividend==0&&divisor!=0) return 0;
        if(divisor==0) return dividend<0?Integer.MIN_VALUE:Integer.MAX_VALUE;
        boolean isNeg=false;
        if(dividend<0&&divisor>0) isNeg=true;
        else if(dividend>0&&divisor<0) isNeg=true;
        dividend=Math.abs(dividend);
        divisor=Math.abs(divisor);
        int res=0;
        while(dividend>=divisor){
            dividend-=divisor;
            res++;
        }
        return isNeg?-res:res;
    }
}