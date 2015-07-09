public final numComparator CMP=new numComparator();
    public String largestNumber(int[] nums) {
        if(nums==null||nums.length==0) return "";
        String[] str=new String[nums.length];
        for(int i=0;i<nums.length;i++)
            str[i]=String.valueOf(nums[i]);
        Arrays.sort(str,CMP);
        if(str[str.length-1].equals("0")) return "0";
        StringBuilder res=new StringBuilder();
        for(int i=str.length-1;i>=0;i--)
            res.append(str[i]);
        return res.toString();
    }
    private class numComparator implements Comparator<String>{
        public int compare(String a,String b){
            String s1=a+b;
            String s2=b+a;
            for(int i=0;i<s1.length();i++){
                if(s1.charAt(i)>s2.charAt(i)){
                    return 1;
                }else if(s1.charAt(i)<s2.charAt(i)){
                    return -1;
                }
            }
            return 0;
        }
    }