public class AddBinary{
	public String addBinary(String a,String b){
		if(a==null&b==null) return null;
		if(a==null) return b;
		if(b==null) return a;
		if(a.length()<b.length()){
			String temp=a;
			a=b;
			b=temp;
		}
		char[] charA=a.toCharArray();
		char[] charB=b.toCharArray();
		int i,j;
		char sum='0',carry='0';
		StringBuilder sb=new StringBuilder();
		for(i=a.length()-1,j=b.length()-1;j>=0;i--,j--){
			if(charA[i]=='1'&&charB[j]==1&&carry=='1'){
				sum='1';
				carry='1';
			} else if(charA[i]=='1'&&charB[j]=='1'&&carry=='0'){
				sum='0';
				carry='1';
			} else if((charA[i]=='1'||charB[j]=='1')&&carry=='1'){
				sum='0';
				carry='1';
			} else if((charA[i]=='1'||charB[j]=='1')&&carry=='0'){
				sum='1';
				carry='0';
			} else {
				sum=carry;
				carry='0';
			}
			sb.insert(0,sum);
		}
		if(i<0){
			if(carry=='1')
				sb.insert(0,carry);
		} else{
			if(carry=='0') sb.insert(0,charA,0,i+1);
			while(i>=0&&a.charAt(i)=='1'){
				sb.insert(0,'0');
				i--;
			}
			if(i<0){
				sb.insert(0,'1');
			}else{
				sb.insert(0,'1');
				sb.insert(0,charA,0,i);
			}
		}
		return sb.toString();
	}
}