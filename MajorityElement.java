import java.util.Arrays;

public class MajorityElement{
	public int majorityElement(int[] num){
		int len=num.length;
		//O(NlogN)
		Arrays.sort(num);
		int count=1;
		int majority=num[0];
		for(int i=1;i<len;i++){
			if(num[i]==majority){
				count++;
				//count大于len/2没有等于号，否则有可能在后面有len/2+1的majority
				if(count>len/2) break;
			} else {
				majority=num[i];
				count=1;
			}
		}
		return majority;
	}
}