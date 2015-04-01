public class Triangle{
	//shortest path in DAG的变种
	public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle==null) return 0;
        if(triangle.size()==1) return triangle.get(0).get(0);
        int[] distTo=new int[triangle.get(0).size()];
        distTo[0]=triangle.get(0).get(0);
        for(int i=1;i<triangle.size();i++){
            List<Integer> list=triangle.get(i);
            int[] temp=new int[list.size()];
            for(int k=0;k<temp.length;k++)
                temp[k]=Integer.MAX_VALUE;
            relax(distTo,temp,list);
            distTo=temp;
        }
        int minDist=Integer.MAX_VALUE;
        for(int i=0;i<distTo.length;i++)
            if(distTo[i]<minDist)
                minDist=distTo[i];
        return minDist;
    }
    public void relax(int[] distTo,int[] temp,List<Integer> list){
        for(int p=0;p<temp.length;p++){
            for(int q=p-1;q<=p;q++){
                if(q>=0&&q<=distTo.length-1){
                    int dist=distTo[q]+list.get(p);
                    if(dist<temp[p]){
                        temp[p]=dist;
                    }
                }
            }
        }
    }
}