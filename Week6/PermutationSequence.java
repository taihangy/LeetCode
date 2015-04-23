public class PermutationSequence{
	public String getPermutation(int n, int k) {
        if(n<1) return "";
        k--;
        ArrayList<Integer> num=new ArrayList<Integer>();
        StringBuilder sb=new StringBuilder();
        int factorial=1;
        for(int i=2;i<=n-1;i++){
            factorial*=i;
        }
        for(int i=1;i<=n;i++){
            num.add(i);
        }
        int round=n-1;
        while(round>=0){
            int index=k/factorial;
            k%=factorial;
            sb.append(num.get(index));
            num.remove(index);
            if(round>0)
                factorial/=round;
            round--;
        }
        return sb.toString();
    }
}