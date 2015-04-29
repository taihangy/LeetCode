public class DecodeWays{
    //时间超过
	HashMap<Integer,Character> map=new HashMap<Integer,Character>();
    public int numDecodings(String s) {
        if(s==null||s.length()==0) return 0;
        List<String> res=new ArrayList<String>();
        for(int i=0;i<26;i++)
            map.put(i+1,(char)('A'+i));
        helper(s,0,"",res);
        return res.size();
    }
    private void helper(String s,int index,String item,List<String> res){
        if(index>=s.length()){
            res.add(item);
            return;
        } 
        for(int i=1;i<3&&(index+i)<=s.length();i++){
            int num=Integer.parseInt(s.substring(index,index+i));
            if(num<=26){
                helper(s,index+i,item+map.get(num),res);
            }
        }
    }
    //动态规划，注意char是有'0'的而不是0
    public int numDecodings(String s) {
        if(s==null||s.length()==0||s.charAt(0)=='0') return 0;
        int num1=1;
        int num2=1;
        int num3=1;
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)=='0'){
                if(s.charAt(i-1)=='1'||s.charAt(i-1)=='2'){
                    num3=num1;
                }else{
                    return 0;
                }
            }else{
                if(s.charAt(i-1)=='0'||s.charAt(i-1)>='3'){
                    num3=num2;
                }
                else {
                    if(s.charAt(i)>='7'&&s.charAt(i-1)=='2'){
                        num3=num2;
                    } else{
                        num3=num2+num1;
                    }
                }
            }
            num1=num2;
            num2=num3;
        }
        return num3;
}