public class RemoveDuplicatesfromSortedArray2 {
    public int removeDuplicates(int[] A) {
        if(A==null||A.length==0) return 0;
        int index=0;
        int count=0;
        for(int i=1;i<A.length;i++){
            if(A[i]==A[i-1]){
                count++;
                if(count>=2) continue;
            }else{
                count=0;
            }
            A[++index]=A[i];
        }
        return index+1;
    }
}