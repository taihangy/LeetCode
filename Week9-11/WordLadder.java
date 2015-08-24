public class Solution {
    public int ladderLength(String beginWord, String endWord, Set<String> wordDict) {
        if(beginWord==null||endWord==null||beginWord.length()==0||endWord.length()==0||wordDict==null) return 0;
        int level=1;
        //every level's word nums
        int lastlevelnum=1;
        int curlevelnum=0;
        LinkedList<String> queue=new LinkedList<String>();
        HashSet<String> visited=new HashSet<String>();
        queue.offer(beginWord);
        visited.add(beginWord);
        while(!queue.isEmpty()){
            String cur=queue.poll();
            lastlevelnum--;
            for(int i=0;i<cur.length();i++){
                char[] curChar=cur.toCharArray();
                for(char c='a';c<='z';c++){
                    curChar[i]=c;
                    String temp=new String(curChar);
                    if(temp.equals(endWord)) return level+1;
                    if(wordDict.contains(temp)&&!visited.contains(temp)){
                        curlevelnum++;
                        queue.offer(temp);
                        visited.add(temp);
                    }
                }
            }
            if(lastlevelnum==0){
                lastlevelnum=curlevelnum;
                curlevelnum=0;
                level++;
            }
        }
        return 0;
    }
}