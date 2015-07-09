public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if(gas==null||gas.length==0||cost==null||cost.length==0||gas.length!=cost.length) return -1;
        int N=gas.length;
        int res=-1;
        int i;
        for(i=0;i<N;i++){
            int rest=0;
            int count=0;
            for(int j=i;count<N;j=(j+1)%N,count++){
                if(rest+gas[j]<cost[j]) break;
                else{
                    rest=gas[j]+rest-cost[j];
                }
            }
            if(count==N&&rest>=0) {
                res=i;
                break;
            }
        }
        return res;
    }
}