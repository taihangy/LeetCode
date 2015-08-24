public class ClombingString{
	//recursive version，time requirement cannot be achived
	public int climbStaits(int n){
		if(n<=0) return 0;
		if(n==1) return 1;
		if(n==2) return 2;
		return climbStaits(n-1)+climbStaits(n-2);
	}

	//iterated version
	public int climbStaits2(int n){
		if(n<=0) return 0;
		int f1=1;
		int f2=2;
		if(n==1)
			return f1;
		if(n==2)
			return f2;
		for(int i=3;i<=n;i++){
			int f3=f1+f2;
			f1=f2;
			f2=f3;
		}
		return f2;
	}
}