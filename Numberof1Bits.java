public class Numberof1Bits{
	public int hammingWeight(int n) {
        int count=0;
        if(n<0){
            n=n^Integer.MIN_VALUE;
            count=1;
        }
        while(n>0){
            if(n%2==1) count++;
            n=n/2;
        }
        return count;
    }
}