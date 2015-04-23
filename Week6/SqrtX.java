public class SqrtX{
	public int mySqrt(int x) {
        if(x<0) return -1;
        if(x==0) return 0;
        int lo=1,hi=x/2+1;
        while(lo<=hi){
            int m=(lo+hi)/2;
            if(m<=x/m&&(m+1)>x/(m+1)) return m;
            if(m>x/m) hi=m-1;
            else lo=m+1;
        }
        return 0;
    } 
}