public class TwoSum{
	//用哈希表找到index，key是值，value是index，时间复杂度O(n)，空间复杂度O(n)
	public  int[] twoSum(int[] numbers,int target){
		int[] res=new int[2];
		if(numbers==null|numbers.length<2)
			return null;
		HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
		for(int i=0;i<numbers.length;i++){
			if(map.containsKey(target-numbers[i])){
				res[0]=map.get(target-numbers[i])+1;
				res[1]=i+1;
				return res;
			}
			map.put(numbers[i],i);
		}
		return null;
	}

	//排序后，用binarysearch找对应值，然后再找index，时间复杂度为O(2nlogn+n)，空间复杂度O(n)
	public int[] twoSum(int[] numbers, int target) {
		int[] temp=new int[numbers.length];
		for(int i=0;i<numbers.length;i++)
			temp[i]=numbers[i];
		Arrays.sort(numbers);
        int index1=0,index2=0;
        for(int i=0;i<numbers.length;i++){
        	int first=numbers[i];
        	int sub=target-first;
        	int m=i+1,n=numbers.length-1,k=(m+n)/2;
        	while(m<=n){
        		if(numbers[k]==sub) break;
        		else if(sub<numbers[k]) n=k-1;
        		else if(sub>numbers[k]) m=k+1;
        		k=(m+n)/2;
        	}
        	if(numbers[k]==sub){
        		index1=first;
        		index2=sub;
        		break;
        	}
        }
        int[] ret=new int[2];
        int i;
        for(i=0;i<temp.length;i++)
        	if(index1==temp[i]){
        		ret[0]=i+1;
        		break;
        	}

        for(int j=0;j<temp.length;j++)
        	if(index2==temp[j]&&j!=i){
        		ret[1]=j+1;
        		break;
        	}
        if(ret[0]>ret[1]){
            int x=ret[0];
            ret[0]=ret[1];
            ret[1]=x;
        }
    	return ret;
    }

    //HashSet寻找值，时间复杂度O(n)，空间复杂度O(n)
    public int[] twoSum(int[] numbers, int target) {
		int[] res=new int[2];
		if(numbers==null||numbers.length<2)
			return null;
		HashSet<Integer> set=new HashSet<Integer>();
		for(int i=0;i<numbers.length;i++){
			if(set.contains(target-numbers[i])){
				res[0]=target-numbers[i];
				res[1]=numbers[i];
				return res;
			}
			set.add(numbers[i]);
		}
		return null;
    }

    //排序后，夹逼法寻找值或者index，时间复杂度O(nlogn+n)，空间复杂度O(n)
    public int[] twoSum(int[] numbers, int target) {
    	int[] res = new int[2];
    	if(numbers==null || numbers.length<2)
        	return null;
    	Arrays.sort(numbers);
    	int l = 0;
    	int r = numbers.length-1;
    	while(l<r)
    	{
        	if(numbers[l]+numbers[r]==target)
        	{
            	res[0] = numbers[l];
            	res[1] = numbers[r];
            	return res;
        	}
        	else if(numbers[l]+numbers[r]>target)
        	{
            	r--;
        	}
        	else
        	{
            	l++;
        	}
    	}
    	return null;
	}
}