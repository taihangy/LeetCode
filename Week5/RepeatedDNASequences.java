public class RepeatedDNASequences{
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
            if(i>9) hash-=map.get(s.substring(i-10,i-9))*SUB_POW;
            hash=map.size()*hash+map.get(s.substring(i,i+1));
            if(i>8&&!hashset.add(hash)) res.add(s.substring(i-9,i+1));
        }
        return new ArrayList<String>(res);
    }

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
        for(int i=0;i<s.length();i++){
            if(i>9) hash-=Math.pow(4,9)*map[s.charAt(i-10)-'A'];
            hash=4*hash+map[s.charAt(i)-'A'];
            if(i>8&&!a.add(hash)) b.add(s.substring(i-9,i+1)); 
        }
        return new ArrayList<String>(b);
    }
}