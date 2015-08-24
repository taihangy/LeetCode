public class RemoveDuplicatesfromSortedArray2 {
    public int removeDuplicates(int[] A) {
        if(A==null||A.length==0) return 0;
        //保持index用于构成新的数组
        int index=0;
        //保持有一个count用于记录重复元素的个数
        int count=0;
        for(int i=1;i<A.length;i++){
            if(A[i]==A[i-1]){
                count++;
                //如果count已经是两个了，则看下一个，而不能去将该元素加入新数组，直至找到一个不相同的元素
                if(count>=2) continue;
            }else{
                count=0;
            }
            A[++index]=A[i];
        }
        return index+1;
    }
}