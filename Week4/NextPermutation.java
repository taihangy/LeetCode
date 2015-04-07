public class NextPermutation{
	public void nextPermutation(int[] num){
		if(num==null||null.length==0) return;
		int p=-1;
        for(int i=num.length-1;i>0;i--){
            if(num[i]<=num[i-1]) continue;
            else{
                p=i-1;
                break;
            }
        }
        if(p==-1){
            for(int i=0,j=num.length-1;i<j;i++,j--){
                int temp=num[i];
                num[i]=num[j];
                num[j]=temp;
            }
        }else{
            int i;
            for(i=num.length-1;i>p;i--)
                if(num[i]>num[p]) break;
            int temp=num[p];
            num[p]=num[i];
            num[i]=temp;
            for(int x=p+1,y=num.length-1;x<y;x++,y--){
                int t=num[x];
                num[x]=num[y];
                num[y]=t;
            }
        }
	}
}