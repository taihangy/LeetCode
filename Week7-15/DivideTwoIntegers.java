public class DivideTwoIntegers{
    //通过减法做，超时
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

    //整数可以表示为a0*2^0+a1*2^1+...+an*2^n，因此我们就可以先将除数左移到小于被除数之前的那个基
    //比如10/2，那么现将被除数右移一位（这样才能保证除数左移最大也不会超过被除数），然后将除数不断左移直至大于它，记录下左移位数
    //被除数减去最大的除数，res加上1左移对应的位数，每次结束后除数要右移1位，位数要减一
    public int divide(int dividend, int divisor) {
        if(divisor==0){
            return Integer.MAX_VALUE;
        }
        boolean isNeg=(dividend^divisor)>>>31==1;
        int res=0;
        if(dividend==Integer.MIN_VALUE){
            dividend+=Math.abs(divisor);
            if(divisor==-1){
                return Integer.MAX_VALUE;
            }
            res++;
        }
        if(divisor==Integer.MIN_VALUE)
            return res;
        int digit=0;
        dividend=Math.abs(dividend);
        divisor=Math.abs(divisor);
        while(divisor<=(dividend>>1)){
            divisor<<=1;
            digit++;
        }
        while(digit>=0){
            if(dividend>=divisor){
                res+=1<<digit;
                dividend-=divisor;
            }
            divisor>>=1;
            digit--;
        }
        return isNeg?-res:res;
    }
}