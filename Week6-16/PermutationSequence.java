public class PermutationSequence{
    //第一个数字，后面有n-1个数字，因此(n-1)!后才会换一个，因此k/(n-1)!就是第一位数字，如此循环直到最后一位
    //为了方便把n中所有数存在数组以便查找，使用O(n)空间
    //k--以便与num数组对齐
    //时间复杂度O(n)
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