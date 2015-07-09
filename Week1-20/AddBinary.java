public class AddBinary{
	public String addBinary(String a,String b){
		//考虑的情况多一些
		if(a==null&b==null) return null;
		if(a==null) return b;
		if(b==null) return a;
		//将较长的String赋值个a，以为后面的两种情况
		if(a.length()<b.length()){
			String temp=a;
			a=b;
			b=temp;
		}
		//初始化
		char[] charA=a.toCharArray();
		char[] charB=b.toCharArray();
		int i,j;
		char sum='0',carry='0';
		StringBuilder sb=new StringBuilder();
		//考虑相同长度部分的加法，只需要j>=0就可以了，从最后一位（length-1）到第一位
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
		//a若与b同样长，i<0
		if(i<0){
			//此时如果还有进位，则插入
			if(carry=='1')
				sb.insert(0,carry);
		} 
		//若a长一些
		else{
			//没有进位时，只需将所有超出部分插入sb最前端
			if(carry=='0') sb.insert(0,charA,0,i+1);
			//有进位时，连续判断a的超出部分各个位上的数字，若为1则一直插入0
			while(i>=0&&a.charAt(i)=='1'){
				sb.insert(0,'0');
				i--;
			}
			//若所有超出部分都为1，则出现最高位的延长，插入1
			if(i<0){
				sb.insert(0,'1');
			}
			//反之，插入1与剩余部分
			else{
				sb.insert(0,'1');
				sb.insert(0,charA,0,i);
			}
		}
		return sb.toString();
	}
}