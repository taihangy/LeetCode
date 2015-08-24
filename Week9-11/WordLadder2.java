public class Solution {
    //fist bfs to find all words to specific word, and words' distance to start
    // then dfs to find shortest paths from end to start 
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        List<List<String>> res=new ArrayList<List<String>>();
        if(dict==null||dict.size()==0) return res;
        dict.add(start);
        dict.add(end);
        HashMap<String,List<String>> map=new HashMap<String,List<String>>();
        HashMap<String,Integer> distance=new HashMap<String,Integer>();
        bfs(start,end,dict,map,distance);
        List<String> path=new ArrayList<String>();
        dfs(start,end,map,distance,path,res);
        return res;
    }
    
    private void dfs(String start,String cur,HashMap<String,List<String>> map,
                    HashMap<String,Integer> distance,
                    List<String> path,List<List<String>> res)
    {
        path.add(cur);
        if(cur.equals(start)){
            Collections.reverse(path);
            res.add(new ArrayList<String>(path));
            Collections.reverse(path);
        }else{
            for(String prev:map.get(cur)){
                if(distance.containsKey(prev)&&distance.get(cur)==distance.get(prev)+1){
                    dfs(start,prev,map,distance,path,res);
                }
            }
        }
        path.remove(path.size()-1); 
    }
    private void bfs(String start,String end,Set<String> dict,
                    HashMap<String,List<String>> map,HashMap<String,Integer> distance){
        for(String s:dict){
            map.put(s,new ArrayList<String>());
        }
        Queue<String> queue=new LinkedList<String>();
        distance.put(start,0);
        queue.offer(start);
        while(!queue.isEmpty()){
            String cur=queue.poll();
            ArrayList<String> nextList=expand(cur,dict);
            for(String next:nextList){
                map.get(next).add(cur);
                if(!distance.containsKey(next)){
                    distance.put(next,distance.get(cur)+1);
                    queue.offer(next);
                }
            }
        }
    }
    private ArrayList<String> expand(String cur,Set<String> dict){
        ArrayList<String> expansion=new ArrayList<String>();
        for(int i=0;i<cur.length();i++){
            for(char c='a';c<'z';c++){
                if(c!=cur.charAt(i)){
                    String expanded=cur.substring(0,i)+c+cur.substring(i+1);
                    if(dict.contains(expanded)){
                        expansion.add(expanded);
                    }
                }
            }
        }
        return expansion;
    }
}