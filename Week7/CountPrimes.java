public class CountPrimes{
	public int countPrimes(int n) {
        if(n<2) return 0;
        boolean[] marked=new boolean[n];
        int count=0;
        for(int p=2;p*p<=n-1;p++){
            if(marked[p]) continue;
            for(int temp=p*p;temp<=n-1;temp+=p){
                if(!marked[temp]){
                  marked[temp]=true;
                  count++;
                } 
            }
        }
        return n-2-count;
    }
}