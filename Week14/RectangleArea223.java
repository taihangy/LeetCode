public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int area1 = (G - E) * (H - F);
        int area2 = (C - A) * (D - B);
        int res = area1 + area2;
        if(isOverLap(A, B, C, D, E, F, G, H)) {
            int width = (C - A + G -E) - Math.abs(Math.max(G, C) - Math.min(A, E));
            int height = (D - B + H - F) - Math.abs(Math.max(D, H) - Math.min(B, F));
            int over = width * height;
            res = res - over;
        }
        return res;
    }
    private boolean isOverLap(int A, int B, int C, int D, int E, int F, int G, int H) {
        if(H <= B || F >= D || E >= C || G <= A) return false;
        return true;
    }
}