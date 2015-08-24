public class SingleNumber2{
	//思路和SingleNumber相同
	public int singleNumber(int[] A){
		if(A==null||A.length==0) return 0;
		int[] digit=new int[32];
        for(int i=0;i<32;i++){
            for(int j=0;j<A.length;j++){
                digit[i]+=(A[j]>>i)&1;
            }
        }
        int res=0;
        for(int i=0;i<32;i++){
            res+=(digit[i]%3)<<i;
        }
        return res;
	}

	public int singleNumber(int[] A){
		if(A==null||A.length==0) return 0;
		HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
		for(int i=0;i<A.length;i++){
			if(map.containsKey(A[i])){
				//要看count，==2才删除
				int count=map.get(A[i]);
				if(count==2) map.remove(A[i]);
				else map.put(A[i],++count);
			}
			else map.put(A[i],1);
		}
		return map.keySet().iterator().next();
	}

}