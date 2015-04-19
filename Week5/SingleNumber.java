public class SingleNumber {
    //所有整数和本身异或都是0，因此偶数个数异或为0，因此可以找出唯一那个奇数个的，所有数和0异或为原数
    public int singleNumber(int[] A) {  
        if(A==null||A.length==0) return 0;
        int res=0;
        for(int i=0;i<A.length;i++){
            res=res^A[i];
        }
        return res;
    }
    //适用很广
    //统计32位上每个位的1的个数，因为如果出现两个数，那么该位1的个数就是2的倍数，除非有一个数只有一个
    public int singleNumber(int[] A) {  
        if(A==null||A.length==0) return 0;
        int[] digit=new int[32];
        for(int i=0;i<32;i++){
            for(int j=0;j<A.length;j++){
                digit[i]+=(A[j]>>i)&1;
            }
        }
        int res=0;
        //将那个数还原出来
        for(int i=0;i<32;i++){
            res+=(digit[i]%2)<<i;
        }
        return res;
    }

    //加入hashmap，若存在，则remove，不存在则加入，剩下那个肯定就是唯一的那个
    public int singleNumber(int[] A) {  
        if(A==null||A.length==0) return 0;
        Map<Integer,Integer> map=new HashMap<Integer,Integer>();
        for(int i=0;i<A.length;i++){
            if(map.containsKey(A[i])) map.remove(A[i]);
            else map.put(A[i],1);
        }
        return map.keySet().iterator().next();
    }
}