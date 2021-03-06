public class HappyNumber{
	public boolean isHappy(int n) {
        //空间复杂度O(n),时间复杂度O(?)
        if(n==1) return true;
        HashSet<Integer> set=new HashSet<Integer>();
        int sum=0;
        while(set.add(n)){
            while(n>0){
                sum+=(n%10)*(n%10);
                n/=10;
            }
            if(sum==1) return true;
            n=sum;
            sum=0;
        }
        return false;
    }
}