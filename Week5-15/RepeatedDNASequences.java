public class RepeatedDNASequences{
    //这种思路时间复杂度O(nlogn)，空间复杂度O(s.length())
	public List<String> findRepeatedDnaSequences(String s) {
        if(s==null||s.length()<20) return null;
        List<String> res=new ArrayList<String>();
        HashSet<String> set=new HashSet<String>();
        int N=s.length();
        String[] suffixes=new String[N];
        for(int i=0;i<s.length();i++)
            suffixes[i]=s.substring(i,N);
        Arrays.sort(suffixes);
        for(int i=0;i<N-1;i++){
            int len=lcp(suffixes[i],suffixes[i+1]);
            if(len>=10){
                String str=suffixes[i].substring(0,10);
                set.add(str);
            }
        }
        res.addAll(set);
        return res;
    }
    private int lcp(String s,String t){
        if(s==null||t==null||s.length()==0||t.length()==0) return 0;
        int N=Math.min(s.length(),t.length());
        for(int i=0;i<N;i++)
            if(s.charAt(i)!=t.charAt(i))
                return i;
        return N;
    }

    //Solution2，这种方法，时间复杂度O(n)，空间复杂度因为存在map会比较大，如何算？
    private static final HashMap<String,Integer> map=new HashMap<String,Integer>();
    static{
        map.put("A",0);
        map.put("C",1);
        map.put("G",2);
        map.put("T",3);  
    }   
    private static final int SUB_POW=(int)Math.pow(map.size(),9);
    public List<String> findRepeatedDnaSequences(String s) {
        if(s==null||s.length()<20) return new ArrayList<String>();
        Set<String> res=new HashSet<String>();
        Set<Integer> hashset=new HashSet<Integer>();
        int hash=0;
        for(int i=0;i<s.length();i++){
            //每次减少第一个char的hash
            if(i>9) hash-=map.get(s.substring(i-10,i-9))*SUB_POW;
            //加入当前char的hash
            hash=map.size()*hash+map.get(s.substring(i,i+1));
            //每次判断这个hash是否加入过，如果加入过，那就加入res
            if(i>8&&!hashset.add(hash)) res.add(s.substring(i-9,i+1));
        }
        return new ArrayList<String>(res);
    }

    //Solution 3， 用两个set，一个char[]，这样似乎可以省空间复杂度
    public List<String> findRepeatedDnaSequences(String s) {
        ArrayList<String> res=new ArrayList<String>();
        if(s==null||s.length()<=10) return res;
        char[] map = new char[26];  
        map['C' - 'A'] = 1;  
        map['G' - 'A'] = 2;  
        map['T' - 'A'] = 3;  
        Set<Integer> a=new HashSet<Integer>();
        Set<Integer> b=new HashSet<Integer>();
        for(int i=0;i<s.length()-9;i++){
            int hash=0;
            for(int j=i;j<i+10;j++)
                hash=4*hash+map[s.charAt(j)-'A'];
            //a加入过，b没加入过的时候，说明之前出现过一次了，因此将substring加入b
            //这种方法不好，时间复杂度不好，O(n^2)
            if(!a.add(hash)&&b.add(hash)) res.add(s.substring(i,i+10)); 
        }
        return res;
    }

    public List<String> findRepeatedDnaSequences(String s) {
        if(s==null||s.length()<=10) new ArrayList<String>();
        char[] map = new char[26];  
        map['C' - 'A'] = 1;  
        map['G' - 'A'] = 2;  
        map['T' - 'A'] = 3;  
        Set<Integer> a=new HashSet<Integer>();
        Set<String> b=new HashSet<String>();
        int hash=0;
        //时间复杂度到达O(n),还check了重复，虽然空间复杂度牺牲了O(n)
        for(int i=0;i<s.length();i++){
            if(i>9) hash-=Math.pow(4,9)*map[s.charAt(i-10)-'A'];
            hash=4*hash+map[s.charAt(i)-'A'];
            if(i>8&&!a.add(hash)) b.add(s.substring(i-9,i+1)); 
        }
        return new ArrayList<String>(b);
    }
}