public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int area1=(C-A)*(D-B);
        int area2=(G-E)*(H-F);
        int res=area1+area2;
        if(isOverLap(A,B,C,D,E,F,G,H)&&area1!=0&&area2!=0){
            int width=C-A+G-E-Math.abs(Math.max(C,G)-Math.min(A,E));
            int height=D-B+H-F-Math.abs(Math.max(D,H)-Math.min(B,F));
            int overlap=width*height;
            res=res-overlap;
        }
        return res;
    }
    private boolean isOverLap(int A, int B, int C, int D, int E, int F, int G, int H){
        if(H<=B||D<=F||C<=E||G<=A) return false;
        return true;
    }
}