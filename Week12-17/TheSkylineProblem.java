public class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> res=new ArrayList<int[]>();
        List<int[]> sides=new ArrayList<int[]>();
        PriorityQueue<Integer> maxHeight=new PriorityQueue<Integer>(10,new Comparator<Integer>(){
            public int compare(Integer a,Integer b){
                return b-a;
            }
        });
        for(int i=0;i<buildings.length;i++){
            int[] building=buildings[i];
            sides.add(new int[]{building[0],building[2]});
            sides.add(new int[]{building[1],-building[2]});
        }
        Collections.sort(sides,new Comparator<int[]>(){
            public int compare(int[] a,int[] b){
                return a[0]!=b[0]?a[0]-b[0]:b[1]-a[1];
            }
        });
        int pre=0,cur=0;
        for(int i=0;i<sides.size();i++){
            int[] building=sides.get(i);
            if(building[1]>0){
                maxHeight.add(building[1]);
                cur=maxHeight.peek();
            }else{
                maxHeight.remove(-building[1]);
                cur=maxHeight.isEmpty()?0:maxHeight.peek();
            }
            if(cur!=pre){
                res.add(new int[]{building[0],cur});
                pre=cur;
            }
        }
        return res;
    }
}